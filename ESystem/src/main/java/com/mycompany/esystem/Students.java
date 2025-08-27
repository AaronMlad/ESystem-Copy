/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esystem;

/**
 *
 * @author amalda
 */
public class Students extends ESystem{
    int studId;
    String studName;
    String studAddress;
    String studContact;
    String studGender;
    String studYearlvl;
    
    Students() {
        connectDB();
    }
    public void connectDB() {
        DBConnect();
    }
    
    public void SaveRecord(int id, String name, String add, String contact, String gender, String yrlvl){
        ESystem save = new ESystem();
        String query = "insert into Students values(" + id + ",'" + name + "','" + add + "','" + contact + "','" + gender + "','" + yrlvl + "');";
        try {
            save.st.executeUpdate(query);
            System.out.println("Insert Success!");
        } catch (Exception ex) {
            System.out.println("Failed to insert..." + ex);
        }
    }
    public void UpdateRecord(int id, String name, String add, String contact, String gender, String yrlvl){
        ESystem update = new ESystem();
        String query = "UPDATE Students SET studname='" + name + "',studadd='" + add + "',studcontact='" + contact + "',studgender='" + gender + "',studyrlvl='" + yrlvl + "' WHERE studid=" + id + ";";
        try {
            update.st.executeUpdate(query);
            System.out.println("Update Success!");
        } catch (Exception ex) {
            System.out.println("Failed to update..." + ex);
        }
    }
    public void DeleteRecord(int id){
        ESystem delete = new ESystem();
        String query = "DELETE FROM Students WHERE studid="+ id +";";
        try {
            delete.st.executeUpdate(query);
            System.out.println("Delete Success!");
        } catch (Exception ex) {
            System.out.println("Failed to delete..." + ex);
        }
    }
    public void LoadRecords() {
        System.out.println("Student records loaded!");
    }
}


