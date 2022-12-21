package Shapes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.Path;

public class DrawingFrame extends javax.swing.JFrame implements Node{

    private Node parent;
    private Polygons copiedShape;

    Polygons oldShape;
    Polygons selectedShape;
    
    public static DrawingPanel getDrawingPanel1() {
        return drawingPanel1;
    }
    public DrawingFrame()
    {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        Line = new javax.swing.JButton();
        Oval = new javax.swing.JButton();
        rectangle = new javax.swing.JButton();
        ComboBox = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();
        colorize = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        drawingPanel1 = new Shapes.DrawingPanel();
        Triangle = new javax.swing.JButton();
        Clone = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Save = new javax.swing.JMenuItem();
        Load = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Line.setText("Line");
        Line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineActionPerformed(evt);
            }
        });

        Oval.setText("Oval");
        Oval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OvalActionPerformed(evt);
            }
        });

        rectangle.setText("Rectangle");
        rectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        colorize.setText("Colorize");
        colorize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizeActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Shape");

        drawingPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout drawingPanel1Layout = new javax.swing.GroupLayout(drawingPanel1);
        drawingPanel1.setLayout(drawingPanel1Layout);
        drawingPanel1Layout.setHorizontalGroup(
            drawingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        drawingPanel1Layout.setVerticalGroup(
            drawingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        Triangle.setText("Triangle");
        Triangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TriangleActionPerformed(evt);
            }
        });

        Clone.setText("Clone");
        Clone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloneActionPerformed(evt);
            }
        });

        File.setText("File");

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        File.add(Save);

        Load.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Load.setText("Load");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });
        File.add(Load);

        jMenuBar1.add(File);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(colorize)
                        .addGap(18, 18, 18)
                        .addComponent(delete))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clone))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(Line, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(Oval, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(rectangle)
                        .addGap(82, 82, 82)
                        .addComponent(Triangle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(drawingPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Line, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Oval, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Triangle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(colorize))
                        .addGap(18, 18, 18)
                        .addComponent(Clone))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(drawingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void LineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineActionPerformed
        
        LineInfo lineInfo = new LineInfo();
        lineInfo.setParentNode(this);
        lineInfo.setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_LineActionPerformed

    private void OvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OvalActionPerformed
        
        Ovalinfo ovalInfo = new Ovalinfo();
        ovalInfo.setParentNode(this);
        ovalInfo.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_OvalActionPerformed

    private void rectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleActionPerformed
        
        RectangleInfo recInfo = new RectangleInfo();
        recInfo.setParentNode(this);
        recInfo.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_rectangleActionPerformed

    private void colorizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizeActionPerformed
        if (drawingPanel1.getShapes().length != 0 ) 
        {    
        String name = ComboBox.getSelectedItem().toString();
        Polygons shape = drawingPanel1.returnByName(name);
            if(shape instanceof LineSegment)
            {
                ColorizeLine colorizeWindow = new ColorizeLine(shape);
                colorizeWindow.setParentNode(this);
                colorizeWindow.setVisible(true);
                 this.setVisible(false);
                drawingPanel1.refresh(null);
            }
            else
            {
                Colorize colorizeWindow = new Colorize(shape);
                colorizeWindow.setParentNode(this);
                colorizeWindow.setVisible(true);
                 this.setVisible(false);
                drawingPanel1.refresh(null);

            }
        }
        else
            JOptionPane.showMessageDialog(null, "No shapes to colorize.");
    }//GEN-LAST:event_colorizeActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (drawingPanel1.getShapes().length != 0 ) 
        {
        String name = ComboBox.getSelectedItem().toString();
        Polygons shape = drawingPanel1.returnByName(name);
        drawingPanel1.removeShape(shape);
        drawingPanel1.getCorners().clear();
        ComboBox.removeItem(ComboBox.getSelectedItem());
        drawingPanel1.refresh(null);
        }
        else
            JOptionPane.showMessageDialog(null,"Can't delete "
                    + "an empty field");
            
    }//GEN-LAST:event_deleteActionPerformed

    private void TriangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TriangleActionPerformed
       
       TriangleInfo triangleInfo = new TriangleInfo();
       triangleInfo.setParentNode(this);
       triangleInfo.setVisible(true);
       this.setVisible(false);
       
    }//GEN-LAST:event_TriangleActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        jFileChooser1.showSaveDialog(this);
        File f = jFileChooser1.getSelectedFile();
      Path path = f.toPath();
      drawingPanel1.save(path);      
    }//GEN-LAST:event_SaveActionPerformed

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed
        Shape shapes[] = drawingPanel1.getShapes();
        jFileChooser1.showOpenDialog(this);
        File f = jFileChooser1.getSelectedFile();
        System.out.println(f.toString());    
        ComboBox.removeAllItems();                  
        if (shapes.length != 0)
        {
            for(Shape shape: drawingPanel1.getShapes())
                 drawingPanel1.removeShape(shape);     
        } 
        drawingPanel1.refresh(null);
        drawingPanel1.load(f);       
    }//GEN-LAST:event_LoadActionPerformed
    
    private void CloneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloneActionPerformed
        try {
            int copiedShapeindex = getComboBox().getSelectedIndex();

            oldShape = (Polygons)drawingPanel1.getShapes()[copiedShapeindex];


            for (int i = drawingPanel1.getShapes().length - 1; i >= 0 ; i--) {
                selectedShape = ((Polygons) drawingPanel1.getShapes()[i]);
                drawingPanel1.getCorners().clear();
            }

            copiedShape = (Polygons) (oldShape).clone();
            drawingPanel1.addShape(copiedShape);


            String copiedObjectName = copiedShape.getObjectName();
            getComboBox().addItem(copiedObjectName);

            drawingPanel1.refresh(null);

        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(DrawingFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CloneActionPerformed

    public static JComboBox<String> getComboBox() {
        return ComboBox;
    }
   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                new DrawingFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clone;
    private static javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JMenu File;
    private javax.swing.JButton Line;
    private javax.swing.JMenuItem Load;
    private javax.swing.JButton Oval;
    private javax.swing.JMenuItem Save;
    private javax.swing.JButton Triangle;
    private javax.swing.JButton colorize;
    private javax.swing.JButton delete;
    private static Shapes.DrawingPanel drawingPanel1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton rectangle;
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