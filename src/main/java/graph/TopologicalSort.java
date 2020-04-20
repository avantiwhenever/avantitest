package graph;

import java.util.LinkedList;

public class TopologicalSort {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List
    class Graph {
        //Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) { adj[v].add(w); }

    public static void main(String args[]) {

    }

}
