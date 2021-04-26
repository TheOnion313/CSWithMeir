public class Vote {
    private int first, second, third;

    public Vote(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    public static int theWinner(Vote[] judges) {
        int[] scores = new int[40];

        for (Vote judge : judges) {
            scores[judge.getFirst()] += 7;
            scores[judge.getSecond()] += 5;
            scores[judge.getThird()] += 1;
        }

        int maxIdx = 0;
        for(int i = 1; i < scores.length; i++) {
            if(scores[i] > scores[maxIdx]) {
                maxIdx = i;
            }
        }

        return maxIdx + 1;
    }
}
