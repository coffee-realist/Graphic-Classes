package lab1.graphics;

public class Rectangle extends SquareAbleGeometryFigures {
    private final Dot dot1, dot2, dot3, dot4;

    public Rectangle(Dot dot1, Dot dot2, Dot dot3, Dot dot4) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;
        this.dot4 = dot4;
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

    public Dot getDot4() {
        return dot4;
    }

    @Override
    public void calculateSquare() {
        setSquare((Math.abs((getDot1().getX() - getDot2().getX()) * (getDot1().getY() + getDot2().getY()) +
                (getDot2().getX() - getDot3().getX()) * (getDot2().getY() + getDot3().getY()) +
                (getDot3().getX() - getDot4().getX()) * (getDot3().getY() + getDot4().getY()) +
                (getDot4().getX() - getDot1().getX()) * (getDot4().getY() + getDot1().getY()))) * 0.5);
    }
}
