package com.syntheticfeelings.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Shape, Serializable {

    private static final Group group;

    static {
        group = new Group();
    }
    public int i = 0;

    public void setI(int i) {
        this.i = i;
    }
    private List<Shape> shapes = new ArrayList<>();

    public static Group group() {
        return group;
    }

    public void addShapes(Shape shape1) {
        shapes.add(shape1);
    }

    @Override
    public double checkDistance(Shape shape) {
        for (Shape shape1 : shapes) {
            if (checkDistance2(shape1, shape) < 50) {
                setI(shapes.indexOf(shape1));
            }
        }
        double AC = getX() - shape.getX();
        double BC = getY() - shape.getY();
        return Math.sqrt(AC * AC + BC * BC);
    }

    public double checkDistance2(Shape shape1, Shape shape) {
        double AC = getX(shape1) - shape.getX();
        double BC = getY(shape1) - shape.getY();
        return Math.sqrt(AC * AC + BC * BC);
    }

    @Override
    public double getX() {
        return shapes.get(i).getX();
    }

    @Override
    public double getY() {
        return shapes.get(i).getY();
    }

    public double getX(Shape shape) {
        return shape.getX();
    }

    public double getY(Shape shape) {
        return shape.getY();
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public void moveLeft() {
        for (Shape shape : shapes) {
            shape.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        for (Shape shape : shapes) {
            shape.moveRight();
        }
    }

    @Override
    public void moveTop() {
        for (Shape shape : shapes) {
            shape.moveTop();
        }
    }

    @Override
    public void moveBottom() {
        for (Shape shape : shapes) {
            shape.moveBottom();
        }
    }

    @Override
    public void drawField() {
        for (Shape shape : shapes) {
            shape.drawField();
        }
    }

    @Override
    public void increaseDiameter() {
        for (Shape shape : shapes) {
            shape.increaseDiameter();
        }
    }

    @Override
    public void decreaseDiameter() {
        for (Shape shape : shapes) {
            shape.decreaseDiameter();
        }
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public String toString() {
        return "Group{" +
                ", shapes=" + shapes +
                '}';
    }
}
