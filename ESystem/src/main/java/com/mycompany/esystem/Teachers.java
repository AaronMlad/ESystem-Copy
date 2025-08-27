/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esystem;

/**
 *
 * @author amalda
 */
public class Teachers extends ESystem{
    int teachId;
    String teachName;
    String teachAdd;
    String teachContact;
    String teachDept;
    
    Teachers() {
        connectDB();
    }
    public void connectDB() {
        DBConnect();
    }
    
    public void SaveRecord(String name, String add, String contact, String dept){
        ESystem save = new ESystem();
        String query = "insert into Teachers (tname, tadd, tcontact, tdept)" + "values('" + name + "','" + add + "','" + contact + "','" + dept + "');";
        try {
            save.st.executeUpdate(query);
            System.out.println("Insert Success!");
        } catch (Exception ex) {
            System.out.println("Failed to insert..." + ex);
        }
    }
    public void UpdateRecord(int id, String name, String add, String contact, String dept){
        ESystem update = new ESystem();
        String query = "UPDATE Teachers SET tname='" + name + "',tadd='" + add + "',tcontact='" + contact + "',tdept='" + dept + "' WHERE tid=" + id + ";";
        try {
            update.st.executeUpdate(query);
            System.out.println("Update Success!");
        } catch (Exception ex) {
            System.out.println("Failed to update..." + ex);
        }
    }
    public void DeleteRecord(int id){
        ESystem delete = new ESystem();
        String query = "DELETE FROM Teachers WHERE tid="+ id +";";
        try {
            delete.st.executeUpdate(query);
            System.out.println("Delete Success!");
        } catch (Exception ex) {
            System.out.println("Failed to delete..." + ex);
        }
    }
    public void LoadRecords() {
        System.out.println("Teacher records loaded!");
    }
}
