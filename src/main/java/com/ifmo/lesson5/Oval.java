package com.ifmo.lesson5;

public class Oval extends Shape {
    private double a;
    private double b;

    public Oval(double a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        double results = Math.PI * a * b;
        System.out.printf("oval(circle) area a=%.0f, b=%.0f is %.4f\n", a, b, results);
        return results;
    }
}
