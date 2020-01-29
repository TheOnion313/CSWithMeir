package Classes;

import basics.*;
import canvasML.Ellipse;
import canvasML.Rect;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class Class9 {


    public static Student youngerStudent(Student st) {
        return new Student(st.getAge() - 2, st.getHeight(), st.getGender(), st.getHair());
    }

    public static void ass1() {
        Student lebron = new Student(18, 1, "hood", "red");
        Student lebron2 = youngerStudent(lebron);
        System.out.println(lebron);
        System.out.println(lebron2);
    }

    public static Vehicle pickup(Vehicle v1, Vehicle v2) {
        return new Vehicle(500, 5000, 5000, v1.getPassangers() + v2.getPassangers() + 2);
    }

    public static void ass2() {
        Vehicle v1 = new Vehicle(500, 500, 500, 4), v2 = new Vehicle(500, 500, 500, 80);
        Vehicle pickupTruck = pickup(v1, v2);
        System.out.println(pickupTruck);
    }

    public static Point2D middlePoint(Point2D p1, Point2D p2) {
        return new Point2D((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    public static void ass3() {
        Point2D p1 = new Point2D(50, 70), p2 = new Point2D(20, 20);
        System.out.println(middlePoint(p1, p2));
    }

    public static Rect pointRect(int x1, int y1, int x2, int y2) {
        return new Rect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(y1 - y2), Math.abs(x1 - x2), "blue");
    }

    public static void ass4() {
        int x1 = 50, x2 = 80, y1 = 100, y2 = 10;
        Rect r = pointRect(x1, y1, x2, y2);
        System.out.println(r);
    }

    public static String int2Col(int color) {
        String[] colors = {"black", "red", "green", "blue", "yellow", "magenta"};
        return colors[color % 6];
    }

    public static void ass5() {
        int col = 2;
        System.out.println(int2Col(col));
    }

    public static void fiveEllipses(int x, int y, int r1, int r2) {
        Ellipse e = new Ellipse(x, y, r1, r2, "black");
        for(int i = 0; i < 5; i++) {
            e.setCol(int2Col(i));
            e.move(e.getDiaX() / 8, e.getDiaY() / 8);
            e.setDiaX(e.getDiaX() * 3 / 4);
            e.setDiaY(e.getDiaY() * 3 / 4);
            e.draw();
        }
    }

    public static void main(String[] args) {
        ass1();
        ass2();
        ass3();
        ass4();
        ass5();
        fiveEllipses(20, 20, 150, 300);
    }

}
