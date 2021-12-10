/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIFrames;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

import backendclasses.*;
import database.Database;
import java.sql.*;
/**
 *
 * @author Anand
 */
public class RegisteredRenterFrame extends javax.swing.JFrame {

    /**
     * Creates new form backendclasses.RegisteredRenter
     */
    private final Database db;
    private final Integer renterID;
    private final RegisteredRenter registeredRenter;
    private final String renterEmail;
    public RegisteredRenterFrame(Database db, String ID, String renterEmail) {
        initComponents();
        this.db = db;
        this.renterID = Integer.valueOf(ID);
        this.renterEmail = renterEmail;
        this.registeredRenter = new RegisteredRenter(db.getSubscriptionState(renterID),
                renterID, db);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        logoutButton = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        apartmentType = new javax.swing.JComboBox<>();
        numBed = new javax.swing.JComboBox<>();
        numBath = new javax.swing.JComboBox<>();
        cityQuadrant = new javax.swing.JComboBox<>();
        label5 = new java.awt.Label();
        furnishedBool = new java.awt.Checkbox();
        searchButton = new java.awt.Button();
        unsubscribeButton = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList<>();
        emailButton = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notificationList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutButton.setLabel("Logout");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Criteria", 0, 0, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        label1.setText("Apartment Type:");

        label2.setText("# of Bedrooms:");

        label3.setText("# of Bathrooms:");

        label4.setText("City Quadrant:");

        apartmentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Attached", "Detached", "Townhouse", "Apartment" }));

        numBed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        numBath.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        cityQuadrant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SW", "NW", "NE", "SE" }));

        label5.setText("Furnished:");

        searchButton.setLabel("Search");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        unsubscribeButton.setLabel("Unsubscribe");
        unsubscribeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unsubscribeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(28, 28, 28))
                                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(furnishedBool, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(apartmentType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(numBed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(numBath, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cityQuadrant, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(12, 12, 12))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(381, 381, 381)
                                                .addComponent(unsubscribeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(apartmentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numBed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numBath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cityQuadrant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(furnishedBool, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(unsubscribeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(searchList);

        emailButton.setLabel("Email Landlord");
        emailButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Search Results:");

//        notificationList.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = { "temp", " " };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
//        jScrollPane2.setViewportView(notificationList);

        jLabel2.setText("Notifications:");
        ArrayList<Property> notificationProperties = db.getNewProperties(renterID);

        String[] propertyDisplay = new String[notificationProperties.size()];
        int i = 0;
        for(Property properties : notificationProperties) {
            propertyDisplay[i] = "PropertyID: " + properties.getPropertyID() + " Address:"
                    + properties.getPropertyAddress();
            i++;
        }
        notificationList.setModel(new javax.swing.AbstractListModel<String>() {
            //                String[] strings = { "No Matches", "NewItem" };
            public int getSize() { return propertyDisplay.length; }
            public String getElementAt(int i) { return propertyDisplay[i]; }
        });
        jScrollPane2.setViewportView(notificationList);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(emailButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addComponent(emailButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        this.dispose();
        new BaseFrame(db).setVisible(true);
    }

    private void unsubscribeButtonMouseClicked(java.awt.event.MouseEvent evt) {
        boolean subState = db.getSubscriptionState(renterID);
        if(subState) {
            subState = false;
            registeredRenter.setSubscriptionState(subState);
            unsubscribeButton.setLabel("Subscribe");
        }
        else {
            subState = true;
            registeredRenter.setSubscriptionState(subState);
            unsubscribeButton.setLabel("Unsubscribe");
        }
        // TODO add your handling code here:
        // unsubcribes to all the criteria in the class for this renter
    }

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:\
        String apartmentText = Objects.requireNonNull(apartmentType.getSelectedItem()).toString();
        Integer numBathrooms = Integer.valueOf(Objects.requireNonNull(numBath.getSelectedItem()).toString());
        Integer numBedrooms = Integer.valueOf(Objects.requireNonNull(numBed.getSelectedItem()).toString());
        String cityQuad = Objects.requireNonNull(cityQuadrant.getSelectedItem()).toString();
        boolean furnishedState = furnishedBool.getState();

        // TO DO:
        // save this criteria of the renter into the database
        // display any new criteria in the notifications text
        // Change code using the Renter class

        Criteria criteria = new Criteria(ApartmentType.fromInt(ApartmentType.fromString(apartmentText)), numBedrooms, numBathrooms, Quadrant.fromInt(Quadrant.fromString(cityQuad)), furnishedState);
        ArrayList<Property> matched = registeredRenter.searchResults(criteria);
        if(matched.isEmpty()) {
            searchList.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = {"No Matches"};
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
        }
        else {
            String[] propertyDisplay = new String[matched.size()];
            int i = 0;
            for(Property properties : matched) {
                propertyDisplay[i] = "PropertyID: " + properties.getPropertyID() + " Address:"
                        + properties.getPropertyAddress();
                i++;
            }
            searchList.setModel(new javax.swing.AbstractListModel<String>() {
                //                String[] strings = { "No Matches", "NewItem" };
                public int getSize() { return propertyDisplay.length; }
                public String getElementAt(int i) { return propertyDisplay[i]; }
            });
        }


    }

    private void emailButtonMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        String selectedProperty = "";
        int flag = 0;
        if(notificationList.getSelectedValue() == null && searchList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No properties are selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(notificationList.getSelectedValue() != null && searchList.getSelectedValue() != null) {
            notificationList.clearSelection();
            JOptionPane.showMessageDialog(this, "Only select one property!", "Error", JOptionPane.ERROR_MESSAGE);
            searchList.clearSelection();
        }
        if(notificationList.getSelectedValue() != null && searchList.getSelectedValue() == null){
            selectedProperty = notificationList.getSelectedValue();
            flag = 1;
        }
        else if(searchList.getSelectedValue() != null && notificationList.getSelectedValue() == null) {
            selectedProperty = searchList.getSelectedValue();
            flag = 1;
        }
        if(flag == 1) {
                System.out.println(selectedProperty);
                String email = JOptionPane.showInputDialog(this, "What is your preferred email?");
                String message = JOptionPane.showInputDialog(this, "What is your message to the landlord?");
                Message constructMessage = new Message(email, message);

                StringBuilder propertyID = new StringBuilder();
                for(int i = 12; i < selectedProperty.length(); i++){
                    if(selectedProperty.charAt(i) == ' ' || selectedProperty.charAt(i) == 'A'){
                        break;
                    }
                    propertyID.append(String.valueOf(selectedProperty.charAt(i)));

                }
                Integer landlordID = db.getPropertyLandlord(Integer.parseInt(propertyID.toString()));
                db.addMessage(landlordID, constructMessage);
                // save message in the landlord emails, pass in who the renter is
        }



    }

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(RegisteredRenterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegisteredRenterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegisteredRenterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegisteredRenterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisteredRenterUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> apartmentType;
    private javax.swing.JComboBox<String> cityQuadrant;
    private java.awt.Button emailButton;
    private java.awt.Checkbox furnishedBool;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Button logoutButton;
    private javax.swing.JList<String> notificationList;
    private javax.swing.JComboBox<String> numBath;
    private javax.swing.JComboBox<String> numBed;
    private java.awt.Button searchButton;
    private javax.swing.JList<String> searchList;
    private java.awt.Button unsubscribeButton;
    // End of variables declaration
}
