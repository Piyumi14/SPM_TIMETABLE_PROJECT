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
 * @author User
 */
public class AstudentStacDetails extends AbstractTableModel {
    
    
     private static final String[] COLUMN_NAMES = {
          
         
        "Program",
        "Acadamic year",
        "Semester",
        "No Of Student",
        "noOfGroup",
        "noOfSubGroup"
           
    };
    
    private static ArrayList<AstudentStacModel> list;

    AstudentStacDetails(ArrayList<AstudentStacModel> sList) {
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
                return list.get(rowIndex).getSprogram();
            case 1:
                return list.get(rowIndex).getAcadamicYear();
            case 2:
                return list.get(rowIndex).getSsenester();
            case 3:
                return list.get(rowIndex).getNoOfStu();
            case 4:
                return list.get(rowIndex).getNoOfGroup();
            case 5:
                return list.get(rowIndex).getNoOfSubGroup(); 
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    
}
