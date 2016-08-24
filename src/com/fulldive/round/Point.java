package com.fulldive.round;

/*
Класс Point описывает точку на плоскости. Точка имеет полярные координаты (радиус и угол fi), и декартовые координаты (x и y), которые рассчитываются автоматически из полярных.
 */

public class Point {
    private double radius;
    private double fi;
    private double x;
    private double y;

    public Point(double radius, double fi) {
        this.radius = radius;
        this.fi = fi;
        this.x = radius * Math.cos(fi);
        this.y = radius * Math.sin(fi);
    }



    public double getRadius() {
        return radius;
    }

    public double getFi() {
        return fi;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
