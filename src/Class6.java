package Classes;

import java.util.Scanner;

public class Class6 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter a positive integer");
        int input = s.nextInt();
        int flippedInput = 0;
        while (input > 0) {
            flippedInput =flippedInput * 10 + input % 10;
            input /= 10;
        }
        System.out.println(flippedInput);
    }
}
