package Graph2;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
/**
 * Created by ajothomas on 11/11/17.
 */
class Node {
    String name;
    List<Node> adjList;

    Node(String name) {
        this.name = name;
        this.adjList = new ArrayList<>();
    }

    void addEdge(Node neighbor) {
        this.adjList.add(neighbor);
    }

    List<Node> getAdjList() {
        return this.adjList;
    }
}


public class MyGraph {
    List<Node> nodeList;
    MyGraph() {
        nodeList = new ArrayList<>();
    }

    void addNode(Node n) {
        nodeList.add(n);
    }

    List<Node> getNodeList() {
       return nodeList;
    }

    void BFS(Node n) {
        System.out.println(" *** BFS *** ");
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(n);
        visited.add(n);

        while(!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.name+", ");

            for(Node neighbor:temp.getAdjList()) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    void DFSUtil(Node start, Set<Node> visited) {
        System.out.print(start.name+", ");
        visited.add(start);
        for(Node neighbor:start.getAdjList()) {
            if(!visited.contains(neighbor)) {
                DFSUtil(neighbor,visited);
            }
        }
    }

    void DFS(Node n) {
        System.out.println(" *** DFS *** ");
        Set<Node> visited = new HashSet<>();

        DFSUtil(n, visited);
    }
}
