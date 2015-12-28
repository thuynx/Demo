/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO_Util.Util;
import GUI.ClassObject;
import GUI.Courses;
import GUI.Staff;
import GUI.Student;
import GUI.Subject;
import GUI.Timetable;
import GUI.checkStudent;
import GUI.sumAllStudent;
import GUI.sumDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Devjl Ladykillah
 */
public class Manager {

   private Util ul = new Util();
    private Connection con ;

    public Manager() throws  SQLException {
        con = ul.getConnection();
    }

    public int Login(String user, String pass, boolean admin) throws SQLException {
        if (admin) {
            PreparedStatement pre = con.prepareStatement("Select * from admin where UserName=? and Password=? and status=1");
            pre.setString(1, user);
            pre.setString(2, pass);
            ResultSet res = pre.executeQuery();
            if (res.next()) {
                return 1;
            } else {
                return 0;
            }
        } else {
            PreparedStatement pre = con.prepareStatement("Select * from Staff where ID=? and password=? and status=1");
            pre.setString(1, user);
            pre.setString(2, pass);
            ResultSet res = pre.executeQuery();
            if (res.next()) {
                return 2;
            } else {
                return 0;
            }
        }
    }
    public void changePass(String user, String pass, boolean admin) throws SQLException{
        String p="";
        if(admin){
            p="update admin set Password='"+pass+"' where UserName='"+user+"'";
        }else{
             p="update Staff set password='"+pass+"' where ID='"+user+"'";
        }
        Statement st=con.createStatement();
        st.executeUpdate(p);
        
        
    }
    public List<String> getAllAdmin() throws SQLException{
       List<String> ls=new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs=st.executeQuery("Select * from admin where status=1 and UserName !='admin'");
        while(rs.next()){
            ls.add(rs.getString("UserName"));
        }
        return ls;
    }
    public List<String> getAllAdminDeleted() throws SQLException{
         List<String> ls=new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs=st.executeQuery("Select * from admin where status=0 and UserName !='admin'");
        while(rs.next()){
            ls.add(rs.getString("UserName"));
        }
        return ls;
    }
    public void addAdmin(String user)throws SQLException {
        PreparedStatement pre=con.prepareStatement("insert into admin values(?,'123456',1)");
        pre.setString(1, user);
        pre.executeUpdate();
    }
    public void delAdmin(String user) throws SQLException{
         PreparedStatement pre=con.prepareStatement("update admin  set status=0 where UserName=?");
        pre.setString(1, user);
        pre.executeUpdate();
        
    }

    public ArrayList<ClassObject> getAllClass() throws SQLException {
        ArrayList<ClassObject> arr = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select ID,CourseID from Class where status =1");
        while (rs.next()) {
            arr.add(new ClassObject(rs.getString("ID"), rs.getString("CourseID")));
        }
        return arr;
    }
    public ArrayList<ClassObject> getAllClassDeleted() throws SQLException {
        ArrayList<ClassObject> arr = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select ID,CourseID from Class where status =0");
        while (rs.next()) {
            arr.add(new ClassObject(rs.getString("ID"), rs.getString("CourseID")));
        }
        return arr;
    }
    

    public boolean addClass(ClassObject cl) throws SQLException {

        PreparedStatement pre = con.prepareStatement("insert into Class values(?,?,1)");
        pre.setString(1, cl.getClassID());
        pre.setString(2, cl.getCourseID());
        if (pre.executeUpdate() > 0) {
            return true;
        }
        return false;

    }

    public void updateClass(ClassObject cl) throws SQLException {

        PreparedStatement pre = con.prepareStatement("update Class set CourseID=? where ID=?");
        pre.setString(1, cl.getCourseID());
        pre.setString(2, cl.getClassID());
        pre.executeUpdate();
    }

    public void removeClass(ClassObject cl) throws SQLException {


        PreparedStatement pre = con.prepareStatement("update Class set status=0 where ID=?");

        pre.setString(1, cl.getClassID());
        pre.executeUpdate();
    }

