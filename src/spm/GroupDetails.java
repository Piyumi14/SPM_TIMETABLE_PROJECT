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
public class GroupDetails extends AbstractTableModel{
    private static final String[] COLUMN_NAMES = {
        "Group ID",
    };
    
    private static ArrayList<Subject> list;

    GroupDetails(ArrayList<Subject> sList) {
        list = sList;
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
                return  list.get(rowIndex).getAcademicYear() + "."
                        + list.get(rowIndex).getSemester() + "."
                        + list.get(rowIndex).getProgram() + "."
                        + list.get(rowIndex).getGroupNo(); 
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }


}
