package Classes;

import canvasML.Line;
import canvasML.Rect;

import java.util.Arrays;

public class Class12 {

    public static void dispArr(int[] arr) {
        int max = 0;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (arr[i] * 300 / max);
        }

        showArr(arr);
    }

    public static void showArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Line l = new Line((2 * (i + 1)) % 600, 400, (2 * (i + 1)) % 600, 400 - arr[i], "red");
            if ((2 * (i + 1)) % 600 == 0) {
                Rect clear = new Rect(0, 0, 400, 600, "white");
            }
        }
    }

    public static int[] shiftArrRoy(int[] arr, int n) {
        int O = 0;
        int count = 0;
        if (arr.length % 2 == 0) {
            if (n % 2 == 0) {
                arr = shiftArrRoy(shiftArrRoy(arr, n - 1), 1);
            } else {
                int tmp = arr[0];
                int jump = (arr.length + n) % (arr.length - 1) - 1;
                for (int i = 0; count < arr.length; i += jump) {
                    O++;
                    count++;
                    int tmp1 = arr[(i + jump)%(arr.length - 1)];
                    arr[(i + jump) % (arr.length - 1)] = tmp;
                    tmp = tmp1;
                }
            }
        } else {
            if (n % 2 != 0) {
                arr = shiftArrRoy(shiftArrRoy(arr, n - 1), 1);
            } else {
                int tmp = arr[0];
                for (int i = 0; count < arr.length; i += (arr.length + n) % arr.length) {
                    O++;
                    count++;
                    int tmp1 = arr[i + (arr.length + n) % arr.length];
                    arr[i + (arr.length + n) % arr.length] = tmp;
                    tmp = tmp1;
                }
            }

        }
        System.out.println(O);
        return arr;
    }

    public static int[] shiftArrBen(int[] arr, int n) {
        int O = 0;
        int[] piece = new int[n];
        for(int i = arr.length - n; i < arr.length; i++) {
            O++;
            piece[arr.length - i - 1] = arr[i];
        }
        int tmp = arr[n];
        int tmp1;
        for(int i = n; i < arr.length; i++) {
            O++;
            tmp1 = arr[i];
            arr[i] = tmp;
            tmp = tmp1;
        }
        for(int i = 0; i < n; i++) {
            O++;
            arr[i] = piece[i];
        }
        System.out.println(O);
        return arr;
    }

    public static int[] shiftArrRoyBetter(int[] arr, int n) {
        int O = 0;
        int[] moved = new int[arr.length];
        int count = 0;
        for(int i = arr.length - n; count < arr.length; i = (i + 1) % arr.length) {
            O++;
            count++;
            moved[count - 1] = arr[i];
        }
        System.out.println(O);
        return moved;
    }

    public static void main(String[] args) {
        //ass1
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 654);
        }
        /*dispArr(arr);*/
        int[] arr1 = shiftArrRoy(arr, 5);
        arr1 = shiftArrBen(arr, 5);
        arr1 = shiftArrRoyBetter(arr, 5);

    }

}
