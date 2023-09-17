package lab1.graphics;

import java.lang.Math;

public class Rectangle extends Figure {
    private Dot dot1, dot2, dot3, dot4;
    private final double rotation;
    private double width, height;
    private final double diagonal;
    private final Dot center;

    public Rectangle(Dot dot1, Dot dot2, Dot dot3, Dot dot4) {
        double width = Math.sqrt(Math.pow(dot1.getX() - dot4.getX(), 2) + Math.pow(dot1.getY() - dot4.getY(), 2));
        double height = Math.sqrt(Math.pow(dot1.getX() - dot2.getX(), 2) + Math.pow(dot1.getY() - dot4.getY(), 2));
        check(dot1, dot2, dot3, dot4, width, height);
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;
        this.dot4 = dot4;
        this.width = width;
        this.height = height;
        double rotation = -Math.acos((dot4.getX() - dot1.getX()) / width);
        if (rotation < 0)
            rotation += 360;
        this.rotation = rotation;
        this.center = new Dot((dot3.getX() - dot1.getX()) / 2 + dot1.getX(),
                (dot3.getY() - dot1.getY()) / 2 + dot1.getY());
        this.diagonal = Math.sqrt(Math.pow(dot3.getX() - dot1.getX(), 2) + Math.pow(dot3.getY() - dot1.getY(), 2));
        calculateSquare();
    }

    public double getDiagonal() {
        return diagonal;
    }

    public double getRotation() {
        return rotation;
    }

    public Dot getDot1() {
        return dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public Dot getDot3() {
        return dot3;
    }

    public Dot getDot4() {
        return dot4;
    }

    public Dot getCenter() {
        return center;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    public void setDot3(Dot dot3) {
        this.dot3 = dot3;
    }

    public void setDot4(Dot dot4) {
        this.dot4 = dot4;
    }

    @Override
    public void calculateSquare() {
        setSquare(getHeight() * getWidth());
    }

    public void check(Dot d1, Dot d2, Dot d3, Dot d4, double width, double height) {
        if (d1.getX() < 0 || d1.getY() < 0 || d2.getX() < 0 || d2.getY() < 0 ||
                d3.getX() < 0 || d3.getY() < 0 || d4.getX() < 0 || d4.getY() < 0)
            throw new RuntimeException("Координаты не могут быть отрицательными. Пожалуйста задайте другие координаты");
        if ((!(d2.getX() - d1.getX() == d3.getX() - d4.getX() &&
                d2.getY() - d1.getY() == d3.getY() - d4.getY() &&
                d3.getX() - d2.getX() == d4.getX() - d1.getX() &&
                d3.getY() - d2.getY() == d4.getY() - d1.getY())) ||
                (width == 0) || (height == 0))
            throw new RuntimeException("Это не прямоугольник. Пожалуйста задайте другие координаты");
    }

    @Override
    public void move(double delta_x, double delta_y) {
        dot1.move(delta_x, delta_y);
        dot2.move(delta_x, delta_y);
        dot3.move(delta_x, delta_y);
        dot4.move(delta_x, delta_y);
    }

    public Ellipse getCircumscribedCircle() {
        return new Ellipse(getCenter(), getDiagonal() * 0.5, getDiagonal() * 0.5, getRotation());
    }

    @Override
    public void expandTo(double multiplier) {
        setWidth(getWidth() * multiplier);
        setHeight(getHeight() * multiplier);
        setDot1(new Dot((getDot1().getX() - getCenter().getX()) * multiplier,
                (getDot1().getY() - getCenter().getY()) * multiplier));
        setDot2(new Dot((getDot2().getX() - getCenter().getX()) * multiplier,
                (getDot2().getY() - getCenter().getY()) * multiplier));
        setDot3(new Dot((getDot3().getX() - getCenter().getX()) * multiplier,
                (getDot3().getY() - getCenter().getY()) * multiplier));
        setDot4(new Dot((getDot4().getX() - getCenter().getX()) * multiplier,
                (getDot4().getY() - getCenter().getY()) * multiplier));
        calculateSquare();
    }

    @Override
    public String toString() {
        return String.format("""
                        Класс Прямоугольника.
                        Координаты точек: %s %s %s %s.
                        Площадь: %f""", getDot1().toString(), getDot2().toString(),
                getDot3().toString(), getDot4().toString(), getSquare());
    }

    @Override
    public void draw() {
    }
}
