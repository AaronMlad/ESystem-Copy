/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esystem;

/**
 *
 * @author amalda
 */
public class Subject extends ESystem{
    int subjId;
    String subjCode;
    String subjSched;
    int subjUnits;
    String subjDesc;
    
    public void SaveRecord(String code, String schedule, int units, String desc){
        ESystem save = new ESystem();
        String query = "insert into Subjects (subjcode, subjsched, subjunits, subjdesc)" + "values('" + code + "','" + schedule + "','" + units + "','" + desc + "');";
        try {
            save.st.executeUpdate(query);
            System.out.println("Insert Success!");
        } catch (Exception ex) {
            System.out.println("Failed to insert..." + ex);
        }
    }
    public void UpdateRecord(int id, String code, String sched, int units, String desc){
        ESystem update = new ESystem();
        String query = "UPDATE Subjects SET subjcode='" + code + "',subjsched='" + sched + "',subjunits='" + units + "',subjdesc='" + desc + "' WHERE subjid=" + id + ";";
        try {
            update.st.executeUpdate(query);
            System.out.println("Update Success!");
        } catch (Exception ex) {
            System.out.println("Failed to update..." + ex);
        }        
    }
    public void DeleteRecord(int id){
        ESystem delete = new ESystem();
        String query = "DELETE FROM Subjects WHERE subjid="+ id +";";
        try {
            delete.st.executeUpdate(query);
            System.out.println("Delete Success!");
        } catch (Exception ex) {
            System.out.println("Failed to delete..." + ex);
        }
    }
    public void LoadRecords() {
        System.out.println("Subject Records Loaded!");
    }
}
