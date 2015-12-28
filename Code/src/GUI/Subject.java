/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author TuanAnh
 */
public class Subject {
    String SubjectID;
    String StaffID;

    public Subject() {
    }

    public Subject(String SubjectID, String StaffID) {
        this.SubjectID = SubjectID;
        this.StaffID = StaffID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }
    
    
}
