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
public class MyTableDetailSum extends AbstractTableModel{
private ArrayList<sumDetail> data=new ArrayList<>();
    @Override
    public int getRowCount() {
       return data.size();
    }

    @Override
    public int getColumnCount() {
     return 4;
    }

    public MyTableDetailSum() {
    }

    public ArrayList<sumDetail> getData() {
        return data;
    }

    public void setData(ArrayList<sumDetail> data) {
        this.data = data;
    }

    @Override
    public String getColumnName(int i) {
     switch(i){
         case 0:
             return "Subject Name";
         case 1:
             return "Attendant (Number)";
         case 2:
             return "Total number of sessions";
         case 3:
             return "Attendant (%)";
         default:
             return "";
     }
    }

    @Override
    public Class<?> getColumnClass(int i) {
      switch(i){
          case 0:
              return String.class;
          case 3:
              return Float.class;
          default:
              return Integer.class;
      }
    }

    @Override
    public Object getValueAt(int i, int i1) {
      switch(i1){
          case 0:
              return data.get(i).getNameSub();
          case 1:
              return data.get(i).getAttend();
          case 2:
              return data.get(i).getSumDay();
          case 3:
              return data.get(i).getPercent();
          default:
              return null;
      }
    }
    
}
