package Classes;

import java.util.*;

public class Class1 {
    static Random r = new Random();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> im = new ArrayList<Integer>();
        im.add(5);
        im.add(6);
        im.add(3);
        im.add(7);
        im.add(1);
        im.add(8);
        im.add(9);
        SetInt set1 = new SetInt(im);
        SetInt set2 = set1.copySetInt();
        int max, min;
        while (!set2.isEmpty()) {
            System.out.println();
            max = set2.removeMax();
            if (set2.isEmpty()) {
                System.out.println("The median is: " + max);
            } else {
                min = set2.removeMin();
                if (set2.isEmpty()) {
                    System.out.println("The median is: " + (max + min) / 2);
                }
            }
        }
        System.out.println(set1.isEmpty());
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(9);
        a.add(3);
        a.add(9);
        a.add(7);
        a.add(1);
        a.add(5);
        SetInt set3 = new SetInt(a);
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(9);
        b.add(3);
        b.add(9);
        b.add(7);
        b.add(1);
        b.add(5);
        SetInt set4 = new SetInt(b);
        SetInt setCopy3 = set3.copySetInt();
        SetInt setCopy4 = set4.copySetInt();
        boolean equal = true;
        while (equal && !setCopy3.isEmpty() && !setCopy4.isEmpty()) {
            int i3 = setCopy3.removeMax();
            int i4 = setCopy4.removeMax();
            equal = i3 == i4;
            System.out.println(i3 + " " + i4);

        }
        String ter = equal ? "equal" : "not equal";
        System.out.println("The groups are: " + ter);

        int input = s.nextInt();
        boolean prime = true;
        for (int i = 2; i <= input / 2; i++) {
            prime = !(input % i == 0);
        }
        System.out.println(prime);
    }
}

class SetInt {
    private ArrayList<Integer> array;

    public SetInt() {

    }

    public SetInt(ArrayList<Integer> arr) {
        this.array = arr;
    }

    public boolean isEmpty() {
        return this.array.size() == 0;
    }

    public int removeMax() {
        int tmp = this.array.get(this.getMax());
        this.array.remove(this.getMax());
        return tmp;
    }

    public int removeMin() {
        int tmp = this.array.get(this.getMin());
        this.array.remove(this.getMin());
        return tmp;
    }

    private int getMax() {
        int maxIndex = 0;
        for (int i = 0; i < this.array.size(); i++) {
            if (array.get(i) > array.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int getMin() {
        int minIndex = 0;
        for (int i = 0; i < this.array.size(); i++) {
            if (array.get(i) < array.get(minIndex)) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public SetInt copySetInt() {
        return this;
    }

}

