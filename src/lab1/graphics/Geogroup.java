package lab1.graphics;

import java.util.*;

public class Geogroup extends Drawable {
    private final ArrayList<Drawable> list;
    private double square;

    public Geogroup(Drawable... drawables) {
        this.list = new ArrayList<>();
        this.list.addAll(Arrays.asList(drawables));
    }

    public double getSquare() {
        calculateSquare();
        return square;
    }

    public void calculateSquare() {
        double new_square = 0;
        for (Drawable drawable : list)
            if (drawable instanceof Figure)
                new_square += ((Figure) drawable).getSquare();
        this.square = new_square;
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
    public Geogroup move(double delta_x, double delta_y) {
        Geogroup moved_geogroup = new Geogroup();
        for (Drawable drawable : list)
            moved_geogroup.add(drawable.move(delta_x, delta_y));
        return moved_geogroup;
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
        for (int i = 0; i < list.size(); i++)
            out.append(String.format("(Элемент группы №%d).\n", i)).append(list.get(i).toString());
        return "{{{\nГруппа фигур:\n" + out + "}}}";
    }
}
