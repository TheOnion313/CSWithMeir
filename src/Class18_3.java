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


    public static int[] mergeChar(char[] arrA, char[] arrB) {
        int[] arrC = new int[arrA.length + arrB.length];
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

    public static void main(String[] args) {
        int[] arrA = new int[]
    }


}
