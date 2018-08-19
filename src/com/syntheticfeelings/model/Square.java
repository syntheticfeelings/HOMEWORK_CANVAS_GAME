package com.syntheticfeelings.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class Square extends AbstractShape implements Serializable {

    public Square(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }


    @Override
    public void draw() {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);

        gc.fillRect(x, y, diameter, diameter);
        gc.strokeRect(x, y, diameter, diameter);
    }

    @Override
    public void drawField() {
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(4);
        gc.strokeRect(x, y, diameter, diameter);
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
