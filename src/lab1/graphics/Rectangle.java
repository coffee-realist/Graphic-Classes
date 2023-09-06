package lab1.graphics;

public class Rectangle extends Figure {
    private Dot dot1, dot2, dot3, dot4;

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

    public void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    public void setDot3(Dot dot3) {
        this.dot3 = dot3;
    }

    public void setDot4(Dot dot4) {
        this.dot4 = dot4;
    }

    @Override
    public void calculateSquare() {
        Triangle triangle = new Triangle(getDot1(), getDot2(), getDot3());
        setSquare(2 * triangle.getSquare());
    }

    public void move(int delta_x, int delta_y) {
        Dot dot = getDot1();
        setDot1(new Dot(dot.getX() + delta_x, dot.getY() + delta_y));
        dot = getDot2();
        setDot2(new Dot(dot.getX() + delta_x, dot.getY() + delta_y));
        dot = getDot3();
        setDot3(new Dot(dot.getX() + delta_x, dot.getY() + delta_y));
        dot = getDot4();
        setDot4(new Dot(dot.getX() + delta_x, dot.getY() + delta_y));
    }
    @Override
    public void expandTo() {

    }

    @Override
    public void draw() {
    }
}
