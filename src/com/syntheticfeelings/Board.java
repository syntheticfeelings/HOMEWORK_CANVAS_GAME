package com.syntheticfeelings;

import com.syntheticfeelings.model.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private int i = 0;
    private int j = 0;
    private List<Shape> shapes = new ArrayList<>();
    private GraphicsContext gc;

    public Board(GraphicsContext gc) {
        this.gc = gc;

        Shape circle = new Circle(gc, 100, 100);
        shapes.add(circle);

        Shape square = new Square(gc, 300, 100);
        shapes.add(square);

        Triangle triangle = new Triangle(gc, 150, 150);
        shapes.add(triangle);
    }

    private void clearScreen() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRoundRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight(), 0, 0);
    }

    public void keyPressed(KeyEvent event) {
        clearScreen();
        switch (event.getCode()) {
            case UP:
                shapes.get(i).moveTop();
                if (shapes.get(i) instanceof AbstractShape) {
                    for (Shape shape : shapes) {
                        if (shape == shapes.get(i)) {
                            continue;
                        }
                        if (shape instanceof Group) {
                            for (Shape shape1 : ((Group) shape).getShapes()) {
                                if (shapes.get(i).checkDistance(shape1) < 50) {
                                    shapes.get(i).moveBottom();
                                }
                            }
                        }
                        if (shapes.get(i).checkDistance(shape) < 50) {
                            shapes.get(i).moveBottom();
                        }
                    }
                }
                if (shapes.get(i) instanceof Group) {
                    for (Shape shape1 : shapes) {
                        if (shape1 == shapes.get(i)) {
                            continue;
                        }
                        if (shapes.get(i).checkDistance(shape1) < 50) {
                            shapes.get(i).moveRight();
                        }
                        if(shape1 instanceof Group){
                            for(Shape shape:((Group) shape1).getShapes()){
                                if(shapes.get(i).checkDistance(shape)<50){
                                    shapes.get(i).moveRight();
                                }
                            }
                        }
                    }
                }
                break;
            case RIGHT:
                shapes.get(i).moveRight();
                if (shapes.get(i) instanceof AbstractShape) {
                    for (Shape shape : shapes) {
                        if (shape == shapes.get(i)) {
                            continue;
                        }
                        if (shape instanceof Group) {
                            for (Shape shape1 : ((Group) shape).getShapes()) {
                                if (shapes.get(i).checkDistance(shape1) < 50) {
                                    shapes.get(i).moveLeft();
                                }
                            }
                        }
                        if (shapes.get(i).checkDistance(shape) < 50) {
                            shapes.get(i).moveLeft();
                        }
                    }
                }
                if (shapes.get(i) instanceof Group) {
                    for (Shape shape1 : shapes) {
                        if (shape1 == shapes.get(i)) {
                            continue;
                        }
                        if (shapes.get(i).checkDistance(shape1) < 50) {
                            shapes.get(i).moveTop();
                        }
                        if(shape1 instanceof Group){
                            for(Shape shape:((Group) shape1).getShapes()){
                                if(shapes.get(i).checkDistance(shape)<50){
                                    shapes.get(i).moveTop();
                                }
                            }
                        }
                    }
                }
                break;
            case DOWN:
                shapes.get(i).moveBottom();
                if (shapes.get(i) instanceof AbstractShape) {
                    for (Shape shape : shapes) {
                        if (shape == shapes.get(i)) {
                            continue;
                        }
                        if (shape instanceof Group) {
                            for (Shape shape1 : ((Group) shape).getShapes()) {
                                if (shapes.get(i).checkDistance(shape1) < 50) {
                                    shapes.get(i).moveTop();
                                }
                            }
                        }
                        if (shapes.get(i).checkDistance(shape) < 50) {
                            shapes.get(i).moveTop();
                        }
                    }
                }
                if (shapes.get(i) instanceof Group) {
                    for (Shape shape1 : shapes) {
                        if (shape1 == shapes.get(i)) {
                            continue;
                        }
                        if (shapes.get(i).checkDistance(shape1) < 50) {
                            shapes.get(i).moveLeft();
                        }
                        if(shape1 instanceof Group){
                            for(Shape shape:((Group) shape1).getShapes()){
                                if(shapes.get(i).checkDistance(shape)<50){
                                    shapes.get(i).moveLeft();
                                }
                            }
                        }
                    }
                }
                break;
            case LEFT:
                shapes.get(i).moveLeft();
                if (shapes.get(i) instanceof AbstractShape) {
                    for (Shape shape : shapes) {
                        if (shape == shapes.get(i)) {
                            continue;
                        }
                        if (shape instanceof Group) {
                            for (Shape shape1 : ((Group) shape).getShapes()) {
                                if (shapes.get(i).checkDistance(shape1) < 50) {
                                    shapes.get(i).moveRight();
                                }
                            }
                        }
                        if (shapes.get(i).checkDistance(shape) < 50) {
                            shapes.get(i).moveRight();
                        }
                    }
                }
                if (shapes.get(i) instanceof Group) {
                    for (Shape shape1 : shapes) {
                        if (shape1 == shapes.get(i)) {
                            continue;
                        }
                        if (shapes.get(i).checkDistance(shape1) < 50) {
                            shapes.get(i).moveBottom();
                        }
                        if(shape1 instanceof Group){
                            for(Shape shape:((Group) shape1).getShapes()){
                                if(shapes.get(i).checkDistance(shape)<50){
                                    shapes.get(i).moveBottom();
                                }
                            }
                        }
                    }
                }
                break;
            case K:
                reWrite();
                break;
            case L:
                loadFromFile();
                break;
            case PAGE_UP:
                previous();
                break;
            case PAGE_DOWN:
                next();
                break;
            case C:
                copyShape();
                break;
            case A:
                Shape circle = new Circle(gc, 10, 10);
                shapes.add(circle);
                break;
            case S:
                Shape square = new Square(gc, 100, 100);
                shapes.add(square);
                break;
            case D:
                Triangle triangle = new Triangle(gc, 150, 150);
                shapes.add(triangle);
                break;
            case G:
                group();
                break;
            case W:
                shapes.get(i).increaseDiameter();
                break;
            case Q:
                shapes.get(i).decreaseDiameter();
                break;
        }
        drawAll();
    }

    private void loadFromFile() {
        shapes.clear();
        List<Shape> newShapes;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/antn/IdeaProjects/HOMEWORK_CANVAS_GAME/src/com/syntheticfeelings/model/save.dat"))) {
            newShapes = (List<Shape>) ois.readObject();
            for (Object object : newShapes) {
                if (object instanceof Circle) {
                    shapes.add(new Circle(gc, ((Circle) object).getX(), ((Circle) object).getY()));
                }
                if (object instanceof Triangle) {
                    shapes.add(new Triangle(gc, ((Triangle) object).getX(), ((Triangle) object).getY()));
                }
                if (object instanceof Square) {
                    shapes.add(new Square(gc, ((Square) object).getX(), ((Square) object).getY()));
                }
                if (object instanceof Group) {
                    Group group = new Group();
                    for (Shape shape : ((Group) object).getShapes()) {
                        if (shape instanceof Circle) {
                            Circle circle = new Circle(gc, shape.getX(), shape.getY());
                            group.addShapes(circle);
                        }
                        if (shape instanceof Triangle) {
                            Triangle triangle = new Triangle(gc, shape.getX(), shape.getY());
                            group.addShapes(triangle);
                        }
                        if (shape instanceof Square) {
                            Square square = new Square(gc, shape.getX(), shape.getY());
                            group.addShapes(square);
                        }
                    }
                    shapes.add(group);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void reWrite() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/antn/IdeaProjects/HOMEWORK_CANVAS_GAME/src/com/syntheticfeelings/model/save.dat"))) {
            oos.writeObject(shapes);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void copyShape() {
        if (shapes.get(i) instanceof Circle) {
            shapes.add(new Circle(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        }
        if (shapes.get(i) instanceof Square) {
            shapes.add(new Square(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        }
        if (shapes.get(i) instanceof Triangle) {
            shapes.add(new Triangle(gc, shapes.get(i).getX(), shapes.get(i).getY()));
        }
        if (shapes.get(i) instanceof Group) {
            Group group = (Group) shapes.get(i);
            Group copyGroup = new Group();
            for (int j = 0; j < group.getShapes().size(); j++) {
                if (group.getShapes().get(j) instanceof Circle) {
                    copyGroup.addShapes(new Circle(gc, group.getShapes().get(j).getX(), group.getShapes().get(j).getY()));
                }
                if (group.getShapes().get(j) instanceof Square) {
                    copyGroup.addShapes(new Square(gc, group.getShapes().get(j).getX(), group.getShapes().get(j).getY()));
                }
                if (group.getShapes().get(j) instanceof Triangle) {
                    copyGroup.addShapes(new Triangle(gc, group.getShapes().get(j).getX(), group.getShapes().get(j).getY()));
                }
            }
            shapes.add(copyGroup);
        }
    }

    private void group() {
        if (shapes.get(i) instanceof Circle) {
            Group.group().addShapes(new Circle(gc, shapes.get(i).getX(), shapes.get(i).getY()));
            shapes.remove(shapes.get(i));
        }
        if (shapes.get(i) instanceof Triangle) {
            Group.group().addShapes(new Triangle(gc, shapes.get(i).getX(), shapes.get(i).getY()));
            shapes.remove(shapes.get(i));
        }
        if (shapes.get(i) instanceof Square) {
            Group.group().addShapes(new Square(gc, shapes.get(i).getX(), shapes.get(i).getY()));
            shapes.remove(shapes.get(i));
        }
        if (i == 0) {
            i++;
        }
        if (i == shapes.size() - 1) {
            i = 0;
        }
        shapes.add(Group.group());
    }

    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
        shapes.get(i).drawField();
    }

    private void previous() {
        i--;
        if (i < 0) {
            i = shapes.size() - 1;
        }
    }

    private void next() {
        i++;
        if (i >= shapes.size()) {
            i = 0;
        }
    }
}
