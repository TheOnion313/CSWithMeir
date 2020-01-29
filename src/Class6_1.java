package Classes;

import java.util.Scanner;

public class Class6_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a real number");
        int input = (int) Math.abs(s.nextDouble());
        int size = 0;
        if (input == 0) {
            System.out.println(1);
        } else {
            while (input > 0) {
                size++;
                input /= 10;
            }
            System.out.println(size);
        }
    }
}
