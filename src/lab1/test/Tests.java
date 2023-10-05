package lab1.test;

import lab1.RoundAboutAvailable;
import lab1.graphics.Drawable;
import lab1.graphics.Geogroup;

public class Tests {
    static public void movingTest() {
        System.out.println("-------- ТЕСТ НА ПЕРЕДВИЖЕНИЕ ФИГУР --------");
        Geogroup mixed = DrawableGenerator.mixedGroup();
        System.out.println(mixed);
        mixed.move(2, 2);
        System.out.println(mixed);
        System.out.println("-------- КОНЕЦ ТЕСТА --------");
    }

    static public void squareTest() {
        System.out.println("-------- ТЕСТ НА ПОЛУЧЕНИЕ ПЛОЩАДЕЙ ФИГУР --------");
        Geogroup mixed = DrawableGenerator.mixedGroup();
        System.out.println(mixed);
        double square1 = mixed.getSquare();
        System.out.println("Изначальная лощадь группы: " + square1);
        Geogroup expanded = mixed.expandTo(2);
        double square2 = expanded.getSquare();
        System.out.println(expanded);
        System.out.println("Конечная площадь группы: " + square2);
        System.out.println((square2 / square1) == 4);
        System.out.println("-------- КОНЕЦ ТЕСТА --------");
    }

    static public void roundAboutTest() {
        System.out.println("-------- ТЕСТ НА ПОЛУЧЕНИЕ ОПИСАННЫХ ОКРУЖНОСТЕЙ ФИГУР --------");
        Geogroup mixed = DrawableGenerator.mixedGroup();
        for (Drawable drawable : mixed.getList()) {
            if (drawable instanceof RoundAboutAvailable)
                System.out.printf("Фигура:\n%s\nОписанная окружность фигуры:\n%s\n", drawable,
                        ((RoundAboutAvailable) drawable).getRoundAbout());
        }
        System.out.println("-------- КОНЕЦ ТЕСТА --------");
    }

    static public void describeNestedGroupsTest() {
        System.out.println("-------- ТЕСТ НА ПОЛУЧЕНИЕ ОПИСАНИЯ ВЛОЖЕННЫХ ГРУПП --------");
        Geogroup nested_group = DrawableGenerator.nestedGroup();
        System.out.println(nested_group);
        System.out.println("-------- КОНЕЦ ТЕСТА --------");
    }
}
