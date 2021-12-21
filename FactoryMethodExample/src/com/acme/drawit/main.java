package com.acme.drawit;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DiagramFactory shipFactory = new DiagramFactory();

        Diagram diagramShape = null;

        Scanner userInput = new Scanner(System.in);

        System.out.print("What type of shape do you want? (R / CR / CD)");
        if (userInput.hasNextLine()) {
            String typeOfShape = userInput.nextLine();

            diagramShape = shipFactory.makeDiagramShape(typeOfShape);
            diagramShape.addShape();
            diagramShape.drawArrows();

        }


    }
}
