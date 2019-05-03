/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.view;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.Color;
import java.awt.Component;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import lk.ijse.rtrsc.controller.ManageDayController;
import lk.ijse.rtrsc.controller.ManagePriceController;
import lk.ijse.rtrsc.controller.ManageReservationController;
import lk.ijse.rtrsc.controller.ManageRouteController;
import lk.ijse.rtrsc.controller.ManageSheetController;
import lk.ijse.rtrsc.controller.ManageStationController;
import lk.ijse.rtrsc.controller.ManageTrainController;
import lk.ijse.rtrsc.controller.ManageWagonController;
import lk.ijse.rtrsc.controller.ViewTrainsController;
import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.dto.PassengerDto;
import lk.ijse.rtrsc.dto.PaymentDto;
import lk.ijse.rtrsc.dto.PricaeDto;
import lk.ijse.rtrsc.dto.ReservationDto;
import lk.ijse.rtrsc.dto.ReservationSheetDetailDto;
import lk.ijse.rtrsc.dto.ReservationTransactionDto;
import lk.ijse.rtrsc.dto.ReservationWagonDetailDto;
import lk.ijse.rtrsc.dto.RouteDto;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.dto.StationDto;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.dto.ViewTrainsDto;
import lk.ijse.rtrsc.dto.WagonDetailDto;
import lk.ijse.rtrsc.dto.WagonDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.view.classes.JpanelEdit;
import lk.ijse.rtrsc.view.classes.JpanelEdit1;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Gnanod-PC
 */
