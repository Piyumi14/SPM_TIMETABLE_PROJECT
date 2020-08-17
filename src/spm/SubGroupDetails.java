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
public class SubGroupDetails extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {
        "Sub Group ID",
    };
    
    private static ArrayList<Subject> list;

    SubGroupDetails(ArrayList<Subject> sList) {
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
                        + list.get(rowIndex).getGroupNo() + "."
                        + list.get(rowIndex).getSubGroupNo(); 
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }


}
