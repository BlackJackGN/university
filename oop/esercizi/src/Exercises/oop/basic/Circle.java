package Exercises.oop.basic;

import java.awt.*;

/**
 * Class representing a Circle
 */
public class Circle {
    private Point center;
    private int radius;

    public Circle(Point center,int radius) {
        this.radius = radius;
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }

    public double getPerimeter(){
        return Math.PI*radius*2;
    }

    public boolean contains(Point point){
        return center.distance(point)<radius;
    }

    public void translate(int x,int y){
        center.translate(x,y);
    }

    @Override
    public String toString() {
        return "Circle: {Center, X and Y: "+center.getX()+" "+center.getY()+" Radius: "+radius+" }";
    }
}
