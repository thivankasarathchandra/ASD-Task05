package rugby;

/******************************************************************************
 * This class stores the details of a Premiership rugby club including the 
 * performance measures that determine their position in the league. The class 
 * implements the Comparable interface, which determines how clubs will be 
 * sorted.     
 * 
 * @author Dr Kevan Buckley, University of Wolverhampton, 2019
 ******************************************************************************/

public class Club implements Comparable<Club> {
    private final int position;
    private final String club;
    private final int played;
    private final int won;
    private final int drawn;
    private final int lost;
    private final int pointsFor;
    private final int pointsAgainst;
    private final int pointsDifference;
    private final int triesFor;
    private final int triesAgainst;
    private final int tryBonus;
    private final int losingBonus;
    private final int points;

    public Club(int position, String club, int played, int won, int drawn,
                int lost, int pointsFor, int pointsAgainst, int pointsDifference,
                int triesFor, int triesAgainst, int tryBonus, int losingBonus,
                int points) {
        this.position = position;
        this.club = club;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.pointsFor = pointsFor;
        this.pointsAgainst = pointsAgainst;
        this.pointsDifference = pointsDifference;
        this.triesFor = triesFor;
        this.triesAgainst = triesAgainst;
        this.tryBonus = tryBonus;
        this.losingBonus = losingBonus;
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public String getClub() {
        return club;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getDrawn() {
        return drawn;
    }

    public int getLost() {
        return lost;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public int getPointsDifference() {
        return pointsDifference;
    }

    public int getTriesFor() {
        return triesFor;
    }

    public int getTriesAgainst() {
        return triesAgainst;
    }

    public int getTryBonus() {
        return tryBonus;
    }

    public int getLosingBonus() {
        return losingBonus;
    }

    public int getPoints() {
        return points;
    }

    public Club withPosition(int newPosition) {
        return new Club(newPosition, club, played, won, drawn, lost, pointsFor,
                pointsAgainst, pointsDifference, triesFor, triesAgainst, tryBonus,
                losingBonus, points);
    }

    public Club withClub(String newClub) {
        return new Club(position, newClub, played, won, drawn, lost, pointsFor,
                pointsAgainst, pointsDifference, triesFor, triesAgainst, tryBonus,
                losingBonus, points);
    }

    public int calculateTotalPoints() {
        return won * 4 + drawn * 2 + tryBonus + losingBonus;
    }

    @Override
    public String toString() {
        return String.format("%-3d%-20s%10d%10d%10d", position, club, pointsFor,
                pointsAgainst, points);
    }

    public int compareTo(Club c) {
        return Integer.compare(pointsFor, c.pointsFor);
    }
}
