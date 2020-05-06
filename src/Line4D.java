import canvasML.Line;

import java.util.Objects;
import java.util.Random;

public class Line4D {
    private Point4D p1, p2;

    public Line4D(Point4D p1, Point4D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line4D(Line4D l) {
        this.p1 = l.getP1();
        this.p2 = l.getP2();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line4D line4D = (Line4D) o;
        return Objects.equals(p1, line4D.p1) &&
                Objects.equals(p2, line4D.p2);
    }

    @Override
    public String toString() {
        return "Line4D{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    public Point4D getP1() {
        return new Point4D(p1);
    }

    public void setP1(Point4D p1) {
        this.p1 = new Point4D(p1);
    }

    public Point4D getP2() {
        return new Point4D(p2);
    }

    public void setP2(Point4D p2) {
        this.p2 = new Point4D(p2);
    }

    public double length() {
        return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2) + Math.pow((p1.getZ() - p2.getZ()), 2) + Math.pow((p1.getT() - p2.getT()), 2));
    }

    public static void main(String[] args) {
        int n = 50;
        Line4D[] lines = new Line4D[n];
        Random r = new Random();
        for(int i = 0; i < lines.length; i++) {
            lines[i] = new Line4D(new Point4D(r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt()), new Point4D(new Point4D(r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt());
        }

        Line4D shortest, longest;
        shortest = new Line4D(lines[0]);
        longest = new Line4D(lines[0]);
        for(int i = 1; i < lines.length; i++) {
            if(lines[i].length() < shortest.length()) {
                shortest = new Line4D(lines[i]);
            }
            if(lines[i].length() > longest.length()) {
                longest = new Line4D(lines[i]);
            }
        }
        System.out.println(shortest);
        System.out.println(longest);


    }
}
