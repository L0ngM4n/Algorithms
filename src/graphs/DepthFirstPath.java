package graphs;

import java.util.Stack;

/**
 * 06/08/2017
 */
public class DepthFirstPath {

    private int s;
    private boolean[] visited;
    private int[] previous;

    public DepthFirstPath(Graph graph, int s) {

        this.s = s;
        this.visited = new boolean[graph.getV()];
        this.previous = new int[graph.getV()];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        visited[v] = true;
        for (Integer w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(graph, w);
                previous[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public Iterable<Integer> getPathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();

        for (int x = v; x != this.s ; x = previous[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
