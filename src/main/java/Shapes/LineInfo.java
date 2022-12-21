package Shapes;

import com.sun.source.tree.ParenthesizedTree;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LineInfo extends javax.swing.JFrame implements Node {

    /**
     * Creates new form LineInfo
     */
    Graphics canvas;

    private Node parent;
    private Color borderColor = Color.CYAN;

    public LineInfo() {
        initComponents();
    }

    public static boolean isIntger(String str) {
        try {
            Integer.valueOf(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        startingLabel = new javax.swing.JLabel();
        xStartingLabel = new javax.swing.JLabel();
        endingLabel = new javax.swing.JLabel();
        xEndingLabel = new javax.swing.JLabel();
        yStartingLabel = new javax.swing.JLabel();
        yEndingLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        xStartingTextField = new javax.swing.JTextField();
        yStartingTextField = new javax.swing.JTextField();
        xEndingTextField = new javax.swing.JTextField();
        yEndingTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        borderColorButton = new javax.swing.JButton();
        createLineButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Line Details");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        startingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startingLabel.setText("Starting Point");

        xStartingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        xStartingLabel.setText("x:");

        endingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        endingLabel.setText("Ending Point");

        xEndingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        xEndingLabel.setText("x:");

        yStartingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yStartingLabel.setText("y:");

        yEndingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yEndingLabel.setText("y:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Coordinates:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Colors:");

        borderColorButton.setText("Border Color");
        borderColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borderColorButtonActionPerformed(evt);
            }
        });

        createLineButton.setText("Create Line");
        createLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLineButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(startingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                    .addComponent(endingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(xStartingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                    .addComponent(xEndingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xStartingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(xEndingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yStartingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(yEndingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yStartingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yEndingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createLineButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(borderColorButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startingLabel)
                    .addComponent(xStartingLabel)
                    .addComponent(yStartingLabel)
                    .addComponent(xStartingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yStartingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endingLabel)
                    .addComponent(xEndingLabel)
                    .addComponent(yEndingLabel)
                    .addComponent(xEndingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yEndingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(borderColorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(createLineButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borderColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borderColorButtonActionPerformed
        Color col = Color.BLUE;
        Color borderColor = jColorChooser1.showDialog(null, "Select a border color", col);
        this.borderColor = borderColor;
    }//GEN-LAST:event_borderColorButtonActionPerformed

    private void createLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLineButtonActionPerformed
        // TODO add your handling code here:
        if (xStartingTextField.getText().equals("") || xEndingTextField.getText().equals("") ||
                yStartingTextField.getText().equals("") || yEndingTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "There is one or more empty fields");
        } else {
            if (isIntger(xStartingTextField.getText()) && isIntger(xEndingTextField.getText()) &&
                    isIntger(yStartingTextField.getText()) && isIntger(yEndingTextField.getText())) {
                int startingXCor = Integer.parseInt(xStartingTextField.getText());
                int endingXCor = Integer.parseInt(xEndingTextField.getText());
                int startingYCor = Integer.parseInt(yStartingTextField.getText());
                int endingYCor = Integer.parseInt(yEndingTextField.getText());
                
                LineSegment line = new LineSegment(new Point(startingXCor, startingYCor), new Point(endingXCor, endingYCor));
                line.setBorderColor(borderColor);
                line.setFillColor(borderColor);
                DrawingFrame.getDrawingPanel1().addShape(line);
                String objectName = line.getObjectName();
                DrawingFrame.getComboBox().addItem(objectName);
                DrawingFrame.getDrawingPanel1().refresh(null);
                
                this.setVisible(false);
                ((JFrame) getParentNode()).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter only integer values!!");
                xStartingTextField.setText("");
                xEndingTextField.setText("");
                yStartingTextField.setText("");
                yEndingTextField.setText(""); 
            }
        }

    }//GEN-LAST:event_createLineButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
        ((JFrame)getParentNode()).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(LineInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LineInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LineInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LineInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borderColorButton;
    private javax.swing.JButton createLineButton;
    private javax.swing.JLabel endingLabel;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel startingLabel;
    private javax.swing.JLabel xEndingLabel;
    private javax.swing.JTextField xEndingTextField;
    private javax.swing.JLabel xStartingLabel;
    private javax.swing.JTextField xStartingTextField;
    private javax.swing.JLabel yEndingLabel;
    private javax.swing.JTextField yEndingTextField;
    private javax.swing.JLabel yStartingLabel;
    private javax.swing.JTextField yStartingTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }

    @Override
    public Node getParentNode() {
        return parent;
    }
}
