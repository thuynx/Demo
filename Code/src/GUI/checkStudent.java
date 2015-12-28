/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Devjl Ladykillah
 */
public class checkStudent {
   private String id;
   private String name;
   private boolean check;

    public checkStudent(String id, String name, boolean check) {
        this.id = id;
        this.name = name;
        this.check = check;
    }

    public checkStudent() {
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

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return String.valueOf(check) ; //To change body of generated methods, choose Tools | Templates.
    }
   
}
