/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view;

import java.awt.Checkbox;
import java.awt.Color;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import lk.ijse.rtrsc.controller.IdController;
import lk.ijse.rtrsc.controller.ManageTrainController;
import lk.ijse.rtrsc.controller.ManageWagonController;
import lk.ijse.rtrsc.dto.IdDto;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.utilities.Validation;

/**
 *
 * @author Gnanod-PC
 */
public class ManageTrain extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form ManageTrain
     */
    private DefaultTableModel dtm;
    String trainId;
    boolean selectTrain;
    String trainsId;
    String engineNumber;
    String trainType;
    int firstClassQty;
    int seconClassQty;
    int thirdClassQty;
    int observation;

    public ManageTrain() {
        initComponents();
        dtm = (DefaultTableModel) tblTrain.getModel();
        selectTrain = false;
        txtTrainId.setBorder(new LineBorder(Color.black, 1));
        txtEngineId.setBorder(new LineBorder(Color.black, 1));
        txtQtyFirst.setBorder(new LineBorder(Color.black, 1));
        txtQtySecond.setBorder(new LineBorder(Color.black, 1));
        txtQtyFourth.setBorder(new LineBorder(Color.black, 1));
        txtQtyThird.setBorder(new LineBorder(Color.black, 1));
       // getAllTrains();
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageTrainController.getSubject().registerObserver(this);
        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadId();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTrainId = new javax.swing.JTextField();
        txtEngineId = new javax.swing.JTextField();
        txtQtyFourth = new javax.swing.JTextField();
        chkObservation = new javax.swing.JCheckBox();
        chkFirst = new javax.swing.JCheckBox();
        chkSecond = new javax.swing.JCheckBox();
        chkThird = new javax.swing.JCheckBox();
        txtQtyFirst = new javax.swing.JTextField();
        txtQtySecond = new javax.swing.JTextField();
        txtQtyThird = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSearchTrain = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrain = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbTrainType = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 157, 175));
        jLabel2.setText("Train ID");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 160, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 157, 175));
        jLabel3.setText("Manage Train");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 390, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 157, 175));
        jLabel4.setText("Class Type");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 160, 40));

        txtTrainId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrainIdActionPerformed(evt);
            }
        });
        txtTrainId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTrainIdKeyReleased(evt);
            }
        });
        add(txtTrainId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 300, 40));

        txtEngineId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEngineIdKeyReleased(evt);
            }
        });
        add(txtEngineId, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 290, 40));

        txtQtyFourth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyFourthKeyReleased(evt);
            }
        });
        add(txtQtyFourth, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 140, 40));

        chkObservation.setBackground(new java.awt.Color(255, 255, 255));
        chkObservation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkObservation.setForeground(new java.awt.Color(27, 157, 175));
        chkObservation.setText("Observation Saloon");
        add(chkObservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, -1, -1));

        chkFirst.setBackground(new java.awt.Color(255, 255, 255));
        chkFirst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkFirst.setForeground(new java.awt.Color(27, 157, 175));
        chkFirst.setText("First Class");
        add(chkFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        chkSecond.setBackground(new java.awt.Color(255, 255, 255));
        chkSecond.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkSecond.setForeground(new java.awt.Color(27, 157, 175));
        chkSecond.setText("Second Class");
        add(chkSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        chkThird.setBackground(new java.awt.Color(255, 255, 255));
        chkThird.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkThird.setForeground(new java.awt.Color(27, 157, 175));
        chkThird.setText("Third Class");
        add(chkThird, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, -1));

        txtQtyFirst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyFirstKeyReleased(evt);
            }
        });
        add(txtQtyFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 140, 40));

        txtQtySecond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtySecondActionPerformed(evt);
            }
        });
        txtQtySecond.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtySecondKeyReleased(evt);
            }
        });
        add(txtQtySecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 140, 40));

        txtQtyThird.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyThirdActionPerformed(evt);
            }
        });
        txtQtyThird.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyThirdKeyReleased(evt);
            }
        });
        add(txtQtyThird, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 140, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 157, 175));
        jLabel5.setText("Train Type");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 150, 40));
        add(txtSearchTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 220, 30));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 90, 30));

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 620, 90, 40));

        tblTrain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "Train Id", "TrainType", "Engine Number", "First Class Sheet Quantity", "Second Class Sheet Quantity", "Third Class Sheet Quantity", "Observation Saloon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTrain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTrainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTrain);
        if (tblTrain.getColumnModel().getColumnCount() > 0) {
            tblTrain.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblTrain.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 1070, 200));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 620, 90, 40));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 90, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 157, 175));
        jLabel6.setText("Engine Id");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 100, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 157, 175));
        jLabel7.setText("Quantity Of Wagons");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 150, 40));

        cmbTrainType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intercity", "Express", "Normal", "NightMale", "Slow" }));
        add(cmbTrainType, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 180, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtQtySecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtySecondActionPerformed
        if (!txtQtySecond.getText().isEmpty()) {
            Validation.validateInt(txtQtySecond);
        }
    }//GEN-LAST:event_txtQtySecondActionPerformed

    private void txtQtyThirdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyThirdActionPerformed
        if (!txtQtyThird.getText().isEmpty()) {
            Validation.validateInt(txtQtyThird);
        }
    }//GEN-LAST:event_txtQtyThirdActionPerformed

    private void txtTrainIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrainIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrainIdActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String engineId = txtEngineId.getText();
            String trainId = txtTrainId.getText();
            String trainType = (String) cmbTrainType.getSelectedItem();
            boolean first;
            boolean second;
            boolean third;
            boolean observation;
            if (chkFirst.isSelected()) {
                first = true;
            } else {
                first = false;
            }
            if (chkSecond.isSelected()) {
                second = true;
            } else {
                second = false;
            }
            if (chkThird.isSelected()) {
                third = true;
            } else {
                third = false;
            }
            if (chkObservation.isSelected()) {
                observation = true;
            } else {
                observation = false;
            }

            if (trainId.isEmpty()) {
                txtTrainId.setBorder(new LineBorder(Color.red, 1));
            }
            if (engineId.isEmpty()) {
                txtEngineId.setBorder(new LineBorder(Color.red, 1));
            }
