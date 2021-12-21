package com.acme.drawit;

abstract public class Shape {
    final private double height;
    final private double width;

    public Shape(double height, double width) {
        this.height = height;
        this.width = width;
    }

    abstract public void draw();

    abstract public void arrow();
}
