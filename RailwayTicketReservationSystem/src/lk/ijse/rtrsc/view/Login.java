/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view;

import com.sun.security.ntlm.Client;
import lk.ijse.rtrsc.view.classes.JpanelEdit;
import lk.ijse.rtrsc.view.classes.JLableEdit;
import lk.ijse.rtrsc.view.classes.JButtonEdit;
import lk.ijse.rtrsc.view.classes.JTextFieldEdit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import lk.ijse.rtrsc.controller.ManageUserController;
import lk.ijse.rtrsc.dto.UserDto;

/**
 *
 * @author Gnanod-PC
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        time();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new JpanelEdit();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new JLableEdit();
        cmbLoginType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new JTextFieldEdit(30);
        txtUserId = new JTextFieldEdit(30);
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new JButtonEdit();
        lblTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,150));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 80, 30));

        jLabel2.setBackground(new java.awt.Color(243, 156, 18,150));
        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("               Login");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 362, 62));

        cmbLoginType.setBackground(new java.awt.Color(204, 204, 204,100));
        cmbLoginType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Client" }));
        jPanel2.add(cmbLoginType, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 240, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Account Type");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 120, 30));

        txtPassword.setBackground(new java.awt.Color(204, 204, 204,100));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setOpaque(false);
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 240, 40));

        txtUserId.setBackground(new java.awt.Color(204, 204, 204,100));
        txtUserId.setForeground(new java.awt.Color(255, 255, 255));
        txtUserId.setOpaque(false);
        jPanel2.add(txtUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 240, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User Id");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 80, 30));

        jButton1.setBackground(new java.awt.Color(243, 156, 18,100));
        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton1.setText("Login");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 360, 430));

        lblTime.setFont(new java.awt.Font("Wide Latin", 1, 48)); // NOI18N
        lblTime.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 540, 540, 110));

        jLabel6.setFont(new java.awt.Font("Villa", 0, 36));
        jLabel6.setText("  Railway Ticket Reservation System");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/rtrsc/asset/shut-small (1).png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 600, 140, 130));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/ijse/rtrsc/asset/log2.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1367, 730));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 730));

        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            try {
                    String userType = (String) cmbLoginType.getSelectedItem();
                    String userId = txtUserId.getText();
                    String password = txtPassword.getText();
                    
                    UserDto login = new UserDto();
                    login.setUserId(userId);
                    login.setUserPassword(password);
                    login.setUserType(userType);
                    
            UserDto id =ManageUserController.searchPasssword(login);
            System.out.println("idddddd"+id);
            
            if (id != null) {
                    if (id.getUserType().equals("Administrator")) {
                    new MainFrame().setVisible(true);
                    this.dispose();

                } else if (id.getUserType().equals("Client")) {
                    String userStation = id.getUserAddress();
                        System.out.println("uuuu"+userStation);
                    new ReservationFrame(userStation).setVisible(true);
                    this.dispose();

                }
                
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect");
            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/lk/ijse/rtrsc/asset/shut-small (2).png")));

    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setIcon(new ImageIcon(getClass().getResource("/lk/ijse/rtrsc/asset/shut-small (1).png")));
    }//GEN-LAST:event_jLabel8MouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbLoginType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables

    public void time() {
        new Thread(() -> {
            while (true) {
                Date date = new Date();
                String currentdate = new SimpleDateFormat("hh:mm ").format(date);
                String currentdate1 = new SimpleDateFormat("aa").format(date);
                lblTime.setText(currentdate + "\n" + currentdate1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
            }
        }).start();
    }

}
