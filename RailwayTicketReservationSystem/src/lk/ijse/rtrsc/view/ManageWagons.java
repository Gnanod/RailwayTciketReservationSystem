/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view;

import java.awt.Color;
import java.rmi.server.UnicastRemoteObject;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import lk.ijse.rtrsc.controller.IdController;
import lk.ijse.rtrsc.controller.ManageTrainController;
import lk.ijse.rtrsc.controller.ManageWagonController;
import lk.ijse.rtrsc.dto.IdDto;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.dto.Wagon;
import lk.ijse.rtrsc.dto.WagonDetailDto;
import lk.ijse.rtrsc.dto.WagonDetail_PkDto;
import lk.ijse.rtrsc.dto.WagonDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.utilities.Validation;

/**
 *
 * @author Gnanod-PC
 */
public class ManageWagons extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form ManageTrain
     */
    private DefaultTableModel dtm;
    private DefaultTableModel dtmWagonDetail;

    public ManageWagons() {
        initComponents();
        dtm = (DefaultTableModel) tblTrain.getModel();
        dtmWagonDetail = (DefaultTableModel) tblWagonDetail.getModel();
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageWagonController.getSubject().registerObserver(this);
            ManageTrainController.getSubject().registerObserver(this);
            ManageTrainController.getSubject().notifyObservers();
        } catch (Exception ex) {
            Logger.getLogger(ManageWagons.class.getName()).log(Level.SEVERE, null, ex);
        }
        // getAllTrains();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClzGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        txtSearchTrain = new javax.swing.JTextField();
        txtSeatQuantity = new javax.swing.JTextField();
        btnSearchTrain = new javax.swing.JButton();
        txtWagonId = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWagonDetail = new javax.swing.JTable();
        jrThird = new javax.swing.JRadioButton();
        jrbtnObservation = new javax.swing.JRadioButton();
        jrFirst = new javax.swing.JRadioButton();
        jrSecond = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTrain = new javax.swing.JTable();
        btnAddToTable = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTrainId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Remove");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 140, 30));
        add(txtSearchTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 390, 30));

        txtSeatQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSeatQuantityKeyReleased(evt);
            }
        });
        add(txtSeatQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 320, 30));

        btnSearchTrain.setText("Search");
        btnSearchTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTrainActionPerformed(evt);
            }
        });
        add(btnSearchTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 120, 30));

        txtWagonId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtWagonIdKeyReleased(evt);
            }
        });
        add(txtWagonId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 320, 30));

        btnSave.setText("Add");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 600, 140, 50));

        tblWagonDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Train Id", "WagonId", "Class Type", "SheetQuantity"
            }
        ));
        jScrollPane1.setViewportView(tblWagonDetail);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 1070, 210));

        jrThird.setBackground(new java.awt.Color(255, 255, 255));
        ClzGroup.add(jrThird);
        jrThird.setText("ThirdClass");
        jrThird.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrThirdMouseClicked(evt);
            }
        });
        add(jrThird, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, -1, -1));

        jrbtnObservation.setBackground(new java.awt.Color(255, 255, 255));
        ClzGroup.add(jrbtnObservation);
        jrbtnObservation.setText("Observation Saloon");
        jrbtnObservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbtnObservationMouseClicked(evt);
            }
        });
        add(jrbtnObservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        jrFirst.setBackground(new java.awt.Color(255, 255, 255));
        ClzGroup.add(jrFirst);
        jrFirst.setText("FirstClass");
        jrFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrFirstMouseClicked(evt);
            }
        });
        add(jrFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        jrSecond.setBackground(new java.awt.Color(255, 255, 255));
        ClzGroup.add(jrSecond);
        jrSecond.setText("SecondClass");
        jrSecond.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrSecondMouseClicked(evt);
            }
        });
        add(jrSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 157, 175));
        jLabel8.setText("Wagon Id");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 150, 40));

        tblTrain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Train Id", "First Class Wagon Quantity", "Second Class Wagon Quantity", "Third Class Wagon Quantity", "Observation Saloon"
            }
        ));
        tblTrain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTrainMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTrain);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1070, 100));

        btnAddToTable.setText("AddToTable");
        btnAddToTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToTableActionPerformed(evt);
            }
        });
        add(btnAddToTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 120, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(27, 157, 175));
        jLabel9.setText("Seat Quantity");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 150, 40));

        txtTrainId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTrainIdKeyReleased(evt);
            }
        });
        add(txtTrainId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 320, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 157, 175));
        jLabel7.setText("Train Id");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 150, 40));

        jButton1.setText("Wagon Settings");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTrainActionPerformed
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
            Logger.getLogger(ManageWagons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchTrainActionPerformed

    private void jrbtnObservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbtnObservationMouseClicked
//        if (jrbtnObservation.isSelected()) {
//            txtWagonId.setText("WO");
//        }
    }//GEN-LAST:event_jrbtnObservationMouseClicked

    private void jrFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrFirstMouseClicked
