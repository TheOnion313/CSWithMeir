public class Cube {
    private int sideLength;
    private String cubeColour;

    public Cube(int sideLength, String cubeColour) {
        this.sideLength = sideLength;
        this.cubeColour = cubeColour;
    }

    public Cube(Cube c) {
        this.sideLength = c.getSideLength();
        this.cubeColour = c.getCubeColour();
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public String getCubeColour() {
        return cubeColour;
    }

    public void setCubeColour(String cubeColour) {
        this.cubeColour = cubeColour;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "sideLength=" + sideLength +
                ", cubeColour='" + cubeColour + '\'' +
                '}';
    }

    public boolean equals(Cube c) {
        return this.toString().equals(c.toString());
    }
}
