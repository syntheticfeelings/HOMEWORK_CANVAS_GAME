package com.syntheticfeelings.model;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class Triangle extends AbstractShape implements Serializable {

    public Triangle(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
    }

    @Override
    public void draw() {
        double[] arr1 = {x + 20, x + 40 - diameter, x + diameter};
        double[] arr2 = {y, y + diameter + 10, y + diameter + 10};
        gc.setFill(Color.BLUE);
        gc.fillPolygon(arr1, arr2, 3);
        gc.setLineWidth(5);
        gc.strokePolygon(arr1, arr2, 3);

    }

    @Override
    public void drawField() {

        double[] arr1 = {x + 20, x + 40 - diameter, x + diameter};
        double[] arr2 = {y, y + diameter + 10, y + diameter + 10};
        gc.setStroke(Color.YELLOW);
        gc.strokePolygon(arr1, arr2, 3);
        gc.setLineWidth(5);

    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
