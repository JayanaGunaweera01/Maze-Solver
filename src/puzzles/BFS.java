//H.K.J.N.Gunaweera
//w1810567
//20200003

package puzzles;
import linked_list.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class BFS {

    // store locations
    private List<List<Location>> locationGrid;

    private Location fLocation;
    private Location sLocation;

    public BFS(List<List<String>> grid) {

        locationGrid = new ArrayList<>();

        // create locationGrid
        for (int row = 0; row < grid.size(); row++) {
            List<Location> locationGridRow = new ArrayList<>();

            for (int col = 0; col < grid.get(row).size(); col++) {
                String data = grid.get(row).get(col);

                // create location and add to the row
                Location newLocation = new Location(row, col, data);
                locationGridRow.add(newLocation);

                if (data.equals("F")) {
                    fLocation = newLocation;
                } else if (data.equals("S")) {
                    sLocation = newLocation;
                }
            }
            //Adding row to grid
            locationGrid.add(locationGridRow);
        }

    }

    //Getting right vertex
    private Location getRightNeighbour(int row, int col) {
        Location nextLocation;
        Location currentLocation = locationGrid.get(row).get(col);

        if (col >= locationGrid.get(row).size() - 1) {
            return currentLocation;
        } else {
            nextLocation = locationGrid.get(row).get(col + 1);

            if (nextLocation.getData().equals("F")) {
                return nextLocation;
            }
            if (nextLocation.getData().equals("0")) {
                return currentLocation;
            }
            return getRightNeighbour(row, col + 1);
        }
    }


    //Getting left vertex
    private Location getLeftNeighbour(int row, int col) {
        Location leftLocation;
        Location currentLocation = locationGrid.get(row).get(col);

        if (col <= 0) {
            return currentLocation;
        } else {
            leftLocation = locationGrid.get(row).get(col - 1);

            if (leftLocation.getData().equals("F")) {
                return leftLocation;
            }
            if (leftLocation.getData().equals("0")) {
                return currentLocation;
            }
            return getLeftNeighbour(row, col - 1);
        }
    }

    //Getting top vertex
    private Location getTopNeighbour(int row, int col) {
        Location topLocation;
        Location currentLocation = locationGrid.get(row).get(col);

        if (row <= 0) {
            return currentLocation;
        } else {
            topLocation = locationGrid.get(row - 1).get(col);

            if (topLocation.getData().equals("F")) {
                return topLocation;
            }
            if (topLocation.getData().equals("0")) {
                return currentLocation;
            }
            return getTopNeighbour(row - 1, col);
        }
    }


    //Getting bottom vertex
    private Location getBottomNeighbour(int row, int col) {
        Location bottomLocation;
        Location currentLocation = locationGrid.get(row).get(col);

        if (row >= locationGrid.size() - 1) {
            return currentLocation;
        } else {
            bottomLocation = locationGrid.get(row + 1).get(col);

            if (bottomLocation.getData().equals("F")) {
                return bottomLocation;
            }
            if (bottomLocation.getData().equals("0")) {
                return currentLocation;
            }
            return getBottomNeighbour(row + 1, col);
        }
    }

    //List creation to store all vertexes
    private void createAdjacencyList() {

        int fLocationRowNum = fLocation.getRow();
        int fLocationColNum = fLocation.getCol();

        for (List<Location> locationGridRow : locationGrid) {

            for (Location locationGridCol : locationGridRow) {
                LinkedList newLinkedList = new LinkedList();

                int rowNum = locationGridCol.getRow();
                int colNum = locationGridCol.getCol();

                Location rightNeighbor = null;
                Location leftNeighbor = null;
                Location topNeighbor = null;
                Location bottomNeighbor = null;

                // get neighbours
                if (!(rowNum == fLocationRowNum && colNum == fLocationColNum)) {
                    rightNeighbor = getRightNeighbour(rowNum, colNum);
                    leftNeighbor = getLeftNeighbour(rowNum, colNum);
                    topNeighbor = getTopNeighbour(rowNum, colNum);
                    bottomNeighbor = getBottomNeighbour(rowNum, colNum);
                }

                // add right neighbor to the linked list
                if (rightNeighbor != null
                        && !(rowNum == rightNeighbor.getRow()
                        && colNum == rightNeighbor.getCol()))
                    newLinkedList.insertAtHead(rightNeighbor);

                // add left neighbor to the linked list
                if (leftNeighbor != null
                        && !(rowNum == leftNeighbor.getRow()
                        && colNum == leftNeighbor.getCol()))
                    newLinkedList.insertAtHead(leftNeighbor);

                // add top neighbor to the linked list
                if (topNeighbor != null
                        && !(rowNum == topNeighbor.getRow()
                        && colNum == topNeighbor.getCol()))
                    newLinkedList.insertAtHead(topNeighbor);

                // add bottom neighbor to the linked list
                if (bottomNeighbor != null
                        && !(rowNum == bottomNeighbor.getRow()
                        && colNum == bottomNeighbor.getCol()))
                    newLinkedList.insertAtHead(bottomNeighbor);

                locationGridCol.setAjList(newLinkedList);
            }
        }

    }

    //Bredth First Search Algorithm implementation
    private void solve() {

        sLocation.setVisited(true);

        // help to go to indexes
        Queue q = new Queue();
        //add first index to queue
        q.enqueue(sLocation);

        while (!q.isEmpty()) {

            Location location = q.dequeue();
            //get neighbour Nodes
            Location[] neighboursNodes = location.getAjList().streamList();

            // go to all neighbour nodes and add to the queue
            for (Location nextLocation : neighboursNodes) {
                if (!nextLocation.isVisited()) {
                    q.enqueue(nextLocation);

                    // make node as visited
                    nextLocation.setVisited(true);

                    //add previous node location
                    nextLocation.setPreviousLocation(location);
                }
            }
        }
    }

    //Generating path arraylist
    private List<Location> findPath() {
        List<Location> path = new ArrayList<>();

        //start with ending position
        Location currentPositionLocation;
        if (fLocation.isVisited()) {
            currentPositionLocation = fLocation;

            // check current index Location and find next path
            while (currentPositionLocation != sLocation) {

                // add location to path list
                path.add(currentPositionLocation);
                currentPositionLocation = currentPositionLocation.getPreviousLocation();
            }
        }

        //revers found path
        List<Location> reversPath = new ArrayList<>();

        for (int i = path.size() - 1; i >= 0; i--) {
            reversPath.add(path.get(i));
        }
        path = reversPath;

        return path;
    }

    //Creating path arraylist
    private void convertPathToWords(List<Location> path) {
        if (path.isEmpty()) {
            System.out.println("No Path found");
            return;
        }

        int num = 1;

        Location previousLocation = sLocation;
        System.out.println(num + " Start at " + sLocation);
        num += 1;

        for (Location index : path) {

             if (previousLocation.getCol() < index.getCol()) {
                System.out.println(num + " Move right to  " + index);
            } else if (previousLocation.getCol() > index.getCol()) {
                System.out.println(num + " Move left to  " + index);
            } else if (previousLocation.getRow() > index.getRow()) {
                System.out.println(num + " Move up to  " + index);
            } else if (previousLocation.getRow() < index.getRow()) {
                System.out.println(num + " Move down to  " + index);
            }

            previousLocation = index;
            num++;
        }
        System.out.println(num + " Done!");
    }

    public void showPath(List<Location> path){
        convertPathToWords(path);
    }

    public  List<Location> find() {
        createAdjacencyList();
        solve();
        return findPath();

    }
}
