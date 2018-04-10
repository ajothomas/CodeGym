package Graph2;
import java.util.*;

/**
 * Created by ajothomas on 11/11/17.
 */
public class TPSort {
    public static void TopologicalSortUtil(Node n, Stack<Node> st, Set<Node> visited) {
        visited.add(n);
        for(Node neighbor:n.getAdjList()) {
            if(!visited.contains(neighbor)) {
                TopologicalSortUtil(neighbor, st, visited);
            }
        }
        st.push(n);
    }

    public static void TopologicalSort(MyGraph graph) {

        System.out.println(" *** Topological Sort *** ");
        Stack<Node> st = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for(Node n:graph.getNodeList()) {
            if(!visited.contains(n)) {
                TopologicalSortUtil(n, st, visited);
            }
        }

        while(!st.isEmpty())
            System.out.print(st.pop().name+", ");
    }

    public static void main(String args[]) {
        MyGraph graph = new MyGraph();
        Node n0 = new Node("0");
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");

        // adding neighbors
        n5.addEdge(n2);
        n5.addEdge(n0);
        n4.addEdge(n0);
        n4.addEdge(n1);
        n2.addEdge(n3);
        n3.addEdge(n1);
        graph.addNode(n0);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);

        //graph.BFS(n2);
        TopologicalSort(graph);
    }
}
