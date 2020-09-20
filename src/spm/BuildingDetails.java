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
public class BuildingDetails extends AbstractTableModel{
    
     private static final String[] COLUMN_NAMES = {
        "Building ID",
        "Building Name",
        "Center",
        "Location",
        "Number Of Floors",
        "Department"
    };
    
    private static ArrayList<BuildingModel> list;

    BuildingDetails(ArrayList<BuildingModel> sList) {
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
                return list.get(rowIndex).getBid();
            case 1:
                return list.get(rowIndex).getbName();
            case 2:
                return list.get(rowIndex).getCenter();
            case 3:
                return list.get(rowIndex).getLocation();
            case 4:
                return list.get(rowIndex).getNoOfFloors();
            case 5:
                return list.get(rowIndex).getDepartment();
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    
}
