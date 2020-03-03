import basics.Student;
import canvasML.Line;

public class Class16 {

    /*
    Exercise:
    A. write a function that recieves a 2D Array of Students (a class sitting arrangment) and returns a sorted version of it, sorted first by age, for each column, and then by height, for each row.
    notice that you cannot corrupt the given class.

    B. call the function in the main class.
     */

    public static Student copyStudent(Student st) {
        return new Student(st.getAge(), st.getHeight(), st.getGender(), st.getHair());
    }

    public static Student[][] copyClass(Student[][] arrange) {
        Student[][] ret = new Student[arrange.length][arrange[0].length];

        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                ret[i][j] = copyStudent(arrange[i][j]);
            }
        }

        return ret;
    }

    public static void swapStudents(Student[][] arrange, int[] st1, int[] st2) {
        Student copy = copyStudent(arrange[st1[0]][st1[1]]);
        arrange[st1[0]][st1[1]] = arrange[st2[0]][st2[1]];
        arrange[st2[0]][st2[1]] = copy;
    }

    public static Student[][] sortClass(Student[][] arrangment) {
        Student[][] copy = copyClass(arrangment);
        int swapRow = 0;
        int swapCol = 0;

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j] == null) {
                    continue;
                }
                if (copy[i][j].getGender().equals("G")) {
                    swapStudents(copy, new int[]{swapRow, swapCol}, new int[]{i, j});
                    if (swapCol == copy[swapRow].length - 1) {
                        swapRow += 1;
                        swapCol = 0;
                    } else {
                        swapCol++;
                    }
                }
            }
        }
        return copy;
    }

    public static boolean linesIntersect(int[][] ln1, int[][] ln2) {
        int[] p1 = ln1[0];
        double m1 = (double)(p1[1] - ln2[0][1]) / (double)(p1[0] - ln2[0][0] + Math.pow(10, -10));
        double m2 = (double)(p1[1] - ln2[1][1]) / (double)(p1[0] - ln2[1][0] + Math.pow(10, -10));
        double m = (double)(p1[1] - ln1[1][1]) / (double)(p1[0] - ln1[1][0] + Math.pow(10, -10));

        return m > Math.max(m1, m2) || m < Math.min(m1, m2);
    }

    public static boolean isPoly(int[][] poly) {
        boolean is = true;
        for (int i = 0; i < poly.length - 1; i++) {
            for (int j = 0; j < poly.length - 1; j++) {
                if (i != j && linesIntersect(new int[][]{poly[i], poly[i + 1]}, new int[][]{poly[j], poly[j + 1]})) {
                    is = false;
                }
            }
        }
        return is;
    }

    public static void drawPoly(int[][] poly) {
        for (int i = 0; i < poly.length - 1; i++) {
            Line l = new Line(poly[i][0], poly[i][1], poly[i + 1][0], poly[i + 1][1], "black");
        }
        Line l = new Line(poly[0][0], poly[0][1], poly[poly.length - 1][0], poly[poly.length - 1][1], "black");
    }


    public static void main(String[] args) {
        int[][] poly = new int[][]{{50, 50}, {100, 100}, {150, 50}, {85, 75}};
        System.out.println(isPoly(poly));
        drawPoly(poly);
    }

}
