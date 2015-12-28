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
public class MyTableClass extends AbstractTableModel {

    private ArrayList<ClassObject> data = new ArrayList<>();

    public ArrayList<ClassObject> getData() {
        return data;
    }

    public void setData(ArrayList<ClassObject> data) {
        this.data = data;
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
    public String getColumnName(int i) {
       switch(i){
           case 0:
               return "Class ID";
           case 1:
               return "Course ID";
           default:
               return "";
       }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return data.get(i).getClassID();
            case 1:
                return data.get(i).getCourseID();
            default:
                return null;
        }
    }
}
