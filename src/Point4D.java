public class Point4D {
    private int x, y, z, t; // params

    public Point4D(int x, int y, int z, int t) { // constructor
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }

    public Point4D(Point4D p) { //copy constructor, calls get functions
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
        this.t = p.getT();
    }


    public boolean equals(Point4D p) { // equals checks for each param that it is equal, primitive therefore just == is fine
        return this.getX() == p.getX() &&
                this.getY() == p.getY() &&
                this.getZ() == p.getZ() &&
                this.getT() == p.getT();
    }

    @Override
    public String toString() { // follows java convention for toString
        return "Point4D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", t=" + t +
                '}';
    }

    // getters and setters
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
}
