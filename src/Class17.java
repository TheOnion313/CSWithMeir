import canvasML.Canvas;
import canvasML.Line;
import canvasML.Rect;

import java.util.Arrays;

public class Class17 {

    public static boolean numInArray(int[] arr, int num) {
        arr = bubbleSort(arr, false);
        boolean equal = false;
        int idx = arr.length / 2;
        int size = arr.length;
        for(int i = 0; i < Math.log(arr.length) / Math.log(2); i++) {
            if (arr[idx] == num) {
                return true;
            }
            if (arr[idx] > num) {
                size /= 2;
                idx -= size / 2;
            } else {
                size /= 2;
                idx += size / 2;
            }
        }
        return false;
    }

    public static int[] dispArr(int[] arr) {
        int max = 0;
        int[] copy = arr.clone();
        for (int value : copy) {
            if (value > max) {
                max = value;
            }
        }

        for (int i = 0; i < copy.length; i++) {
            copy[i] = (int) (copy[i] * 300 / max);
        }
        return copy;
    }

    public static void showArr(int[] arr) {
        Rect clear = new Rect(0, 0, 400, 600, "white");
        for (int i = 0; i < arr.length; i++) {
            Line l = new Line((2 * (i + 1)) % 600, 400, (2 * (i + 1)) % 600, 400 - arr[i], "red");
        }
    }

    public static int[] swap(int[] arr, int id1, int id2, boolean display) {
        int[] copy = dispArr(arr);
        int i = id1;
        if (display) {
            Line l = new Line((2 * (i + 1)) % 600, 400, (2 * (i + 1)) % 600, 400 - copy[i], "white");
            i = id2;
            Line l1 = new Line((2 * (i + 1)) % 600, 400, (2 * (i + 1)) % 600, 400 - copy[i], "white");
        }
        int tmp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = tmp;
        copy = dispArr(arr);
        i = id1;
        if (display) {
            Line l2 = new Line((2 * (i + 1)) % 600, 400, (2 * (i + 1)) % 600, 400 - copy[i], "red");
            i = id2;
            Line l3 = new Line((2 * (i + 1)) % 600, 400, (2 * (i + 1)) % 600, 400 - copy[i], "red");
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr, boolean display) {
        boolean swapped = false;
        if (display) showArr(dispArr(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    arr = swap(arr, j, j + 1, display);
                }
            }
            if (!swapped) {
                return arr;
            }
            swapped = false;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr, boolean display) {
        if (display) showArr(dispArr(arr));
        int minidx;
        for (int i = 0; i < arr.length; i++) {
            minidx = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minidx]) {
                    minidx = j;
                }
            }
            swap(arr, minidx, i, display);
        }
        return arr;
    }

    public static void main(String[] args) {
        Canvas.DefaultWaitTime = 2;
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        int[] a = new int[] {1, 1, 2, 5, 2, 3, 10, 18, 3};
        System.out.println(numInArray(a, 10));
    }

}
