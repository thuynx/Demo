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
public class MyTableAdmin extends AbstractTableModel {

    private List<String> data = new ArrayList<>();

    public MyTableAdmin() {
    }

    @Override
    public String getColumnName(int i) {
        return "User Name";

    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return data.get(i);
    }
}
