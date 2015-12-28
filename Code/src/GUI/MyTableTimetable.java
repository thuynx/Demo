/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Devjl Ladykillah
 */
public class MyTableTimetable extends AbstractTableModel{

    private List<Timetable> data=new ArrayList<>();

    public List<Timetable> getData() {
        return data;
    }

    public void setData(List<Timetable> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
       return data.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
           case 0:
               return "Time Slot";
           case 1:
               return "Monday";
           case 2:
               return "Tuesday";
              
           case 3:
               return "Wednesday";
           case 4:
               return "Thursday";
           case 5:
               return "Friday";
           case 6:
               return "Saturday";
           default:
               return "";
    }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class; 
    }

    @Override
    public Object getValueAt(int i, int i1) {
       switch(i1){
           case 0:
               return data.get(i).getTimeSlot();
           case 1:
               return data.get(i).getMon();
           case 2:
               return data.get(i).getTue();
           case 3:
               return data.get(i).getWed();
           case 4:
               return data.get(i).getThu();
           case 5:
               return data.get(i).getFri();
           case 6:
               return data.get(i).getSat();
           default:
               return null;
       }
    }
    
}
