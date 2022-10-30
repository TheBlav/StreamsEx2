import java.util.Objects;

public class SoccerMatch {

    private String homeTeamName;
    private String guestTeamName;
    private int homeTeamScore;
    private int guestTeamScore;


    public SoccerMatch(String homeTeamName, String guestTeamName, int homeTeamScore, int guestTeamScore) {
        this.homeTeamName = homeTeamName;
        this.guestTeamName = guestTeamName;
        this.homeTeamScore = homeTeamScore;
        this.guestTeamScore = guestTeamScore;
    }

    public  String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }

    public void setGuestTeamName(String guestTeamName) {
        this.guestTeamName = guestTeamName;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getGuestTeamScore() {
        return guestTeamScore;
    }

    public void setGuestTeamScore(int guestTeamScore) {
        this.guestTeamScore = guestTeamScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoccerMatch that = (SoccerMatch) o;
        return homeTeamScore == that.homeTeamScore && guestTeamScore == that.guestTeamScore && Objects.equals(homeTeamName, that.homeTeamName) && Objects.equals(guestTeamName, that.guestTeamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeamName, guestTeamName, homeTeamScore, guestTeamScore);
    }

    @Override
    public String
    toString() {
        return homeTeamName + " : " + guestTeamName
                + " (" + homeTeamScore + ":" + guestTeamScore + ")";
    }
}
