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
 * @author TuanAnh
 */
public class MyTableStaff extends AbstractTableModel {

    private List<Staff> data=new ArrayList<>();
   

    public void setData(List<Staff> data) {
        this.data = data;
        this.fireTableDataChanged();
    }

    public void addStaff(Staff s) {
        data.add(s);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
           case 2:
                return String.class;
           case 3:
                return String.class;
           case 4:
               return Integer.class;
           case 5:
                return String.class;
          
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
           
            case 1:
                return "Name";
            case 2:
                return "Gender";
            case 3:
                return "Phonenumber";
            case 4:
                return "Email";
           case 5:
                return "Experience";    
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getId();
          
            case 1:
                return data.get(rowIndex).getName();
            case 2:
                return data.get(rowIndex).getSex();
            case 3:
                return data.get(rowIndex).getPhonenumber();
            case 4:
                return data.get(rowIndex).getEmail();
            case 5:
                return data.get(rowIndex).getExperience();    
        }
        return "";
    }
}   
