/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author itsto
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    static final String driver = "com.mysql.jdbc.Driver";  
    static final String dbURL = "jdbc:mysql://localhost/rms?autoReconnect=true&useSSL=false";
    static final String user = "root";
    static final String pass = "";
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs ;

     public DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(dbURL,user,pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void insertData(String sql) {
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            System.out.println(""+rs.getFetchSize());
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public Object[][] getData(int regiNo){
        int size=0;
        
        try {
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM `results` WHERE `regiNo` = "+regiNo;
            rs = stmt.executeQuery(sql);
            while (rs.next())size++;
            rs.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[][] results = new Object[size][4];
        try {
            while(rs.next())
            {
                results[rs.getRow()][1]= rs.getString("courseName");
                results[rs.getRow()][2]= rs.getString("courseCode");
                results[rs.getRow()][3]= rs.getString("courseCredit");
                results[rs.getRow()][4]= rs.getString("gpa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
     
    
    public static void main(String[] args) {
        DatabaseConnection data =new DatabaseConnection();
        
        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery("SELECT * FROM `results` WHERE `regiNo` = 1");
            int size=0;
            while (rs.next()) {
                size++;
            }rs.beforeFirst();
while (rs.next())
            System.out.println(""+rs.getString("gpa"));
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}

   
   
    
}