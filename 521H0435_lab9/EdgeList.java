import java.util.LinkedList;
import java.util.Vector;

class IntegerTriple {
    private Integer weight;
    private Integer source;
    private Integer dest;

    public IntegerTriple(Integer w, Integer s, Integer d) {
        weight = w;
        source = s;
        dest = d;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getSource() {
        return source;
    }

    public Integer getDest() {
        return dest;
    }

    @Override
    public String toString() {
        return weight + " " + source + " " + dest;
    }
}

public class EdgeList {

    private Vector<IntegerTriple> edges;

    public EdgeList() {
        edges = new Vector<IntegerTriple>();
    }

    public void addEdge(int w, int u, int v) {
        edges.add(new IntegerTriple(w, u, v));
    }

    public void printGraph() {
        for (int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i));
        }
    }

    public int countVertext() {
        LinkedList<Integer> temp = new LinkedList<Integer>();
        for (int i = 0; i < edges.size(); i++) {
            if (!temp.contains(edges.get(i).getDest())) {
                temp.add(edges.get(i).getDest());
            }
            if (!temp.contains(edges.get(i).getSource())) {
                temp.add(edges.get(i).getSource());
            }
        }
        return temp.size();
    }

    public int countEdge() {
        return edges.size();
    }

    public LinkedList<Integer> EnumerateNeighbors(int u) {
        LinkedList<Integer> temp = new LinkedList<Integer>();
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getDest() == u) {
                temp.add(edges.get(i).getSource());
            }
            if (edges.get(i).getSource() == u) {
                temp.add(edges.get(i).getDest());
            }
        }
        return temp;
    }

    public boolean checkNeighbors(int u, int v) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getDest() == u && edges.get(i).getSource() == v) {
                return true;
            }
            if (edges.get(i).getDest() == v && edges.get(i).getSource() == u) {
                return true;
            }
        }
        return false;
    }
}