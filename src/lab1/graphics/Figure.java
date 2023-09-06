package lab1.graphics;

public abstract class Figure extends Drawable {
    private double square;

    abstract public void calculateSquare();

    public void setSquare(double square){
        this.square = square;
    }

    public double getSquare(){
        return square;
    }

    abstract public void expandTo();

    @Override
    public String toString() {
        return "Класс геометрических фигур, имеющих площадь.";
    }
}

