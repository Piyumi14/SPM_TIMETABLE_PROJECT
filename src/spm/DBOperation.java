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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    Statement st;
    
    public static Connection connect(){
        
        Connection con=null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spm", "root", "root");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return con;
        
    }
    
    //Add Subject Details
    boolean addSubject(Subject s) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into student values (?,?,?,?,?,?)";
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
            String query = "SELECT * FROM student";
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
  
     
     //Execute SQL
     public void executeSQLQuery(String query, String message){
         try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            st = con.createStatement();

            if((st.executeUpdate(query)) == 1){
                JOptionPane.showMessageDialog(null, "Data " +message+" Successfully");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not " +message+" Successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
     }
     
     //Add Tag Details
    boolean addTag(Tag t) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into tag values (?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, t.getTid());
            pst.setString(2, t.getTag());
            pst.setString(3, t.getDescription());
           
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
    ArrayList<Tag> getTags() {
        try {
            ArrayList<Tag> list = new ArrayList<Tag>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM tag";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                Tag t = new Tag();
                t.setTid(rs.getInt(1));
                t.setTag(rs.getString(2));
                t.setDescription(rs.getString(3));
                
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
    ///////DURANKA
        boolean addBuilding(BuildingModel b) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into building values (?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            
    

            pst.setInt(1, b.getBid());
            pst.setString(2, b.getbName());
            pst.setString(3, b.getCenter());
            pst.setString(4, b.getLocation());
            pst.setString(5, b.getNoOfFloors());
            pst.setString(6, b.getDepartment());

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
    
    
     ArrayList<BuildingModel> getBuildingDetails() {
        try {
            ArrayList<BuildingModel> list = new ArrayList<BuildingModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM building";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                BuildingModel buildingModel = new BuildingModel();
                buildingModel.setBid(rs.getInt(1));
                buildingModel.setCenter(rs.getString(3));
                buildingModel.setbName(rs.getString(2));
                buildingModel.setLocation(rs.getString(4));
                buildingModel.setNoOfFloors(rs.getString(5));
                buildingModel.setDepartment(rs.getString(6));
               
                list.add(buildingModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
     
      boolean addRoom(AddRoomModel r) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into room values (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            
    

            pst.setInt(1, r.getRid());
            pst.setString(2, r.getrName());
            pst.setString(3, r.getRoomType());
            pst.setString(4, r.getFloorNo());
            pst.setString(5, r.getSection());
            pst.setString(6, r.getRoomNo());
             pst.setInt(7, r.getrBid());

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
      
      ArrayList<AddRoomModel> getRoomDetails() {
        try {
            ArrayList<AddRoomModel> list = new ArrayList<AddRoomModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM room";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                AddRoomModel addRoomModel = new AddRoomModel();
                addRoomModel.setRid(rs.getInt(1));
                addRoomModel.setrName(rs.getString(2));
                addRoomModel.setRoomType(rs.getString(3));
                addRoomModel.setFloorNo(rs.getString(4));
                addRoomModel.setSection(rs.getString(5));
                addRoomModel.setRoomNo(rs.getString(6));
                addRoomModel.setrBid(rs.getInt(7));
               
                list.add(addRoomModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

      ArrayList<AsubjectStacModel> getSubStac() {
        try {
            ArrayList<AsubjectStacModel> list = new ArrayList<AsubjectStacModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM subjects";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();
            
          

            while (rs.next()) {
                AsubjectStacModel asubjectStacModel = new AsubjectStacModel();
                asubjectStacModel.setId(rs.getInt(1));
                asubjectStacModel.setYears(rs.getString(2));
                asubjectStacModel.setSem(rs.getString(3));
                asubjectStacModel.setSubName(rs.getString(4));
                asubjectStacModel.setSubCode(rs.getString(5));
                asubjectStacModel.setLecHr(rs.getString(6));
                asubjectStacModel.setTuteHr(rs.getString(7));
                asubjectStacModel.setLabHr(rs.getString(8));
                 asubjectStacModel.setEvlHr(rs.getString(9));
               
                list.add(asubjectStacModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

 ArrayList<AlecStacModel> getLecStac() {
        try {
            ArrayList<AlecStacModel> list = new ArrayList<AlecStacModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM lecturers";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();
          
            while (rs.next()) {
                AlecStacModel alecStacModel = new AlecStacModel();
                alecStacModel.setEmployeeID(rs.getInt(1));
                alecStacModel.setName(rs.getString(2));
                alecStacModel.setFaculty(rs.getString(3));
                alecStacModel.setDept(rs.getString(4));
                alecStacModel.setCenter(rs.getString(5));
                alecStacModel.setBuilding(rs.getString(6));
                alecStacModel.setLevel(rs.getString(7));
                alecStacModel.setLevel(rs.getString(8));
              
               
                list.add(alecStacModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
 
  ArrayList<AstudentStacModel> getStuStac() {
        try {
            ArrayList<AstudentStacModel> list = new ArrayList<AstudentStacModel>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT program,academicYear,semester ,count(DISTINCT groupNo), COUNT(subGroupNo),COUNT(sid) as NoOFStudent FROM `student`GROUP BY program,academicYear";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                AstudentStacModel astudentStacModel = new AstudentStacModel();
                astudentStacModel.setSprogram(rs.getString(1));
                 astudentStacModel.setAcadamicYear(rs.getString(2));
                astudentStacModel.setSsenester(rs.getString(3));
                astudentStacModel.setNoOfStu(rs.getString(6));
                astudentStacModel.setNoOfGroup(rs.getString(4));
                astudentStacModel.setNoOfSubGroup(rs.getString(5));
                
               
                list.add(astudentStacModel);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

   
}
