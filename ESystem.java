/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.esystem;

/**
 *
 * @author amalda
 */
import java.sql.*;

public class ESystem {
    //10.0.2.15
    static Connection con;
    static Statement st;
    static ResultSet rs;
    
    public static String db;
    public static String uname;
    public static String pswd;
    
    public static void setDatabaseCredentials(String dbName, String username, String password) {
        db = dbName;
        uname = username;
        pswd = password;
    }
    
    public static void main(String[] args) {
        //DBConnect();
        Login form = new Login();
        form.setVisible(true);
    }
    public void DBConnect() {
        try {
        // Expect that db, uname, pswd have been set via setDatabaseCredentials()
        if (db == null || uname == null || pswd == null) {
            throw new IllegalStateException("Database credentials not set. Please login and select a database first.");
        }
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://10.4.44.171:3306/"+ db +"?zeroDateTimeBehavior=convertToNull", uname, pswd);
        st = con.createStatement();
        System.out.println("Connected");
        } catch (Exception ex){
            System.out.println("Failed to Connect" + ex);
        }
    }
}
