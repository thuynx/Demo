/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.Manager;
import GUI.ClassObject;
import GUI.Courses;
import GUI.Staff;
import GUI.Student;
import GUI.Subject;
import GUI.Timetable;
import GUI.checkStudent;
import GUI.sumAllStudent;
import GUI.sumDetail;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Devjl Ladykillah
 */
public class Business {
    
   private Manager ma ;

    public Business() throws  SQLException {
        ma = new Manager();
    }
    
    public int Login(String user, String pass, boolean admin) throws SQLException {
        
        
        return ma.Login(user, pass, admin);
    }
     public void delAdmin(String user) throws SQLException{
         ma.delAdmin(user);
     }
        public void changePass(String user, String pass, boolean admin) throws SQLException{
            ma.changePass(user, pass, admin);
        }
     public List<String> getAllAdmin() throws SQLException{
         return ma.getAllAdmin();
     }
     public List<String> getAllAdminDeleted() throws SQLException{
         return ma.getAllAdminDeleted();
     }
      public void addAdmin(String user)throws SQLException {
          ma.addAdmin(user);
      }
    public ArrayList<ClassObject> getAllClass() throws SQLException {
        
        return ma.getAllClass();
    }
    
    public boolean addClass(ClassObject cl) throws SQLException {
        
        return ma.addClass(cl);
    }
    
    public void updateClass(ClassObject cl) throws SQLException {
        ma.updateClass(cl);
    }
    
    public void removeClass(ClassObject cl) throws SQLException {
        ma.removeClass(cl);
    }
    
    public List<Timetable> getTimetableByClass(String classID) throws SQLException {
        
        return ma.getTimetableByClass(classID);
    }
    
    public boolean addTimetable(String ClassID, boolean am, boolean mon, String subject1, String subject2, String subject3, String subject4) throws SQLException {
        
        return ma.addTimetable(ClassID, am, mon, subject1, subject2, subject3, subject4);
    }
    
    public void removeTimetable(String classID) throws SQLException {
        ma.removeTimetable(classID);
    }
    
    public List<String> getAllCourseName() throws SQLException {
        
        return ma.getAllCourseName();
    }
    
    public String[] getAllSubjectByCourse(String CourseID) throws SQLException {
        
        return ma.getAllSubjectByCourse(CourseID);
    }
    
    public boolean addStudent(Student s) throws SQLException {
        return ma.addStudent(s);
    }
    
    public List<Student> getAllStudent() {
        
        return ma.getAllStudent();
    }

    public void updateStudent(Student s) throws SQLException {
        ma.updateStudent(s);
    }

    public void deleteStudent(String id) throws SQLException {
        ma.deleteStudent(id);
    }
    
    public List<Student> searchStudentByName(String name) throws SQLException {
        return ma.searchStudentByName(name);
    }
    
    public List<Student> getStudentByClassID(String classID) throws SQLException {
        return ma.getStudentByClassID(classID);
    }
    
    public List<String> getClassByCourse(String courseID) throws SQLException {
        return ma.getClassByCourse(courseID);
    }
    
    public List<checkStudent> getStudentBySession(String classID, String subID) throws SQLException {
        return ma.getStudentBySession(classID, subID);
        
    }
    
    public void atttendanceStudent(String ID, String subSession) throws SQLException {
        ma.atttendanceStudent(ID, subSession);
    }
    
    public List<Staff> getAllStaff() throws SQLException {
        return ma.getAllStaff();
    }
    
    public void updateStaff(Staff p) throws SQLException {
        ma.updateStaff(p);
    }
    
    public boolean addStaff(Staff p) throws SQLException {
        return ma.addStaff(p);
    }
    
    public void deleteStaff(Staff p) throws SQLException {
        ma.deleteStaff(p);
    }
    
    public List<Staff> searchStaffByName(String name) throws SQLException {
        return ma.searchStaffByName(name);
    }

    public List<Subject> getAllSubject() throws SQLException {
        return ma.getAllSubject();
    }

    public void addSubject(Subject su) throws SQLException {
        ma.addSubject(su);
    }

    public void updateSubject(Subject su) throws SQLException {
        ma.updateSubject(su);
    }

    public void deleteSubject(String subID) throws SQLException {
        ma.deleteSubject(subID);
    }
     public List<Subject> searchSubjectByName(String name) throws SQLException{
        return ma.searchSubjectByName(name);
     }
       public List<Courses> getViewAllCourses() throws SQLException {
        return ma.getViewAllCourses();
    }

    public void addCourse(Courses cs) throws SQLException {
       ma.addCourses(cs);
    }

    public void editCourse(Courses cs) throws SQLException {
        ma.editCourses(cs);
    }

    public void delCourse(Courses cs) throws SQLException {
        ma.delCourses(cs);
    }
    public List<Courses> searchCoursesByName(String name) throws SQLException {
        return ma.searchCoursesByName(name);
    }
     public List<sumAllStudent> getAllSum() throws SQLException{
         return ma.getAllSum();
     }
     public List<sumAllStudent> searchAllSum(String name) throws SQLException{
         return ma.searchAllSum(name);
     }
     public List<sumDetail> getDetailStudentSum(sumAllStudent st) throws SQLException{
         return ma.getDetailStudentSum(st);
     }
     public ArrayList<ClassObject> getAllClassDeleted() throws SQLException {
         return ma.getAllClassDeleted();
     }
     public List<Student> getAllStudentDeleted() {
         return ma.getAllStudentDeleted();
     }
     public List<Staff> getAllStaffDeleted() throws SQLException {
         return ma.getAllStaffDeleted();
     }
      public List<Subject> getAllSubjectDeleted() throws SQLException {
          return ma.getAllSubjectDeleted();
      }
      public List<Courses> getViewAllCoursesDeleted() throws SQLException {
          return ma.getViewAllCoursesDeleted();
      }
      public void setAllRes(String table) throws SQLException{
          ma.setAllRes(table);
      }
        public void setOneRes(String table,String id) throws SQLException{
            ma.setOneRes(table, id);
        }
}
