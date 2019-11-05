package com.ifmo.lesson5;

import com.ifmo.lesson5.LinkedList;

public class Shapes {
    public static void main(String[] args) {
        LinkedList shapesList = new LinkedList();
        shapesList.add(new Rectangle(10, 15));
        shapesList.add(new Rectangle(4, 8));
        shapesList.add(new Square(23));
        shapesList.add(new Triangle(5,10,13));
        shapesList.add(new Triangle(7,17,22));
        shapesList.add(new Oval(5,4));
        shapesList.add(new Circle(10));

        double totalArea1 = totalArea(shapesList);

        System.out.println(totalArea1);

        double totalArea2 = totalArea(
                new Rectangle(10, 15),
                new Rectangle(4, 8),
                new Square(23),
                new Triangle(5,10,13),
                new Oval(5,4),
                new Circle(10));

        System.out.println(totalArea2);

    }

    public static double totalArea(Shape... shapes) {
        double sum = 0;

        for (Shape shape : shapes) {
            sum += shape.area();
        }

        return sum;
    }

    public static double totalArea(LinkedList shapes) {
        double sum = 0;
        Shape shp;
        while ((shp = (Shape)shapes.get(0)) != null)
        {
            sum += shp.area();
            shapes.remove(0);
        }

        return sum;
     }
}
