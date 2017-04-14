package src.GraphProblems;

import java.util.*;

/**
 * Created by ajothomas on 3/21/17.
 */



class MyGraph {
    HashMap<String, TreeSet<String>> myAdjList;
    HashMap<String, Boolean> myVertices;

    int myNumVertices;
    int myNumEdges;

    MyGraph(){
        this.myAdjList = new HashMap<String, TreeSet<String>>();
        this.myVertices = new HashMap<String, Boolean>();
        this.myNumVertices = 0;
        this.myNumEdges = 0;
    }

    void addEdge(String source, String destination){
        if(!myVertices.containsKey(source)){
            myVertices.put(source,false);
            myNumVertices++;

            TreeSet<String> adj = new TreeSet<String>();
            adj.add(destination);
            myAdjList.put(source, adj);
        }
        else {
            TreeSet<String> adj = myAdjList.get(source);
            adj.add(destination);
            myAdjList.put(source, adj);
        }

        if(!myVertices.containsKey(destination)){
            myVertices.put(destination,false);
            myNumVertices++;

            TreeSet<String> adj = new TreeSet<String>();
            adj.add(source);
            myAdjList.put(destination, adj);
        }
        else {
            TreeSet<String> adj = myAdjList.get(destination);
            adj.add(source);
            myAdjList.put(destination, adj);
        }
        myNumEdges++;
    }

    void addVertex(String vertex){
        if(!myVertices.containsKey(vertex)){
            myVertices.put(vertex,false);
            myNumVertices++;
        }
    }

    void resetVisited(){
        Iterator it = myVertices.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String key = (String)pair.getKey();
            myVertices.put(key, false);
        }
    }
    void DFS(String startVertex){
        ArrayList<String> result = new ArrayList<String>();
        resetVisited();
        Stack st = new Stack();
        if(!myVertices.containsKey(startVertex))
            return;

        if(myVertices.get(startVertex))
            return;

        st.push(startVertex);
        myVertices.put(startVertex, true);

        while(!st.empty()) {
            String source = (String)st.pop();
            result.add(source);

            TreeSet<String> adj = myAdjList.get(source);
            Iterator it = adj.iterator();
            while (it.hasNext()) {
                String key = (String)it.next();
                if((boolean)myVertices.get(key)==false){
                    st.push(key);
                    myVertices.put(key, true);
                }
            }

        }

        System.out.println("DFS :: "+result);
    }

    void BFS(String startVertex){
        ArrayList<String> result = new ArrayList<String>();
        resetVisited();

        Queue Q = new LinkedList();
        if(!myVertices.containsKey(startVertex))
            return;

        Q.add(startVertex);
        myVertices.put(startVertex, true);

        while(!Q.isEmpty()) {
            String source = (String)Q.remove();
            result.add(source);

            TreeSet<String> adj = myAdjList.get(source);
            Iterator it = adj.iterator();
            while (it.hasNext()) {
                String key = (String)it.next();
                if((boolean)myVertices.get(key)==false){
                    Q.add(key);
                    myVertices.put(key, true);
                }

            }

        }

        System.out.println("BFS :: "+result);
    }
}

public class GraphImplementation {

    public static void main(String args[]){
        MyGraph myG = new MyGraph();

        myG.addEdge("A", "B");
        myG.addEdge("A", "C");
        myG.addEdge("C", "D");
        myG.addEdge("D", "E");
        myG.addEdge("D", "G");
        myG.addEdge("E", "G");
        myG.addVertex("H");

        myG.DFS("A");
        myG.BFS("A");
    }
}
