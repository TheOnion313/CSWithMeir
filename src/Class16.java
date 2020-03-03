import basics.Student;

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


    public static void main(String[] args) {

    }

}
