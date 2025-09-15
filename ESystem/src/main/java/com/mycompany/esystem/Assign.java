/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esystem;

/**
 *
 * @author amalda
 */
public class Assign extends ESystem{
    private int assignSubjId;
    
    public void setAssignSubjId(int assignSubjId) { 
        this.assignSubjId = assignSubjId; 
    }
    
    public int getAssignSubjId() { 
        return assignSubjId; 
    }
    
    public String assignSubject(int tid) {
        String checkQuery = "SELECT tid FROM Assign WHERE subjid = " + assignSubjId;
        try {
            ESystem.rs = ESystem.st.executeQuery(checkQuery);
            
            if (ESystem.rs.next()) {
                int assignedTeacherId = ESystem.rs.getInt("tid");
                if (assignedTeacherId == tid) {
                    return "Subject is already assigned to this teacher";
                } else {
                    return "Subject is already assigned to another teacher";
                }
            }
            
            String insertQuery = "INSERT INTO Assign (subjid, tid) VALUES (" + 
                                assignSubjId + ", " + tid + ")";
            ESystem.st.executeUpdate(insertQuery);
            return "Subject assigned successfully";
        } 
        catch (Exception ex) {
            return "Assignment failed: " + ex.getMessage();
        }
    }
    
    public String deleteSubject(int tid) {
        String deleteQuery = "DELETE FROM Assign WHERE subjid = " + assignSubjId + 
                           " AND tid = " + tid;
        try {
            int affectedRows = ESystem.st.executeUpdate(deleteQuery);
            
            if (affectedRows == 0) {
                return "No assignment found for subject and teacher";
            }
            return "Subject unassigned successfully";
        } 
        catch (Exception ex) {
            return "Unassignment failed: " + ex.getMessage();
        }
    }
}
