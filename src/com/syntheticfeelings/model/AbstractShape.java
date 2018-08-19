package com.syntheticfeelings.model;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public abstract class AbstractShape implements Shape, Serializable {

    protected double x;
    protected double y;
    protected double diameter = 50;


    protected double shift = 10;
    transient protected GraphicsContext gc;

    public AbstractShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public AbstractShape(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;
    }

    public double checkDistance(Shape shape) {
        double AC = x - shape.getX();
        double BC = y - shape.getY();
        return Math.sqrt(AC * AC + BC * BC);
    }


    @Override
    public void moveLeft() {
        x = x - shift;
        if (x <= 0 || x + diameter >= 1200) {
            x += shift;
        }
    }

    @Override
    public void moveRight() {
        x = x + shift;
        if (x <= 0 || x + diameter >= 1200) {
            x -= shift;
        }
    }

    @Override
    public void moveTop() {
        y = y - shift;
        if (y <= 0 || y + diameter >= 700) {
            y += shift;
        }
    }

    @Override
    public void moveBottom() {
        y = y + shift;
        if (y <= 0 || y + diameter >= 700) {
            y -= shift;
        }
    }

    public void increaseDiameter() {
        this.diameter = diameter + 2;
    }

    public void decreaseDiameter() {
        this.diameter = diameter - 2;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }


}
