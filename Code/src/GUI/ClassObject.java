/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Devjl Ladykillah
 */
public class ClassObject {
    private String classID;
   private String CourseID;

    public ClassObject(String classID, String CourseID) {
        this.classID = classID;
        this.CourseID = CourseID;
    }

   
    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }
   
    
}
