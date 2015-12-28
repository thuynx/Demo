/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Jonathan
 */
public class Courses {

    private String Id;
    private String Name;
    private String Info;
    private String Sb1;
    private String Sb2;
    private String Sb3;
    private String Sb4;

    public Courses() {
    }

    public Courses(String Id, String Name, String Info, String Sb1, String Sb2, String Sb3, String Sb4) {
        this.Id = Id;
        this.Name = Name;
        this.Info = Info;
        this.Sb1 = Sb1;
        this.Sb2 = Sb2;
        this.Sb3 = Sb3;
        this.Sb4 = Sb4;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public String getSb1() {
        return Sb1;
    }

    public void setSb1(String Sb1) {
        this.Sb1 = Sb1;
    }

    public String getSb2() {
        return Sb2;
    }

    public void setSb2(String Sb2) {
        this.Sb2 = Sb2;
    }

    public String getSb3() {
        return Sb3;
    }

    public void setSb3(String Sb3) {
        this.Sb3 = Sb3;
    }

    public String getSb4() {
        return Sb4;
    }

    public void setSb4(String Sb4) {
        this.Sb4 = Sb4;
    }
}
