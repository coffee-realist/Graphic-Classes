package lab1.graphics;

import java.lang.Math;

public class Triangle extends Figure {
    private Dot dot1, dot2, dot3;

    public Triangle(Dot dot1, Dot dot2, Dot dot3) {
        double a = Math.sqrt(Math.pow(dot1.getX() - dot2.getX(), 2) + Math.pow(dot1.getY() - dot2.getY(), 2));
        double b = Math.sqrt(Math.pow(dot1.getX() - dot3.getX(), 2) + Math.pow(dot1.getY() - dot3.getY(), 2));
        double c = Math.sqrt(Math.pow(dot2.getX() - dot3.getX(), 2) + Math.pow(dot2.getY() - dot3.getY(), 2));
        check(dot1, dot2, dot3, a, b, c);
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;
        calculateSquare();
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

    public void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    public void setDot3(Dot dot3) {
        this.dot3 = dot3;
    }

    public void check(Dot d1, Dot d2, Dot d3, double a, double b, double c) {
        if (d1.getX() < 0 || d1.getY() < 0 || d2.getX() < 0 || d2.getY() < 0 ||
                d3.getX() < 0 || d3.getY() < 0)
            throw new RuntimeException("Координаты не могут быть отрицательными. Пожалуйста задайте другие координаты");
        if (a == 0 || b == 0 || c == 0)
            throw new RuntimeException("Это не треугольник. Пожалуйста задайте другие координаты");
    }

    @Override
    public void calculateSquare() {
        setSquare((Math.abs((getDot2().getX() - getDot1().getX()) * (getDot3().getY() - getDot1().getY()) -
                (getDot3().getX() - getDot1().getX()) * (getDot2().getY() - getDot1().getY()))) * 0.5);
    }

    @Override
    public void move(double delta_x, double delta_y) {
        dot1.move(delta_x, delta_y);
        dot2.move(delta_x, delta_y);
        dot3.move(delta_x, delta_y);
    }

    public Ellipse getCircumscribedCircle() {
        // (p,t) (q,u) (s,z) for x^2 + y^2 + Ax + By + C
        double p = getDot1().getX(), t = getDot1().getY(), q = getDot2().getX(), u = getDot2().getY(),
                s = getDot3().getX(), z = getDot3().getY();
        double v = (q - p) * z + (p - s) * u + (s - q) * t;
        double A = ((u - t) * z * z + (-u * u + t * t - q * q + p * p) * z + t * u * u + (-t * t + s * s - p * p) * u + (q * q - s * s) * t) / v;
        double B = -((q - p) * z * z + (p - s) * u * u + (s - q) * t * t + (q - p) * s * s + (p * p - q * q) * s + p * q * q - p * p * q) / v;
        double center_x = -A * 0.5;
        double center_y = -B * 0.5;
        double radius = Math.sqrt(Math.pow(p - center_x, 2) + Math.pow(t - center_y, 2));
        return new Ellipse(new Dot(center_x, center_y), radius, radius, 0);
    }

    @Override
    public void expandTo(double multiplier) {
        double mass_center_x = (getDot1().getX() + getDot2().getX() + getDot3().getX()) / 3;
        double mass_center_y = (getDot1().getY() + getDot2().getY() + getDot3().getY()) / 3;
        setDot1(new Dot((getDot1().getX() - mass_center_x) * multiplier,
                (getDot1().getY() - mass_center_y) * multiplier));
        setDot2(new Dot((getDot2().getX() - mass_center_x) * multiplier,
                (getDot2().getY() - mass_center_y) * multiplier));
        setDot3(new Dot((getDot3().getX() - mass_center_x) * multiplier,
                (getDot3().getY() - mass_center_y) * multiplier));
        calculateSquare();
    }

    @Override
    public String toString() {
        return String.format("""
                Класс Треугольника.
                Координаты точек: %s %s %s.
                Площадь: %f""", getDot1().toString(), getDot2().toString(), getDot3().toString(), getSquare());
    }

    @Override
    public void draw() {
    }
}
