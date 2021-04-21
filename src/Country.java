//א1
public class Country {
    private String countryName;
    private Game[] games;
//א1

    //א2
    public Country(String countryName) {
        this.countryName = countryName;
        this.games = new Game[43];
    }
//א2

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }

    //א3
    public boolean participates(Game g) {
        for(Game game : this.games) {
            if(g == game) {
                return true;
            }
        }

        return false;
    }
    //א3
    

}
