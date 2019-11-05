package com.ifmo.lesson5;

public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area(){
        double pp = (a + b + c)/2;
        double result = Math.sqrt(pp*(pp-a)*(pp-b)*(pp-c));
        System.out.printf("rectangle(square) area a=%.0f, b=%.0f, c=%.0f is %.4f\n", a, b, c, result);
        return result;
    }
}
