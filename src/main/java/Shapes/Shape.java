package Shapes;

public interface Shape
{
    /* set position */
    public void setPosition(java.awt.Point position);
    public java.awt.Point getPosition();
    /* colorize */
    public void setBorderColor(java.awt.Color color);
    public java.awt.Color getBorderColor();
    public void setFillColor(java.awt.Color color);
    public java.awt.Color getFillColor();
    /* redraw the shape on the canvas */
    public void draw(java.awt.Graphics canvas);
}