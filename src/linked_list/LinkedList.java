//H.K.J.N.Gunaweera
//w1810567
//20200003

package linked_list;
import puzzles.Location;

public class LinkedList {
    private Node head;

   //Adding data from head
    public void insertAtHead(Location location){
        Node newNode = new Node(location);

        newNode.setNextNode(this.head);
        head = newNode;

    }

    public int len(){
        int len = 0;

        Node currentNode = this.head;

        while(currentNode != null){
            len++;
            currentNode = currentNode.getNextNode();
        }

        return len;
    }

    //Linked list conversion to location
    public Location[] streamList(){

        int len = len();

        Location[] list = new Location[len];
        Location[] temp = new Location[len];

        Node currentNode = head;

        for (int i = 0; i<len; i++){
            list[i] = currentNode.getLocation();
            currentNode = currentNode.getNextNode();
        }

        for(int i = len; i>0;i--){
            temp[len-i] = list[i-1];
        }

        list = temp;

        return list;
    }


    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("{");

        Node currentNode = head;

        while (currentNode != null){
            result.append(currentNode.toString()).append(" ,");
            currentNode = currentNode.getNextNode();
        }

        result.append("}");

        return result.toString();
    }
}
