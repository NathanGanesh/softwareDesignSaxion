package com.acme.drawit;

public class DiagramFactory {

    public Diagram makeDiagramShape(String shapeType) {
        switch (shapeType) {
            case "R":
                return new RectangleDiagram(DiagramType.Rectangle);
            //circle
            case "CR":
                return new CircleDiagram(DiagramType.Circle);
            //cloud
            case "CD":
                return new CloudDiagram(DiagramType.Cloud);
            default:
                return null;
        }
    }
}
