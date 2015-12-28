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
 * @author Admin
 */
public class MytableStudent extends AbstractTableModel {

    private List<Student> data=new ArrayList<>();

    public void setData(List<Student> data) {
        this.data = data;
        this.fireTableDataChanged();
    }

    public MytableStudent() {
    }

    public List<Student> getData() {
        return data;
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getId();
            case 1:
                return data.get(rowIndex).getName();
            case 2:
                return data.get(rowIndex).getEmail();
            case 3:
                return data.get(rowIndex).getAddress();
            case 4:
                return data.get(rowIndex).getGender();
            case 5:
                return data.get(rowIndex).getAge();
            case 6:
                return data.get(rowIndex).getClassID();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Student ID";
            case 1:
                return "Name";
            case 2:
                return "Email";
            case 3:
                return "Address";
            case 4:
                return "Gender";
            case 5:
                return "Age";
            case 6:
                return "Class ID";
                
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 5:
            return Integer.class;
        }
        return Object.class;
    }
}
