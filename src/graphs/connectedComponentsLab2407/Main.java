package graphs.connectedComponentsLab2407;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> graph = readGraph();

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.println(connectedComponent);
        }
    }

    private static List<List<Integer>> readGraph() {
        Scanner in = new Scanner(System.in);

        List<List<Integer>> graph = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            List<Integer> connectedComponents = new ArrayList<>();

            String line = in.nextLine();
            if (line.equals("")) {
                graph.add(connectedComponents);
                continue;
            }
            String[] nodes = line.split(" ");

            for (String node : nodes) {
                connectedComponents.add(Integer.parseInt(node));
            }

            graph.add(connectedComponents);
        }
        return graph;
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean visited[] = new boolean[graph.size()];
        List<Deque<Integer>> connectedComponents = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]) {
                continue;
            }

            Deque<Integer> connected = new ArrayDeque<>();
            dfs(graph, i, visited, connected);
            connectedComponents.add(connected);
        }
        return connectedComponents;
    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited, Deque<Integer> connected) {
        if (visited[node]) {
            return;
        }
        connected.add(node);
        visited[node] = true;
        for (Integer child : graph.get(node)) {

            dfs(graph, child, visited, connected);
        }



    }
}
