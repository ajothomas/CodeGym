package GraphProblems;

/**
 * Created by ajothomas on 9/14/17.
 */
import java.util.Stack;
class MyGraph2 extends MyGraph {
    MyGraph2(int v) {
        super(v);
    }

    void topologicalSortUtil(int vertex, boolean visited[], Stack stack) {
        visited[vertex] = true;
        for(int x: adj[vertex]) {
            if(!visited[x]) {
                topologicalSortUtil( x, visited, stack);
            }
        }
        stack.push(vertex);
    }

    void topologicalSort() {
        Stack stack = new Stack();
        boolean visited[] = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+", ");
        }

    }
}
public class TopologicalSort {

    public static void main(String args[]) {
        MyGraph2 g = new MyGraph2(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}
