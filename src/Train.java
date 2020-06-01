import java.util.Arrays;
import java.util.Random;

public class Train {
    private Engine eng;
    private Carriage[] carr;

    public Train(Engine eng, Carriage[] carr) {
        this.eng = new Engine(eng);
        this.carr = new Carriage[carr.length];
        for(int i = 0; i < this.carr.length; i++) {
            this.carr[i] = new Carriage(carr[i]);
        }
    }

    public Train(Train t) {
        this.eng = t.getEng();
        this.carr = t.getCarr();
    }

    public Engine getEng() {
        return new Engine(eng);
    }

    public void setEng(Engine eng) {
        this.eng = new Engine(eng);
    }

    public Carriage[] getCarr() {
        Carriage[] car = new Carriage[this.carr.length];
        for(int i = 0; i < car.length; i++) {
            car[i] = new Carriage(carr[i]);
        }
        return car;
    }

    public void setCarr(Carriage[] carr) {
        this.carr = new Carriage[carr.length];
        for(int i = 0; i < this.carr.length; i++) {
            this.carr[i] = new Carriage(carr[i]);
        }
    }

    @Override
    public String toString() {
        return "Train{" +
                "Engine=" + eng +
                ", Carriages=" + Arrays.toString(carr) +
                '}';
    }

    public boolean equals(Train t) {
        return this.toString().equals(t.toString());
    }

    //1: already done, see setEng
    public void addCarriage(Carriage c) {//2
        Carriage[] carrs = new Carriage[carr.length + 1];
        for(int i = 0; i < carr.length; i++) {
            carrs[i] = new Carriage(carr[i]);
        }
        carrs[carrs.length - 1] = new Carriage(c);
        this.setCarr(carrs);
    }

    public int totalCapacity() {//3
        int totalCap = 0;
        for(int i = 0; i < carr.length; i++) {
            totalCap += carr[i].getCapacity();
        }
        return totalCap;
    }

    public double averageCapacity() {
        return (double)this.totalCapacity() / carr.length;
    }

    public static void main(String[] args) {
        Carriage[] carrs = new Carriage[15];
        Random r = new Random();
        for(int i = 0; i < carrs.length; i++) {
            carrs[i] = new Carriage(r.nextInt(), r.nextInt());
        }
        Engine e = new Engine(r.nextInt(), r.nextInt());
        Train t = new Train(e, carrs);
        Engine e2 = new Engine(r.nextInt(), r.nextInt());
        t.setEng(e2);//1
        t.addCarriage(new Carriage(r.nextInt(), r.nextInt()));
        int totCap = t.totalCapacity();
        double avgCap = t.averageCapacity();
        System.out.println(String.format("Total Capacity: %d\nAverage Capacity: %f\n%s", totCap, avgCap, t.toString()));
    }
}
