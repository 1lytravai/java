import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrix {
    private int[][] adj;
    private final int NUMBER_OF_VERTICES;

    public AdjacencyMatrix(int vertices) {
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
    }

    public void setEgde(int vertexSource, int vertexDestination,int weight) {
        try {
            adj[vertexSource][vertexDestination] = weight;
            adj[vertexDestination][vertexSource] = weight;
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("The vertex is invalid");
        }
    }

    public int getEgde(int vertexSource, int vertexDestination) {
        try {
            return adj[vertexSource][vertexDestination];
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("The vertex is invalid");
        }
        return -1;
    }

    public int countVertex() {
        return NUMBER_OF_VERTICES;
    }

    public int countEdges() {
        int temp[][] = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                temp[i][j] = adj[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                if (temp[i][j] == 1) {
                    count++;
                    temp[j][i] = 0;
                }
            }
        }
        return count;
    }

    // đỉnh truyển vào là 1 thì trong mảng là 0
    public ArrayList<Integer> EnumerateNeighbors(int vertex) {
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        System.out.println(getEgde(1, 0));

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if (adj[vertex - 1][i] == 1) {

                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public boolean checkNeighbors(int vertex, int neighbors) {
        if (getEgde(vertex, neighbors) == 1) {
            return true;
        }
        return false;
    }

    public void printGraph() {
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {

            int x = queue.poll();
            System.out.print(x + " ");

            for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if (adj[x][i] != 0 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DFS_recur(int v, boolean[] visited) {
        visited[v] = true;

        System.out.print(v + " ");

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if (adj[v][i] != 0 && visited[i] == false) {
                DFS_recur(i, visited);
            }
        }
    }

    public void DFS(int s) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        DFS_recur(s, visited);
    }

    public void DFS_norecurse(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Stack<Integer> stack = new Stack<Integer>();
        visited[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if (visited[i] == false && adj[stack.peek()][i] != 0) {
                    visited[i] = true;
                    stack.push(i);
                    i = 0;
                }
            }
            System.out.print(stack.pop() + " ");
        }
    }

    public boolean isReachable(int u, int v){
        if(adj[u][v]==1 && adj[v][u]==1)
            return true;
        return false;
    }
}