package Graph2;

/**
 * Created by ajothomas on 11/11/17.
 */
public class GraphImplementation {
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
        n2.addEdge(n0);
        n2.addEdge(n3);
        n3.addEdge(n3);
        graph.addNode(n0);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        //graph.BFS(n2);
        graph.DFS(n2);
    }
}
