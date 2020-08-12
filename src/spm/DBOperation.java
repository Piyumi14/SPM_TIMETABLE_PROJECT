/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PIYUMI
 */
public class DBOperation {
    String url = "jdbc:mysql://localhost:3306/spm";
    String username = "root";
    String password = "root";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Add Subject Details
    boolean addSubject(Subject s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into subject values (?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, s.getSid());
            pst.setString(2, s.getAcademicYear());
            pst.setString(3, s.getSemester());
            pst.setString(4, s.getProgram());
            pst.setString(5, s.getGroupNo());
            pst.setString(6, s.getSubGroupNo());

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }
    
    //Get all Subject Details
    ArrayList<Subject> getSubjects() {
        try {
            ArrayList<Subject> list = new ArrayList<Subject>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM subject";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                Subject s = new Subject();
                s.setSid(rs.getInt(1));
                s.setAcademicYear(rs.getString(2));
                s.setSemester(rs.getString(3));
                s.setProgram(rs.getString(4));
                s.setGroupNo(rs.getString(5));
                s.setSubGroupNo(rs.getString(6));
               
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    //Update Subject Details
    public boolean updateSubject(Subject s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE subject SET academicYear='" + s.getAcademicYear()
                    + "' , semester='" + s.getSemester()
                    + "' , program='" + s.getProgram()
                    + "' , groupNo='" + s.getGroupNo()
                    + "' , subGroupNo='" + s.getSubGroupNo()
                   
                    + "' WHERE id=" + s.getSid();
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    //Delete Subject Details
     public boolean deleteSubject(Subject s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM subject WHERE id=" + s.getSid();
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    } 
}
