package lab1;

import lab1.graphics.Drawable;
import lab1.graphics.Figure;
import lab1.graphics.Lazy;

import java.util.*;

public class Geogroup extends Drawable {
    private final ArrayList<Drawable> list;
    protected Lazy<Double> square;

    public Geogroup(Drawable... drawables) {
        this.list = new ArrayList<>();
        this.list.addAll(Arrays.asList(drawables));
        square = new Lazy<>(this::calculateSquare);
    }

    public double getSquare() {
        return square.get();
    }

    public double calculateSquare() {
        double new_square = 0;
        for (Drawable drawable : list)
            if (drawable instanceof Figure)
                new_square += ((Figure) drawable).getSquare();
        return new_square;
    }

    public List<Drawable> getList() {
        return Collections.unmodifiableList(list);
    }

    public Drawable get(int index) {
        return list.get(index);
    }

    public void add(Drawable drawable) {
        list.add(drawable);
    }

    public void add(Drawable... drawables) {
        Collections.addAll(list, drawables);
    }

    public void add(Geogroup geogroup) {
        list.addAll(geogroup.getList());
    }

    public void remove(Drawable drawable) {
        list.remove(drawable);
    }

    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public void draw() {
        for (Drawable drawable : list)
            drawable.draw();
    }

    @Override
    public void move(double delta_x, double delta_y) {
        for (Drawable drawable : list)
            drawable.move(delta_x, delta_y);
    }

    public Geogroup expandTo(double multiplier) {
        Geogroup expanded = new Geogroup();
        for (Drawable drawable : list)
            if (drawable instanceof Figure)
                expanded.add(((Figure) drawable).expandTo(multiplier));
        return expanded;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Drawable drawable : list)
            out.append(drawable.toString());
        return "Группа фигур:\n" + out;
    }
}
