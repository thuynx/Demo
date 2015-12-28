/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TuanAnh
 */
public class MyTableSubject extends AbstractTableModel {

    private List<Subject> data;
   

    public void setData(List<Subject> data) {
        this.data = data;
        this.fireTableDataChanged();
    }

    public List<Subject> getData() {
        return data;
    }
    

    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
           
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Subject Name";
            case 1:
                return "StaffID";
              
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getSubjectID();
            case 1:
                return data.get(rowIndex).getStaffID();
            
        }
        return "";
    }
}   
