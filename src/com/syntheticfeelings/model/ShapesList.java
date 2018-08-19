package com.syntheticfeelings.model;

import java.util.ArrayList;
import java.util.List;

public class ShapesList {
    private List<Shape> shapes = new ArrayList<>();

    public ShapesList(List<Shape> shapes){
        this.shapes.addAll(shapes);
    }
}
