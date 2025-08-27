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
    
    static String db;
    static String uname;
    static String pswd;
    
    public static void main(String[] args) {
        //DBConnect();
        StudentGUI form = new StudentGUI();
        form.setVisible(true);
    }
    public void DBConnect() {
        try {
        db = "1stSem_sy2025_2026";
        uname = "root";
        pswd = "stoic";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://10.4.44.171:3306/"+ db +"?zeroDateTimeBehavior=convertToNull", uname, pswd);
        st = con.createStatement();
        System.out.println("Connected");
        } catch (Exception ex){
            System.out.println("Failed to Connect" + ex);
        }
    }
}
