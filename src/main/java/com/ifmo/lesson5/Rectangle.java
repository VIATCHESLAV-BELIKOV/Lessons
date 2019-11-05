package com.ifmo.lesson5;

public class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        double result = a * b;
        System.out.printf("rectangle(square) area a=%.0f, b=%.0f is %.4f\n", a, b, a * b);
        return a * b;
    }
}