    public List<Timetable> getTimetableByClass(String classID) throws SQLException {
        List<Timetable> ls = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from Time_Table where ClassID='" + classID + "' and status=1");
        rs.next();
        ls.add(new Timetable("7h30-9h30", rs.getString(2), rs.getString(6), rs.getString(10), rs.getString(14), rs.getString(18), rs.getString(22)));
        ls.add(new Timetable("9h30-11h30", rs.getString(3), rs.getString(7), rs.getString(11), rs.getString(15), rs.getString(19), rs.getString(23)));
        ls.add(new Timetable("13h30-15h30", rs.getString(4), rs.getString(8), rs.getString(12), rs.getString(16), rs.getString(20), rs.getString(24)));
        ls.add(new Timetable("15h30-17h30", rs.getString(5), rs.getString(9), rs.getString(13), rs.getString(17), rs.getString(21), rs.getString(25)));
        return ls;

    }

    public boolean addTimetable(String ClassID, boolean am, boolean mon, String subject1, String subject2, String subject3, String subject4) throws SQLException {

        Statement st = con.createStatement();
        String c1 = "";
        String c2 = "";
        String c3 = "";
        String c4 = "";
        String c5 = "";
        String c6 = "";

        if (am) {
            if (mon) {
                c1 = "Mo_slot1,";
                c2 = "Mo_slot2,";
                c3 = "We_slot1,";
                c4 = "We_slot2,";
                c5 = "Fr_slot1,";
                c6 = "Fr_slot2";


            } else {

                c1 = "Tu_slot1,";
                c2 = "Tu_slot2,";
                c3 = "Th_slot1,";
                c4 = "Th_slot2,";
                c5 = "Sa_slot1,";
                c6 = "Sa_slot2";
            }
        } else {
            if (mon) {
                c1 = "Mo_slot3,";
                c2 = "Mo_slot4,";
                c3 = "We_slot3,";
                c4 = "We_slot4,";
                c5 = "Fr_slot3,";
                c6 = "Fr_slot4";


            } else {
                c1 = "Tu_slot3,";
                c2 = "Tu_slot4,";
                c3 = "Th_slot3,";
                c4 = "Th_slot4,";
                c5 = "Sa_slot3,";
                c6 = "Sa_slot4";
            }
        }

        if (0 < st.executeUpdate("insert into Time_Table (ClassID," + c1 + c2 + c3 + c4 + c5 + c6 + ") values('" + ClassID + "','" + subject1 + "','" + subject2 + "','" + subject1 + "','" + subject2 + "','" + subject3 + "','" + subject4 + "')")) {

            return true;
        }
        return false;


    }

    public void removeTimetable(String classID) throws SQLException {
        Statement st = con.createStatement();
        int rs = st.executeUpdate("delete Time_Table  where ClassID='" + classID + "'");

    }

    public List<String> getAllCourseName() throws SQLException {
        List<String> ls = new ArrayList<>();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Courses where status=1");
        while (rs.next()) {
            ls.add(rs.getString("ID"));
        }
        return ls;

    }

    public String[] getAllSubjectByCourse(String CourseID) throws SQLException {
        String[] ss = new String[4];

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select Subject1ID,Subject2ID,Subject3ID,Subject4ID from Courses where ID='" + CourseID + "' and status=1");
        rs.next();
        for (int i = 0; i < 4; i++) {
            ss[i] = rs.getString(i + 1);
        }
        return ss;
    }

