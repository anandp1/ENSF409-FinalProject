/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIFrames;

import javax.swing.*;

import backendclasses.*;
import database.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mubas
 */
public class ManagerFrame extends javax.swing.JFrame {

    /**
     * Creates new form DisplayTable
     */
    private final Database db;
    private final Integer ID;
    Manager manager;
    private HashMap<Integer, Double> propertyFee = new HashMap<Integer, Double>();
    private HashMap<Integer, Integer> propertyPeriod = new HashMap<Integer, Integer>();

    public ManagerFrame(Database db, String ID) {
        initComponents();
        changeFeeButton.setVisible(false);
        changeListingButton.setVisible(false);
        changePeriodButton.setVisible(false);
        periodLabel.setVisible(false);
        periodEntry.setVisible(false);
        createSummaryReportButton.setVisible(false);
        this.db = db;
        this.ID = Integer.valueOf(ID);
        manager = new Manager(db);
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
        selectDropDown = new javax.swing.JComboBox<>();
        displayLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayList = new javax.swing.JList<>();
        changeListingButton = new javax.swing.JButton();
        changeFeeButton = new javax.swing.JButton();
        changePeriodButton = new javax.swing.JButton();
        createSummaryReportButton = new javax.swing.JButton();
        periodEntry = new javax.swing.JTextField();
        periodLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        logout = new java.awt.Button();


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        logout.setLabel("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        selectDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "All renters", "All landlords", "All properties" }));
        selectDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDropDownActionPerformed(evt);
            }
        });

        displayLabel.setText("Display");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        displayList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        displayList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(displayList);

        changeListingButton.setText("Change Listing Status");
        changeListingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeListingButtonActionPerformed(evt);
            }
        });

        changeFeeButton.setText("Change Fee");
        changeFeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFeeButtonActionPerformed(evt);
            }
        });

        changePeriodButton.setText("Change Period");

        createSummaryReportButton.setText("Create Summary Report");
        createSummaryReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSummaryReportButtonActionPerformed(evt);
            }
        });



        periodLabel.setText("Period");
        changePeriodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePeriodButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup() // added
                                .addGap(0, 0, Short.MAX_VALUE) // added
                                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) // added
                        .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(displayLabel)
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchButton)
                                        .addComponent(selectDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(322, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(changeFeeButton)
                                                                .addGap(0, 49, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(periodLabel)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(changeListingButton)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(changePeriodButton))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(periodEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(225, Short.MAX_VALUE)))) // added this add container

                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(createSummaryReportButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) // added
                                        .addComponent(selectDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(displayLabel))
                                .addGap(18, 18, 18)
                                .addComponent(searchButton)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(changeFeeButton)
                                                                        .addComponent(changePeriodButton)
                                                                        .addComponent(changeListingButton))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(periodEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(periodLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(createSummaryReportButton))
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        selectDropDown.getAccessibleContext().setAccessibleName("");
        displayLabel.getAccessibleContext().setAccessibleName("DisplayLabel\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        new BaseFrame(db).setVisible(true);
    }
    private void selectDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectDropDownActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String select= selectDropDown.getSelectedItem().toString();
        if(select.equals("All properties"))
        {
            ArrayList<Property> allProperties = manager.getProperties();
            if(allProperties.isEmpty()) {
                displayList.setModel(new javax.swing.AbstractListModel<String>() {
                    String[] strings = {"No Properties"};
                    public int getSize() { return strings.length; }
                    public String getElementAt(int i) { return strings[i]; }
                });
            }
            else {
                String[] propertyDisplay = new String[allProperties.size()];
                int i = 0;
                for(Property properties : allProperties) {
                    String isFurnished = (properties.getIsFurnished()) ? "Furnished" : "Not Furnished";
                    propertyDisplay[i] = "<html>PropertyID: " + properties.getPropertyID() + "<br/>Address: "
                            + properties.getPropertyAddress() + "<br/>ApartmentType: " + ApartmentType.fromInt(properties.getApartmentType().getInt()) +
                    "<br/>Number of Bedrooms: " + properties.getNumBed() + "<br/>Number of Bathrooms: " + properties.getNumBath() +
                    "<br/>Quadrant: " + Quadrant.fromInt(properties.getQuadrant().getInt()) + "<br>Furnished State: " + isFurnished +
                    "<br/>Fee: " + String.valueOf(properties.getListing().getFee().getFeeAmount()) + "<br/>Period: " +
                            String.valueOf(properties.getListing().getFee().getPeriod()) + "<br/>Listing State: " +
                    State.fromInt(properties.getListing().getListingState().getInt()) + "<br/></html>";
                    propertyFee.put(properties.getPropertyID(), properties.getListing().getFee().getFeeAmount());
                    propertyPeriod.put(properties.getPropertyID(), properties.getListing().getFee().getPeriod());
                    i++;
                }
                displayList.setModel(new javax.swing.AbstractListModel<String>() {
                    //                String[] strings = { "No Matches", "NewItem" };
                    public int getSize() { return propertyDisplay.length; }
                    public String getElementAt(int i) { return propertyDisplay[i]; }
                });
            }

            changeFeeButton.setVisible(true);
            changeListingButton.setVisible(true);
            changePeriodButton.setVisible(true);
            periodLabel.setVisible(true);
            periodEntry.setVisible(true);
            createSummaryReportButton.setVisible(true);
        }
        else
        {
            if(select.equals("All renters")) {
                ArrayList<String> allRenters = manager.getRenters();
                if(allRenters.isEmpty()) {
                    displayList.setModel(new javax.swing.AbstractListModel<String>() {
                        String[] strings = {"No Renters"};
                        public int getSize() { return strings.length; }
                        public String getElementAt(int i) { return strings[i]; }
                    });
                }
                else {
                    String[] renterDisplay = new String[allRenters.size()];
                    int i = 0;
                    for(String renters : allRenters) {
                        renterDisplay[i] = renters;
                        i++;
                    }
                    displayList.setModel(new javax.swing.AbstractListModel<String>() {
                        //                String[] strings = { "No Matches", "NewItem" };
                        public int getSize() { return renterDisplay.length; }
                        public String getElementAt(int i) { return renterDisplay[i]; }
                    });
                }
            }
            if (select.equals("All landlords")){
                ArrayList<String> allLandlords = manager.getLandlords();
                if(allLandlords.isEmpty()) {
                    displayList.setModel(new javax.swing.AbstractListModel<String>() {
                        String[] strings = {"No Landlords"};
                        public int getSize() { return strings.length; }
                        public String getElementAt(int i) { return strings[i]; }
                    });
                }
                else {
                    String[] landlordDisplay = new String[allLandlords.size()];
                    int i = 0;
                    for(String renters : allLandlords) {
                        landlordDisplay[i] = renters;
                        i++;
                    }
                    displayList.setModel(new javax.swing.AbstractListModel<String>() {
                        //                String[] strings = { "No Matches", "NewItem" };
                        public int getSize() { return landlordDisplay.length; }
                        public String getElementAt(int i) { return landlordDisplay[i]; }
                    });
                }
            }
            changeFeeButton.setVisible(false);
            changeListingButton.setVisible(false);
            changePeriodButton.setVisible(false);
            periodLabel.setVisible(false);
            periodEntry.setVisible(false);
            createSummaryReportButton.setVisible(false);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void changeListingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeListingButtonActionPerformed
        if(displayList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No properties are selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            String selectedProperty = displayList.getSelectedValue();
            StringBuilder propertyID = new StringBuilder();
            for(int i = 18; i < selectedProperty.length(); i++){
                if(selectedProperty.charAt(i) == '<' || selectedProperty.charAt(i) == 'A'){
                    break;
                }
                propertyID.append(String.valueOf(selectedProperty.charAt(i)));

            }
            System.out.println("propertyID: " + propertyID.toString());
            JFrame frame =new ChangeListingStatusFrame(db, Integer.valueOf(propertyID.toString()));
            frame.setVisible(true);
        }

    }//GEN-LAST:event_changeListingButtonActionPerformed

    private void changeFeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFeeButtonActionPerformed
        if(displayList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No properties are selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            String selectedProperty = displayList.getSelectedValue();
            StringBuilder propertyID = new StringBuilder();
            for(int i = 18; i < selectedProperty.length(); i++){
                if(selectedProperty.charAt(i) == '<' || selectedProperty.charAt(i) == 'A'){
                    break;
                }
                propertyID.append(String.valueOf(selectedProperty.charAt(i)));

            }
            Integer period = propertyPeriod.get(Integer.valueOf(propertyID.toString()));
            JFrame frame =new ChangeFeeFrame(db, period, Integer.valueOf(propertyID.toString()));
            frame.setVisible(true);
        }
    }//GEN-LAST:event_changeFeeButtonActionPerformed

    private void createSummaryReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSummaryReportButtonActionPerformed
        if(periodEntry.getText() == null) {
            JOptionPane.showMessageDialog(this, "No period entered", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JFrame frame = new SummaryReportFrame(db, manager, Integer.valueOf(periodEntry.getText()));
            frame.setVisible(true);

        }
        // GUI gui = new GUI() as well
    }//GEN-LAST:event_createSummaryReportButtonActionPerformed
    private void changePeriodButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(displayList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No properties are selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            String selectedProperty = displayList.getSelectedValue();
            StringBuilder propertyID = new StringBuilder();
            for(int i = 18; i < selectedProperty.length(); i++){
                if(selectedProperty.charAt(i) == '<' || selectedProperty.charAt(i) == 'A'){
                    break;
                }
                propertyID.append(String.valueOf(selectedProperty.charAt(i)));

            }
            Double fee = Double.valueOf(propertyPeriod.get(Integer.valueOf(propertyID.toString())));
            JFrame frame =new ChangePeriodFrame(db, fee, Integer.valueOf(propertyID.toString()));
            frame.setVisible(true);
        }
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DisplayTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DisplayTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DisplayTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DisplayTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DisplayTable().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeFeeButton;
    private javax.swing.JButton changeListingButton;
    private javax.swing.JButton changePeriodButton;
    private javax.swing.JButton createSummaryReportButton;
    private javax.swing.JLabel displayLabel;
    private javax.swing.JList<String> displayList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField periodEntry;
    private javax.swing.JLabel periodLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> selectDropDown;
    private java.awt.Button logout;
    // End of variables declaration//GEN-END:variables
}