/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.*;

/**
 *
 * @author DELL
 */
public class Triangle extends Polygons {

    private Point point2, point3;
    private int xDiff, yDiff;

    private Rectangle firstPointCorner,secondPointCorner ,thirdPointCorner ;

    public Triangle(Point position, Point point2, Point point3) {
        super(position);
        this.point2 = point2;
        this.point3 = point3;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    @Override
    public void moveTo(Point point) {
        xDiff = point.x - getDraggingPoint().x;
        yDiff = point.y - getDraggingPoint().y;
        this.setPosition(new Point(getPosition().x + xDiff , getPosition().y + yDiff));
        this.setPoint2(new Point(getPoint2().x + xDiff , getPoint2().y + yDiff));
        this.setPoint3(new Point(getPoint3().x + xDiff , getPoint3().y + yDiff));

        this.firstPointCorner.setPosition(new Point(this.firstPointCorner.getPosition().x + xDiff, this.firstPointCorner.getPosition().y + yDiff));
        this.secondPointCorner.setPosition(new Point(this.secondPointCorner.getPosition().x + xDiff, this.secondPointCorner.getPosition().y + yDiff));
        this.thirdPointCorner.setPosition(new Point(this.thirdPointCorner.getPosition().x + xDiff, this.thirdPointCorner.getPosition().y + yDiff));


    }

    float sign(Point p1, Point p2, Point p3) {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    @Override
    public boolean contains(Point point) {
        float d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = sign(point, this.getPosition(), getPoint2());
        d2 = sign(point, getPoint2(), getPoint3());
        d3 = sign(point, getPoint3(), this.getPosition());
        has_neg = (d1 < 0) || (d2< 0) || (d3< 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);

    }

    public int[] getxPosition() {
        int[] xCoordinates = {getPosition().x, point2.x, point3.x};
        return xCoordinates;

    }

    public int[] getyPosition() {
        int[] yCoordinates = {getPosition().y, point2.y, point3.y};
        return yCoordinates;
    }

    @Override
    public void draw(Graphics canvas) {
        Color oldColor = canvas.getColor();
        canvas.setColor(getBorderColor());
        canvas.drawPolygon(getxPosition(), getyPosition(), 3);

        canvas.setColor(getFillColor());
        canvas.fillPolygon(getxPosition(), getyPosition(), 3);
        canvas.setColor(oldColor);
    }
    public void drawCorners() {
        this.setIsCorners(true);

        Point firstPoint = new Point(this.getPosition().x - getCORNERSIZE() / 2, this.getPosition().y - getCORNERSIZE() / 2);
        Point secondPoint = new Point(this.getPoint2().x - getCORNERSIZE() / 2, this.getPoint2().y - getCORNERSIZE() / 2);
        Point thirdPoint = new Point(this.getPoint3().x - getCORNERSIZE() / 2, this.getPoint3().y - getCORNERSIZE() / 2);


        firstPointCorner = new Rectangle(firstPoint, getCORNERSIZE(), getCORNERSIZE());
        firstPointCorner.setBorderColor(Color.black);
        firstPointCorner.setFillColor(Color.black);
        DrawingFrame.getDrawingPanel1().addCorner(firstPointCorner);

        secondPointCorner = new Rectangle(secondPoint, getCORNERSIZE(), getCORNERSIZE());
        secondPointCorner.setBorderColor(Color.black);
        secondPointCorner.setFillColor(Color.black);
        DrawingFrame.getDrawingPanel1().addCorner(secondPointCorner);

        thirdPointCorner = new Rectangle(thirdPoint, getCORNERSIZE(), getCORNERSIZE());
        thirdPointCorner.setBorderColor(Color.black);
        thirdPointCorner.setFillColor(Color.black);
        DrawingFrame.getDrawingPanel1().addCorner(thirdPointCorner);


        DrawingFrame.getDrawingPanel1().refresh(null);



    }

    public void removeCorners() {
        this.setIsCorners(false);

        if(DrawingFrame.getDrawingPanel1().getCorners() != null){
            DrawingFrame.getDrawingPanel1().removeCorner(firstPointCorner);
            DrawingFrame.getDrawingPanel1().removeCorner(secondPointCorner);
            DrawingFrame.getDrawingPanel1().removeCorner(thirdPointCorner);
        }

        DrawingFrame.getDrawingPanel1().refresh(null);
    }

    @Override
    public void resizeTo(Rectangle draggedCorner, Point draggedPoint) {
        int index = DrawingFrame.getDrawingPanel1().getCorners().indexOf(draggedCorner);
        switch (index) {
            case 0:
                this.setPosition(draggedPoint);
                break;
            case 1:
                this.setPoint2(draggedPoint);
                break;
            case 2:
                this.setPoint3(draggedPoint);
                break;
            default:
                throw new AssertionError();
        }
        draggedCorner.setPosition(new Point(draggedPoint.x - getCORNERSIZE()/2, draggedPoint.y - getCORNERSIZE()/2));
    }




}