public class ReservationFrame extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form ReservationFrame
     */
    private JasperReport jasper;
    private DefaultTableModel dtm;
    private DefaultListModel listModel1;
    private DefaultListModel listModel2;
    private DefaultListModel listModel3;
    private DefaultListModel listModelObservation;
    private DefaultListModel listModelWagon;
    private DefaultListModel allModel;
    Object listObject;
    private String time;
    private String routeId;
    private String dayId;
    private String depatureTime;
    private String StartTime = "8.30";
    private String routeName;
    private Set set = new HashSet();
    private Set set2 = new HashSet();
    private Set seatSetSecond = new HashSet();
    private Set allset = new HashSet();
    boolean reserveSeat = false;
    String trainType;
    private int reserveId;
    private List<Integer> reserverIdList;
    private String jasperDate;

    public ReservationFrame() {

        // getAllSeats();
        //getAllSeconSeats();
        //getAllThirdSeats();
        //getObservationSaloon();
        // date() ;
        //  day();
    }

    ReservationFrame(String userStation) {
        initComponents();
        jPanel2.setVisible(false);
        loadJasper();
        try {
            UnicastRemoteObject.exportObject(this, 0);

            if (ManageReservationController.getReservationSubject().registerObserver(this)) {
                ManageStationController.getSubject().registerObserver(this);
                ManageStationController.getSubject().notifyObservers();
            }
            // if(ManageStationController.getSubject().registerObserver(this)){

            //   }
            // ManageStationController.getSubject().notifyObservers();
            ManageSheetController.getSubject().registerObserver(this);
            ManageSheetController.getSubject().notifyObservers();

        } catch (Exception ex) {
            Logger.getLogger(ManageWagons.class.getName()).log(Level.SEVERE, null, ex);
        }
        pnlFirstClass.setVisible(true);
        pnlSecondClass.setVisible(false);
        pnlThirdClass.setVisible(false);
        pnlObservationSaloon.setVisible(false);
        dtm = (DefaultTableModel) tblTrains.getModel();
        // getAllStations();
        AutoCompleteDecorator.decorate(cmbEndStation);
        listModel1 = new DefaultListModel();
        listModel2 = new DefaultListModel();
        listModelWagon = new DefaultListModel();
        listModel3 = new DefaultListModel();
        listModelObservation = new DefaultListModel();
        allModel = new DefaultListModel();
        reserverIdList = new ArrayList<>();
        showThirdClasses();

        txtStartStation.setText(userStation);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDatePickerUtil1 = new net.sourceforge.jdatepicker.util.JDatePickerUtil();
        lblMinimize = new javax.swing.JLabel();
        lblClose1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtStartStation = new javax.swing.JTextField();
        cmbEndStation = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrains = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtStationId2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTrainId = new javax.swing.JTextField();
        cmbClassType = new javax.swing.JComboBox<>();
        pnlObservationSaloon = new JpanelEdit1();
        btnO1 = new javax.swing.JToggleButton();
        btnO7 = new javax.swing.JToggleButton();
        btnO13 = new javax.swing.JToggleButton();
        btnO19 = new javax.swing.JToggleButton();
        btnO3 = new javax.swing.JToggleButton();
        btnO9 = new javax.swing.JToggleButton();
        btnO15 = new javax.swing.JToggleButton();
        btnO21 = new javax.swing.JToggleButton();
        btnO5 = new javax.swing.JToggleButton();
        btnO11 = new javax.swing.JToggleButton();
        btnO17 = new javax.swing.JToggleButton();
        btnO23 = new javax.swing.JToggleButton();
        pnlFirstClass = new JpanelEdit1();
        tbtn1 = new javax.swing.JToggleButton();
        btnF13 = new javax.swing.JToggleButton();
        btnF19 = new javax.swing.JToggleButton();
        btnF20 = new javax.swing.JToggleButton();
        tbtn2 = new javax.swing.JToggleButton();
        btnF22 = new javax.swing.JToggleButton();
        btnF16 = new javax.swing.JToggleButton();
        btnF10 = new javax.swing.JToggleButton();
        btn4 = new javax.swing.JToggleButton();
        btnF24 = new javax.swing.JToggleButton();
        btnF18 = new javax.swing.JToggleButton();
        btnF12 = new javax.swing.JToggleButton();
        btn5 = new javax.swing.JToggleButton();
        tbtn3 = new javax.swing.JToggleButton();
        tbtn4 = new javax.swing.JToggleButton();
        tbtn5 = new javax.swing.JToggleButton();
        pnlSecondClass = new JpanelEdit1();
        btnFirst = new javax.swing.JToggleButton();
        btn7 = new javax.swing.JToggleButton();
        btn14 = new javax.swing.JToggleButton();
        btn20 = new javax.swing.JToggleButton();
        btn21 = new javax.swing.JToggleButton();
        btn15 = new javax.swing.JToggleButton();
        btn8 = new javax.swing.JToggleButton();
        btnSecond = new javax.swing.JToggleButton();
        btn23 = new javax.swing.JToggleButton();
        btn17 = new javax.swing.JToggleButton();
        btn11 = new javax.swing.JToggleButton();
        btnFourth = new javax.swing.JToggleButton();
        btn25 = new javax.swing.JToggleButton();
        btn19 = new javax.swing.JToggleButton();
        btn13 = new javax.swing.JToggleButton();
        btn6 = new javax.swing.JToggleButton();
        pnlThirdClass = new JpanelEdit1();
        btnT19 = new javax.swing.JToggleButton();
        btnT25 = new javax.swing.JToggleButton();
        btnT17 = new javax.swing.JToggleButton();
        btnT9 = new javax.swing.JToggleButton();
        btnT21 = new javax.swing.JToggleButton();
        btnT27 = new javax.swing.JToggleButton();
        btnT15 = new javax.swing.JToggleButton();
        btnT23 = new javax.swing.JToggleButton();
        btnT29 = new javax.swing.JToggleButton();
        btnT11 = new javax.swing.JToggleButton();
        btnT5 = new javax.swing.JToggleButton();
        btnT3 = new javax.swing.JToggleButton();
        btnT13 = new javax.swing.JToggleButton();
        btnT1 = new javax.swing.JToggleButton();
        btnT7 = new javax.swing.JToggleButton();
        txtTotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtPassengerId = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtPassengerName = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtChilrens = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTPNumber = new javax.swing.JTextField();
        txtAdults = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lblObserver = new javax.swing.JLabel();
        lblOne = new javax.swing.JLabel();
        lblTwo = new javax.swing.JLabel();
        lblThree = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnGetCount = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListFirst = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        wagonList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSecond = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListThird = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListObservation = new javax.swing.JList<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbWagonId = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListAll = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblThirdClass = new javax.swing.JLabel();
        lblObservation = new javax.swing.JLabel();
        lblFirstClass = new javax.swing.JLabel();
        lblSecondClass = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMinimize.setBackground(new java.awt.Color(221, 75, 57));
        lblMinimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMinimize.setText("  -");
        lblMinimize.setOpaque(true);
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseExited(evt);
            }
        });
        getContentPane().add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 40, 60));

        lblClose1.setBackground(new java.awt.Color(221, 75, 57));
        lblClose1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClose1.setText("   X");
        lblClose1.setOpaque(true);
        lblClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClose1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblClose1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblClose1MouseExited(evt);
            }
        });
        getContentPane().add(lblClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 60));

        jLabel5.setBackground(new java.awt.Color(221, 75, 57));
        jLabel5.setFont(new java.awt.Font("MODERNA", 0, 36));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("     Railway Reservation System");
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 157, 175));
        jLabel2.setText("WagonId");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 90, 30));

        txtStartStation.setEditable(false);
        txtStartStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartStationActionPerformed(evt);
            }
        });
        jPanel1.add(txtStartStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 280, 30));

        cmbEndStation.setEditable(true);
        cmbEndStation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEndStationItemStateChanged(evt);
            }
        });
        cmbEndStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEndStationActionPerformed(evt);
            }
        });
        jPanel1.add(cmbEndStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 280, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 157, 175));
        jLabel4.setText("Start Station");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 160, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 157, 175));
        jLabel6.setText("End Station");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 160, 30));

        jButton1.setText("View Today Trains");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, 30));

        jButton2.setText("Search");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 90, 30));

        tblTrains.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RouteId", "Depature Time", "Train Type"
            }
        ));
        tblTrains.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTrainsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTrains);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 550, 140));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 157, 175));
        jLabel7.setText("Date");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 160, 30));

        txtStationId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStationId2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtStationId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 190, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 157, 175));
        jLabel8.setText("Train Id");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 90, 30));

        txtTrainId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrainIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtTrainId, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 300, 30));

        cmbClassType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FirstClass", "SecondClass", "ThirdClass", "ObservationSaloon" }));
        cmbClassType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassTypeActionPerformed(evt);
            }
        });
        jPanel1.add(cmbClassType, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 300, 30));

        pnlObservationSaloon.setBackground(new java.awt.Color(255, 255, 255));
        pnlObservationSaloon.setLayout(null);

        btnO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO1ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO1);
        btnO1.setBounds(40, 10, 48, 35);

        btnO7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO7ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO7);
        btnO7.setBounds(40, 60, 48, 35);

        btnO13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO13ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO13);
        btnO13.setBounds(40, 140, 48, 35);

        btnO19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO19ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO19);
        btnO19.setBounds(40, 180, 48, 35);

        btnO3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO3ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO3);
        btnO3.setBounds(220, 10, 48, 35);

        btnO9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO9ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO9);
        btnO9.setBounds(220, 60, 48, 35);

        btnO15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO15ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO15);
        btnO15.setBounds(220, 140, 48, 35);

        btnO21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO21ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO21);
        btnO21.setBounds(220, 180, 48, 35);

        btnO5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO5ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO5);
        btnO5.setBounds(400, 10, 48, 35);

        btnO11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO11ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO11);
        btnO11.setBounds(400, 60, 48, 35);

        btnO17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO17ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO17);
        btnO17.setBounds(400, 140, 48, 35);

        btnO23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO23ActionPerformed(evt);
            }
        });
        pnlObservationSaloon.add(btnO23);
        btnO23.setBounds(400, 180, 48, 35);

        jPanel1.add(pnlObservationSaloon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 550, 220));

        pnlFirstClass.setBackground(new java.awt.Color(255, 255, 255));
        pnlFirstClass.setLayout(null);

        tbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn1ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(tbtn1);
        tbtn1.setBounds(40, 15, 48, 30);

        btnF13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF13ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF13);
        btnF13.setBounds(40, 140, 48, 35);

        btnF19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF19ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF19);
        btnF19.setBounds(40, 180, 48, 35);

        btnF20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF20ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF20);
        btnF20.setBounds(170, 180, 48, 35);

        tbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn2ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(tbtn2);
        tbtn2.setBounds(170, 70, 48, 35);

        btnF22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF22ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF22);
        btnF22.setBounds(310, 180, 48, 35);

        btnF16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF16ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF16);
        btnF16.setBounds(310, 140, 48, 35);

        btnF10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF10ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF10);
        btnF10.setBounds(310, 70, 48, 35);

        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btn4);
        btn4.setBounds(310, 10, 48, 35);

        btnF24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF24ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF24);
        btnF24.setBounds(490, 180, 48, 35);

        btnF18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF18ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF18);
        btnF18.setBounds(490, 140, 48, 35);

        btnF12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF12ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btnF12);
        btnF12.setBounds(490, 70, 48, 35);

        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(btn5);
        btn5.setBounds(490, 10, 48, 35);

        tbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn3ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(tbtn3);
        tbtn3.setBounds(170, 10, 48, 35);

        tbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn4ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(tbtn4);
        tbtn4.setBounds(40, 70, 48, 35);

        tbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtn5ActionPerformed(evt);
            }
        });
        pnlFirstClass.add(tbtn5);
        tbtn5.setBounds(170, 140, 48, 35);

        jPanel1.add(pnlFirstClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 550, 220));

        pnlSecondClass.setBackground(new java.awt.Color(255,255, 255));
        pnlSecondClass.setLayout(null);

        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btnFirst);
        btnFirst.setBounds(40, 15, 48, 30);

        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn7);
        btn7.setBounds(180, 10, 48, 35);

        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn14ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn14);
        btn14.setBounds(330, 10, 48, 35);

        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn20);
        btn20.setBounds(490, 10, 48, 35);

        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn21);
        btn21.setBounds(40, 60, 48, 35);

        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn15);
        btn15.setBounds(180, 60, 48, 35);

        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn8);
        btn8.setBounds(40, 180, 48, 35);

        btnSecond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecondActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btnSecond);
        btnSecond.setBounds(180, 180, 48, 35);

        btn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn23ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn23);
        btn23.setBounds(330, 180, 48, 35);

        btn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn17ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn17);
        btn17.setBounds(330, 140, 48, 35);

        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn11);
        btn11.setBounds(330, 60, 48, 35);

        btnFourth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFourthActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btnFourth);
        btnFourth.setBounds(40, 140, 48, 35);

        btn25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn25ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn25);
        btn25.setBounds(490, 180, 48, 35);

        btn19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn19ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn19);
        btn19.setBounds(490, 140, 48, 35);

        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn13);
        btn13.setBounds(490, 60, 48, 35);

        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        pnlSecondClass.add(btn6);
        btn6.setBounds(180, 140, 48, 35);

        jPanel1.add(pnlSecondClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 550, 220));

        pnlThirdClass.setBackground(new java.awt.Color(255, 255, 255));
        pnlThirdClass.setLayout(null);

        btnT19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT19ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT19);
        btnT19.setBounds(30, 140, 48, 35);

        btnT25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT25ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT25);
        btnT25.setBounds(30, 180, 48, 35);

        btnT17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT17ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT17);
        btnT17.setBounds(390, 80, 48, 35);

        btnT9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT9ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT9);
        btnT9.setBounds(220, 40, 48, 35);

        btnT21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT21ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT21);
        btnT21.setBounds(220, 140, 48, 35);

        btnT27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT27ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT27);
        btnT27.setBounds(220, 180, 48, 35);

        btnT15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT15ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT15);
        btnT15.setBounds(220, 80, 48, 35);

        btnT23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT23ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT23);
        btnT23.setBounds(390, 140, 48, 35);

        btnT29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT29ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT29);
        btnT29.setBounds(390, 180, 48, 35);

        btnT11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT11ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT11);
        btnT11.setBounds(390, 40, 48, 35);

        btnT5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT5ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT5);
        btnT5.setBounds(390, 0, 48, 35);

        btnT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT3ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT3);
        btnT3.setBounds(220, 0, 48, 35);

        btnT13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT13ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT13);
        btnT13.setBounds(30, 80, 48, 35);

        btnT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnT1MouseClicked(evt);
            }
        });
        btnT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT1ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT1);
        btnT1.setBounds(30, 5, 48, 30);

        btnT7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnT7ActionPerformed(evt);
            }
        });
        pnlThirdClass.add(btnT7);
        btnT7.setBounds(30, 40, 48, 35);

        jPanel1.add(pnlThirdClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 550, 220));
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 420, 160, 30));

        jButton3.setBackground(new java.awt.Color(60, 141, 188));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cost");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, 90, 30));

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 590, 50));

        jLabel20.setText("Observation");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 70, 30));

        jLabel21.setText("1");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 60, 30));

        jLabel22.setText("2");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 60, 30));

        jLabel23.setText("3");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 200, 60, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(27, 157, 175));
        jLabel24.setText("Cost");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 60, 30));

        txtPassengerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassengerIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassengerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 470, 300, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(27, 157, 175));
        jLabel25.setText("Passenger Name");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 120, 30));

        txtPassengerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassengerNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassengerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 510, 300, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(27, 157, 175));
        jLabel26.setText("Childrens");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 630, 120, 30));

        txtChilrens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChilrensActionPerformed(evt);
            }
        });
        jPanel1.add(txtChilrens, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, 300, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(27, 157, 175));
        jLabel27.setText("Passenger TP ");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 550, 120, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(27, 157, 175));
        jLabel28.setText("Adults");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 120, 30));

        txtTPNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTPNumberActionPerformed(evt);
            }
        });
        jPanel1.add(txtTPNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 550, 300, 30));

        txtAdults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdultsActionPerformed(evt);
            }
        });
        jPanel1.add(txtAdults, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 590, 300, 30));

        jButton4.setBackground(new java.awt.Color(60, 141, 188));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 620, 160, 40));

        jButton5.setBackground(new java.awt.Color(60, 141, 188));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 90, 30));

        lblObserver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblObserver, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 350, 50, 40));

        lblOne.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, 50, 40));

        lblTwo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, 50, 40));

        lblThree.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblThree, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 50, 40));

        jLabel14.setText("Number Of Seats");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 110, 40));

        btnGetCount.setBackground(new java.awt.Color(60, 141, 188));
        btnGetCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGetCount.setForeground(new java.awt.Color(255, 255, 255));
        btnGetCount.setText("Get Count");
        btnGetCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetCountActionPerformed(evt);
            }
        });
        jPanel1.add(btnGetCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 350, 100, 40));

        jScrollPane2.setViewportView(jListFirst);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 90, 110));

        jScrollPane3.setViewportView(wagonList);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 230, 90, 110));

        jScrollPane4.setViewportView(jListSecond);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 90, 110));

        jScrollPane5.setViewportView(jListThird);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 90, 110));

        jScrollPane6.setViewportView(jListObservation);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, 90, 110));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Number Of Seats"));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 590, 210));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 157, 175));
        jLabel11.setText("Class Type");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 90, 30));

        cmbWagonId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbWagonIdActionPerformed(evt);
            }
        });
        jPanel1.add(cmbWagonId, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 300, 30));

        jScrollPane7.setViewportView(jListAll);

        jPanel2.add(jScrollPane7);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 440, 160, 110));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 157, 175));
        jLabel1.setText("Third Class      :");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 100, 90, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 157, 175));
        jLabel3.setText("Observation   :");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 10, 90, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 157, 175));
        jLabel12.setText("First Class       :");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(0, 40, 90, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 157, 175));
        jLabel13.setText("Second Class  :");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(0, 70, 90, 30);

        lblThirdClass.setText("0");
        jPanel3.add(lblThirdClass);
        lblThirdClass.setBounds(100, 100, 70, 30);

        lblObservation.setText("0");
        jPanel3.add(lblObservation);
        lblObservation.setBounds(100, 10, 70, 30);

        lblFirstClass.setText("0");
        jPanel3.add(lblFirstClass);
        lblFirstClass.setBounds(100, 40, 70, 30);

        lblSecondClass.setText("0");
        jPanel3.add(lblSecondClass);
        lblSecondClass.setBounds(100, 70, 70, 30);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 40, 190, 130));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(27, 157, 175));
        jLabel29.setText("PassengerId");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1370, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStartStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartStationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartStationActionPerformed

    private void txtStationId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStationId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStationId2ActionPerformed

    private void txtTrainIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrainIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrainIdActionPerformed

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        this.setState(1);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        //        lblMinimize.setBackground(new Color(128, 169, 211));
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        //  lblMinimize.setBackground(new Color(40, 202, 204));
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void lblClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClose1MouseClicked
        dispose();
    }//GEN-LAST:event_lblClose1MouseClicked

    private void lblClose1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClose1MouseEntered
        //        lblClose1.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_lblClose1MouseEntered

    private void lblClose1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClose1MouseExited
        // lblClose1.setBackground(new Color(40, 202, 204));
    }//GEN-LAST:event_lblClose1MouseExited

    private void cmbClassTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassTypeActionPerformed

        try {
            String trainId = txtTrainId.getText();
            String classType = (String) cmbClassType.getSelectedItem();
            Object[] ob = {trainId, classType};
            List<WagonDto> wagon = ManageWagonController.getWagon(ob);
            cmbWagonId.removeAllItems();
            for (WagonDto wagonDto : wagon) {
                cmbWagonId.addItem(wagonDto.getWagonId());
            }
            String startStationName = txtStartStation.getText();
            String endStationName = (String) cmbEndStation.getSelectedItem();
            Object[] search = {classType, trainType, startStationName, endStationName};
            PricaeDto price = ManagePriceController.searchPrice(search);

            if (price != null) {

                if (price.getClassType().equals("FirstClass")) {

                    lblFirstClass.setText(price.getAmount() + "");
                }
                if (price.getClassType().equals("SecondClass")) {
                    lblSecondClass.setText(price.getAmount() + "");
                }
                if (price.getClassType().equals("ThirdClass")) {
                    lblThirdClass.setText(price.getAmount() + "");
                }
                if (price.getClassType().equals("ObservationSaloon")) {
                    lblObservation.setText(price.getAmount() + "");
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbClassTypeActionPerformed

    private void txtPassengerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassengerIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassengerIdActionPerformed

    private void txtPassengerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassengerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassengerNameActionPerformed

    private void txtChilrensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChilrensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChilrensActionPerformed

    private void txtTPNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTPNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTPNumberActionPerformed

    private void txtAdultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdultsActionPerformed

    private void btnF13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF13ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF13.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF13)) {
                    if (btnF13.isSelected()) {
                        listModel1.addElement(btnF13.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF13.isEnabled()) {
                        listModel1.removeElement(btnF13.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF13.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnF13ActionPerformed

    private void btnF19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF19ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF19.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF19)) {
                    if (btnF19.isSelected()) {
                        listModel1.addElement(btnF19.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF19.isEnabled()) {
                        listModel1.removeElement(btnF19.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF19.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnF19ActionPerformed

    private void btnF20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF20ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF20.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF20)) {
                    if (btnF20.isSelected()) {
                        listModel1.addElement(btnF20.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF20.isEnabled()) {
                        listModel1.removeElement(btnF20.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF20.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnF20ActionPerformed

    private void btnF12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF12ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF12.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF12)) {
                    if (btnF12.isSelected()) {
                        listModel1.addElement(btnF12.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF12.isEnabled()) {
                        listModel1.removeElement(btnF12.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF12.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnF12ActionPerformed

    private void btnO13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO13ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO13.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO13)) {
                    if (btnO13.isSelected()) {
                        listModelObservation.addElement(btnO13.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO13.isEnabled()) {
                        listModelObservation.removeElement(btnO13.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO13.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO13ActionPerformed

    private void btnO19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO19ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO19.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO19)) {
                    if (btnO1.isSelected()) {
                        listModelObservation.addElement(btnO19.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO19.isEnabled()) {
                        listModelObservation.removeElement(btnO19.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO19.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO19ActionPerformed

    private void btnO15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO15ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO15.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO15)) {
                    if (btnO15.isSelected()) {
                        listModelObservation.addElement(btnO15.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO15.isEnabled()) {
                        listModelObservation.removeElement(btnO15.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO15.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO15ActionPerformed

    private void btnO17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO17ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO17.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO17)) {
                    if (btnO17.isSelected()) {
                        listModelObservation.addElement(btnO17.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO17.isEnabled()) {
                        listModelObservation.removeElement(btnO17.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO17.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO17ActionPerformed

    private void btnO23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO23ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO23.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO23)) {
                    if (btnO23.isSelected()) {
                        listModelObservation.addElement(btnO23.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO23.isEnabled()) {
                        listModelObservation.removeElement(btnO23.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO23.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO23ActionPerformed

    private void jDateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserMouseClicked

    }//GEN-LAST:event_jDateChooserMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String startStation = txtStartStation.getText();
            String endStation = (String) cmbEndStation.getSelectedItem();
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
            String day = dateFormat.format(date);
            jasperDate = day;
            String stationName = (String) cmbEndStation.getSelectedItem();
            String stationId = ManageStationController.searchStationId(stationName);

            Object[] ob = {startStation, endStation, day, stationId};

            ViewTrainsDto viewTrainsDto = ViewTrainsController.searchTrains(ob);

            if (viewTrainsDto == null) {
                JOptionPane.showMessageDialog(this, "No Trains Fund in that time");
            } else {
                Object[] tbl = {viewTrainsDto.getRouteName(), viewTrainsDto.getDepaturetime(), viewTrainsDto.getTrainType()};
                dtm.addRow(tbl);
            }
        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void cmbEndStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEndStationActionPerformed

    }//GEN-LAST:event_cmbEndStationActionPerformed

    private void cmbEndStationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEndStationItemStateChanged
//     try {
//           
//            
//           
//        } catch (Exception ex) {
//            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_cmbEndStationItemStateChanged

    private void tbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn1ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {tbtn1.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(tbtn1)) {
                    if (tbtn1.isSelected()) {
                        listModel1.addElement(tbtn1.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (tbtn1.isEnabled()) {
                        listModel1.removeElement(tbtn1.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(tbtn1.getText()));
                        for (Integer integer : reserverIdList) {
                            System.out.println("integer" + integer);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbtn1ActionPerformed

    private void btnO3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO3ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO3.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO3)) {
                    if (btnO3.isSelected()) {
                        listModelObservation.addElement(btnO3.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO3.isEnabled()) {
                        listModelObservation.removeElement(btnO3.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO3.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO3ActionPerformed

    private void tblTrainsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrainsMouseClicked
        try {
            routeName = tblTrains.getValueAt(tblTrains.getSelectedRow(), 0).toString();
            depatureTime = tblTrains.getValueAt(tblTrains.getSelectedRow(), 1).toString();
            RouteDto route = ManageRouteController.searchTrain(routeName);
            if (route != null) {
                txtTrainId.setText(route.getTrainDto().getTrainId());
                dayId = route.getDayDto().getDateId();
                routeId = route.getRouteId();
            }
            trainType = tblTrains.getValueAt(tblTrains.getSelectedRow(), 2).toString();

            //   PricaeDto price = ManagePriceController.searchPrice(trainType);
            // price.get
        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblTrainsMouseClicked

    private void tbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn2ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {tbtn2.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(tbtn2)) {

//                    if (tbtn3.isSelected()) {
//                        listModel1.addElement(tbtn3.getText());
//                        jListFirst.setModel(listModel1);
//                        listModelWagon.removeAllElements();
//                        set.add(cmbWagonId.getSelectedItem());
//                        for (Object object : set) {
//                            listModelWagon.addElement(object);
//                        }
//                        ListModel model = wagonList.getModel();
//                        wagonList.removeAll();
//                        if (model.getSize() == 0) {
//                            wagonList.setModel(listModelWagon);
//                        } else {
//
//                        }
//
//                    } else if (tbtn3.isEnabled()) {
//                       
//                            listModel1.removeElement(tbtn3.getText());
//                            listModelWagon.removeElement(cmbWagonId.getSelectedItem());
//                       
//
//                    }
                    if (tbtn2.isSelected()) {
                        listModel1.addElement(tbtn2.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (tbtn2.isEnabled()) {
                        listModel1.removeElement(tbtn2.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(tbtn2.getText()));
//                        for (Integer integer : reserverIdList) {
//                            System.out.println("integer" + integer);
//                        }
                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbtn2ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn4.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn4)) {
                    if (btn4.isSelected()) {
                        listModel1.addElement(btn4.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn4.isEnabled()) {
                        listModel1.removeElement(btn4.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn4.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnF10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF10ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF10.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF10)) {
                    if (btnF10.isSelected()) {
                        listModel1.addElement(btnF10.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF10.isEnabled()) {
                        listModel1.removeElement(btnF10.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF10.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnF10ActionPerformed

    private void btnF16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF16ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF16.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF16)) {
                    if (btnF16.isSelected()) {
                        listModel1.addElement(btnF16.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF16.isEnabled()) {
                        listModel1.removeElement(btnF16.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF16.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnF16ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn5.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn5)) {
                    if (btn5.isSelected()) {
                        listModel1.addElement(btn5.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn5.isEnabled()) {
                        listModel1.removeElement(btn5.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn5.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btnF18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF18ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF18.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF18)) {
                    if (btnF18.isSelected()) {
                        listModel1.addElement(btnF18.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF18.isEnabled()) {
                        listModel1.removeElement(btnF18.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF18.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnF18ActionPerformed

    private void btnF22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF22ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF22.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF22)) {
                    if (btnF22.isSelected()) {
                        listModel1.addElement(btnF22.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF22.isEnabled()) {
                        listModel1.removeElement(btnF22.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF22.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnF22ActionPerformed

    private void btnF24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF24ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnF24.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnF24)) {
                    if (btnF24.isSelected()) {
                        listModel1.addElement(btnF24.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnF24.isEnabled()) {
                        listModel1.removeElement(btnF24.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnF24.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnF24ActionPerformed

    private void btnO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO1ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO1.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO1)) {
                    if (btnO1.isSelected()) {
                        listModelObservation.addElement(btnO1.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO1.isEnabled()) {
                        listModelObservation.removeElement(btnO1.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO1.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO1ActionPerformed

    private void btnO5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO5ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO5.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO5)) {
                    if (btnO5.isSelected()) {
                        listModelObservation.addElement(btnO5.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO5.isEnabled()) {
                        listModelObservation.removeElement(btnO5.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO5.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO5ActionPerformed

    private void btnO7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO7ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO7.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO7)) {
                    if (btnO7.isSelected()) {
                        listModelObservation.addElement(btnO7.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO7.isEnabled()) {
                        listModelObservation.removeElement(btnO7.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO7.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO7ActionPerformed

    private void btnO9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO9ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO1.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO9)) {
                    if (btnO9.isSelected()) {
                        listModelObservation.addElement(btnO9.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO9.isEnabled()) {
                        listModelObservation.removeElement(btnO9.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO9.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO9ActionPerformed

    private void btnO11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO11ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO11.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO11)) {
                    if (btnO11.isSelected()) {
                        listModelObservation.addElement(btnO11.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO11.isEnabled()) {
                        listModelObservation.removeElement(btnO11.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO11.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO11ActionPerformed

    private void btnO21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO21ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnO21.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnO21)) {
                    if (btnO21.isSelected()) {
                        listModelObservation.addElement(btnO21.getText());
                        jListObservation.setModel(listModelObservation);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnO21.isEnabled()) {
                        listModelObservation.removeElement(btnO21.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnO21.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnO21ActionPerformed

    private void btnGetCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetCountActionPerformed
        int countFirst = jListFirst.getModel().getSize();
        lblOne.setText("" + countFirst);

        int countSecond = jListSecond.getModel().getSize();
        lblTwo.setText("" + countSecond);

        int countThird = jListThird.getModel().getSize();
        lblThree.setText("" + countThird);

        int countObserver = jListObservation.getModel().getSize();
        lblObserver.setText("" + countObserver);

        ListModel model2 = jListSecond.getModel();
        ListModel model1 = jListFirst.getModel();
        ListModel model3 = jListThird.getModel();
        ListModel observer = jListObservation.getModel();

        Object sheet1;
        SheetDto sheetDto;
        for (int i = 0; i < model1.getSize(); i++) {
            sheet1 = model1.getElementAt(i);
            allModel.removeAllElements();
            allset.add(sheet1);
            for (Object object : allset) {
                allModel.addElement(object);
            }
            ListModel model = jListAll.getModel();
            jListAll.removeAll();
            if (model.getSize() == 0) {
                jListAll.setModel(allModel);
            }
        }
        Object sheet2;
        for (int i = 0; i < model2.getSize(); i++) {
            sheet2 = model2.getElementAt(i);
            allModel.removeAllElements();
            allset.add(sheet2);
            for (Object object : allset) {
                allModel.addElement(object);
            }
            ListModel model = jListAll.getModel();
            jListAll.removeAll();
            if (model.getSize() == 0) {
                jListAll.setModel(allModel);
            }
        }

        Object sheet3;
        for (int i = 0; i < model3.getSize(); i++) {
            sheet3 = model3.getElementAt(i);
            allModel.removeAllElements();
            allset.add(sheet3);
            for (Object object : allset) {
                allModel.addElement(object);
            }
            ListModel model = jListAll.getModel();
            jListAll.removeAll();
            if (model.getSize() == 0) {
                jListAll.setModel(allModel);
            }
        }

        Object observe;
        for (int i = 0; i < observer.getSize(); i++) {
            observe = model3.getElementAt(i);
            allModel.removeAllElements();
            allset.add(observe);
            for (Object object : allset) {
                allModel.addElement(object);
            }
            ListModel model = jListAll.getModel();
            jListAll.removeAll();
            if (model.getSize() == 0) {
                jListAll.setModel(allModel);
            }
        }
//        Object sheet4;
//        for (int i = 0; i < observer.getSize(); i++) {
//            sheet4 = observer.getElementAt(i);
//            all.addElement(sheet4);
//            jListAll.setModel(all);
//            
//            all.addElement(sheet4);
//            jListAll.setModel(all);
//            allset.add(sheet4);
//           
//            
//            for (Object object : allset) {
//                all.addElement(object);
//            }
//            ListModel model = jListAll.getModel();
//            jListAll.removeAll();
//            if (model.getSize() == 0) {
//                jListAll.setModel(all);
//            }
//            //SheetDto sd = ManageReservationController.getAllSheets(sheet1);
//        }
    }//GEN-LAST:event_btnGetCountActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String startStationName = txtStartStation.getText();
        String endStationName = (String) cmbEndStation.getSelectedItem();

        int countFirst = Integer.parseInt(lblOne.getText());
        int countSecond = Integer.parseInt(lblTwo.getText());
        int countThird = Integer.parseInt(lblThree.getText());
        int countObserver = Integer.parseInt(lblObserver.getText());
        double obserClassTicket = 0;
        System.out.println("lblObservation.getText() " + lblObservation.getText());
        if (lblObservation.getText() != null) {
            obserClassTicket = Double.parseDouble(lblObservation.getText());
        }
        double firstClassTicket = 0;
        if (lblFirstClass.getText() != null) {
            firstClassTicket = Double.parseDouble(lblFirstClass.getText());
        }
        double secondClass = 0;
        if (lblSecondClass.getText() != null) {
            secondClass = Double.parseDouble(lblSecondClass.getText());
        }
        double thirdClass = 0;
        if (lblThirdClass.getText() != null) {
            thirdClass = Double.parseDouble(lblThirdClass.getText());
        }

        double total = (countFirst * firstClassTicket) + (countSecond * secondClass) + (countThird * thirdClass) + (countObserver * obserClassTicket);
        txtTotal.setText("" + total);
        ///  Object[] search = {classType, trainType};
        // PricaeDto price = ManagePriceController.searchPrice(search);
//        StationDto stationDto = ManageStationController.searchStationName(stationName);
//        if (stationDto != null) {
//            boolean mathra = stationDto.isMathara_Colombo();
//            boolean colombo = stationDto.isColombo_Kandy();
//            boolean kandy = stationDto.isColombo_Kandy();
//            
//        }
        // String stationName = txtStartStation.getText();
//        String stationN = ManageStationController.searchStationName(stationName);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        java.util.Date dd = new java.util.Date();
        String d = sdf.format(dd);
        System.out.println("yyyyy" + d);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbWagonIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbWagonIdActionPerformed
        String trainId = txtTrainId.getText();
        String wagonId = (String) cmbWagonId.getSelectedItem();
        Object[] ob = {trainId, wagonId};

        Date date = jDateChooser.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
        String reserveDate = dateFormat.format(date);

        Object[] o = {routeId, reserveDate};
        if ("FirstClass" == cmbClassType.getSelectedItem()) {
            try {
                List<SheetDto> sheetDto = ManageSheetController.getAllTrainSheets(ob);
                ShowFirstClass(sheetDto);
                //   DashBordPanel();
                pnlFirstClass.setVisible(true);
                pnlSecondClass.setVisible(false);
                pnlThirdClass.setVisible(false);
                pnlObservationSaloon.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("SecondClass" == cmbClassType.getSelectedItem()) {
            try {

                List<SheetDto> sheetDto = ManageSheetController.getAllTrainSheets(ob);

                ShowSecondClass(sheetDto);
                pnlSecondClass.setVisible(true);
                pnlFirstClass.setVisible(false);
                pnlThirdClass.setVisible(false);
                pnlObservationSaloon.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ("ThirdClass" == cmbClassType.getSelectedItem()) {
            try {
                List<SheetDto> sheetDto = ManageSheetController.getAllTrainSheets(ob);
                ShowThirdClasses(sheetDto);
                pnlThirdClass.setVisible(true);
                pnlFirstClass.setVisible(false);
                pnlSecondClass.setVisible(false);
                pnlObservationSaloon.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if ("ObservationSaloon" == cmbClassType.getSelectedItem()) {
            try {
                List<SheetDto> sheetDto = ManageSheetController.getAllTrainSheets(ob);
                ShowObservationClass(sheetDto);
                pnlObservationSaloon.setVisible(true);
                pnlThirdClass.setVisible(false);
                pnlFirstClass.setVisible(false);
                pnlSecondClass.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmbWagonIdActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String passengerName = txtPassengerName.getText();
            String passengerId = txtPassengerId.getText();
            String passengerTp = txtTPNumber.getText();

            PassengerDto passenger = new PassengerDto();
            passenger.setPassengerId(passengerId);
            passenger.setPassengerName(passengerName);
            passenger.setPassengerTp(passengerTp);

            RouteDto route = new RouteDto();
            DayDto day = new DayDto();
            day.setDateId(dayId);
            DayDto getDay = ManageDayController.getDay(dayId);
            day.setFriday(getDay.isFriday());
            day.setHoliday(getDay.isHoliday());
            day.setMonday(getDay.isMonday());
            day.setSaturday(getDay.isSaturday());
            day.setSunday(getDay.isSunday());
            day.setThursday(getDay.isThursday());
            day.setTuesday(getDay.isTuesday());
            day.setWednesday(getDay.isWednesday());

            System.out.println("DayId0" + dayId);
            route.setDayDto(day);
            route.setDepatureTime(depatureTime);
            route.setRouteId(routeId);
            route.setRouteName(routeName);

            TrainDto trainDto = new TrainDto();
            trainDto.setTrainId(txtTrainId.getText());

            TrainDto searchTrain = ManageTrainController.searchTrain(txtTrainId.getText());

            trainDto.setEngineNumber(searchTrain.getEngineNumber());
            trainDto.setFirstClass(searchTrain.isFirstClass());
            trainDto.setFirstClassWagonQty(searchTrain.getFirstClassWagonQty());
            trainDto.setObservationSaloon(searchTrain.isObservationSaloon());
            trainDto.setObservationSaloonWagonQty(searchTrain.getObservationSaloonWagonQty());
            trainDto.setSecondClass(searchTrain.isSecondClass());
            trainDto.setSecondClassWagonQty(searchTrain.getSecondClassWagonQty());
            trainDto.setStatus("NotAvailable");
            trainDto.setThirdClass(searchTrain.isThirdClass());
            trainDto.setThirdClassWagonQty(searchTrain.getThirdClassWagonQty());
            trainDto.setTrainType(searchTrain.getTrainType());

            route.setTrainDto(trainDto);

            String startStation = txtStartStation.getText();
            String endStation = (String) cmbEndStation.getSelectedItem();
            int adultCount = Integer.parseInt(txtAdults.getText());
            int childrensCount = Integer.parseInt(txtChilrens.getText());
            String reservationTime = time;

            ReservationDto dto = new ReservationDto();
            dto.setStartStation(startStation);
            dto.setEndStation(endStation);
            dto.setTime(time);
            dto.setAdults(adultCount);
            dto.setChildren(childrensCount);
            dto.setPassengerEntity(passenger);
            dto.setRouteEntity(route);

            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            dto.setDate(reserveDate);

            PaymentDto payment = new PaymentDto();
            payment.setTotal(Double.parseDouble(txtTotal.getText()));

            // List<WagonDetailDto> wagonDetail = new ArrayList<>();
//            Object wagons;
//            List<ReservationWagonDetailDto> reservation = new ArrayList<>();
//            ListModel model = wagonList.getModel();
//            for (int i = 0; i < model.getSize(); i++) {
//                wagons = model.getElementAt(i);
//                WagonDto w = new WagonDto();
//                System.out.println("objects" + wagons);
//                w.setWagonId((String) wagons);
//                System.out.println();
//                WagonDto searchWagon = ManageWagonController.searchWagons((String) wagons);
//
//                w.setClassType(searchWagon.getClassType());
//                w.setSheetQuantity(searchWagon.getSheetQuantity());
//
//                ReservationWagonDetailDto d = new ReservationWagonDetailDto();
//                d.setWagonDto(w);
//                reservation.add(d);
//
//            }
            List<SheetDto> sheetList = new ArrayList<>();

            List<ReservationSheetDetailDto> rs = new ArrayList<>();

            ListModel model1 = jListAll.getModel();
            Object sheet1;
            SheetDto sheetDto;
            for (int i = 0; i < model1.getSize(); i++) {
                sheet1 = model1.getElementAt(i);
                SheetDto sd = ManageReservationController.getAllSheets(sheet1);

                // System.out.println("yyyyyyyyyeeeeeeeee" + sheet1);
                sheetDto = new SheetDto();
                sheetDto.setSheetID(sd.getSheetID());
                sheetDto.setStatus("Booked");
                sheetDto.setSheetType(sd.getSheetType());

                WagonDto wagon = new WagonDto();
                System.out.println("oooooooooooorrrrr" + sd.getWagonDto().getWagonId());
                wagon.setWagonId(sd.getWagonDto().getWagonId());

                WagonDto searchWagon2 = ManageWagonController.searchWagons(sd.getWagonDto().getWagonId());
                wagon.setClassType(searchWagon2.getClassType());
                wagon.setSheetQuantity(searchWagon2.getSheetQuantity());
                sheetDto.setWagonDto(wagon);

                ReservationSheetDetailDto rsDto = new ReservationSheetDetailDto();

                rsDto.setSheetEntity(sheetDto);
                //rsDto.setReservation(dto);
                rs.add(rsDto);

                //sheetList.add(sheetDto);
            }
            ReservationTransactionDto f = new ReservationTransactionDto();

            f.setPassengerDto(passenger);
            f.setPaymentDto(payment);
            f.setReservationDto(dto);
            f.setReservationSheetDetail(rs);
            //  f.setReservationWagonDetail(reservation);
            f.setDayDto(day);
            f.setSheetList(sheetList);
            boolean isAdded = ManageReservationController.addReservation(f);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Added SuccessFully");
                ManageReservationController.releaseSeat(reserveId);
                reserveId = 0;
                JasperLoad() ;

            } else {
                JOptionPane.showMessageDialog(this, "Added Fail");
            }
        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn3ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {tbtn3.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(tbtn3)) {
                    if (tbtn3.isSelected()) {
                        listModel1.addElement(tbtn3.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (tbtn3.isEnabled()) {
                        listModel1.removeElement(tbtn3.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(tbtn3.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbtn3ActionPerformed

    private void tbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn4ActionPerformed

        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {tbtn4.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(tbtn4)) {
                    if (tbtn4.isSelected()) {
                        listModel1.addElement(tbtn4.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (tbtn4.isEnabled()) {
                        listModel1.removeElement(tbtn4.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(tbtn4.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbtn4ActionPerformed

    private void tbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtn5ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {tbtn5.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(tbtn5)) {
                    if (tbtn5.isSelected()) {
                        listModel1.addElement(tbtn5.getText());
                        jListFirst.setModel(listModel1);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (tbtn5.isEnabled()) {
                        listModel1.removeElement(tbtn5.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(tbtn5.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbtn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn6.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn6)) {
                    if (btn6.isSelected()) {
                        listModel2.addElement(btn6.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn6.isEnabled()) {
                        listModel2.removeElement(btn6.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn6.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn13.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn13)) {
                    if (btn13.isSelected()) {
                        listModel2.addElement(btn13.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn13.isEnabled()) {
                        listModel2.removeElement(btn13.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn13.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn19ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn19.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn19)) {
                    if (btn19.isSelected()) {
                        listModel2.addElement(btn19.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn19.isEnabled()) {
                        listModel2.removeElement(btn19.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn19.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn19ActionPerformed

    private void btn25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn25ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn25.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn25)) {
                    if (btn25.isSelected()) {
                        listModel2.addElement(btn25.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn25.isEnabled()) {
                        listModel2.removeElement(btn25.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn25.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn25ActionPerformed

    private void btnFourthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFourthActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnFourth.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnFourth)) {
                    if (btnFourth.isSelected()) {
                        listModel2.addElement(btnFourth.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnFourth.isEnabled()) {
                        listModel2.removeElement(btnFourth.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnFourth.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFourthActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn11.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn11)) {
                    if (btn11.isSelected()) {
                        listModel2.addElement(btn11.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn11.isEnabled()) {
                        listModel2.removeElement(btn11.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn11.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn17ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn17.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn17)) {
                    if (btn17.isSelected()) {
                        listModel2.addElement(btn17.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn17.isEnabled()) {
                        listModel2.removeElement(btn17.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn17.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn17ActionPerformed

    private void btn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn23ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn23.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn23)) {
                    if (btn23.isSelected()) {
                        listModel2.addElement(btn23.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn23.isEnabled()) {
                        listModel2.removeElement(btn23.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn23.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn23ActionPerformed

    private void btnSecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecondActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnSecond.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnSecond)) {
                    if (btnSecond.isSelected()) {
                        listModel2.addElement(btnSecond.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnSecond.isEnabled()) {
                        listModel2.removeElement(btnSecond.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnSecond.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSecondActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn8.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn8)) {
                    if (btn8.isSelected()) {
                        listModel2.addElement(btn8.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn8.isEnabled()) {
                        listModel2.removeElement(btn8.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn8.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn15.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn15)) {
                    if (btn15.isSelected()) {
                        listModel2.addElement(btn15.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn15.isEnabled()) {
                        listModel2.removeElement(btn15.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn15.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn15ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed

        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn21.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn21)) {
                    if (btn21.isSelected()) {
                        listModel2.addElement(btn21.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn21.isEnabled()) {
                        listModel2.removeElement(btn21.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn21.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn21ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn20.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn20)) {
                    if (btn20.isSelected()) {
                        listModel2.addElement(btn20.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn20.isEnabled()) {
                        listModel2.removeElement(btn20.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn20.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn14ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn14.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn14)) {
                    if (btn14.isSelected()) {
                        listModel2.addElement(btn14.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn14.isEnabled()) {
                        listModel2.removeElement(btn14.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn14.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn14ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btn7.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btn7)) {
                    if (btn7.isSelected()) {
                        listModel2.addElement(btn7.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btn7.isEnabled()) {
                        listModel2.removeElement(btn7.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btn7.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnFirst.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnFirst)) {
                    if (btnFirst.isSelected()) {
                        listModel2.addElement(btnFirst.getText());
                        jListSecond.setModel(listModel2);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnFirst.isEnabled()) {
                        listModel2.removeElement(btnFirst.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnFirst.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnT7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT7ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT7.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT7)) {
                    if (btnT7.isSelected()) {
                        listModel3.addElement(btnT7.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT7.isEnabled()) {
                        listModel3.removeElement(btnT7.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT7.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT7ActionPerformed

    private void btnT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT1ActionPerformed
//        try {
//            SheetDto sheet = ManageReservationController.getAllSheets(btnT1.getText());
//            if (sheet != null) {
//                System.out.println("lllllllll" + sheet.getStatus());
//
//            } else {
//                System.out.println("tttt");
//            }
//
//            if (btnT1.isSelected()) {
//                listModel3.addElement(btnT1.getText());
//                jListThird.setModel(listModel3);
//                listModelWagon.removeAllElements();
//                set.add(cmbWagonId.getSelectedItem());
//                for (Object object : set) {
//                    listModelWagon.addElement(object);
//                }
//                ListModel model = wagonList.getModel();
//                wagonList.removeAll();
//                if (model.getSize() == 0) {
//                    wagonList.setModel(listModelWagon);
//                } else {
//
//                }
//
//            } else if (btnT1.isEnabled()) {
//                listModel3.removeElement(btnT1.getText());
//                listModelWagon.removeElement(cmbWagonId.getSelectedItem());
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT1.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT1)) {
                    if (btnT1.isSelected()) {
                        listModel3.addElement(btnT1.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT1.isEnabled()) {
                        listModel3.removeElement(btnT1.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT1.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT1ActionPerformed

    private void btnT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnT1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnT1MouseClicked

    private void btnT13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT13ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT13.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT13)) {
                    if (btnT13.isSelected()) {
                        listModel3.addElement(btnT13.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT13.isEnabled()) {
                        listModel3.removeElement(btnT13.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT13.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT13ActionPerformed

    private void btnT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT3ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT3.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT3)) {
                    if (btnT3.isSelected()) {
                        listModel3.addElement(btnT3.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT3.isEnabled()) {
                        listModel3.removeElement(btnT3.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT3.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT3ActionPerformed

    private void btnT5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT5ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT5.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT5)) {
                    if (btnT5.isSelected()) {
                        listModel3.addElement(btnT5.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT5.isEnabled()) {
                        listModel3.removeElement(btnT5.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT5.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT5ActionPerformed

    private void btnT11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT11ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT1.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT1)) {
                    if (btnT1.isSelected()) {
                        listModel3.addElement(btnT1.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT1.isEnabled()) {
                        listModel3.removeElement(btnT1.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT1.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT11ActionPerformed

    private void btnT29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT29ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT29.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT29)) {
                    if (btnT29.isSelected()) {
                        listModel3.addElement(btnT29.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT29.isEnabled()) {
                        listModel3.removeElement(btnT29.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT29.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT29ActionPerformed

    private void btnT23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT23ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT23.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT23)) {
                    if (btnT23.isSelected()) {
                        listModel3.addElement(btnT23.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT23.isEnabled()) {
                        listModel3.removeElement(btnT23.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT23.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT23ActionPerformed

    private void btnT15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT15ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT15.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT15)) {
                    if (btnT15.isSelected()) {
                        listModel3.addElement(btnT15.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT15.isEnabled()) {
                        listModel3.removeElement(btnT15.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT15.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT15ActionPerformed

    private void btnT27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT27ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT27.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT27)) {
                    if (btnT27.isSelected()) {
                        listModel3.addElement(btnT27.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT27.isEnabled()) {
                        listModel3.removeElement(btnT27.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT27.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT27ActionPerformed

    private void btnT21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT21ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT21.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT21)) {
                    if (btnT21.isSelected()) {
                        listModel3.addElement(btnT21.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT21.isEnabled()) {
                        listModel3.removeElement(btnT21.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT21.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT21ActionPerformed

    private void btnT9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT9ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT9.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT9)) {
                    if (btnT9.isSelected()) {
                        listModel3.addElement(btnT9.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT9.isEnabled()) {
                        listModel3.removeElement(btnT9.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT9.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT9ActionPerformed

    private void btnT17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT17ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT17.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT17)) {
                    if (btnT17.isSelected()) {
                        listModel3.addElement(btnT17.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT17.isEnabled()) {
                        listModel3.removeElement(btnT17.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT17.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT17ActionPerformed

    private void btnT25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT25ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT25.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT25)) {
                    if (btnT25.isSelected()) {
                        listModel3.addElement(btnT25.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT25.isEnabled()) {
                        listModel3.removeElement(btnT25.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT25.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT25ActionPerformed

    private void btnT19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnT19ActionPerformed
        try {
            Date date = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String reserveDate = dateFormat.format(date);
            Object[] getAll = {btnT19.getText(), reserveDate};
            int all = ManageSheetController.getCountAllCount(getAll);
            if (all == 0) {
                if (seatReservation(btnT19)) {
                    if (btnT19.isSelected()) {
                        listModel3.addElement(btnT19.getText());
                        jListThird.setModel(listModel3);
                        listModelWagon.removeAllElements();
                        set.add(cmbWagonId.getSelectedItem());
                        for (Object object : set) {
                            listModelWagon.addElement(object);
                        }
                        ListModel model = wagonList.getModel();
                        wagonList.removeAll();
                        if (model.getSize() == 0) {
                            wagonList.setModel(listModelWagon);
                        } else {
                        }
                    } else if (btnT19.isEnabled()) {
                        listModel3.removeElement(btnT19.getText());
                        listModelWagon.removeElement(cmbWagonId.getSelectedItem());
                        ManageReservationController.releaseSeat(Integer.parseInt(btnT19.getText()));

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnT19ActionPerformed

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
                if ("Mac".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn11;
    private javax.swing.JToggleButton btn13;
    private javax.swing.JToggleButton btn14;
    private javax.swing.JToggleButton btn15;
    private javax.swing.JToggleButton btn17;
    private javax.swing.JToggleButton btn19;
    private javax.swing.JToggleButton btn20;
    private javax.swing.JToggleButton btn21;
    private javax.swing.JToggleButton btn23;
    private javax.swing.JToggleButton btn25;
    private javax.swing.JToggleButton btn4;
    private javax.swing.JToggleButton btn5;
    private javax.swing.JToggleButton btn6;
    private javax.swing.JToggleButton btn7;
    private javax.swing.JToggleButton btn8;
    private javax.swing.JToggleButton btnF10;
    private javax.swing.JToggleButton btnF12;
    private javax.swing.JToggleButton btnF13;
    private javax.swing.JToggleButton btnF16;
    private javax.swing.JToggleButton btnF18;
    private javax.swing.JToggleButton btnF19;
    private javax.swing.JToggleButton btnF20;
    private javax.swing.JToggleButton btnF22;
    private javax.swing.JToggleButton btnF24;
    private javax.swing.JToggleButton btnFirst;
    private javax.swing.JToggleButton btnFourth;
    private javax.swing.JButton btnGetCount;
    private javax.swing.JToggleButton btnO1;
    private javax.swing.JToggleButton btnO11;
    private javax.swing.JToggleButton btnO13;
    private javax.swing.JToggleButton btnO15;
    private javax.swing.JToggleButton btnO17;
    private javax.swing.JToggleButton btnO19;
    private javax.swing.JToggleButton btnO21;
    private javax.swing.JToggleButton btnO23;
    private javax.swing.JToggleButton btnO3;
    private javax.swing.JToggleButton btnO5;
    private javax.swing.JToggleButton btnO7;
    private javax.swing.JToggleButton btnO9;
    private javax.swing.JToggleButton btnSecond;
    private javax.swing.JToggleButton btnT1;
    private javax.swing.JToggleButton btnT11;
    private javax.swing.JToggleButton btnT13;
    private javax.swing.JToggleButton btnT15;
    private javax.swing.JToggleButton btnT17;
    private javax.swing.JToggleButton btnT19;
    private javax.swing.JToggleButton btnT21;
    private javax.swing.JToggleButton btnT23;
    private javax.swing.JToggleButton btnT25;
    private javax.swing.JToggleButton btnT27;
    private javax.swing.JToggleButton btnT29;
    private javax.swing.JToggleButton btnT3;
    private javax.swing.JToggleButton btnT5;
    private javax.swing.JToggleButton btnT7;
    private javax.swing.JToggleButton btnT9;
    private javax.swing.JComboBox<String> cmbClassType;
    private javax.swing.JComboBox<String> cmbEndStation;
    private javax.swing.JComboBox<String> cmbWagonId;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private net.sourceforge.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListAll;
    private javax.swing.JList<String> jListFirst;
    private javax.swing.JList<String> jListObservation;
    private javax.swing.JList<String> jListSecond;
    private javax.swing.JList<String> jListThird;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblClose1;
    private javax.swing.JLabel lblFirstClass;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblObservation;
    private javax.swing.JLabel lblObserver;
    private javax.swing.JLabel lblOne;
    private javax.swing.JLabel lblSecondClass;
    private javax.swing.JLabel lblThirdClass;
    private javax.swing.JLabel lblThree;
    private javax.swing.JLabel lblTwo;
    private javax.swing.JPanel pnlFirstClass;
    private javax.swing.JPanel pnlObservationSaloon;
    private javax.swing.JPanel pnlSecondClass;
    private javax.swing.JPanel pnlThirdClass;
    private javax.swing.JTable tblTrains;
    private javax.swing.JToggleButton tbtn1;
    private javax.swing.JToggleButton tbtn2;
    private javax.swing.JToggleButton tbtn3;
    private javax.swing.JToggleButton tbtn4;
    private javax.swing.JToggleButton tbtn5;
    private javax.swing.JTextField txtAdults;
    private javax.swing.JTextField txtChilrens;
    private javax.swing.JTextField txtPassengerId;
    private javax.swing.JTextField txtPassengerName;
    private javax.swing.JTextField txtStartStation;
    private javax.swing.JTextField txtStationId2;
    private javax.swing.JTextField txtTPNumber;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTrainId;
    private javax.swing.JList<String> wagonList;
    // End of variables declaration//GEN-END:variables

    private void getAllStations() {

    }

    private void ShowThirdClass(List<SheetDto> sheetDto) {
        if (sheetDto == null) {
            return;
        }
        Component[] comp = pnlThirdClass.getComponents();
        JToggleButton[] btn = new JToggleButton[pnlThirdClass.getComponentCount()];
        int i = 0;
        for (Component component : comp) {
            btn[i] = (JToggleButton) component;
            i++;
        }
        int x = 0;
        for (SheetDto dto : sheetDto) {
            if (dto.getSheetType().equals("Third")) {
                btn[x].setText(dto.getSheetID() + "");

                if (dto.getStatus().equals("Booked")) {
                    btn[x].setBackground(Color.BLUE);
                }
                x++;
            }
        }
    }

    private void ShowFirstClass(List<SheetDto> sheetDto) {
        if (sheetDto == null) {
            return;
        }
        Component[] comp = pnlFirstClass.getComponents();
        JToggleButton[] btn = new JToggleButton[pnlFirstClass.getComponentCount()];
        int i = 0;
        for (Component component : comp) {
            btn[i] = (JToggleButton) component;
            i++;
        }
        int x = 0;
        for (SheetDto dto : sheetDto) {
            if (dto.getSheetType().equals("FirstClass")) {

                try {
                    btn[x].setText(dto.getSheetID() + "");
                    Date date = jDateChooser.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
                    String reserveDate = dateFormat.format(date);
                    Object[] getAllr = {btn[x].getText(), reserveDate};
                    int all = ManageSheetController.getCountAllCount(getAllr);
                    if (all != 0) {
                        btn[x].setBackground(Color.BLUE);
                    }
                    x++;
                } catch (Exception ex) {
                    Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void ShowSecondClass(List<SheetDto> sheetDto) {
        if (sheetDto == null) {
            return;
        }
        Component[] comp = pnlSecondClass.getComponents();
        JToggleButton[] btn = new JToggleButton[pnlSecondClass.getComponentCount()];
        int i = 0;
        for (Component component : comp) {
            btn[i] = (JToggleButton) component;
            i++;
        }
        int x = 0;
        for (SheetDto dto : sheetDto) {
            if (dto.getSheetType().equals("SecondClass")) {
                try {
                    btn[x].setText(dto.getSheetID() + "");
                    Date date = jDateChooser.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
                    String reserveDate = dateFormat.format(date);
                    Object[] getAllr = {btn[x].getText(), reserveDate};
                    int all = ManageSheetController.getCountAllCount(getAllr);
                    if (all != 0) {
                        btn[x].setBackground(Color.BLUE);
                    }
                    x++;
                } catch (Exception ex) {
                    Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void ShowObservationClass(List<SheetDto> sheetDto) {
        if (sheetDto == null) {
            return;
        }
        Component[] comp = pnlObservationSaloon.getComponents();
        JToggleButton[] btn = new JToggleButton[pnlObservationSaloon.getComponentCount()];
        int i = 0;
        for (Component component : comp) {
            btn[i] = (JToggleButton) component;
            i++;
        }
        int x = 0;
        for (SheetDto dto : sheetDto) {
            if (dto.getSheetType().equals("ObservationSaloon")) {
                try {
                    btn[x].setText(dto.getSheetID() + "");
                    Date date = jDateChooser.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
                    String reserveDate = dateFormat.format(date);
                    Object[] getAllr = {btn[x].getText(), reserveDate};
                    int all = ManageSheetController.getCountAllCount(getAllr);
                    if (all != 0) {
                        btn[x].setBackground(Color.BLUE);
                    }
                    x++;
                } catch (Exception ex) {
                    Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void ShowThirdClasses(List<SheetDto> sheetDto) {
        if (sheetDto == null) {
            return;
        }
        Component[] comp = pnlThirdClass.getComponents();
        JToggleButton[] btn = new JToggleButton[pnlThirdClass.getComponentCount()];
        int i = 0;
        for (Component component : comp) {
            btn[i] = (JToggleButton) component;
            i++;
        }
        int x = 0;
        for (SheetDto dto : sheetDto) {
            if (dto.getSheetType().equals("ThirdClass")) {
                try {
                    btn[x].setText(dto.getSheetID() + "");
                    Date date = jDateChooser.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MMM-dd");
                    String reserveDate = dateFormat.format(date);
                    Object[] getAllr = {btn[x].getText(), reserveDate};
                    int all = ManageSheetController.getCountAllCount(getAllr);
                    if (all != 0) {
                        btn[x].setBackground(Color.BLUE);
                    }
                    x++;
                } catch (Exception ex) {
                    Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void showThirdClasses() {
        ListModel model = wagonList.getModel();

        for (int i = 0; i < model.getSize(); i++) {
            listObject = model.getElementAt(i);

        }
    }

    public void time() {
        new Thread(() -> {
            while (true) {
                Date date = new Date();
                String currentdate = new SimpleDateFormat("hh:mm:ss aa").format(date);
                time = currentdate;

                //lblTime.setText(currentdate);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
            }
        }).start();
    }

    private boolean seatReservation(JToggleButton btn) {

        try {
            SheetDto sheet = ManageReservationController.getAllSheets(btn.getText());

            if (reserveId == 0) {
                ManageReservationController.releaseSeat(reserveId);
            }

            reserveId = Integer.parseInt(btn.getText());
            reserverIdList.add(Integer.parseInt(btn.getText()));
            reserveSeat = ManageReservationController.reserveSeat(reserveId);
            System.out.println("reserveSeat" + reserveSeat);
            if (!reserveSeat) {
                JOptionPane.showMessageDialog(this, "Seat has been already reserved");
            } else {

            }
            // return true;

        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("uuu" + reserveSeat);
        return reserveSeat;
    }

    @Override
    public void updateObservers() throws Exception {
        //getAllStations();
        try {
            List<StationDto> stationDto = ManageStationController.getAllStation();
            cmbEndStation.removeAllItems();
            if (stationDto != null) {
                for (StationDto station : stationDto) {

                    cmbEndStation.addItem(station.getStationName());

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadJasper() {
        try {
            jasper = (JasperReport) JRLoader.loadObject(ReservationFrame.class.getResourceAsStream("/lk/ijse/rtrsc/jasper/TrainTicket.jasper"));
        } catch (JRException ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void JasperLoad() {
      
        try {
            HashMap<String, Object> data = new HashMap<>();
            data.put("Start Station", txtStartStation.getText());
            data.put("End Station",(String) cmbEndStation.getSelectedItem());
            data.put("PassengerId", txtPassengerId.getText());
            data.put("routeName", routeName);
            data.put("Date", jasperDate);
            data.put("StartTime","8.45");
            data.put("Adults", Integer.parseInt( txtAdults.getText()));
            data.put("Childrens", Integer.parseInt(txtChilrens.getText()));
            data.put("Cost",Double.parseDouble(txtTotal.getText()));
            JasperPrint filledReport = JasperFillManager.fillReport(jasper, data, new JREmptyDataSource());
            JRViewer jRViewer = new JRViewer(filledReport);
            jRViewer.setOpaque(true);
            jRViewer.setBackground(Color.WHITE);
//        pnlJasper.removeAll();
//        pnlJasper.add(jRViewer);
//        pnlJasper.setVisible(true);
            JasperTicketFrame f1 = new JasperTicketFrame();
            f1.add( jRViewer);
            f1.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReservationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
