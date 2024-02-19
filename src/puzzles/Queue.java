//H.K.J.N.Gunaweera
//w1810567
//20200003

package puzzles;
import java.util.ArrayList;
import java.util.List;

public class Queue {

    private List<Location> queue = new ArrayList<>();

   //Adding location
    public void enqueue(Location location) {
        queue.add(location);
    }

    //Getting data from queue and removing
    public Location dequeue() {
        Location location = queue.get(0);
        queue.remove(0);

        return location;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        for (Location i : queue) {
            string.append(i).append(" ");
        }

        return string.toString();
    }
}
