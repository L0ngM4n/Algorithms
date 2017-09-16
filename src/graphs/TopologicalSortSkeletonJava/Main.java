package graphs.TopologicalSortSkeletonJava;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Map<String, List<String>> graph = readGraph();
    List<String> topSorted = topSort(graph);
    Collections.reverse(topSorted);
    topSorted.forEach(e -> {
      System.out.print(e + " ");
    });

  }

  protected static List<String> topSort(Map<String, List<String>> graph) {
    Map<String, Integer> predecessorsCount = getPredecessorsCount(graph);

    List<String> removed = new ArrayList<>();
    while (true) {
      String nodeToRemove;
      try {
        nodeToRemove = predecessorsCount.entrySet().stream()
            .filter(e -> e.getValue() == 0)
            .sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()))
            .findFirst().get().getKey();
      } catch (NoSuchElementException e) {
        break;
      }

      for (String child : graph.get(nodeToRemove)) {
        predecessorsCount.put(child, predecessorsCount.get(child) - 1);
      }
      removed.add(nodeToRemove);
      predecessorsCount.remove(nodeToRemove);
      graph.remove(nodeToRemove);

    }

    return removed;
  }

  private static Map<String, Integer> getPredecessorsCount(Map<String, List<String>> graph) {
    Map<String, Integer> predecessorsCount = new HashMap<>();
    for (Map.Entry<String, List<String>> node : graph.entrySet()) {
      if (!predecessorsCount.containsKey(node.getKey())) {
        predecessorsCount.put(node.getKey(), 0);
      }

      for (String child : node.getValue()) {
        if (!predecessorsCount.containsKey(child)) {
          predecessorsCount.put(child, 0);
        }
        predecessorsCount.put(child, predecessorsCount.get(child) + 1);
      }
    }

    return predecessorsCount;
  }

  private static Map<String, List<String>> readGraph() {
    Scanner in = new Scanner(System.in);

    Map<String, List<String>> graph = new HashMap<>();

    while (true) {

      String line = in.nextLine();
      if (line == null || line.isEmpty() || line.equals("")) {
        break;
      }
      String[] vertex = line.split(" -> ");
//      vertex[0] = vertex[0].substring(1, vertex[0].lastIndexOf('"'));

      String[] nodes = vertex.length > 1 ? vertex[1].split(", ") : new String[0];
//      for (int i = 0; i < nodes.length; i++) {
//        String s = nodes[i];
//        nodes[i] = s.substring(1, s.lastIndexOf('"'));
//      }

      graph.put(vertex[0], Arrays.asList(nodes));
    }
    return graph;
  }
}
