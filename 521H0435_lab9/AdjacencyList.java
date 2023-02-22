import java.util.*;

public class AdjacencyList {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    public AdjacencyList(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public int countVertex() {
        return V;
    }

    public int countEdge() {
        int count = 0;
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                if (!(adj[i].get(j) < i && adj[adj[i].get(j)].contains(i))) {
                    count++;
                }
            }
        }
        return count;
    }

    public LinkedList<Integer> EnumerateNeighbors(int u) {
        return adj[u - 1];
    }

    public boolean checkNeighbors(int u, int v) {
        if (adj[u - 1].contains(v - 1)) {
            return true;
        }
        return false;
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for (Integer v : adj[i]) {
                System.out.print("->" + v);
            }
            System.out.println();
        }
    }
}
