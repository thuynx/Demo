/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Devjl Ladykillah
 */
public class sumAllStudent {
   private String id;
    private String name;
    private float percent;
    private boolean fines;
    private boolean attendFinalExams;
    private String classID;

    public sumAllStudent() {
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public boolean isFines() {
        return fines;
    }

    public void setFines(boolean fines) {
        this.fines = fines;
    }

    public boolean isAttendFinalExams() {
        return attendFinalExams;
    }

    public void setAttendFinalExams(boolean attendFinalExams) {
        this.attendFinalExams = attendFinalExams;
    }
    
    
    
}
