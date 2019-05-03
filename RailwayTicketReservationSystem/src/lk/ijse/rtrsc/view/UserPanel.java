/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.rtrsc.controller.ManageStationController;
import lk.ijse.rtrsc.controller.ManageUserController;
import lk.ijse.rtrsc.dto.StationDto;
import lk.ijse.rtrsc.dto.UserDto;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Gnanod
 */
public class UserPanel extends javax.swing.JPanel {
    //  private User user;

    /**
     * Creates new form UserPanel
     */
    public UserPanel() {
        initComponents();
        lblConfirmPassword.setVisible(false);
        getAllStations();
        AutoCompleteDecorator.decorate(cmbLoadStation);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbGenderGroup = new javax.swing.ButtonGroup();
        pnlManageUser = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        txtUserAddress = new javax.swing.JTextField();
        txtUserId = new javax.swing.JTextField();
        txtUserTelNumber = new javax.swing.JTextField();
        txtUserConfirmPassword = new javax.swing.JPasswordField();
        txtUserPassword = new javax.swing.JPasswordField();
        lblConfirmPassword = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnUserFemale = new javax.swing.JRadioButton();
        btnUserMale = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        cmbLoadStation = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1070, 660));

        pnlManageUser.setBackground(new java.awt.Color(255, 255, 255));
        pnlManageUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        pnlManageUser.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 400, 40));

        txtUserAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUserAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserAddressActionPerformed(evt);
            }
        });
        txtUserAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserAddressKeyPressed(evt);
            }
        });
        pnlManageUser.add(txtUserAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 400, 40));

        txtUserId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIdActionPerformed(evt);
            }
        });
        txtUserId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserIdKeyPressed(evt);
            }
        });
        pnlManageUser.add(txtUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 400, 40));

        txtUserTelNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUserTelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserTelNumberActionPerformed(evt);
            }
        });
        txtUserTelNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserTelNumberKeyPressed(evt);
            }
        });
        pnlManageUser.add(txtUserTelNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 400, 40));

        txtUserConfirmPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUserConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserConfirmPasswordActionPerformed(evt);
            }
        });
        txtUserConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserConfirmPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserConfirmPasswordKeyReleased(evt);
            }
        });
        pnlManageUser.add(txtUserConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 400, 40));

        txtUserPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUserPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserPasswordActionPerformed(evt);
            }
        });
        txtUserPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserPasswordKeyPressed(evt);
            }
        });
        pnlManageUser.add(txtUserPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 400, 40));

        lblConfirmPassword.setBackground(new java.awt.Color(59, 62, 77));
        lblConfirmPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblConfirmPassword.setForeground(new java.awt.Color(255, 0, 0));
        lblConfirmPassword.setText("Password Did not match  !!!!");
        pnlManageUser.add(lblConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 210, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(27, 157, 175));
        jLabel18.setText("          User Type");
        jLabel18.setToolTipText("");
        jLabel18.setOpaque(true);
        jLabel18.setRequestFocusEnabled(false);
        pnlManageUser.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 260, 40));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 157, 175));
        jLabel17.setText("         Station");
        jLabel17.setToolTipText("");
        jLabel17.setOpaque(true);
        jLabel17.setRequestFocusEnabled(false);
        pnlManageUser.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 260, 40));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 157, 175));
        jLabel16.setText("          Tel Number");
        jLabel16.setToolTipText("");
        jLabel16.setOpaque(true);
        jLabel16.setRequestFocusEnabled(false);
        pnlManageUser.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 260, 40));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 157, 175));
        jLabel15.setText("          Confirm Password");
        jLabel15.setToolTipText("");
        jLabel15.setOpaque(true);
        jLabel15.setRequestFocusEnabled(false);
        pnlManageUser.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 260, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 157, 175));
        jLabel14.setText("          Password");
        jLabel14.setToolTipText("");
        jLabel14.setOpaque(true);
        jLabel14.setRequestFocusEnabled(false);
        pnlManageUser.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 260, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 157, 175));
        jLabel13.setText("          Gender");
        jLabel13.setToolTipText("");
        jLabel13.setOpaque(true);
        jLabel13.setRequestFocusEnabled(false);
        pnlManageUser.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 260, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 157, 175));
        jLabel10.setText("          User Id");
        jLabel10.setToolTipText("");
        jLabel10.setOpaque(true);
        jLabel10.setRequestFocusEnabled(false);
        pnlManageUser.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 260, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(53, 126, 120));
        jLabel5.setText("                        Manage User");
        jLabel5.setToolTipText("");
        pnlManageUser.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 770, 50));

        btnUserFemale.setBackground(new java.awt.Color(255, 255, 255));
        cmbGenderGroup.add(btnUserFemale);
        btnUserFemale.setText("Female");
        btnUserFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserFemaleActionPerformed(evt);
            }
        });
        pnlManageUser.add(btnUserFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 90, -1));

        btnUserMale.setBackground(new java.awt.Color(255, 255, 255));
        cmbGenderGroup.add(btnUserMale);
        btnUserMale.setText("Male");
        pnlManageUser.add(btnUserMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 90, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(27, 157, 175));
        jLabel19.setText("          User Name");
        jLabel19.setToolTipText("");
        jLabel19.setOpaque(true);
        jLabel19.setRequestFocusEnabled(false);
        pnlManageUser.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 260, 40));

        cmbType.setEditable(true);
        cmbType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Client" }));
        pnlManageUser.add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 400, 40));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlManageUser.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 500, 140, 60));

        pnlManageUser.add(cmbLoadStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 400, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlManageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed

    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                txtUserId.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                txtUserId.requestFocus();
                break;
        }
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void txtUserAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserAddressActionPerformed

    private void txtUserAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserAddressKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                txtUserTelNumber.requestFocus();
                break;
            case KeyEvent.VK_ENTER:
                txtUserName.requestFocus();
        }
    }//GEN-LAST:event_txtUserAddressKeyPressed

    private void txtUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIdActionPerformed

    }//GEN-LAST:event_txtUserIdActionPerformed

    private void txtUserIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserIdKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                txtUserPassword.requestFocus();
                break;
            case KeyEvent.VK_DOWN:
                txtUserPassword.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtUserName.requestFocus();
                break;
        }
    }//GEN-LAST:event_txtUserIdKeyPressed

    private void txtUserTelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserTelNumberActionPerformed

    }//GEN-LAST:event_txtUserTelNumberActionPerformed

    private void txtUserTelNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserTelNumberKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                txtUserId.requestFocus();
            case KeyEvent.VK_DOWN:
                txtUserAddress.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtUserConfirmPassword.requestFocus();
                break;
        }

    }//GEN-LAST:event_txtUserTelNumberKeyPressed

    private void txtUserConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserConfirmPasswordActionPerformed
        comfirmPassword();
    }//GEN-LAST:event_txtUserConfirmPasswordActionPerformed

    private void txtUserConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserConfirmPasswordKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                txtUserTelNumber.requestFocus();
            case KeyEvent.VK_DOWN:
                txtUserTelNumber.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtUserPassword.requestFocus();
                break;
        }
    }//GEN-LAST:event_txtUserConfirmPasswordKeyPressed

    private void txtUserPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserPasswordActionPerformed

    private void txtUserPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserPasswordKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                txtUserConfirmPassword.requestFocus();
            case KeyEvent.VK_DOWN:
                txtUserConfirmPassword.requestFocus();
                break;
            case KeyEvent.VK_UP:
                txtUserId.requestFocus();
                break;
        }
    }//GEN-LAST:event_txtUserPasswordKeyPressed

    private void btnUserFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserFemaleActionPerformed

    private void txtUserConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserConfirmPasswordKeyReleased

    }//GEN-LAST:event_txtUserConfirmPasswordKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String userName = txtUserName.getText();
            String userId = txtUserId.getText();
            String userGender = "male";
            if (btnUserMale.isSelected()) {
                userGender = "Male";
            }
            if (btnUserFemale.isSelected()) {
                userGender = "Female";
            }
            String userType = (String) cmbType.getSelectedItem();
            System.out.println("userType" + userType);
            String userPassword = txtUserPassword.getText();
            String userTelNum = txtUserTelNumber.getText();
            String userAddress = (String) cmbLoadStation.getSelectedItem();

            UserDto user = new UserDto(userName, userId, userType, userGender, userPassword, userTelNum, userAddress);

            boolean isAdded = ManageUserController.addUser(user);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Added Success");

            } else {
                JOptionPane.showMessageDialog(this, "Oops Updated Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnUserFemale;
    private javax.swing.JRadioButton btnUserMale;
    private javax.swing.ButtonGroup cmbGenderGroup;
    private javax.swing.JComboBox<String> cmbLoadStation;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JPanel pnlManageUser;
    private javax.swing.JTextField txtUserAddress;
    private javax.swing.JPasswordField txtUserConfirmPassword;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPasswordField txtUserPassword;
    private javax.swing.JTextField txtUserTelNumber;
    // End of variables declaration//GEN-END:variables

    private void comfirmPassword() {
        String password = txtUserPassword.getText();
        String tconfirmPassword = txtUserConfirmPassword.getText();
        if (!password.equals(tconfirmPassword)) {
            lblConfirmPassword.setVisible(true);
        } else {
            lblConfirmPassword.setVisible(false);
        }
    }

    private void getAllStations() {
        try {
            List<StationDto> stationDto = ManageStationController.getAllStation();
            // dtm.setRowCount(0);
            if (stationDto != null) {
                for (StationDto station : stationDto) {
                    cmbLoadStation.addItem(station.getStationName());

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
