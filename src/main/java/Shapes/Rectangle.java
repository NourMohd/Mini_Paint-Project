/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author mohdn
 */
public class Rectangle extends Polygons{
    private int height,width,xDiff,yDiff;

    private Rectangle U_LCorner, U_RCorner, B_LCorner, B_RCorner;

    public Rectangle( Point position, int height, int width) {
        super(position);
        this.height = height;
        this.width = width;
    }

    public void setHeight(int height) {
        if (height < 0) {
            height = 0;
            this.setPosition(new Point(U_LCorner.getPosition().x + getCORNERSIZE()/2, U_LCorner.getPosition().y + getCORNERSIZE()/2));
        } else {
            this.height = height;
        }
    }

    public void setWidth(int width) {
        if (width < 0) {
            width = 0;
            this.setPosition(new Point(U_LCorner.getPosition().x + getCORNERSIZE()/2, U_LCorner.getPosition().y + getCORNERSIZE()/2));
        } else {
            this.width = width;
        }
    }

    public int getHeight() 
    {
        return height;
    }

    public int getWidth() 
    {
        return width;
    }

    @Override
    public void draw(Graphics canvas) 
    {
        Color oldColor = canvas.getColor();
        canvas.setColor(getBorderColor());
        canvas.drawRect(getPosition().x, getPosition().y, getWidth(),
                getHeight());
        //refresh after fill color
        canvas.setColor(getFillColor());
        canvas.fillRect(getPosition().x, getPosition().y, getWidth(), 
                getHeight());
        canvas.setColor(oldColor);
    }

    @Override
    public boolean contains(Point point) {
        int xRangeStart = this.getPosition().x;
        int xRangeEnd = this.getPosition().x + width;
        int yRangeStart = this.getPosition().y;
        int yRangeEnd = this.getPosition().y + height;

        return !(point.x < xRangeStart ||  point.x > xRangeEnd ||  
                point.y < yRangeStart || point.y > yRangeEnd);
    }
    @Override
    public void moveTo(Point point) {
        xDiff = point.x - getDraggingPoint().x;
        yDiff = point.y - getDraggingPoint().y;
        this.setPosition(new Point(this.getPosition().x + xDiff, this.getPosition().y + yDiff));

        this.U_LCorner.setPosition(new Point(this.U_LCorner.getPosition().x + xDiff, this.U_LCorner.getPosition().y + yDiff));
        this.U_RCorner.setPosition(new Point(this.U_RCorner.getPosition().x + xDiff, this.U_RCorner.getPosition().y + yDiff));
        this.B_LCorner.setPosition(new Point(this.B_LCorner.getPosition().x + xDiff, this.B_LCorner.getPosition().y + yDiff));
        this.B_RCorner.setPosition(new Point(this.B_RCorner.getPosition().x + xDiff, this.B_RCorner.getPosition().y + yDiff));

    }
    public void drawCorners() {
        this.setIsCorners(true);

        Point upperLeftCorner = new Point(this.getPosition().x - getCORNERSIZE() / 2, this.getPosition().y - getCORNERSIZE() / 2);
        Point upperRightCorner = new Point(this.getPosition().x + (this.width - getCORNERSIZE() / 2), this.getPosition().y - getCORNERSIZE() / 2);
        Point bottomLeftCorner = new Point(this.getPosition().x - getCORNERSIZE() / 2, this.getPosition().y + (this.height - getCORNERSIZE() / 2));
        Point bottomRightCorner = new Point(this.getPosition().x + (this.width - getCORNERSIZE() / 2), this.getPosition().y + (this.height - getCORNERSIZE() / 2));

        U_LCorner = new Rectangle(upperLeftCorner, getCORNERSIZE(), getCORNERSIZE());
        U_RCorner = new Rectangle(upperRightCorner, getCORNERSIZE(), getCORNERSIZE());
        B_LCorner = new Rectangle(bottomLeftCorner, getCORNERSIZE(), getCORNERSIZE());
        B_RCorner = new Rectangle(bottomRightCorner, getCORNERSIZE(), getCORNERSIZE());

        U_LCorner.setBorderColor(Color.black);
        U_LCorner.setFillColor(Color.black);

        U_RCorner.setBorderColor(Color.black);
        U_RCorner.setFillColor(Color.black);

        B_LCorner.setBorderColor(Color.black);
        B_LCorner.setFillColor(Color.black);

        B_RCorner.setBorderColor(Color.black);
        B_RCorner.setFillColor(Color.black);

        if (DrawingFrame.getDrawingPanel1().getCorners() != null) {
            DrawingFrame.getDrawingPanel1().addCorner(U_LCorner);
            DrawingFrame.getDrawingPanel1().addCorner(U_RCorner);
            DrawingFrame.getDrawingPanel1().addCorner(B_LCorner);
            DrawingFrame.getDrawingPanel1().addCorner(B_RCorner);
        }

        DrawingFrame.getDrawingPanel1().refresh(null);

    }

    public void removeCorners() {
        this.setIsCorners(false);

        if (DrawingFrame.getDrawingPanel1().getCorners() != null) {
            DrawingFrame.getDrawingPanel1().removeCorner(U_LCorner);
            DrawingFrame.getDrawingPanel1().removeCorner(U_RCorner);
            DrawingFrame.getDrawingPanel1().removeCorner(B_LCorner);
            DrawingFrame.getDrawingPanel1().removeCorner(B_RCorner);
        }

        DrawingFrame.getDrawingPanel1().refresh(null);
    }

    @Override
    public void resizeTo(Rectangle draggedCorner, Point draggedPoint) {
        int index = DrawingFrame.getDrawingPanel1().getCorners().indexOf(draggedCorner);
        xDiff = draggedPoint.x - draggedCorner.getPosition().x - getCORNERSIZE() / 2;
        yDiff = draggedPoint.y - draggedCorner.getPosition().y - getCORNERSIZE() / 2;

        switch (index) {
            case 0: // upper left corner
                setWidth(getWidth() - xDiff);
                setHeight(getHeight() - yDiff);
                setPosition(draggedPoint);

                resetCorners();
                break;
            case 1: // upper right corner
                setWidth(getWidth() + xDiff);
                setHeight(getHeight() - yDiff);
                setPosition(new Point(getPosition().x, draggedPoint.y));

                resetCorners();
                break;
            case 2: // bottom left corner
                setWidth(getWidth() - xDiff);
                setHeight(getHeight() + yDiff);
                setPosition(new Point(draggedPoint.x, getPosition().y));

                resetCorners();
                break;
            case 3: // bottom right corner
                setWidth(getWidth() + xDiff);
                setHeight(getHeight() + yDiff);


                resetCorners();
                break;
            default:
                throw new AssertionError();
        }

    }

    public void resetCorners() {
        this.U_LCorner.setPosition(new Point(this.getPosition().x - getCORNERSIZE() / 2, this.getPosition().y - getCORNERSIZE() / 2));
        this.B_LCorner.setPosition(new Point(this.getPosition().x - getCORNERSIZE() / 2, this.getPosition().y + (this.height - getCORNERSIZE() / 2)));
        this.U_RCorner.setPosition(new Point(this.getPosition().x + (this.width - getCORNERSIZE() / 2), this.getPosition().y - getCORNERSIZE() / 2));
        this.B_RCorner.setPosition(new Point(this.getPosition().x + (this.width - getCORNERSIZE() / 2), this.getPosition().y + (this.height - getCORNERSIZE() / 2)));
    }

    
    
}
