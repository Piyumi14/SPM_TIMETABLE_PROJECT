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
public class AddRoomDetails extends AbstractTableModel{
    
     private static final String[] COLUMN_NAMES = {
        "Room ID",
        "Room Name",
        "Room Type",
        "Floor No",
        "Section",
        "Room No",
         "Building ID"    
    };
    
    private static ArrayList<AddRoomModel> list;

    AddRoomDetails(ArrayList<AddRoomModel> sList) {
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
                return list.get(rowIndex).getRid();
            case 1:
                return list.get(rowIndex).getrName();
            case 2:
                return list.get(rowIndex).getRoomType();
            case 3:
                return list.get(rowIndex).getFloorNo();
            case 4:
                return list.get(rowIndex).getSection();
            case 5:
                return list.get(rowIndex).getRoomNo();
            case 6:
                return list.get(rowIndex).getrBid();    
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

}
