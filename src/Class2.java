package Classes;

import java.util.Random;

public class Class2 {
    static Random r = new Random();

    public static void main(String[] args) {
        int bibleSum = 0, CSSum = 0, bibleFails = 0, CSFails = 0, bible, CS, bibleNonFailSum = 0, CSNonFailSum = 0, excellers = 0, bibleHighest = 0, CSHighest = 0;


        for (int i = 0; i < 40; i++) {
            bible = r.nextInt(100);
            CS = r.nextInt(100);
            bibleHighest = bible > bibleHighest ? bible : bibleHighest;
            CSHighest = CS > CSHighest ? CS : CSHighest;
            boolean bibleFailed = bible < 55, CSFailed = CS < 55;

            bibleSum += bible;
            CSSum += CS;

            CSFails += CSFailed ? 1 : 0;
            bibleFails += bibleFailed ? 1 : 0;

            CSNonFailSum += !CSFailed ? CS : 0;
            bibleNonFailSum += !bibleFailed ? bible : 0;

            excellers += bible > 94 && CS > 94 ? 1 : 0;
        }


        System.out.println(String.format("bible average: %d\nCS average: %d", bibleSum / 40, CSSum / 40));
        System.out.println("Bible fails: " + bibleFails + "\nCSFails: " + CSFails);
        System.out.println("Non fail bible average: " + bibleNonFailSum / (40 - bibleFails) + "\nNon fail CS average: " + CSNonFailSum / (40 - CSFails));
        System.out.println("Excellers: " + excellers);
        System.out.println("Bible highest: " + bibleHighest + "\nCS highest: " + CSHighest);
    }
}
