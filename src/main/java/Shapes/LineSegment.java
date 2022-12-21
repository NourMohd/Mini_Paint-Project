/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;
import java.awt.*;
import java.awt.geom.Line2D;
/**
 *
 * @author mohdn
 */
public class LineSegment extends Polygons{
    private Point endPosition;
    private int xDiff, yDiff;

    private Rectangle startCorner, endCorner;
    public LineSegment(Point position, Point endPosition) {
        super(position);
        this.endPosition = endPosition;
    }

    
    public void drawCorners() {
        this.setIsCorners(true);

        Point startCornerPoint = new Point(this.getPosition().x - getCORNERSIZE()/2, this.getPosition().y - getCORNERSIZE()/2);
        Point endCornerPoint = new Point(this.getEndPosition().x - getCORNERSIZE()/2, this.getEndPosition().y - getCORNERSIZE()/2);

        startCorner = new Rectangle(startCornerPoint, getCORNERSIZE(), getCORNERSIZE());
        endCorner = new Rectangle(endCornerPoint, getCORNERSIZE(), getCORNERSIZE());

        startCorner.setBorderColor(Color.black);
        startCorner.setFillColor(Color.black);

        startCorner.setBorderColor(Color.black);
        endCorner.setFillColor(Color.black);

        if (DrawingFrame.getDrawingPanel1().getCorners() != null) {
            DrawingFrame.getDrawingPanel1().addCorner(startCorner);
            DrawingFrame.getDrawingPanel1().addCorner(endCorner);

            DrawingFrame.getDrawingPanel1().refresh(null);
        }
    }
    public void removeCorners() {
        this.setIsCorners(false);

        if (DrawingFrame.getDrawingPanel1().getCorners() != null) {
            DrawingFrame.getDrawingPanel1().removeCorner(startCorner);
            DrawingFrame.getDrawingPanel1().removeCorner(endCorner);

        }

        DrawingFrame.getDrawingPanel1().refresh(null);
    }
    public void resizeTo(Rectangle draggedCorner, Point draggedPoint) {
        int index = DrawingFrame.getDrawingPanel1().getCorners().indexOf(draggedCorner);
        switch (index) {
            case 0:
                this.setPosition(draggedPoint);
                break;
            case 1:
                this.setEndPosition(draggedPoint);
                break;
            default:
                throw new AssertionError();
        }

        draggedCorner.setPosition(new Point(draggedPoint.x - getCORNERSIZE()/2, draggedPoint.y - getCORNERSIZE()/2));
    }
    public void setEndPosition(Point endPosition) {
        this.endPosition = endPosition;
    }

    public Point getEndPosition() {
        return endPosition;
    }

    @Override
    public void draw(Graphics canvas) {
        Color oldColor = canvas.getColor();
        canvas.setColor(getBorderColor());
        canvas.drawLine(getPosition().x, getPosition().y, getEndPosition().x, getEndPosition().y);
        canvas.setColor(oldColor);
    }

    @Override
    public boolean contains(Point point) {
        double distance = Line2D.ptLineDist(getPosition().x, getPosition().y, 
                getEndPosition().x, getEndPosition().y, point.x, point.y);
        if (distance < 4)
            return true;
        return false;
    }

    @Override
    public void moveTo(Point point) {
        xDiff = point.x - getDraggingPoint().x;
        yDiff = point.y - getDraggingPoint().y;
        this.setPosition(new Point(getPosition().x + xDiff, getPosition().y + yDiff));
        this.setEndPosition(new Point(getEndPosition().x + xDiff, getEndPosition().y + yDiff));
        this.startCorner.setPosition(new Point(this.startCorner.getPosition().x + xDiff, this.startCorner.getPosition().y + yDiff));
        this.endCorner.setPosition(new Point(this.endCorner.getPosition().x + xDiff, this.endCorner.getPosition().y + yDiff));
    }
    
    
    
}