    public List<Student> getAllStudent() {

        List<Student> lst;
        Student s;
        try {
            PreparedStatement preparedStatement = con.prepareCall("Select * from Student where status=1");
            ResultSet r = preparedStatement.executeQuery();
            lst = new ArrayList<>();
            while (r.next()) {
                s = new Student();
                s.setId(r.getString(1));
                s.setName(r.getString(2));
                s.setEmail(r.getString(3));
                s.setAddress(r.getString(4));
                s.setGender(r.getString(5));
                s.setAge(r.getInt(6));
                s.setClassID(r.getString(7));
                lst.add(s);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public List<Student> getAllStudentDeleted() {

        List<Student> lst;
        Student s;
        try {
            PreparedStatement preparedStatement = con.prepareCall("Select * from Student where status=0");
            ResultSet r = preparedStatement.executeQuery();
            lst = new ArrayList<>();
            while (r.next()) {
                s = new Student();
                s.setId(r.getString(1));
                s.setName(r.getString(2));
                s.setEmail(r.getString(3));
                s.setAddress(r.getString(4));
                s.setGender(r.getString(5));
                s.setAge(r.getInt(6));
                s.setClassID(r.getString(7));
                lst.add(s);
            }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public boolean addStudent(Student s) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("Insert into Student (id,name,email,address,sex,age,classID ) values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, s.getId());
        preparedStatement.setString(2, s.getName());
        preparedStatement.setString(3, s.getEmail());
        preparedStatement.setString(4, s.getAddress());
        preparedStatement.setString(5, s.getGender());
        preparedStatement.setInt(6, s.getAge());
        preparedStatement.setString(7, s.getClassID());
        if (preparedStatement.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }



    }

    public void updateStudent(Student s) throws SQLException {
        PreparedStatement pre = con.prepareStatement("update Student set name=?,email=?,address=?,sex=?,age=?,classID=? where id=? ");
        pre.setString(1, s.getName());
        pre.setString(2, s.getEmail());
        pre.setString(3, s.getAddress());
        pre.setString(4, s.getGender());
        pre.setInt(5, s.getAge());
        pre.setString(6, s.getClassID());
        pre.setString(7, s.getId());
        pre.executeUpdate();
    }

    public void deleteStudent(String id) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("update Student set status=0 where id='" + id + "'");



    }

    public List<Student> searchStudentByName(String name) throws SQLException {
        List<Student> ls = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Student where name like'%" + name + "%' and status=1");
        while (rs.next()) {

            Student s = new Student();
            s.setId(rs.getString(1));
            s.setName(rs.getString(2));
            s.setEmail(rs.getString(3));
            s.setAddress(rs.getString(4));
            s.setGender(rs.getString(5));
            s.setAge(rs.getInt(6));
            s.setClassID(rs.getString(7));
            ls.add(s);


        }


        return ls;
    }

    public List<Student> getStudentByClassID(String classID) throws SQLException {
        Statement st = con.createStatement();
        List<Student> ls = new ArrayList<>();
        ResultSet rs = st.executeQuery("select * from Student where ClassID='" + classID + "' and status=1");
        while (rs.next()) {
            ls.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
        }
        return ls;
    }

    public List<String> getClassByCourse(String courseID) throws SQLException {
        List<String> ls = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select ID from Class where CourseID='" + courseID + "' and status=1");
        while (rs.next()) {
            ls.add(rs.getString("ID"));
        }
        return ls;
    }

    public List<checkStudent> getStudentBySession(String ClassID, String subID) throws SQLException {

        List<checkStudent> ls = new ArrayList<>();
        PreparedStatement pre = con.prepareStatement("Select id,name," + subID + " from Student where " + subID + "=0 and classID='" + ClassID + "' and status=1");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            ls.add(new checkStudent(rs.getString(1), rs.getString(2), false));
        }
        return ls;
    }

    public void atttendanceStudent(String ID, String subSession) throws SQLException {
        PreparedStatement pre = con.prepareStatement("update Student set " + subSession + "=1 where ID=?");
        pre.setString(1, ID);
        pre.executeUpdate();



    }

    public List<Staff> getAllStaff() throws SQLException {
        List<Staff> ls = new ArrayList<>();


        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from Staff where status=1");

        Staff p;
        while (rs.next()) {
            p = new Staff();
            p.setId(rs.getString(1));
            p.setPassword(rs.getString(2));
            p.setName(rs.getString(3));
            p.setSex(rs.getString(4));
            p.setPhonenumber(rs.getInt(5));
            p.setEmail(rs.getString(6));
            p.setExperience(rs.getString(7));
            ls.add(p);
        }



        return ls;



    }
public List<Staff> getAllStaffDeleted() throws SQLException {
        List<Staff> ls = new ArrayList<>();


        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from Staff where status=0");

        Staff p;
        while (rs.next()) {
            p = new Staff();
            p.setId(rs.getString(1));
            p.setPassword(rs.getString(2));
            p.setName(rs.getString(3));
            p.setSex(rs.getString(4));
            p.setPhonenumber(rs.getInt(5));
            p.setEmail(rs.getString(6));
            p.setExperience(rs.getString(7));
            ls.add(p);
        }



        return ls;



    }
    public void updateStaff(Staff p) throws SQLException {


        Statement statement = con.createStatement();
        statement.executeUpdate("update Staff set Name='" + p.getName() + "',Sex='" + p.getSex() + "',Phonenumber=" + p.getPhonenumber() + ",Email='" + p.getEmail() + "',Experience='" + p.getExperience() + "' where ID='" + p.getId() + "'");
    }

    public boolean addStaff(Staff p) throws SQLException {
        PreparedStatement statement = con.prepareStatement("insert into Staff values(?,?,?,?,?,?,?,1)");
        statement.setString(1, p.getId());
        statement.setString(2, p.getPassword());
        statement.setString(3, p.getName());
        statement.setString(4, p.getSex());
        statement.setInt(5, p.getPhonenumber());
        statement.setString(6, p.getEmail());
        statement.setString(7, p.getExperience());
        if (statement.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteStaff(Staff p) throws SQLException {
        PreparedStatement statement = con.prepareStatement("update Staff set status=0 where ID=?");
        statement.setString(1, p.getId());
        statement.executeUpdate();

    }

    public List<Staff> searchStaffByName(String name) throws SQLException {
        List<Staff> ls = new ArrayList<>();
        name = "%" + name + "%";
        PreparedStatement statement = con.prepareStatement("select * from Staff where Name like ? and status=1");
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Staff st = new Staff();
            st.setId(rs.getString(1));
            st.setName(rs.getString(3));
            st.setSex(rs.getString(4));
            st.setPhonenumber(rs.getInt(5));
            st.setEmail(rs.getString(6));
            st.setExperience(rs.getString(7));
            ls.add(st);

        }


        return ls;
    }

    public List<Subject> getAllSubject() throws SQLException {
        List<Subject> ls = new ArrayList<>();
        PreparedStatement pre = con.prepareStatement("select * from Subject where status=1");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            Subject su = new Subject();
            su.setSubjectID(rs.getString(1));
            su.setStaffID(rs.getString(2));
            ls.add(su);

        }



        return ls;

    }
     public List<Subject> getAllSubjectDeleted() throws SQLException {
        List<Subject> ls = new ArrayList<>();
        PreparedStatement pre = con.prepareStatement("select * from Subject where status=0");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            Subject su = new Subject();
            su.setSubjectID(rs.getString(1));
            su.setStaffID(rs.getString(2));
            ls.add(su);

        }



        return ls;

    }
    

    public void addSubject(Subject su) throws SQLException {

        PreparedStatement pre = con.prepareStatement("insert into Subject values(?,?,1)");
        pre.setString(1, su.getSubjectID());
        pre.setString(2, su.getStaffID());
        pre.executeUpdate();
    }

    public void updateSubject(Subject su) throws SQLException {
        PreparedStatement pre = con.prepareStatement("update Subject set StaffID=? where ID=?");
        pre.setString(2, su.getSubjectID());
        pre.setString(1, su.getStaffID());
        pre.executeUpdate();
    }

    public void deleteSubject(String subID) throws SQLException {

        PreparedStatement pre = con.prepareStatement("update Subject set status=0 where ID=?");
        pre.setString(1, subID);

        pre.executeUpdate();
    }

    public List<Subject> searchSubjectByName(String name) throws SQLException {
        List<Subject> ls = new ArrayList<>();
        PreparedStatement pre = con.prepareStatement("select * from Subject where status=1 and ID like '%" + name + "%'");

        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            Subject su = new Subject();
            su.setSubjectID(rs.getString(1));
            su.setStaffID(rs.getString(2));
            ls.add(su);

        }



        return ls;

    }

    public List<Courses> getViewAllCourses() throws SQLException {


        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from Courses where status=1");
        List<Courses> lst = new ArrayList<>();
        Courses courses;
        while (rs.next()) {
            courses = new Courses();
            courses.setId(rs.getString(1));
            courses.setName(rs.getString(2));
            courses.setInfo(rs.getString(3));
            courses.setSb1(rs.getString(4));
            courses.setSb2(rs.getString(5));
            courses.setSb3(rs.getString(6));
            courses.setSb4(rs.getString(7));
            lst.add(courses);
        }
        return lst;



    }
     public List<Courses> getViewAllCoursesDeleted() throws SQLException {


        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from Courses where status=0");
        List<Courses> lst = new ArrayList<>();
        Courses courses;
        while (rs.next()) {
            courses = new Courses();
            courses.setId(rs.getString(1));
            courses.setName(rs.getString(2));
            courses.setInfo(rs.getString(3));
            courses.setSb1(rs.getString(4));
            courses.setSb2(rs.getString(5));
            courses.setSb3(rs.getString(6));
            courses.setSb4(rs.getString(7));
            lst.add(courses);
        }
        return lst;



    }

    public void addCourses(Courses cs) throws SQLException {


        PreparedStatement ps = con.prepareStatement("insert into Courses values (?,?,?,?,?,?,?,1)");
        ps.setString(1, cs.getId());
        ps.setString(2, cs.getName());
        ps.setString(3, cs.getInfo());
        ps.setString(4, cs.getSb1());
        ps.setString(5, cs.getSb2());
        ps.setString(6, cs.getSb3());
        ps.setString(7, cs.getSb4());
        ps.executeUpdate();

    }

    public void editCourses(Courses cs) throws SQLException {


        PreparedStatement ps = con.prepareStatement("update Courses set Name = ?, Info = ?, Subject1ID = ?, Subject2ID = ?, Subject3ID = ?, Subject4ID = ? where ID = ?");
        ps.setString(1, cs.getName());
        ps.setString(2, cs.getInfo());
        ps.setString(3, cs.getSb1());
        ps.setString(4, cs.getSb2());
        ps.setString(5, cs.getSb3());
        ps.setString(6, cs.getSb4());
        ps.setString(7, cs.getId());
        ps.executeUpdate();

    }

    public void delCourses(Courses cs) throws SQLException {


        PreparedStatement ps = con.prepareStatement("update Courses set status=0 where ID = ?");
        ps.setString(1, cs.getId());
        ps.executeUpdate();

    }
     public List<Courses> searchCoursesByName(String name) throws SQLException {


        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from Courses where status=1 and Name like '%"+name+"%'");
        List<Courses> lst = new ArrayList<>();
        Courses courses;
        while (rs.next()) {
            courses = new Courses();
            courses.setId(rs.getString(1));
            courses.setName(rs.getString(2));
            courses.setInfo(rs.getString(3));
            courses.setSb1(rs.getString(4));
            courses.setSb2(rs.getString(5));
            courses.setSb3(rs.getString(6));
            courses.setSb4(rs.getString(7));
            lst.add(courses);
        }
        return lst;



    }
     public List<sumAllStudent> getAllSum() throws SQLException{
         List<sumAllStudent> ls=new ArrayList<>();
          Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from Student where status=1");
         while(rs.next()){
             sumAllStudent su=new sumAllStudent();
             su.setId(rs.getString(1));
             su.setName(rs.getString(2));
             su.setClassID(rs.getString(7));
             int day=0;
             for(int i=9;i<49;i++){
                 if(rs.getInt(i)==1){
                     day=day+1;
                 }
             }
            float per=(day*100)/(float)40;
          
            su.setPercent(per);
             if(su.getPercent()>70){
                 su.setAttendFinalExams(true);
                 if(su.getPercent()>75){
                     su.setFines(false);
                 }else{
                     su.setFines(true);
                 }
             }else{
                 su.setAttendFinalExams(false);
                 su.setFines(false);
             }
             ls.add(su);
             
         }
         
         return ls;
         
         
     }
     public List<sumAllStudent> searchAllSum(String name) throws SQLException{
         List<sumAllStudent> ls=new ArrayList<>();
          Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from Student where status=1 and name like '%"+name+"%'");
         while(rs.next()){
             sumAllStudent su=new sumAllStudent();
             su.setId(rs.getString(1));
             su.setName(rs.getString(2));
             su.setClassID(rs.getString(7));
             int day=0;
             for(int i=9;i<49;i++){
                 if(rs.getInt(i)==1){
                     day=day+1;
                 }
             }
            float per=(day*100)/(float)40;
            su.setPercent(per);
             if(su.getPercent()>70){
                 su.setAttendFinalExams(true);
                 if(su.getPercent()>75){
                     su.setFines(false);
                 }else{
                     su.setFines(true);
                 }
             }else{
                 su.setAttendFinalExams(false);
                 su.setFines(false);
             }
             ls.add(su);
             
         }
         
         return ls;
         
     }
     public String getCoursebyClass(String classID) throws SQLException{
         Statement statement = con.createStatement();
         ResultSet rs=statement.executeQuery("select CourseID from Class where ID='"+classID+"'");
         while(rs.next()){
             
             return rs.getString(1);
             
         }
         return "";
         
         
     }
       public List<sumDetail> getDetailStudentSum(sumAllStudent st) throws SQLException{
         List<sumDetail> ls=new ArrayList<>();
          Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from Student where status=1 and ID = '"+st.getId()+"'");
         while(rs.next()){
           
          String[] ss=this.getAllSubjectByCourse(this.getCoursebyClass(st.getClassID()));
          
              
              sumDetail sd1=new sumDetail();
              sd1.setNameSub(ss[0]);
              int k1=0;
              for(int i=9;i<19;i++){
                  if(rs.getInt(i)==1){
                      k1++;
                  }
              }
              sd1.setAttend(k1);
              sd1.setSumDay(10);
              sd1.setPercent(k1*100/(float)10);
              ls.add(sd1);
              sumDetail sd2=new sumDetail();
              sd2.setNameSub(ss[1]);
              int k2=0;
              for(int i=19;i<29;i++){
                  if(rs.getInt(i)==1){
                      k2++;
                  }
              }
              sd2.setAttend(k2);
              sd2.setSumDay(10);
              sd2.setPercent(k2*100/(float)10);
              ls.add(sd2);
          sumDetail sd3=new sumDetail();
              sd3.setNameSub(ss[2]);
              int k3=0;
              for(int i=29;i<39;i++){
                  if(rs.getInt(i)==1){
                      k3++;
                  }
              }
              sd3.setAttend(k3);
              sd3.setSumDay(10);
              sd3.setPercent(k3*100/(float)10);
              ls.add(sd3);
             sumDetail sd4=new sumDetail();
              sd4.setNameSub(ss[3]);
              int k4=0;
              for(int i=39;i<49;i++){
                  if(rs.getInt(i)==1){
                      k4++;
                  }
              }
              sd4.setAttend(k4);
              sd4.setSumDay(10);
              sd4.setPercent(k4*100/(float)10);
              ls.add(sd4);
         }
         
         return ls;
         
     }
       public void setAllRes(String table) throws SQLException{
         
           PreparedStatement pre=con.prepareStatement("update "+table+" set status=1");
          pre.executeUpdate();
         
       } 
        public void setOneRes(String table,String id) throws SQLException{
         
           PreparedStatement pre=con.prepareStatement("update "+table+" set status=1 where ID=?");
           pre.setString(1, id);
          pre.executeUpdate();
         
       } 
}