//            if (chkFirst.isSelected() || chkSecond.isSelected() || chkThird.isSelected() || chkObservation.isSelected()) {
//                JOptionPane.showMessageDialog(this, "Plz Select CheckBox");
//            }
            if (txtQtyFirst.getText().isEmpty()) {
                txtQtyFirst.setBorder(new LineBorder(Color.red, 1));
            }
            if (txtQtyFirst.getText().isEmpty()) {
                txtQtyFirst.setBorder(new LineBorder(Color.red, 1));
            }
            if (txtQtySecond.getText().isEmpty()) {
                txtQtySecond.setBorder(new LineBorder(Color.red, 1));
            }
            if (txtQtyThird.getText().isEmpty()) {
                txtQtyThird.setBorder(new LineBorder(Color.red, 1));
            }
            if (txtQtyFourth.getText().isEmpty()) {
                txtQtyFourth.setBorder(new LineBorder(Color.red, 1));
            }

            if (!txtTrainId.getText().isEmpty() && !txtEngineId.getText().isEmpty() && !txtQtyFirst.getText().isEmpty() && !txtQtySecond.getText().isEmpty() && !txtQtyThird.getText().isEmpty() && !txtQtyFourth.getText().isEmpty() || chkFirst.isSelected() == true || chkSecond.isSelected() == true || chkThird.isSelected() == true || chkObservation.isSelected() == true) {
                int firstClzWagonQty = Integer.parseInt(txtQtyFirst.getText());
                int secondClzWagonQty = Integer.parseInt(txtQtySecond.getText());
                int thirdClzWagonQty = Integer.parseInt(txtQtyThird.getText());
                int observationWagonQty = Integer.parseInt(txtQtyFourth.getText());

                int total = firstClzWagonQty + secondClzWagonQty + thirdClzWagonQty + observationWagonQty;
                if (total > 17) {
                    JOptionPane.showMessageDialog(this, "Wagon Qty is High Maximum Wagon Qty is 17");
                } else {
                    TrainDto trainDto = new TrainDto(trainId, engineId, first, second, third, observation, firstClzWagonQty, secondClzWagonQty, thirdClzWagonQty, observationWagonQty);
                    trainDto.setTrainType(trainType);
                    trainDto.setStatus("Available");
                    trainDto.setRouteStatus("Available");
                    boolean isAdded = ManageTrainController.addTrain(trainDto);
                    if (isAdded) {
                        JOptionPane.showMessageDialog(this, "Added SuccessFully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Added Fail");
                    }
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String trainId = txtSearchTrain.getText();
            TrainDto train = ManageTrainController.searchTrain(trainId);
            if (train == null) {
                JOptionPane.showMessageDialog(this, "No Train Found");
            } else {
                dtm.setRowCount(0);
                Object[] ob = {train.getTrainId(), train.getEngineNumber(), train.getFirstClassWagonQty(), train.getSecondClassWagonQty(), train.getThirdClassWagonQty(), train.getObservationSaloonWagonQty()};
                dtm.addRow(ob);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            boolean firstClass = true;
            boolean secondClass = true;
            boolean thirdClass = true;
            boolean observationSaloon = true;
            if (firstClassQty == 0) {
                firstClass = false;
            }

            if (seconClassQty == 0) {
                secondClass = false;
            }

            if (thirdClassQty == 0) {
                thirdClass = false;
            }

            if (observation == 0) {
                observationSaloon = false;
            }
            System.out.println("wwwwwwww" + firstClassQty);

            TrainDto train = new TrainDto(trainsId, engineNumber, firstClass, secondClass, thirdClass, observationSaloon, firstClassQty, seconClassQty, thirdClassQty, observation);
            //train.setStatus("Available");
            boolean isUpdated = ManageTrainController.updateTrain(train);
            if (isUpdated) {
                JOptionPane.showMessageDialog(this, "Updated Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Updated Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(WagonSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
//        boolean tbl = (boolean) tblTrain.getValueAt(tblTrain.getSelectedRow(), 0);
//        boolean firstClass = true;
//        boolean secondClass = true;
//        boolean thirdClass = true;
//        boolean observationSaloon = true;
//        if (tbl == true) {
//            String EngineNumber = tblTrain.getValueAt(tblTrain.getSelectedRow(), 2).toString();
//            trainId = tblTrain.getValueAt(tblTrain.getSelectedRow(), 1).toString();
//            int firstClassQuantity = Integer.parseInt((String) tblTrain.getValueAt(tblTrain.getSelectedRow(), 3));
////            int secondClassQuantity = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 4);
////            int thirdClassQuantity = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 5);
////            int observationSaloonQuantity = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 6);
//            System.out.println("firstClassQuantity" + firstClassQuantity);
////            System.out.println("secondClassQuantity"+ secondClassQuantity);
////            System.out.println("thirdClassQuantity"+ thirdClassQuantity);
////            System.out.println("EngineNumber"+ EngineNumber);
//        }
//        if (tbl == true) {
//            try {
//                trainId = tblTrain.getValueAt(tblTrain.getSelectedRow(), 1).toString();
//                String EngineNumber = tblTrain.getValueAt(tblTrain.getSelectedRow(), 2).toString();
//                int firstClassQuantity = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 3);
//                if(firstClassQuantity==0){
//                    firstClass=false;
//                }
//                int secondClassQuantity = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 4);
//                if(secondClassQuantity==0){
//                    secondClass=false;
//                }
//                int thirdClassQuantity = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 5);
//                if(thirdClassQuantity==0){
//                    thirdClass=false;
//                }
//                int observationSaloonQuantity = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 6);
//                
//                if(observationSaloonQuantity==0){
//                    observationSaloon=false;
//                }
//                
//                TrainDto train = new TrainDto(trainId, EngineNumber, firstClass, secondClass, thirdClass, observationSaloon, firstClassQuantity, secondClassQuantity, thirdClassQuantity, observationSaloonQuantity);
//                
//                boolean isUpdated = ManageTrainController.updateTrain(train);
//                if(isUpdated){
//                    JOptionPane.showMessageDialog(this,"Updated SuccessFully");
//                }else{
//                    JOptionPane.showMessageDialog(this,"Updated Fail");
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Please Select The Row in Table");
//        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblTrainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainMouseClicked
        selectTrain = (boolean) tblTrain.getValueAt(tblTrain.getSelectedRow(), 0);
        trainsId = (String) tblTrain.getValueAt(tblTrain.getSelectedRow(), 1);
        trainType = (String) tblTrain.getValueAt(tblTrain.getSelectedRow(), 2);
        engineNumber = (String) tblTrain.getValueAt(tblTrain.getSelectedRow(), 3);
        firstClassQty = Integer.parseInt(tblTrain.getValueAt(tblTrain.getSelectedRow(), 4).toString());
        seconClassQty = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 5);
        thirdClassQty = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 6);
        observation = (int) tblTrain.getValueAt(tblTrain.getSelectedRow(), 7);
        System.out.println("uuuuuuuuuuuuuuuuuuuu" + firstClassQty);

//       trainId = tblTrain.getValueAt(tblTrain.getSelectedRow(), 0).toString();
//       String EnfineNumber = tblTrain.getValueAt(tblTrain.getSelectedRow(), 1).toString();
    }//GEN-LAST:event_tblTrainMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String deleteTrainId = tblTrain.getValueAt(tblTrain.getSelectedRow(), 1).toString();

            boolean isDeleted = false;
            if (selectTrain == true) {
                isDeleted = ManageTrainController.deleteTrain(deleteTrainId);
            }

            if (isDeleted) {
                JOptionPane.showMessageDialog(this, "Deleted SuccessFully");

            } else {
                JOptionPane.showMessageDialog(this, "Deleted Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtQtyFirstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyFirstKeyReleased
        if (!txtQtyFirst.getText().isEmpty()) {
            Validation.validateInt(txtQtyFirst);
            txtQtyFirst.setBorder(new LineBorder(Color.black, 1));
        }

    }//GEN-LAST:event_txtQtyFirstKeyReleased

    private void txtQtyFourthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyFourthKeyReleased
        if (!txtQtyFourth.getText().isEmpty()) {
            Validation.validateInt(txtQtyFourth);
            txtQtyFourth.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtQtyFourthKeyReleased

    private void txtTrainIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrainIdKeyReleased
        String name = txtTrainId.getText();
        if (name.isEmpty()) {
            txtTrainId.setBorder(new LineBorder(Color.red, 1));
        } else {
            txtTrainId.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtTrainIdKeyReleased

    private void txtEngineIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEngineIdKeyReleased
        String name = txtEngineId.getText();
        if (name.isEmpty()) {
            txtEngineId.setBorder(new LineBorder(Color.red, 1));
        } else {
            txtEngineId.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtEngineIdKeyReleased

    private void txtQtySecondKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtySecondKeyReleased
        if (!txtQtySecond.getText().isEmpty()) {
            Validation.validateInt(txtQtySecond);
            txtQtySecond.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtQtySecondKeyReleased

    private void txtQtyThirdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyThirdKeyReleased
        if (!txtQtyThird.getText().isEmpty()) {
            Validation.validateInt(txtQtyThird);
            txtQtyThird.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtQtyThirdKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkFirst;
    private javax.swing.JCheckBox chkObservation;
    private javax.swing.JCheckBox chkSecond;
    private javax.swing.JCheckBox chkThird;
    private javax.swing.JComboBox<String> cmbTrainType;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTrain;
    private javax.swing.JTextField txtEngineId;
    private javax.swing.JTextField txtQtyFirst;
    private javax.swing.JTextField txtQtyFourth;
    private javax.swing.JTextField txtQtySecond;
    private javax.swing.JTextField txtQtyThird;
    private javax.swing.JTextField txtSearchTrain;
    private javax.swing.JTextField txtTrainId;
    // End of variables declaration//GEN-END:variables

    private void getAllTrains() {
        try {
            List<TrainDto> trainDto = ManageTrainController.getAllTrains();
            dtm.setRowCount(0);

            if (trainDto != null) {

                for (TrainDto train : trainDto) {

                    Object[] ob = {false, train.getTrainId(), train.getEngineNumber(), train.getTrainType(), train.getFirstClassWagonQty(), train.getSecondClassWagonQty(), train.getThirdClassWagonQty(), train.getObservationSaloonWagonQty()};
                    dtm.addRow(ob);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateObservers() throws Exception {
         loadId();
        getAllTrains();
    }
    public void loadId(){

        IdDto idDTO=new IdDto("trainentity", "trainId");
        try {
            String id=IdController.getNewID(idDTO, "T");
            txtTrainId.setText(id);
        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
