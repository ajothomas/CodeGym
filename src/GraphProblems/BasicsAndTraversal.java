package GraphProblems;
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency
class MyGraph {
    public int V;   // No. of vertices
    public LinkedList<Integer> adj[]; // Adjacency List

    //Constructor
    MyGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void printGraph() {
        for(int v = 0; v < V; v++)
        {
            System.out.print("Adjacency list of vertex "+ v+" : ");
            for(int pCrawl: adj[v]){
                System.out.print(pCrawl+",");
            }
            System.out.println("\n");
        }
    }

    void BFS(int start) {
        System.out.println("\n** BFS **\n");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++) {
            visited[i] = false;
        }
        visited[start] = true;

        while(!queue.isEmpty()) {
            int element = queue.remove();
            System.out.print(element+", ");

            for(int x:adj[element]) {
                if(!visited[x]) {
                    queue.add(x);
                    visited[x] = true;
                }
            }
        }
    }

    void DFS(int start) {
        System.out.println("\n** DFS **\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++) {
            visited[i] = false;
        }
        visited[start] = true;

        while(!stack.isEmpty()) {
            int element = stack.pop();
            System.out.print(element+", ");

            for(int x:adj[element]) {
                if(!visited[x]) {
                    stack.push(x);
                    visited[x] = true;
                }
            }
        }
    }

    void DFSutil(int start, boolean visited[]) {
        System.out.print(start+", ");
        visited[start] = true;

        for(int x: adj[start]) {
            if(!visited[x]) {
                DFSutil( x, visited);
            }
        }
    }

    void DFS_2(int start) {
        System.out.println("\n** DFS **\n");
        boolean visited[] = new boolean[V];
        DFSutil(start, visited);
    }

    boolean isCyclicUtil(int start, boolean visited[], boolean current[]) {

        visited[start] = true;
        current[start] = true;
      //  System.out.println("start "+start+" : "+Arrays.toString(current));

        for(int child:adj[start]) {
            if(!visited[child]) {
                if(current[child])
                    return true;
                if(!isCyclicUtil(child, visited, current))
                    return true;
            }
        }
        current[start] = false;
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[V];
        boolean current[] = new boolean[V];
        for(int i=0;i<V;i++){
            visited[i] = false;
            current[i] = false;
        }

        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                if(isCyclicUtil(i, visited, current))
                    return true;
            }
        }
        return false;
    }
}

public class BasicsAndTraversal {
    public static void main(String args[]) {
        MyGraph g = new MyGraph(4);

//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        //g.BFS(2);
        //g.DFS_2(2);

        if(g.isCyclic())
            System.out.println("Graph has a cycle");
        else
            System.out.println("Graph does not have a cycle");
        //g.printGraph();
    }
}
