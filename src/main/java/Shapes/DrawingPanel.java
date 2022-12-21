package Shapes;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author mohdn
 */
public class DrawingPanel extends javax.swing.JPanel implements DrawingEngine, MouseListener, MouseMotionListener {

    private ArrayList<Shape> shapes;

    private ArrayList<Rectangle> corners;
    private static int lineCounter, rectCounter, ovalCounter,
            triCounter, Ex, Ey, currentIndex;
    Polygons selectedShape;

    private Rectangle draggedCorner;

    private boolean isDraggingCorner, isDraggingShape;

    public ArrayList<Rectangle> getCorners() {
        return corners;
    }

    public void addCorner(Rectangle corner) {
        this.corners.add(corner);
    }

    public void removeCorner(Rectangle corner) {
        this.corners.remove(corner);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
        if (corners != null) {
            for (Rectangle corner : corners) {
                corner.draw(g);
            }
        }
    }

    @Override
    public void addShape(Shape shape) {
        this.shapes.add(shape);
        if (shape instanceof LineSegment) {
            String name = "Line_" + ++lineCounter;
            ((LineSegment) shape).setObjectName(name);
        } else if (shape instanceof Oval) {
            String name = "Oval_" + ++ovalCounter;
            ((Oval) shape).setObjectName(name);
        } else if (shape instanceof Triangle) {
            String name = "Triangle_" + ++triCounter;
            ((Triangle) shape).setObjectName(name);
        } else {
            String name = "Rectangle_" + ++rectCounter;
            ((Rectangle) shape).setObjectName(name);
        }
    }

    @Override
    public void removeShape(Shape shape) {
        this.shapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        return this.shapes.toArray(Shape[]::new);
    }

    @Override
    public void refresh(Graphics canvas) {
        repaint();
    }

    public Polygons returnByName(String name) {
        for (Shape shape : shapes) {
            String objname = ((Polygons) shape).getObjectName();
            if (objname.equalsIgnoreCase(name)) {
                return ((Polygons) shape);
            }
        }

        return null;
    }

    public JSONArray toJSONArray() {
        JSONArray jArray = new JSONArray();
        for (Shape shape : shapes) {
            Polygons object = (Polygons) shape;
            jArray.add(object.toJSONobject());
        }

        return jArray;
    }

    public void save(Path path) {
        JSONArray jShapes = toJSONArray();
        String jsonText = jShapes.toJSONString();
        try {
            Files.write(path, jsonText.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        path.resolve(path.toString());
    }

    public void load(File file) {
        JSONParser jParser = new JSONParser();
        try ( FileReader reader = new FileReader(file)) {
            Object obj = jParser.parse(reader);
            JSONArray shapesList = (JSONArray) obj;
            for (Object shape : shapesList) {
                Polygons poly = parseShapeObject((JSONObject) shape);
                addShape(poly);
                DrawingFrame.getComboBox().addItem(poly.getObjectName());
                refresh(null);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Polygons parseShapeObject(JSONObject shape) {
        JSONObject shapeObj = (JSONObject) shape.get("Shape");
        JSONObject point1 = (JSONObject) shapeObj.get("position");
        Point position = new Point(Integer.parseInt((String) point1.get("X")), Integer.parseInt((String) point1.get("Y")));
        Color fillColor = Polygons.returnCol((String) shapeObj.get("fillColor"));
        String objectName = (String) shapeObj.get("objectName");
        Polygons poly;
        if (objectName.contains("Line")) {
            JSONObject point2 = (JSONObject) shapeObj.get("endPosition");
            Point endPosition = new Point(Integer.parseInt((String) point2.get("X")),
                     Integer.parseInt((String) point2.get("Y")));
            poly = new LineSegment(position, endPosition);
            poly.setBorderColor(fillColor);
            poly.setObjectName(objectName);
            System.out.println(objectName);
        } else if (objectName.contains("Rectangle")) {
            long width = (long) shapeObj.get("width");
            long height = (long) shapeObj.get("height");
            poly = new Rectangle(position, (int) height, (int) width);
            Color borderColor = Polygons.returnCol((String) shapeObj.get("borderColor"));
            poly.setBorderColor(borderColor);
            poly.setFillColor(fillColor);
            poly.setObjectName(objectName);
        } else if (objectName.contains("Oval")) {
            long width = (long) shapeObj.get("Width");
            long height = (long) shapeObj.get("Height");
            poly = new Oval(position, (int) width, (int) height);
            Color borderColor = Polygons.returnCol((String) shapeObj.get("borderColor"));
            poly.setBorderColor(borderColor);
            poly.setFillColor(fillColor);
            poly.setObjectName(objectName);

        } else if (objectName.contains("Triangle")) {
            JSONObject p2 = (JSONObject) shapeObj.get("point2");
            JSONObject p3 = (JSONObject) shapeObj.get("point3");
            Point point2 = new Point(Integer.parseInt((String) p2.get("X")), Integer.parseInt((String) p2.get("Y")));
            Point point3 = new Point(Integer.parseInt((String) p3.get("X")), Integer.parseInt((String) p3.get("Y")));
            poly = new Triangle(position, point2, point3);
            Color borderColor = Polygons.returnCol((String) shapeObj.get("borderColor"));
            poly.setBorderColor(borderColor);
            poly.setFillColor(fillColor);
            poly.setObjectName(objectName);
        } else {
            poly = null;
        }
        return poly;

    }

    public DrawingPanel() {
        initComponents();
        shapes = new ArrayList<Shape>();
        corners = new ArrayList<Rectangle>();
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void mouseClicked(MouseEvent e) {
        Ex = e.getX();
        Ey = e.getY();
        for (int i = shapes.size() - 1; i >= 0; i--) {
            selectedShape = ((Polygons) shapes.get(i));
            if (((Polygons) shapes.get(i)).contains(new Point(Ex, Ey)) && !(selectedShape.isCorners())) {
                getCorners().clear();
                selectedShape.drawCorners();
                DrawingFrame.getComboBox().setSelectedIndex(i);
                break;
            } else {
                selectedShape.removeCorners();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point mousePoint = new Point(e.getPoint());

        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (((Polygons) shapes.get(i)).contains(mousePoint) && ((Polygons) shapes.get(i)).isCorners()) {
                selectedShape = ((Polygons) shapes.get(i));
                isDraggingShape = true;
                DrawingFrame.getComboBox().setSelectedIndex(i);
                selectedShape.setDraggingPoint(mousePoint);
                break;
            }
        }
        if (!getCorners().isEmpty()) {
            for (int i = 0; i < corners.size(); i++) {
                if (getCorners().get(i).contains(mousePoint)) {
                    draggedCorner = getCorners().get(i);
                    isDraggingCorner = true;
                }
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //  selectedShape = null;
        isDraggingShape = false;
        draggedCorner = null;
        isDraggingCorner = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        Point draggedPoint = new Point(e.getPoint());
        if (selectedShape != null && selectedShape.isCorners() && !isDraggingCorner && isDraggingShape) {
            selectedShape.moveTo(draggedPoint);
            selectedShape.setDraggingPoint(draggedPoint);
            this.refresh(null);
        } else if (draggedCorner != null && selectedShape != null) {
            selectedShape.resizeTo(draggedCorner, draggedPoint);
            this.refresh(null);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
