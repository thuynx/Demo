/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author TuanAnh
 */
public class Staff {
    private String id;
    private String password;
    private String name;
    private String sex;
    private int phonenumber;
    private String email;
    private String experience;

    public Staff(String id, String password, String name,String sex, int phonenumber, String email, String experience) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.email = email;
        this.experience = experience;
    }

    public Staff() {
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

   

    
    
    
    
}
