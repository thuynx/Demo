/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jonathan
 */
public class MyTableCourse extends AbstractTableModel {

    private List<Courses> courses;

    public void setData(List<Courses> courses) {
        this.courses = courses;
        this.fireTableDataChanged();
    }

    public List<Courses> getCourses() {
        return courses;
    }

    @Override
    public int getRowCount() {
        return courses.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return courses.get(rowIndex).getId();
            case 1:
                return courses.get(rowIndex).getName();
            case 2:
                return courses.get(rowIndex).getInfo();
            case 3:
                return courses.get(rowIndex).getSb1();
            case 4:
                return courses.get(rowIndex).getSb2();
            case 5:
                return courses.get(rowIndex).getSb3();
            case 6:
                return courses.get(rowIndex).getSb4();
        }
        return "";
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
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
                return String.class;
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "CoursesID";
            case 1:
                return "Name";
            case 2:
                return "Info";
            case 3:
                return "Subject I";
            case 4:
                return "Subject II";
            case 5:
                return "Subject III";
            case 6:
                return "Subject IV";
        }
        return "";
    }
}
