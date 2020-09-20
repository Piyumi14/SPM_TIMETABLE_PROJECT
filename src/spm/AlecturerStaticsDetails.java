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
public class AlecturerStaticsDetails extends AbstractTableModel {
    
      private static final String[] COLUMN_NAMES = {
       /* private int id;
     private String employeeID;
     private String name;
     private String faculty;
     private String dept;
     private String center;
     private String building;
     private String level;
     private String rank;*/
          
        "EMPID",
        "Name",
        "faculty",
        "Department",
        "Center",
        "Building",
        "Level",
        "Rank"
         
    };
    
    private static ArrayList<AlecStacModel> list;

    AlecturerStaticsDetails(ArrayList<AlecStacModel> sList) {
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
                return list.get(rowIndex).getEmployeeID();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getFaculty();
            case 3:
                return list.get(rowIndex).getDept();
            case 4:
                return list.get(rowIndex).getCenter();
            case 5:
                return list.get(rowIndex).getBuilding();
            case 6:
                return list.get(rowIndex).getBuilding();
            case 7:
                return list.get(rowIndex).getLevel();
            case 8:
                return list.get(rowIndex).getRank();
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    
}
