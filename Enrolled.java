/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.esystem;

/**
 *
 * @author amalda
 */
public class Enrolled extends ESystem{
    private int enrollSubjId;
    
    public void setsubjid(int sid) { 
        this.enrollSubjId = sid; 
    }
    
    public int getsubjid() { 
        return enrollSubjId; 
    }
    
    public int getEnrollmentId() {
        try {
            String query = "SELECT MAX(eid) + 1 FROM Enroll";
            ESystem.rs = ESystem.st.executeQuery(query);
            
            if (ESystem.rs.next()) {
                int nextId = ESystem.rs.getInt(1);
                return ESystem.rs.wasNull() ? 1 : nextId;
            }
            return 1;
        } 
        catch (Exception ex) {
            System.out.println("Error getting enrollment ID: " + ex.getMessage());
            return 1;
        }
    }
    
    public String enrollStudent(int studid) {
        String checkQuery = "SELECT COUNT(*) FROM Enroll WHERE studid = " + studid + 
                           " AND subjid = " + enrollSubjId;
        try {
            ESystem.rs = ESystem.st.executeQuery(checkQuery);
            
            if (ESystem.rs.next()) {
                int count = ESystem.rs.getInt(1);
                if (count > 0) {
                    return "Student already enrolled in this subject";
                }
            }
            
            int nextEid = getEnrollmentId();
            String insertQuery = "INSERT INTO Enroll (eid, studid, subjid) VALUES (" +
                                nextEid + ", " + studid + ", " + enrollSubjId + ")";
            ESystem.st.executeUpdate(insertQuery);
            return "Enrollment successful";
        } 
        catch (Exception ex) {
            return "Enrollment failed: " + ex.getMessage();
        }
    }
    
    public String dropSubject(int studid) {
        String deleteQuery = "DELETE FROM Enroll WHERE studid = " + studid + 
                            " AND subjid = " + enrollSubjId;
        try {
            int affectedRows = ESystem.st.executeUpdate(deleteQuery);
            
            if (affectedRows == 0) {
                return "No enrollment found for student and subject";
            }
            return "Subject dropped successfully";
        } 
        catch (Exception ex) {
            return "Drop failed: " + ex.getMessage();
        }
    }
}
