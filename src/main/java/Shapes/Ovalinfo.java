package Shapes;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ovalinfo extends javax.swing.JFrame implements Node{


    /**
     * Creates new form OvalInfo
     */

    private Node parent;
    private Color fillColor = Color.BLUE;
    private Color borderColor = Color.BLACK;
    public Ovalinfo() 
    {
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
        jLabel7 = new javax.swing.JLabel();
        startingLabel = new javax.swing.JLabel();
        xStartingTextField = new javax.swing.JTextField();
        yStartingTextField = new javax.swing.JTextField();
        yStartingLabel = new javax.swing.JLabel();
        xStartingLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        startingLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fillColorButton = new javax.swing.JButton();
        borderColorButton = new javax.swing.JButton();
        createOvalButton = new javax.swing.JButton();
        widthTextField = new javax.swing.JTextField();
        startingLabel2 = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Circle Details");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Coordinates:");

        startingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startingLabel.setText("Starting Point");

        yStartingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yStartingLabel.setText("y:");

        xStartingLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        xStartingLabel.setText("x:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Size:");

        startingLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startingLabel1.setText("Width");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Colors:");

        fillColorButton.setText("Fill Color");
        fillColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillColorButtonActionPerformed(evt);
            }
        });

        borderColorButton.setText("Border Color");
        borderColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borderColorButtonActionPerformed(evt);
            }
        });

        createOvalButton.setText("Create Oval");
        createOvalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createOvalButtonActionPerformed(evt);
            }
        });

        startingLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startingLabel2.setText("Height");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fillColorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borderColorButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startingLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(startingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xStartingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xStartingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(startingLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(yStartingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yStartingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(createOvalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yStartingLabel)
                        .addComponent(yStartingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startingLabel)
                        .addComponent(xStartingLabel)
                        .addComponent(xStartingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startingLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(startingLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fillColorButton)
                    .addComponent(borderColorButton))
                .addGap(18, 18, 18)
                .addComponent(createOvalButton)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillColorButtonActionPerformed
        // TODO add your handling code here:
        Color col = Color.BLUE;
        Color fillColor = jColorChooser1.showDialog(null, "Select a filling color", col);
        this.fillColor = fillColor;
    }//GEN-LAST:event_fillColorButtonActionPerformed

    private void borderColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borderColorButtonActionPerformed
        Color col = Color.BLUE;
        Color borderColor = jColorChooser1.showDialog(null, "Select a border color", col);
        this.borderColor = borderColor;
    }//GEN-LAST:event_borderColorButtonActionPerformed

    private void createOvalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createOvalButtonActionPerformed
        if(xStartingTextField.getText().equals("") || 
           yStartingTextField.getText().equals("") || 
           widthTextField.getText().equals("") ||
           heightTextField.getText().equals(""))
            JOptionPane.showMessageDialog(null,
                    "There is one or more empty fields");
        else
        {
           if(isIntger(xStartingTextField.getText()) &&
              isIntger(yStartingTextField.getText()) && 
              isIntger(widthTextField.getText()) &&
              isIntger(heightTextField.getText()))             
            {
                int startingX = Integer.parseInt(xStartingTextField.getText());
                int startingY = Integer.parseInt(yStartingTextField.getText());
                int Width = Integer.parseInt(widthTextField.getText());
                int Height = Integer.parseInt(heightTextField.getText());
                
                Oval oval = new Oval(new Point(startingX, startingY), Width, Height);
                oval.setBorderColor(borderColor);
                oval.setFillColor(fillColor);
                DrawingFrame.getDrawingPanel1().addShape(oval);
                String objectName = oval.getObjectName();
                DrawingFrame.getComboBox().addItem(objectName);
                DrawingFrame.getDrawingPanel1().refresh(null);
                
                this.setVisible(false);
                ((JFrame) getParentNode()).setVisible(true);
            }
           else
           {
               JOptionPane.showMessageDialog(null, 
                       "Please enter only integer values!!");
               xStartingTextField.setText("");
               yStartingTextField.setText("");
               widthTextField.setText("");
               heightTextField.setText("");
           }
        }
        
    }//GEN-LAST:event_createOvalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Ovalinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ovalinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ovalinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ovalinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borderColorButton;
    private javax.swing.JButton createOvalButton;
    private javax.swing.JButton fillColorButton;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel startingLabel;
    private javax.swing.JLabel startingLabel1;
    private javax.swing.JLabel startingLabel2;
    private javax.swing.JTextField widthTextField;
    private javax.swing.JLabel xStartingLabel;
    private javax.swing.JTextField xStartingTextField;
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
