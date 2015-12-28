/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Util;

import java.io.Serializable;

/**
 *
 * @author Devjl Ladykillah
 */
public class Config  implements Serializable{

    private String address;
    private String port;
    private String data;
    private String user;
    private String pass;

    public Config() {
        address = "localhost";
        port = "1433";
        data = "eProjectC1209G3G2";
        user = "sa";
        pass = "123456";
    }

    public Config(String address, String port, String data, String user, String pass) {
        this.address = address;
        this.port = port;
        this.data = data;
        this.user = user;
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
