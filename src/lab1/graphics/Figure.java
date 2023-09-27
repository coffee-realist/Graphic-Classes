package lab1.graphics;

public abstract class Figure extends Drawable {
    protected Lazy<Double> square;

    abstract protected double calculateSquare();

    public double getSquare(){
        return square.get();
    }
    abstract public Ellipse getCircumscribedCircle();
    abstract public Figure expandTo(double multiplier);
    abstract public void move(double delta_x, double delta_y);
}

