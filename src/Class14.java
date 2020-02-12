import java.util.Arrays;
import java.util.Random;

public class Class14 {

    public static int[] averageTemps(int[][] tab) {
        int[] averageTemps = new int[tab.length];
        for(int i = 0; i< tab.length; i++) {
            for(int j = 0; j < tab[i].length; j++) {
                averageTemps[i] += tab[i][j];
            }
            averageTemps[i] /= tab[i].length;
        }
        return averageTemps;
    }

    public static int seated(int[][] seats) {
        int sum = 0;
        for(int i = 0; i < seats.length; i++) {
            sum += seats[i][i];
            sum += seats[i][seats.length - i - 1];
        }
        sum -= seats[seats.length / 2][seats.length / 2];
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j < seats.length - 1; j++) {
                sum += seats[j][i * (seats.length - 1)];
                sum += seats[i * (seats.length - 1)][j];
            }
        }
        return sum;
    }

    public static void orderTickets(int[][] seats, int amount) {
        for(int i = 0; i < seats.length; i++) {
            int straight = 0;
            int best = 0;
            int last = -1;
            for(int j = 0; j < seats[i].length; j++) {
                if(seats[i][j] == 0) {
                    straight++;
                    last = j;
                } else {
                    if(straight > best) {
                        best = straight;
                    }
                    straight = 0;
                }
            }
            if(best >= amount) {
                for(int k = 0; k < amount; k++) {
                    seats[i][last - k] = 1;
                    System.out.println(String.format("Ticket:\trow: %d\tseat:%d", i, last - k));
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[][] temps = {{18, 19, 23, 21, 17, 18, 18, 19}, {13, 17, 17, 18, 12, 13, 13, 14}, {22, 27, 29, 29, 24, 23, 22, 23}};
        int[] averages = averageTemps(temps);
        for(int i = 0; i < temps.length; i++) {
            switch(i){
                case 0:
                    System.out.print(String.format("Tel-Aviv: Average: %d\t\t", averages[0]));
                    break;
                case 1:
                    System.out.print(String.format("Jerusalem: Average: %d\t\t", averages[1]));
                    break;
                case 2:
                    System.out.print(String.format("Eilat: Average: %d\t\t\t", averages[2]));
                    break;
            }
            for(int j = 0; j < temps[i].length; j++) {
                System.out.print(temps[i][j] + "\t");
            }
            System.out.println();
        }



        int[][] seats = new int[8][8];
        Random rand = new Random();
        for(int i = 0;i < seats.length; i++) {
            for(int j = 0; j < seats[i].length; j++) {
                seats[i][j] = rand.nextInt(2);
                System.out.print(seats[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(seated(seats));

        int[] fullRow = {1, 1, 1, 1, 1, 1, 1, 1};
        int[][] findSeats = {fullRow, fullRow, fullRow, fullRow, {1, 1, 0, 0, 0, 0, 0, 1}, fullRow, fullRow, fullRow};
        orderTickets(findSeats, 3);
    }
}
