/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Devjl Ladykillah
 */
public class Timetable {

    private String timeSlot;
    private String mon;
    private String tue;
    private String wed;
    private String Thu;
    private String Fri;
    private String Sat;

    public Timetable(String timeSlot, String mon, String tue, String wed, String Thu, String Fri, String Sat) {
        this.timeSlot = timeSlot;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.Thu = Thu;
        this.Fri = Fri;
        this.Sat = Sat;
    }

    public Timetable() {
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWed() {
        return wed;
    }

    public void setWed(String wed) {
        this.wed = wed;
    }

    public String getThu() {
        return Thu;
    }

    public void setThu(String Thu) {
        this.Thu = Thu;
    }

    public String getFri() {
        return Fri;
    }

    public void setFri(String Fri) {
        this.Fri = Fri;
    }

    public String getSat() {
        return Sat;
    }

    public void setSat(String Sat) {
        this.Sat = Sat;
    }
}
