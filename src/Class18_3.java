import java.util.Arrays;


public class Class18_3 {

    public static int[] mergeInt(int[] arrA, int[] arrB) {
        int[] arrC = new int[arrA.length + arrB.length];
        int idxA = 0, idxB = 0, idxC = 0;
        for (int i = 0; i < arrC.length; i++) {
            if (idxB == arrB.length) {
                arrC[idxC] = arrA[idxA];
                idxA++;
            } else if (idxA == arrA.length) {
                arrC[idxC] = arrB[idxB];
                idxB++;
            } else if (arrA[idxA] < arrB[idxB]) {
                arrC[idxC] = arrA[idxA];
                idxA++;
            } else {
                arrC[idxC] = arrB[idxB];
                idxB++;
            }
            idxC++;
        }
        return arrC;
    }

    public static int[] mergeNoRep(int[] arrA, int[] arrB) {
        int[] arrC = mergeInt(arrA, arrB);
        int lengthNoRep = 1;
        for (int i = 1; i < arrC.length; i++) {
            if (arrC[i] != arrC[i - 1]) {
                lengthNoRep++;
            }
        }

        int[] arr = new int[lengthNoRep];
        arr[0] = arrC[0];
        int idx = 1;
        for (int i = 1; i < arrC.length; i++) {
            if (arrC[i] != arrC[i - 1]) {
                arr[idx] = arrC[i];
                idx++;
            }
        }
        return arr;
    }


    public static char[] mergeChar(char[] arrA, char[] arrB) {
        char[] arrC = new char[arrA.length + arrB.length];
        int idxA = 0, idxB = 0, idxC = 0;
        for (int i = 0; i < arrC.length; i++) {
            if (idxB == arrB.length) {
                arrC[idxC] = arrA[idxA];
                idxA++;
            } else if (idxA == arrA.length) {
                arrC[idxC] = arrB[idxB];
                idxB++;
            } else if ((int) arrA[idxA] > (int) arrB[idxB]) {
                arrC[idxC] = arrA[idxA];
                idxA++;
            } else {
                arrC[idxC] = arrB[idxB];
                idxB++;
            }
            idxC++;
        }
        return arrC;
    }

    public static void swap(int[] arr, int id1, int id2) {
        int tmp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = tmp;
    }


    public static int[] bubbleSort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!swapped) {
                return arr;
            }
            swapped = false;
        }
        return arr;
    }

    public static int[] bubbleSortDown(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    swapped = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!swapped) {
                return arr;
            }
            swapped = false;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arrA = new int[100];
        int[] arrB = new int[50];
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = (int) (Math.random() * 100);
        }
        arrA = bubbleSort(arrA);
        arrB = bubbleSort(arrB);

        System.out.println("Merge integer arrays sorted UP:\n" + Arrays.toString(mergeInt(arrA, arrB)));
        System.out.println("\nMerge integer arrays sorted UP no replicates:\n" + Arrays.toString(mergeNoRep(arrA, arrB)));

        arrA = bubbleSortDown(arrA);
        arrB = bubbleSortDown(arrB);

        char[] charrA = new char[arrA.length];
        for (int i = 0; i < charrA.length; i++) {
            charrA[i] = (char) arrA[i];
        }
        char[] charrB = new char[arrB.length];
        for (int i = 0; i < charrB.length; i++) {
            charrB[i] = (char) arrB[i];
        }
        System.out.println("\nMerge character arrays sorted DOWN:\n" + Arrays.toString(mergeChar(charrA, charrB)));
        System.out.println("\nMerge character arrays sorted DOWN character values:\n" + Arrays.toString(mergeInt(arrA, arrB)));
    }

}
