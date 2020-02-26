public class Class15 {

    public static int sumMainDia(int[][] arrarr) {
        int sum = 0;
        for (int i = 0; i < arrarr.length; i++) {
            sum += arrarr[i][i];
        }

        return sum;
    }

    public static int sumSecDia(int[][] arrarr) {
        int sum = 0;
        for (int i = 0; i < arrarr.length; i++) {
            sum += arrarr[i][arrarr.length - i - 1];
        }

        return sum;
    }

    public static int sumParam(int[][] arrarr) {
        int sum = 0;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < arrarr.length; i++) {
                sum += arrarr[j * (arrarr.length - 1)][i];
            }
        }

        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < arrarr.length - 1; i++) {
                sum += arrarr[i][j * (arrarr.length - 1)];
            }
        }

        return sum;
    }

    public static boolean symetMainDia(int[][] arrarr) {
        boolean tmp = true;
        for (int i = 0; i < arrarr.length; i++) {
            for (int j = 0; j < arrarr[0].length; j++) {
                if (arrarr[i][j] != arrarr[j][i]) {
                    tmp = false;
                }
            }
        }

        return tmp;
    }

    public static boolean isUnitMat(int[][] arrarr) {
        for (int i = 0; i < arrarr.length; i++) {
            if (arrarr[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static int[][] sumMat(int[][] a, int[][] b) {
        int[][] sum = new int[a.length][a[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        return sum;
    }

    public static int[][] scaleMat(int[][] a, int val) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] *= val;
            }
        }
        return a;
    }

    public static int[][] subMats(int[][] a, int[][] b) {
        return sumMat(a, scaleMat(b, -1));
    }

    public static int[][] transpose(int[][] arr) {
        int it = 0
        int[][] tmp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - it; j++) {
                arr[i][j] = arr[arr.length - i][arr[i].length - j];
            }
            it++;
        }

        it = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = tmp[0].length - 1 - it; j >= 0; j++) {
                arr[i][j] = tmp[tmp.length - i][tmp[i].length - j];
            }
            it++;
        }

        return arr;
    }

    public static boolean compareMatrices(int[][] a, int[][] b) {
        boolean equal = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    equal = false;
                }
            }
        }

        return equal;
    }

    public static void main(String[] args) {

    }
}
