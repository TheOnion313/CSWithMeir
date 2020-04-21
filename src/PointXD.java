import java.util.Arrays;

public class PointXD {
    private int[] coord;

    public PointXD(int[] coord) {
        this.coord = new int[coord.length];
        setCoord(coord);
    }

    public PointXD(PointXD p) {
        this.coord = new int[p.getCoord().length];
        setCoord(p.getCoord());
    }

    public PointXD(Point4D p) {
        this.coord = new int[4];
        setCoord(new int[]{p.getX(), p.getY(), p.getZ(), p.getT()});
    }

    public int[] getCoord() {
        int[] coords = new int[this.coord.length];
        for (int i = 0; i < coords.length; i++) {
            coords[i] = this.coord[i];
        }
        return coords;
    }

    public void setCoord(int[] coord) {
        for (int i = 0; i < coord.length; i++) {
            this.coord[i] = coord[i];
        }
    }


    @Override
    public String toString() {
        return "PointXD{" +
                "coord=" + Arrays.toString(coord) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointXD pointXD = (PointXD) o;
        return Arrays.equals(coord, pointXD.coord);
    }

    public boolean setCoord(int val, int idx) {
        if (idx >= this.coord.length) {
            return false;
        }
        this.coord[idx] = val;
        return true;
    }

    public double distance(PointXD p) {
        double dist = 0;
        if (p.getCoord().length != this.coord.length) {
            return -1;
        }
        for (int i = 0; i < this.coord.length; i++) {
            dist += Math.pow((this.coord[i] - p.getCoord()[i]), 2);
        }
        return Math.sqrt(dist);
    }

    public int getDimension() {
        return this.coord.length;
    }

    public static void main(String[] args) {
        PointXD p = new PointXD(new int[]{4, 5, 9, 1, 0, 34, 9});
        PointXD p1 = new PointXD(p);
        p1.setCoord(80, 4);
        System.out.println(p.distance(p1));
        System.out.println(Arrays.toString(p.getCoord()));
        System.out.println(p1);
    }
}