//        if (jrFirst.isSelected()) {
//            txtWagonId.setText("WF");
//        }
    }//GEN-LAST:event_jrFirstMouseClicked

    private void jrSecondMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrSecondMouseClicked
//        if (jrSecond.isSelected()) {
//            txtWagonId.setText("WS");
//        }
    }//GEN-LAST:event_jrSecondMouseClicked

    private void jrThirdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrThirdMouseClicked
//        if (jrThird.isSelected()) {
//            txtWagonId.setText("WT");
//        }
    }//GEN-LAST:event_jrThirdMouseClicked

    private void btnAddToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToTableActionPerformed
        //String wagonDetailId = txtWagonDetailId.getText();
        String wagonId = txtWagonId.getText();
        String trainId = txtTrainId.getText();
        String classType = null;
        if (jrFirst.isSelected()) {
            classType = "FirstClass";
        }
        if (jrSecond.isSelected()) {
            classType = "SecondClass";

        }
        if (jrThird.isSelected()) {
            classType = "ThirdClass";
        }
        if (jrbtnObservation.isSelected()) {
            classType = "ObservationSaloon";
        }
        int seatQuantity = Integer.parseInt(txtSeatQuantity.getText());
        Object[] ob = {trainId, wagonId, classType, seatQuantity};
        dtmWagonDetail.addRow(ob);
               
    }//GEN-LAST:event_btnAddToTableActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        try {
            String trainId = txtTrainId.getText();
            TrainDto trainDto = new TrainDto();
            trainDto.setTrainId(trainId);

            TrainDto searchTrain = ManageTrainController.searchTrain(trainId);

            trainDto.setEngineNumber(searchTrain.getEngineNumber());
            trainDto.setFirstClass(searchTrain.isFirstClass());
            trainDto.setFirstClassWagonQty(searchTrain.getFirstClassWagonQty());
            trainDto.setObservationSaloon(searchTrain.isObservationSaloon());
            trainDto.setObservationSaloonWagonQty(searchTrain.getObservationSaloonWagonQty());
            trainDto.setSecondClass(searchTrain.isSecondClass());
            trainDto.setSecondClassWagonQty(searchTrain.getSecondClassWagonQty());
            trainDto.setStatus("NotAvailable");
            
            trainDto.setRouteStatus(searchTrain.getRouteStatus());
            trainDto.setThirdClass(searchTrain.isThirdClass());
            trainDto.setThirdClassWagonQty(searchTrain.getThirdClassWagonQty());
            trainDto.setTrainType(searchTrain.getTrainType());
            WagonDetailDto wagonDetail = null;
            WagonDto wagon = null;
            List<WagonDetailDto> wagonDetailList = new ArrayList<>();
            List<SheetDto> sheetList = null;
            for (int i = 0; i < dtmWagonDetail.getRowCount(); i++) {
                String wagonId = (String) dtmWagonDetail.getValueAt(i, 1);
                String ClassType = (String) dtmWagonDetail.getValueAt(i, 2);
                int sheetQty = (int) dtmWagonDetail.getValueAt(0, 3);
                System.out.println("sheetQty"+sheetQty);
                sheetList = new ArrayList<>();
                wagon = new WagonDto();
                wagon.setWagonId(wagonId);
                wagon.setClassType(ClassType);
                wagon.setSheetQuantity(sheetQty);
                for (int j = 0; j < sheetQty; j++) {
                    SheetDto sheetDto = new SheetDto();
                    String sheetWagonId = wagonId;
                    String sheetType = ClassType;
                    System.out.println("pppppppppppppp"+sheetType);
                    String status = "Unbooked";
                    sheetDto.setWagonDto(wagon);
                    sheetDto.setStatus(status);
                    sheetDto.setSheetType(sheetType);
                    sheetList.add(sheetDto);
                }
                wagonDetail = new WagonDetailDto();
                //  String wagonDetailId = (String) dtmWagonDetail.getValueAt(i, 0);
                String trainID = (String) dtmWagonDetail.getValueAt(i, 0);

                //.setWagonDetailId(wagonDetailId);
                wagonDetail.setWagonEntity(wagon);
                wagonDetail.setTrain(trainDto);
                wagonDetail.setWagonDetail_Pk(new WagonDetail_PkDto(trainDto.getTrainId(), wagon.getWagonId()));
                wagonDetailList.add(wagonDetail);
            }
            Wagon w = new Wagon();

            w.setTrain(trainDto);
            w.setWagon(wagon);
            w.setWagonDetailList(wagonDetailList);
            w.setSheetList(sheetList);

            boolean isAdded = ManageWagonController.addWagon(w);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Added SuccessFully");
            } else {
                JOptionPane.showMessageDialog(this, "Added Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageWagons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //WagonSettings user = new WagonSettings(null, true, this);
        //user.setVisible(true);
        WagonSettings wagon = new WagonSettings(null, true);
        wagon.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblTrainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainMouseClicked
       String trainId = tblTrain.getValueAt(tblTrain.getSelectedRow(), 0).toString();
       txtTrainId.setText(trainId);
    }//GEN-LAST:event_tblTrainMouseClicked

    private void txtTrainIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrainIdKeyReleased
       String name = txtTrainId.getText();
        if (name.isEmpty()) {
            txtTrainId.setBorder(new LineBorder(Color.red, 1));
        } else {
            txtTrainId.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtTrainIdKeyReleased

    private void txtWagonIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWagonIdKeyReleased
       String name = txtWagonId.getText();
        if (name.isEmpty()) {
            txtWagonId.setBorder(new LineBorder(Color.red, 1));
        } else {
            txtWagonId.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtWagonIdKeyReleased

    private void txtSeatQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeatQuantityKeyReleased
        if (!txtSeatQuantity.getText().isEmpty()) {
            Validation.validateInt(txtSeatQuantity);
            txtSeatQuantity.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtSeatQuantityKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ClzGroup;
    private javax.swing.JButton btnAddToTable;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchTrain;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton jrFirst;
    private javax.swing.JRadioButton jrSecond;
    private javax.swing.JRadioButton jrThird;
    private javax.swing.JRadioButton jrbtnObservation;
    private javax.swing.JTable tblTrain;
    private javax.swing.JTable tblWagonDetail;
    private javax.swing.JTextField txtSearchTrain;
    private javax.swing.JTextField txtSeatQuantity;
    private javax.swing.JTextField txtTrainId;
    private javax.swing.JTextField txtWagonId;
    // End of variables declaration//GEN-END:variables
   private void getAllAvailableTrains() {
        try {
            List<TrainDto> trainDto = ManageTrainController.getAllAvailableTrains();
            System.out.println("tttttttttt"+trainDto);
            dtm.setRowCount(0);

            if (trainDto != null) {

                for (TrainDto train : trainDto) {

                    Object[] ob = {train.getTrainId(), train.getEngineNumber(), train.getFirstClassWagonQty(), train.getSecondClassWagonQty(), train.getThirdClassWagonQty(), train.getObservationSaloonWagonQty()};
                    dtm.addRow(ob);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateObservers() throws Exception {
        getAllAvailableTrains();
        //loadId();
    }
    
//    public void loadId(){
//
//        IdDto idDTO=new IdDto("wagonentity", "wagonId");
//        try {
//            String id=IdController.getNewID(idDTO, "W");
//            txtWagonId.setText(id);
//        } catch (Exception ex) {
//            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
