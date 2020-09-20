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
public class AsubjectStaticsDetails extends AbstractTableModel{
    
      private static final String[] COLUMN_NAMES = {
          
         
            /*
             private int id;
      private String years;
      private String sem;
      private String subName;
      private String subCode;
      private String lecHr;
       private String tuteHr;
      private String labHr;
      private String evlHr;*/
        
        "Year",
        "Semester",
        "Subject Name",
        "Subject Code",
        "LecHr",
         "TuteHr" ,
        "LabHr",
        "EvlHr"
    };
    
    private static ArrayList<AsubjectStacModel> list;

    AsubjectStaticsDetails(ArrayList<AsubjectStacModel> sList) {
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
                return list.get(rowIndex).getYears();
            case 1:
                return list.get(rowIndex).getSem();
            case 2:
                return list.get(rowIndex).getSem();
            case 3:
                return list.get(rowIndex).getSubName();
                 case 4:
                return list.get(rowIndex).getSubCode();
            case 5:
                return list.get(rowIndex).getLecHr();
            case 6:
                return list.get(rowIndex).getTuteHr();
            case 7:
                return list.get(rowIndex).getLabHr();
                
            case 8:
                return list.get(rowIndex).getEvlHr();
           
                
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    
}
