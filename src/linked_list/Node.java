//H.K.J.N.Gunaweera
//w1810567
//20200003

package linked_list;
import puzzles.Location;

public class Node {

    private final Location location;
    private Node nextNode;


    public Node(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public Node getNextNode() { return nextNode; }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }


    @Override
    public String toString() {
        return location.toString();
    }
}
