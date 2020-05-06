import java.util.Objects;

public class Point4D {
    private int x, y, z, t;

    public Point4D(int x, int y, int z, int t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }

    public Point4D(Point4D p) {
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
        this.t = p.getT();
    }

    @Override
    public String toString() {
        return String.format("Point4D{%d, %d, %d, %d}", x, y, z, t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point4D point4D = (Point4D) o;
        return x == point4D.x &&
                y == point4D.y &&
                z == point4D.z &&
                t == point4D.t;
    }

    public double distance(Point4D p) {
        Point4D diff = new Point4D(this.x - p.getX(), this.y - p.getY(), this.z - p.getZ(), this.t - p.getT());
        double squareDistance = Math.pow(diff.getX(), 2) + Math.pow(diff.getY(), 2) + Math.pow(diff.getZ(), 2) + Math.pow(diff.getT(), 2);
        return Math.sqrt(squareDistance);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Point4D p = new Point4D(5, 6, 9, 12);
        Point4D p1 = new Point4D(p);
        System.out.println(p.equals(p1));
        p1.setT(0);
        p1.setX(34);
        System.out.println(p.distance(p1));
        System.out.println(p1);
    }
}
