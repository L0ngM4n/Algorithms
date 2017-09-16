package graphs.ConnectedComponentsSkeletonJava;

import java.util.*;

public class Main {

  private static boolean[] visited;

  public static void main(String[] args) {
    List<List<Integer>> graph = readGraph();
    visited = new boolean[graph.size()];

    List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
    for (Deque<Integer> connectedComponent : connectedComponents) {
      System.out.print("Connected component: ");
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
    visited = new boolean[graph.size()];
    List<Deque<Integer>> connComponents = new ArrayList<>();
    for (int i = 0; i < graph.size(); i++) {
      Deque<Integer> connComponent = new ArrayDeque<>();
      if (!visited[i]) {
        connComponent.add(DFS(graph, i, connComponent));
        connComponents.add(connComponent);
      }
    }
    return connComponents;
  }

  private static int DFS(List<List<Integer>> graph, int v, Deque<Integer> connComponent) {
    if (!visited[v]) {
      visited[v] = true;
      for (int i = 0; i < graph.get(v).size(); i++) {

        int currNode =DFS(graph, graph.get(v).get(i), connComponent);
        if(currNode != -1) connComponent.add(currNode);

      }
      return v;
    }
    return -1;
  }

}
