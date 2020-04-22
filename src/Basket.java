import java.util.Arrays;
import java.util.Objects;

public class Basket {
    private String name;
    private int[] inGame, allPlayers;


    public Basket(String name, int[] inGame, int[] allPlayers) {
        this.name = name;
        this.inGame = new int[inGame.length];
        for (int i = 0; i < inGame.length; i++) {
            this.inGame[i] = inGame[i];
        }
        this.allPlayers = new int[allPlayers.length];
        for (int i = 0; i < allPlayers.length; i++) {
            this.allPlayers[i] = allPlayers[i];
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getInGame() {
        return inGame;
    }

    public void setInGame(int[] inGame) {
        this.inGame = new int[inGame.length];
        for (int i = 0; i < inGame.length; i++) {
            this.inGame[i] = inGame[i];
        }
    }

    public int[] getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(int[] allPlayers) {
        this.allPlayers = new int[allPlayers.length];
        for (int i = 0; i < allPlayers.length; i++) {
            this.allPlayers[i] = allPlayers[i];
        }
    }

    public boolean exchange(int pInGame, int pOnBench) {
        if (0 <= pInGame && pInGame < inGame.length && 0 <= pOnBench && pOnBench < allPlayers.length) {
            int tmp = inGame[pInGame];
            inGame[pInGame] = allPlayers[pOnBench];
            allPlayers[pOnBench] = tmp;
            return true;
        }
        return false;
    }

    public void addPlayer(int pNum) {
        int[] copy = new int[allPlayers.length + 1];
        for (int i = 0; i < allPlayers.length; i++) {
            copy[i] = allPlayers[i];
        }
        copy[allPlayers.length] = pNum;
        this.allPlayers = new int[copy.length];
        for (int i = 0; i < copy.length; i++) {
            this.allPlayers[i] = copy[i];
        }
    }

    public boolean equals(Basket b) {
        if (this == b) return true;
        if (b == null || getClass() != b.getClass()) return false;
        return name.equals(b.name) &&
                Arrays.equals(inGame, b.inGame) &&
                Arrays.equals(allPlayers, b.allPlayers);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "name='" + name + '\'' +
                ", inGame=" + Arrays.toString(inGame) +
                ", allPlayers=" + Arrays.toString(allPlayers) +
                '}';
    }
}
