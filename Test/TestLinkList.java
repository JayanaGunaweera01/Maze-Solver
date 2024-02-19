//H.K.J.N.Gunaweera
//w1810567
//20200003

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import linked_list.LinkedList;
import puzzles.Location;

class TestLinkList {

    LinkedList linkedList;

    @BeforeEach
    void reset(){
        linkedList = new LinkedList();
    }

    @Test
    void testAdd(){
        Location location = new Location();
        linkedList.insertAtHead(location);

        Assertions.assertEquals(1, linkedList.len());
    }

    @Test
    void testGetList(){

        Location[] expectList = new Location[5];

        for(int i = 0 ; i < 5;i++) {
            Location location = new Location(i,i+1);
            linkedList.insertAtHead(location);
            expectList[i] = location;
        }

        String expectListString = "";
        String linkListString = "";

        for(Location i : expectList){
            expectListString += i+",";
        }
        for(Location i : linkedList.streamList()){
            linkListString += i+",";
        }

        Assertions.assertEquals(expectListString,linkListString);

    }
}
