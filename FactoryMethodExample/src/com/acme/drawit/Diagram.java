package com.acme.drawit;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;

public class Diagram {
    final private DiagramType type;
    final private ArrayList<Shape> shapes;

    public Diagram(DiagramType type) {
        this.type = type;
        this.shapes = new ArrayList<>();
    }

    public void render() {
        // draw all shapes
        drawShapes();
        // draw all arrows (not implemented)
        drawArrows();
    }

    public void drawShapes() {
        for (var shape : shapes) {
            shape.draw();
        }
    }

    public void drawArrows() {
        for (Shape shape : shapes) {
            shape.arrow();
        }
    }

    public void addShape() {
        var shape = switch (type) {
            case Rectangle -> new Rectangle(10);
            case Cloud -> new Cloud(10);
            case Circle -> new Circle(10);
        };
        shapes.add(shape);
    }

    public void copyShape(Shape shape) {
        if ((shape instanceof Circle && type == DiagramType.Circle) ||
                (shape instanceof Rectangle && type == DiagramType.Rectangle) ||
                (shape instanceof Cloud && type == DiagramType.Cloud)) {
            shapes.add(shape);
        } else {
            throw new RuntimeException("unknown shape or type mismatch");
        }
    }

}
