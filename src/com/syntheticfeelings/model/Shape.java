package com.syntheticfeelings.model;

public interface Shape {
    void draw();
    void moveLeft();
    void moveRight();
    void moveTop();
    void moveBottom();
    void drawField();
    void increaseDiameter();
    void decreaseDiameter();
    double getX();
    double getY();
    double checkDistance(Shape shape);

}
