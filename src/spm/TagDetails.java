/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PIYUMI
 */
public class TagDetails extends AbstractTableModel{
    private static final String[] COLUMN_NAMES = {
        "ID",
        "Tag",
        "Description",
    };
    
    private static ArrayList<Tag> list;

    TagDetails(ArrayList<Tag> tList) {
        list = tList;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getTid();
            case 1:
                return list.get(rowIndex).getTag();
            case 2:
                return list.get(rowIndex).getDescription();
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

}
