package lab1.graphics;

import java.lang.Math;

public class Triangle extends SquareAbleGeometryFigures {
    private final Dot dot1, dot2, dot3;

    public Triangle(Dot dot1, Dot dot2, Dot dot3) {
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

    @Override
    public void calculateSquare() {
        setSquare((Math.abs((getDot2().getX() - getDot1().getX()) * (getDot3().getY() - getDot1().getY()) -
                (getDot3().getX() - getDot1().getX()) * (getDot2().getY() - getDot1().getY()))) * 0.5);
    }

    @Override
    public String toString() {
        return String.format("""
                Класс Треугольника.
                Координаты точек: %s %s %s.
                Площадь: %f""", getDot1().toString(), getDot2().toString(), getDot3().toString(), getSquare());
    }
}
