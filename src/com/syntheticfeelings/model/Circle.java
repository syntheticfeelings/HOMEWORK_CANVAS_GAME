package com.syntheticfeelings.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class Circle extends AbstractShape implements Serializable {


    public Circle(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillOval(x, y, diameter, diameter);
        gc.strokeOval(x, y, diameter, diameter);
    }

    @Override
    public void drawField() {
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(4);
        gc.strokeOval(x, y, diameter, diameter);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
