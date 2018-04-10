package Graph2;
import java.util.*;

/**
 * Created by ajothomas on 11/11/17.
 */
public class CheckCycle {
    public static boolean checkCycleUtil(Node n, Set<Node> visited, Set<Node> curr) {
        visited.add(n);
        curr.add(n);
        for(Node neighbor:n.getAdjList()) {
            // if the neighbor is not visited, recurse
            if(!visited.contains(neighbor)) {
                return checkCycleUtil(neighbor, visited, curr);
            }
            // check if it is in the current stack
            else if(curr.contains(neighbor)){
                return true;
            }
        }
        curr.remove(n);
        return false;
    }

    public static boolean checkCycle(MyGraph graph) {
        Set<Node> visited = new HashSet<>();
        List<Node> nodeList = graph.getNodeList();
        Set<Node> curr = new HashSet<>();

        for(Node n:nodeList) {
            if(!visited.contains(n)) {
                if(checkCycleUtil(n, visited, curr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        MyGraph graph = new MyGraph();
        Node n0 = new Node("0");
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");

        // adding neighbors
        n0.addEdge(n1);
        n0.addEdge(n2);
        n1.addEdge(n2);
        //n2.addEdge(n0);
        n2.addEdge(n3);
        //n3.addEdge(n0);
        graph.addNode(n0);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        System.out.println(checkCycle(graph));
    }
}
