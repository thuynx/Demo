/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Devjl Ladykillah
 */
public class sumDetail {

    private String nameSub;
    private int attend;
    private int sumDay;
    private float percent;

    public sumDetail() {
    }

    public sumDetail(String nameSub, int attend, int sumDay, float percent) {
        this.nameSub = nameSub;
        this.attend = attend;
        this.sumDay = sumDay;
        this.percent = percent;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public int getAttend() {
        return attend;
    }

    public void setAttend(int attend) {
        this.attend = attend;
    }

    public int getSumDay() {
        return sumDay;
    }

    public void setSumDay(int sumDay) {
        this.sumDay = sumDay;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
    
    
    
}
