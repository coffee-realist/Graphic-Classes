package lab1.graphics;
import java.lang.Math;

public class Ellipse extends SquareAbleGeometryFigures {
    private final int small_radius;
    private final int big_radius;
    private double square;
    private final Dot center;

    public Ellipse(Dot center, int small_radius, int big_radius) {
        this.small_radius = small_radius;
        this.big_radius = big_radius;
        this.center = center;
        calculateSquare();
    }

    public Dot getCenter() {
        return center;
    }

    public int getSmall_radius() {
        return small_radius;
    }

    public int getBig_radius() {
        return big_radius;
    }

    @Override
    public void calculateSquare() {
        setSquare(Math.PI * small_radius * big_radius);
    }

    @Override
    public String toString() {
        return String.format("""
                Класс Эллипса.
                Координаты центра: %s
                Малая полуось: %d.
                Большая полуось: %d.
                Площадь: %f""", getCenter().toString(), getSmall_radius(), getBig_radius(), getSquare());
    }
}

