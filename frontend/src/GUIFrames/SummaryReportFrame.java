/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIFrames;
import backendclasses.Manager;
import database.Database;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author mubas
 */
public class SummaryReportFrame extends javax.swing.JFrame {

    /**
     * Creates new form SummaryReport
     */
    private final Database db;
    private final Manager manager;
    private final Integer period;
    public SummaryReportFrame(Database db, Manager manager, Integer period) {
        initComponents();
        this.db = db;
        this.manager = manager;
        this.period = period;

        manager.setSummaryInfo(period);

        numPropertyPeriod.setText("Total number of houses listed: " + manager.getNumListed());
        numRentedPeriod.setText("Total number of houses rented: " + manager.getNumRented());
        numActivePeriod.setText("Total number of active listings: " + manager.getNumActive());
        ArrayList<ArrayList<String>> numListed = manager.listNumRented();
        StringBuilder constructListed = new StringBuilder();
        constructListed.append("<html>");
        for (ArrayList<String> strings : numListed) {
            constructListed.append(strings.get(0)).append("<br/>");
        }
        System.out.println("listed houses: " + constructListed);
        constructListed.append("</html>");
        numActivePeriod.setText(constructListed.toString());

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        numPropertyPeriod = new javax.swing.JLabel();
        numRentedPeriod = new javax.swing.JLabel();
        numActivePeriod = new javax.swing.JLabel();
        numListPeriod = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        numPropertyPeriod.setText("1.");

        numRentedPeriod.setText("2.");

        numActivePeriod.setText("3.");

        numListPeriod.setText("4.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(167, 167, 167)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(numPropertyPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(numRentedPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(numActivePeriod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(numListPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(206, 206, 206)
                                                .addComponent(exitButton)))
                                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(numPropertyPeriod)
                                .addGap(13, 13, 13)
                                .addComponent(numRentedPeriod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numActivePeriod)
                                .addGap(12, 12, 12)
                                .addComponent(numListPeriod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exitButton)
                                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);
        this.dispose();// TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel numActivePeriod;
    private javax.swing.JLabel numListPeriod;
    private javax.swing.JLabel numPropertyPeriod;
    private javax.swing.JLabel numRentedPeriod;
    // End of variables declaration
}