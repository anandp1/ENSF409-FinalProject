/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Mubashir Rahman, mubashir.rahman@ucalgary.ca
 * @version 1.1
 * @since 1.0
 */
public class ChangeListingStatus extends javax.swing.JFrame {

    /**
     * Creates new form ChangeListingStatus
     */
    public ChangeListingStatus() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkBoxGroup = new javax.swing.ButtonGroup();
        rentedCheckbox = new javax.swing.JCheckBox();
        cancelledCheckBox = new javax.swing.JCheckBox();
        suspendedCheckbox = new javax.swing.JCheckBox();
        activeCheckbox = new javax.swing.JCheckBox();
        changeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        checkBoxGroup.add(rentedCheckbox);
        rentedCheckbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rentedCheckbox.setText("Rented");

        checkBoxGroup.add(cancelledCheckBox);
        cancelledCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelledCheckBox.setText("Cancelled");

        checkBoxGroup.add(suspendedCheckbox);
        suspendedCheckbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        suspendedCheckbox.setText("Suspended");

        checkBoxGroup.add(activeCheckbox);
        activeCheckbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        activeCheckbox.setText("Active");

        changeButton.setText("Change");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activeCheckbox)
                    .addComponent(suspendedCheckbox)
                    .addComponent(cancelledCheckBox)
                    .addComponent(rentedCheckbox)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(activeCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rentedCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelledCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suspendedCheckbox)
                .addGap(18, 18, 18)
                .addComponent(changeButton)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Changes current listing status and closes form
    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_changeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChangeListingStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeListingStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeListingStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeListingStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeListingStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activeCheckbox;
    private javax.swing.JCheckBox cancelledCheckBox;
    private javax.swing.JButton changeButton;
    private javax.swing.ButtonGroup checkBoxGroup;
    private javax.swing.JCheckBox rentedCheckbox;
    private javax.swing.JCheckBox suspendedCheckbox;
    // End of variables declaration//GEN-END:variables
}