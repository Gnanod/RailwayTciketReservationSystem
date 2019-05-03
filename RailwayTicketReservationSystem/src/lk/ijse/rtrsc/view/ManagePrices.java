/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view;

import java.awt.Color;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import lk.ijse.rtrsc.controller.ManagePriceController;
import lk.ijse.rtrsc.controller.ManageRouteController;
import lk.ijse.rtrsc.controller.ManageStationController;
import lk.ijse.rtrsc.controller.ManageTrainController;
import lk.ijse.rtrsc.dto.PricaeDto;
import lk.ijse.rtrsc.dto.RouteDto;
import lk.ijse.rtrsc.dto.StationDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.utilities.Validation;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Gnanod-PC
 */
public class ManagePrices extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form ManageSheduleDetail
     */
    private boolean selectPrice;
    private DefaultTableModel dtm;
    private int priceId;

    public ManagePrices() {
        initComponents();
        dtm = (DefaultTableModel) tblPrices.getModel();
        getAllPrices();
        getAllStations();
        AutoCompleteDecorator.decorate(cmbEndStation);
        AutoCompleteDecorator.decorate(cmbStartStation);
        selectPrice = false;

        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManagePriceController.getSubject().registerObserver(this);
            ManageStationController.getSubject().registerObserver(this);
            ManageStationController.getSubject().notifyObservers();

        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbTrainType = new javax.swing.JComboBox<>();
        btnObservation = new javax.swing.JRadioButton();
        btnFirst = new javax.swing.JRadioButton();
        btnSecond = new javax.swing.JRadioButton();
        btnThird = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrices = new javax.swing.JTable();
        cmbEndStation = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbStartStation = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 120, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 157, 175));
        jLabel3.setText("Manage Prices");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 390, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 157, 175));
        jLabel4.setText("to");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 20, 30));

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 390, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 157, 175));
        jLabel5.setText("Prices");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 160, 30));

        cmbTrainType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intercity", "Express" }));
        jPanel1.add(cmbTrainType, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 390, 40));

        btnObservation.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btnObservation);
        btnObservation.setText("Observaton Saloon");
        jPanel1.add(btnObservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 130, -1));

        btnFirst.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btnFirst);
        btnFirst.setText("First Class");
        jPanel1.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 90, 20));

        btnSecond.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btnSecond);
        btnSecond.setText("Second Class");
        jPanel1.add(btnSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 100, -1));

        btnThird.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btnThird);
        btnThird.setText("Third Class");
        jPanel1.add(btnThird, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 130, -1));

        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 120, 40));

        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 580, 140, 50));

        tblPrices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "PriceId", "TrainType", "Class Type", "StartStation", "EndStation", "Prices"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPrices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPricesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPrices);
        if (tblPrices.getColumnModel().getColumnCount() > 0) {
            tblPrices.getColumnModel().getColumn(0).setMinWidth(40);
            tblPrices.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblPrices.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 860, 200));

        cmbEndStation.setEditable(true);
        jPanel1.add(cmbEndStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 150, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 157, 175));
        jLabel6.setText("Destination");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 160, 30));

        cmbStartStation.setEditable(true);
        jPanel1.add(cmbStartStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 150, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 157, 175));
        jLabel7.setText("Train Type");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 160, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 157, 175));
        jLabel8.setText("Class Type");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String trainType = (String) cmbTrainType.getSelectedItem();
            String classType = null;
            if (btnFirst.isSelected()) {
                classType = "FirstClass";
            }
            if (btnSecond.isSelected()) {
                classType = "SecondClass";
            }
            if (btnThird.isSelected()) {
                classType = "ThirdClass";
            }
            if (btnObservation.isSelected()) {
                classType = "ObservationSaloon";
            }

            String station = null;
            //String destination = (String) cmbStartStation.getSelectedItem() + " - " + (String) cmbEndStation.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            PricaeDto priceD = new PricaeDto();
            priceD.setAmount(price);
            priceD.setClassType(classType);
            priceD.setStartStation((String) cmbStartStation.getSelectedItem());
            priceD.setEndStation((String) cmbEndStation.getSelectedItem());
            priceD.setTrainType(trainType);
            priceD.setPriceId(priceId);
            boolean isUpdated = ManagePriceController.updatePrice(priceD);
            if (isUpdated) {
                JOptionPane.showMessageDialog(this, "Updated Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Updated Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePrices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            String trainType = (String) cmbTrainType.getSelectedItem();
            String classType = null;
            if (btnFirst.isSelected()) {
                classType = "FirstClass";
            }
            if (btnSecond.isSelected()) {
                classType = "SecondClass";
            }
            if (btnThird.isSelected()) {
                classType = "ThirdClass";
            }
            if (btnObservation.isSelected()) {
                classType = "ObservationSaloon";
            }

            String station = null;
            String destination = (String) cmbStartStation.getSelectedItem() + " - " + (String) cmbEndStation.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            PricaeDto priceD = new PricaeDto();
            priceD.setAmount(price);
            priceD.setClassType(classType);
            priceD.setStartStation((String) cmbStartStation.getSelectedItem());
            priceD.setEndStation((String) cmbEndStation.getSelectedItem());
            priceD.setTrainType(trainType);
            boolean isAdded = ManagePriceController.addPrice(priceD);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Added Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Added Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePrices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            String deletePrice = tblPrices.getValueAt(tblPrices.getSelectedRow(), 1).toString();

            boolean isDeleted = false;
            if (selectPrice == true) {
                isDeleted = ManagePriceController.deletePrices(deletePrice);
            }
            if (isDeleted) {
                int x = JOptionPane.showConfirmDialog(this, "Are you sure Delete this Price?");
                if (x == 0) {
                    JOptionPane.showMessageDialog(this, "Deleted Successfully");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Deleted Failled");
            }

        } catch (Exception ex) {
            Logger.getLogger(ManageTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tblPricesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPricesMouseClicked
        selectPrice = (boolean) tblPrices.getValueAt(tblPrices.getSelectedRow(), 0);
        priceId = (int) tblPrices.getValueAt(tblPrices.getSelectedRow(), 1);
        String trainType = (String) tblPrices.getValueAt(tblPrices.getSelectedRow(), 2);

        String classType = (String) tblPrices.getValueAt(tblPrices.getSelectedRow(), 3);
        String destination = (String) tblPrices.getValueAt(tblPrices.getSelectedRow(), 4);
        double prices = (double) tblPrices.getValueAt(tblPrices.getSelectedRow(), 5);

        String[] output = destination.split("-");
        String firstLetter = output[0];
        String secondLetter = output[1];

        cmbTrainType.setSelectedItem(trainType);
        cmbStartStation.setSelectedItem(firstLetter);
        cmbEndStation.setSelectedItem(secondLetter);
        txtPrice.setText("" + prices);
        if (classType.equals("FirstClass")) {
            btnFirst.setSelected(true);
        }

        if (classType.equals("SecondClass")) {
            btnSecond.setSelected(true);
        }
        if (classType.equals("ThirdClass")) {
            btnThird.setSelected(true);
        }
        if (classType.equals("ObservationSaloon")) {
            btnObservation.setSelected(true);
        }

    }//GEN-LAST:event_tblPricesMouseClicked

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        if (!txtPrice.getText().isEmpty()) {
            Validation.validateDouble(txtPrice);
            txtPrice.setBorder(new LineBorder(Color.black, 1));
        }
    }//GEN-LAST:event_txtPriceKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnFirst;
    private javax.swing.JRadioButton btnObservation;
    private javax.swing.JRadioButton btnSecond;
    private javax.swing.JRadioButton btnThird;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbEndStation;
    private javax.swing.JComboBox<String> cmbStartStation;
    private javax.swing.JComboBox<String> cmbTrainType;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrices;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    private void getAllPrices() {
        try {
            List<PricaeDto> priceDto = ManagePriceController.getAllPrices();
            dtm.setRowCount(0);

            if (priceDto != null) {

                for (PricaeDto price : priceDto) {
                    Object[] ob = {false, price.getPriceId(), price.getTrainType(), price.getClassType(), price.getStartStation(), price.getEndStation(), price.getAmount()};
                    dtm.addRow(ob);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePrices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getAllStations() {
        try {
            List<StationDto> stationDto = ManageStationController.getAllStation();
            // dtmStation.setRowCount(0);

            if (stationDto != null) {

                for (StationDto station : stationDto) {
                    cmbStartStation.addItem(station.getStationName());
                    cmbEndStation.addItem(station.getStationName());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ManagePrices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateObservers() throws Exception {
        getAllPrices();
    }

}
