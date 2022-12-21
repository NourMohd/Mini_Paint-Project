/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapes;
import java.awt.*;
/**
 *
 * @author DELL
 */
public interface Moveable 
{
    void setDraggingPoint(Point point);
    Point getDraggingPoint();
    boolean contains(Point point);
    void moveTo(Point point);
}
