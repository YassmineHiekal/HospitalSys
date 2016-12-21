/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Patient extends javax.swing.JFrame {

    private String id;
    public Patient() {
        initComponents();
    }
    public Connection getConnection()
{
   Connection con=null;
        try {
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
       }
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","123456");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
}
    public void Patinet(String ID)
    {
        id=ID;  
         PatientNameDisplay();
         MedicalHistory();
         DoctorName();
         NurseName();
         RoomID();
         
    }
    
    public void PatientNameDisplay()
    {
       Connection connection = getConnection();
       int Id = Integer.valueOf(id);
       String query = "select Fname ,Mname ,Lname from patient where ID ="+Id;
       Statement st;
       ResultSet rs;
       String Firstname ;
       String Middlename;
       String Lastname ;
        try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           
           while(rs.next())
           {
               Firstname=rs.getString("Fname");
               Middlename=rs.getString("Mname");
               Lastname=rs.getString("Lname");
               
               String Name=Firstname+" "+Middlename+" "+Lastname+" ";
               jLabel3.setText(Name);
           } }
      catch (SQLException e) {
          System.out.println (e);
       }
       
    }
    
    public void MedicalHistory()
    {
        Connection connection = getConnection();
       int Id = Integer.valueOf(id);
       String query = "select MedicalHistory from patient where ID ="+Id;
       Statement st;
       ResultSet rs;
       String Mhistory;
        try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           
           while(rs.next())
           {
               Mhistory=rs.getString("MedicalHistory");
               jLabel4.setText(Mhistory);
           } }
      catch (SQLException e) {
          System.out.println (e);
       }
       
    }
   
    public void DoctorName()
    {
       Connection connection = getConnection();
       int Id = Integer.valueOf(id);
       String query="select Fname,Mname,Lname from DOCTOR,TREATED_BY where ID=DoctorID And PatientID ="+Id;
       Statement st;
       ResultSet rs;
       String Firstname ;
       String Middlename;
       String Lastname ;
        try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           while(rs.next())
           {
               Firstname=rs.getString("Fname");
               Middlename=rs.getString("Mname");
               Lastname=rs.getString("Lname");
               
               String Name=Firstname+" "+Middlename+" "+Lastname+" ";
               jLabel9.setText(Name);
           } }
      catch (SQLException e) {
          System.out.println (e);
       }
       
    }
    
    public void NurseName()
    {
        Connection connection = getConnection();
       int Id = Integer.valueOf(id);
       String query="select Fname,Mname,Lname from NURSE where ID in(select NurseID from SERVE where RoomID in(select RooMID from ROOM_PATIENT where PatientID="+Id+" ) )";
       Statement st;
       ResultSet rs;
       String Firstname ;
       String Middlename;
       String Lastname ;
        try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           while(rs.next())
           {
               Firstname=rs.getString("Fname");
               Middlename=rs.getString("Mname");
               Lastname=rs.getString("Lname");
               
               String Name=Firstname+" "+Middlename+" "+Lastname+" ";
               jLabel10.setText(Name);
           } }
      catch (SQLException e) {
          System.out.println (e);
       }
       
    }
    
    public void RoomID()
    {
        Connection connection = getConnection();
       int Id = Integer.valueOf(id);
       String query = "select RooMID from ROOM_PATIENT where PatientID="+Id;
       Statement st;
       ResultSet rs;
       int RoomID;
        try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           
           while(rs.next())
           {
               RoomID=rs.getInt("RooMID");
               String iD= String.valueOf(Id);
               jLabel11.setText(iD);
           } }
      catch (SQLException e) {
          System.out.println (e);
       }
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jSlider1 = new javax.swing.JSlider();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Patient Name: ");

        jLabel5.setText("Medical Hitory:");

        jLabel6.setText("Assigned Doctor Name:");

        jLabel7.setText("Assigned Nurse Name:");

        jLabel8.setText("Room Number:");

        jLabel3.setText("            ");

        jLabel4.setText("           ");

        jLabel9.setText("           ");

        jLabel10.setText("           ");

        jLabel11.setText("            ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                    .addComponent(jLabel10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
