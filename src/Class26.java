import canvasML.Canvas;
import canvasML.Rect;

import java.util.Scanner;

public class Class26 {
    public static int len = 5;
    public static int[] towerLocations = new int[len];
    public static Scanner s = new Scanner(System.in);

    public static void display(Block[] tower) {
        Rect clear = new Rect(0, 0, 400, 600, "white");
        int[] currHeights = new int[]{0, 0, 0};
        for (int i = 0; i < tower.length; i++) {
            Rect r = new Rect(30 + 150 * (tower[i].getLoc() - 1) + (150 - tower[i].getW()) / 2,
                    400 - 10 * (currHeights[tower[i].getLoc() - 1] + 10),
                    10,
                    tower[i].getW(),
                    "blue");
            currHeights[tower[i].getLoc() - 1]++;
        }
    }

    public static Block[] generateTower(int size) {
        Block[] b = new Block[size];
        for (int i = 0; i < size; i++) {
            b[i] = new Block(1, 150 - 4 * i);
        }
        return b;
    }

    public static void towersOfHanoi(Block[] tower, int idx, int move, int via) { //move from 1 to 2
        String trash = "";
        if (idx == tower.length - 1) {
            System.out.println("next move");
            while (!trash.equals("n")) {
                trash = s.nextLine();
            }
            tower[idx].setLoc(move);
            display(tower);
            return;
        }

        towersOfHanoi(tower, idx + 1, via, move);

        System.out.println("next move");
        while (!trash.equals("n")) {
            trash = s.nextLine();
        }
        tower[idx].setLoc(move);

        display(tower);

        towersOfHanoi(tower, idx + 1, move, via);

    }

    public static void main(String[] args) {
        Canvas.DefaultWaitTime = 0;
        System.out.println("enter tower height");
        int height = s.nextInt();
        Block[] t = generateTower(height);
        display(t);
        towersOfHanoi(t, 0, 3, 2);
        System.out.println("done");
    }
}

class Block {
    private int loc, w;

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public int getLoc() {
        return loc;
    }

    public int getW() {
        return w;
    }

    public Block(int loc, int w) {
        this.loc = loc;
        this.w = w;
    }
}
