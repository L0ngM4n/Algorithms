package graphs;

/**
 * 09/08/2017
 */
public class ConnectedComponent {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponent(Graph graph) {
        marked = new boolean[graph.getV()];
        id = new int[graph.getV()];
        for (int i = 0; i < graph.getV(); i++) {
        if (!marked[i]) {
            dfs(graph, i);
            count++;
        }

        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count;

        for (Integer w : graph.adj(v)) {
            if (!marked[w]){
                dfs(graph, v);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public int getId(int v) {
        return id[v];
    }
}
