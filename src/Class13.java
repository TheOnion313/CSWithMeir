import canvasML.*;
import basics.*;

public class Class13 {

    public static int squareBySum(int n) {
        int sum = 0;
        for(int i = 1; i <= (2 * n - 1); i+=2) {
            sum += i;
        }
        return sum;
    }

    public static double bazelSum() {
        double sum = 0;
        for(int i = 1; i <= 10000; i++) {
            sum += 1.0 / squareBySum(i);
        }
        return sum;
    }

    public static boolean dollarsInHalf(char[] chars) {
        int dollars = 0;
        for(int i = 0; i < chars.length / 2; i++) {
            if(chars[i] == '$') {
                dollars++;
            }
        }
        for(int i = chars.length - 1; i >= chars.length / 2; i--) {
            if(chars[i] == '$') {
                dollars--;
            }
        }
        return dollars > 0;
    }

    public static int swingSumTwoArrays(int[] arr1, int[] arr2) {
        int sum = 0;
        for(int i = 0; i < arr1.length; i+= 2) {
            sum += arr1[i];
        }
        for(int i = 1; i < arr2.length; i+= 2) {
            sum += arr2[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(bazelSum());
        System.out.println(Math.PI * Math.PI / 6);
        System.out.println(bazelSum() - (Math.PI * Math.PI / 6));
        System.out.println(Math.abs((double)bazelSum() - (Math.PI * Math.PI / 6)) < 0.0001);
    }
}