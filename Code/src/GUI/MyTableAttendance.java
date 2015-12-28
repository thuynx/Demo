/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Devjl Ladykillah
 */
public class MyTableAttendance extends AbstractTableModel{
   private ArrayList<checkStudent> data=new ArrayList<>();

    public MyTableAttendance() {
    }

    public ArrayList<checkStudent> getData() {
        return data;
    }

    public void setData(ArrayList<checkStudent> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int i) {
      switch(i){
          case 0:
              return "Student ID";
          case 1:
              return "Full Name";
          case 2:
              return "Attendant";
          default:
              return "";
      }
    }

    @Override
    public Class<?> getColumnClass(int i) {
      if(i==2){
       
          return Boolean.class;
      }
         return String.class;
      
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        if(i1==2){
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        switch(i1){
            case 0:
                data.get(i).setId((String) o);
            case 1:
                data.get(i).setName((String)o);
            case 2:
                data.get(i).setCheck((boolean) o);
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0:
                return data.get(i).getId();
            case 1:
                return data.get(i).getName();
            case 2:
                return data.get(i).isCheck();
            default:
                return null;
        }
    }

    
    
}
