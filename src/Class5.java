package Classes;

import java.util.Scanner;

public class Class5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("import a number");
        int input = s.nextInt();
        int i = 2;
        int ii = 1;
        int tmp;
        int index = 3;
        boolean infib = false;
        if (input == 0) {
            System.out.println("in fibonacci, index: 1");
        } else if (input == 1) {
            System.out.println("in fibonacci, index: 2/3");
        } else {
            while (i <= input && !infib) {
                if (i == input) {
                    infib = true;
                } else {
                    tmp = i;
                    i += ii;
                    ii = tmp;
                }
                index++;
            }
            if (infib) {
                System.out.println("in fibonacci, index: " + index);
            } else {
                System.out.println("not in fibonacci");
            }
        }
    }
}
