package Classes;

import java.util.Scanner;

public class Class4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("input a number");
        int input = s.nextInt();
        int div = 1;
        int sum = 0;
        while(div < input) {
            if(input % div == 0) {
                sum += div;
            }
            div++;
        }
        if(sum == input) {
            System.out.println("it's PERFECT!!!");
        } else {
            System.out.println("maybe next time");
        }
    }
}
