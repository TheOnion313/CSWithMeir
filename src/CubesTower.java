import java.util.Arrays;

public class CubesTower {
    private int maxCap, currCap;
    private Cube[] cubes;

    public CubesTower(int maxCap, int currCap, Cube[] cubes) {
        this.maxCap = maxCap;
        this.currCap = currCap;
        this.cubes = new Cube[cubes.length];
        for (int i = 0; i < this.cubes.length; i++) {
            this.cubes[i] = cubes[i];
        }
    }

    public CubesTower(CubesTower c) {
        this.maxCap = c.maxCap;
        this.currCap = c.getCurrCap();
        this.cubes = new Cube[c.getCubes().length];
        for (int i = 0; i < this.cubes.length; i++) {
            this.cubes[i] = c.getCubes()[i];
        }
    }

    public int getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }

    public int getCurrCap() {
        return currCap;
    }

    public void setCurrCap(int currCap) {
        this.currCap = currCap;
    }

    public Cube[] getCubes() {
        return cubes.clone();
    }

    public void setCubes(Cube[] cubes) {
        this.cubes = cubes.clone();
    }

    @Override
    public String toString() {
        return "CubesTower{" +
                "maxCap=" + maxCap +
                ", currCap=" + currCap +
                ", cubes=" + Arrays.toString(cubes) +
                '}';
    }

    public boolean equals(CubesTower c) {
        return this.toString().equals(c.toString());
    }

    public void addCube(Cube c) {
        if(currCap < maxCap) {
            currCap++;
            Cube[] cs = new Cube[this.cubes.length];
            for(int i = 0; i < cs.length - 1; i++) {
                cs[i] = cubes[i];
            }
            cs[cs.length - 1] = new Cube(c);
            this.setCubes(cs);
        }
    }
}
