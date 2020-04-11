package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int vertices;   // No. of vertices
    private LinkedList<Integer>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];
        for (int i=0; i<vertices; ++i)
            adjList[i] = new LinkedList<Integer>();
    }

    private void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.printBFS(2);
        System.out.println();
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 0)");
        g.printDFS(0);
    }

    // prints BFS traversal from a given source s
    private void printBFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited [] = new boolean[this.vertices];
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    private void printDFS(int v) {
// Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[vertices];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }

    }

}
