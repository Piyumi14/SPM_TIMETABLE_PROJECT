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
public class SubjectDetails extends AbstractTableModel{
    private static final String[] COLUMN_NAMES = {
        "ID",
        "Academic Year",
        "Semester",
        "Program",
        "Group Number",
        "Sub Group Number"
    };
    
    private static ArrayList<Subject> list;

    SubjectDetails(ArrayList<Subject> sList) {
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
                return list.get(rowIndex).getSid();
            case 1:
                return list.get(rowIndex).getAcademicYear();
            case 2:
                return list.get(rowIndex).getSemester();
            case 3:
                return list.get(rowIndex).getProgram();
            case 4:
                return list.get(rowIndex).getGroupNo();
            case 5:
                return list.get(rowIndex).getSubGroupNo();
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

}
