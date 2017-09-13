package graphs;

/**
 * 06/08/2017
 */
public class SimpleGraph {
    private int v;
    private Bag<Integer>[] adj;


    public SimpleGraph(int v) {
        this.v = v;
        this.adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(v);
        adj[w].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int getV() {
        return v;
    }
}