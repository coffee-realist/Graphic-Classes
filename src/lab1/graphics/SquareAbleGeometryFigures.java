package lab1.graphics;

public class SquareAbleGeometryFigures extends GeometryFigure {
    private double square;
    public SquareAbleGeometryFigures() {
        calculateSquare();
    }

    public void calculateSquare() {}

    public void setSquare(double square){
        this.square = square;
    }

    public double getSquare(){
        return square;
    }

    public void expandTo(){}

    @Override
    public String toString() {
        return "Класс геометрических фигур, имеющих площадь.";
    }
}

