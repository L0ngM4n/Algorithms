package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 06/08/2017
 */
public class BreathFirstPath {

    private boolean[] visited;
    private int[] previous;

    public BreathFirstPath(Graph graph, int s) {
        this.visited = new boolean[graph.getV()];
        this.previous = new int[graph.getV()];

        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

    }
}
