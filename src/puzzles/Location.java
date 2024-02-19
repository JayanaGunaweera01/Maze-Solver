//H.K.J.N.Gunaweera
//w1810567
//20200003

package puzzles;
import linked_list.LinkedList ;

public class Location {
    private int row = -1;
    private int col = -1;
    private String data;
    //location reached or not status
    private boolean isVisited = false;
    // location witch need to pass before to reach this location
    private Location previousLocation;

    private LinkedList ajList;

    public Location(){}

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Location(int row, int col, String data) {
        this.row = row;
        this.col = col;
        this.data = data;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isVisited() { return isVisited; }

    public void setVisited(boolean status) {
        this.isVisited = status;
    }

    public String getData() {
        return data;
    }

    public Location getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

    public LinkedList getAjList() {
        return ajList;
    }

    public void setAjList(LinkedList ajList) {
        this.ajList = ajList;
    }

    @Override
    public String toString() {

        return "(" + row +
                "," + col +
                ')';

    }
}
