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
public class MyTableSumAll extends AbstractTableModel {

    List<sumAllStudent> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    public List<sumAllStudent> getData() {
        return data;
    }

    public void setData(List<sumAllStudent> data) {
        this.data = data;
    }

    public MyTableSumAll() {
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Student ID";
            case 1:
                return "Name";
            case 2:
                return "Class ID";
            case 3:
                return "Atendant (%)";
            case 4:
                return "Pay Fines";
            case 5:
                return "Attend the Final Exam";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch (i) {

            case 3:
                return Float.class;
            case 4:
                return Boolean.class;
            case 5:
                return Boolean.class;
            default:
                return String.class;

        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return data.get(i).getId();
            case 1:
                return data.get(i).getName();
                
            case 2:
                return data.get(i).getClassID();
            case 3:
                return data.get(i).getPercent();
            case 4:
                return data.get(i).isFines();
            case 5:
                return data.get(i).isAttendFinalExams();
            default:
                return null;
        }
    }
}
