package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ajothomas on 4/14/17.
 */
class NaryNode {
    int data;
    ArrayList<NaryNode> list;

    NaryNode(int data) {
        this.data = data;
        list = null;
    }
}

public class NAryExample {
    NaryNode head;

    NAryExample() {
        head = null;
    }

    void insert() {
        /*
                  1
            2     3     4
          5 6 7   8   9   10
         */

        NaryNode temp2 = new NaryNode(2);
        NaryNode temp5 = new NaryNode(5);
        NaryNode temp6 = new NaryNode(6);
        NaryNode temp7 = new NaryNode(7);
        temp2.list = new ArrayList<>();
        temp2.list.add(temp5);
        temp2.list.add(temp6);
        temp2.list.add(temp7);

        NaryNode temp3 = new NaryNode(3);
        NaryNode temp8 = new NaryNode(8);
        temp3.list = new ArrayList<>();
        temp3.list.add(temp8);

        NaryNode temp4 = new NaryNode(4);
        NaryNode temp10 = new NaryNode(10);
        NaryNode temp9 = new NaryNode(9);
        temp4.list = new ArrayList<>();
        temp4.list.add(temp9);
        temp4.list.add(temp10);

        this.head = new NaryNode(1);
        head.list = new ArrayList<>();
        head.list.add(temp2);
        head.list.add(temp3);
        head.list.add(temp4);
    }

    void BFS() {
        Queue<NaryNode> myQueue = new ArrayDeque();
        myQueue.add(head);
        while(!myQueue.isEmpty()) {
            NaryNode temp = myQueue.remove();
            System.out.print(temp.data+ ", ");
            if(temp.list!=null){
                for(NaryNode listElement: temp.list)
                    myQueue.add(listElement);
            }

        }
    }


    public static void main(String args[]) {
        NAryExample ex = new NAryExample();
        ex.insert();
        ex.BFS();
    }
}
