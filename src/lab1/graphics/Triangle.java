package lab1.graphics;

import java.lang.Math;

public class Triangle extends Figure {
    private final Dot dot1;
    private final Dot dot2;
    private final Dot dot3;

    public Triangle(Dot dot1, Dot dot2, Dot dot3) {
        double a = Math.sqrt(Math.pow(dot1.getX() - dot2.getX(), 2) + Math.pow(dot1.getY() - dot2.getY(), 2));
        double b = Math.sqrt(Math.pow(dot1.getX() - dot3.getX(), 2) + Math.pow(dot1.getY() - dot3.getY(), 2));
        double c = Math.sqrt(Math.pow(dot2.getX() - dot3.getX(), 2) + Math.pow(dot2.getY() - dot3.getY(), 2));
        check(a, b, c);
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;
        square = new Lazy<>(this::calculateSquare);
    }

    public void check(double a, double b, double c) {
        if (a == 0 || b == 0 || c == 0)
            throw new RuntimeException("Это не треугольник. Пожалуйста задайте другие координаты");
    }

    @Override
    public double calculateSquare() {
        return (Math.abs((dot2.getX() - dot1.getX()) * (dot3.getY() - dot1.getY()) -
                (dot3.getX() - dot1.getX()) * (dot2.getY() - dot1.getY()))) * 0.5;
    }

    @Override
    public void move(double delta_x, double delta_y) {
        dot1.move(delta_x, delta_y);
        dot2.move(delta_x, delta_y);
        dot3.move(delta_x, delta_y);
    }

    public Ellipse getCircumscribedCircle() {
        // (p,t) (q,u) (s,z) for x^2 + y^2 + Ax + By + C
        double p = dot1.getX(), t = dot1.getY(), q = dot2.getX(), u = dot2.getY(),
                s = dot3.getX(), z = dot3.getY();
        double v = (q - p) * z + (p - s) * u + (s - q) * t;
        double A = ((u - t) * z * z + (-u * u + t * t - q * q + p * p) * z + t * u * u + (-t * t + s * s - p * p) * u + (q * q - s * s) * t) / v;
        double B = -((q - p) * z * z + (p - s) * u * u + (s - q) * t * t + (q - p) * s * s + (p * p - q * q) * s + p * q * q - p * p * q) / v;
        double center_x = -A * 0.5;
        double center_y = -B * 0.5;
        double radius = Math.sqrt(Math.pow(p - center_x, 2) + Math.pow(t - center_y, 2));
        return new Ellipse(new Dot(center_x, center_y), radius, radius, 0);
    }

    @Override
    public Triangle expandTo(double multiplier) {
        double mass_center_x = (dot1.getX() + dot2.getX() + dot3.getX()) / 3;
        double mass_center_y = (dot1.getY() + dot2.getY() + dot3.getY()) / 3;
        return new Triangle(new Dot((dot1.getX() - mass_center_x) * multiplier,
                (dot1.getY() - mass_center_y) * multiplier), new Dot((dot2.getX() - mass_center_x) * multiplier,
                (dot2.getY() - mass_center_y) * multiplier), new Dot((dot3.getX() - mass_center_x) * multiplier,
                (dot3.getY() - mass_center_y) * multiplier));
    }

    @Override
    public String toString() {
        return String.format("""
                Треугольник.
                Координаты точек: %s %s %s.
                Площадь: %f
                                
                """, dot1.toString(), dot2.toString(), dot3.toString(), getSquare());
    }

    @Override
    public void draw() {
    }
}
