package examPrep140817._03_Sticks;

import java.util.*;

/**
 * 14/09/2017
 */
public class Sticks {

  private static Map<Integer, Set<Integer>> graph;
  private static SortedMap<Integer, Set<Integer>> reversed;

  public static void main(String[] args) {

    readGraph();

    Stack<Integer> result = topSort();
    StringJoiner sj = new StringJoiner(" ");
    for (Integer integer : result) {
      sj.add(String.valueOf(integer));
    }
    if (reversed.size() > 0) {
      System.out.println("Cannot lift all sticks");
    }
    System.out.println(sj.toString());
  }

  private static Stack<Integer> topSort() {
    Stack<Integer> result = new Stack<>();
    while (true) {
      Optional optional = reversed.entrySet().stream().filter(e -> e.getValue().size() == 0)
          .sorted((e1, e2) -> -Integer.compare(e1.getKey(), e2.getKey())).findFirst();

      if (!optional.isPresent()) {
        break;
      }

      int v = ((Map.Entry<Integer, Set<Integer>>) optional.get()).getKey();

      for (Integer child : graph.get(v)) {
        reversed.get(child).remove(v);
      }
      result.push(v);
      reversed.remove(v);
    }

    return result;
  }

  private static void readGraph() {
    Scanner sc = new Scanner(System.in);
    int vCount = Integer.parseInt(sc.nextLine());
    int nCount = Integer.parseInt(sc.nextLine());
    initGraphs(vCount);

    for (int i = 0; i < nCount; i++) {
      int[] node = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      graph.get(node[0]).add(node[1]);
      reversed.get(node[1]).add(node[0]);
    }

  }

  private static void initGraphs(int vCount) {
    graph = new HashMap<>();


    reversed = new TreeMap<>();
    for (int i = 0; i < vCount; i++) {
      graph.put(i, new HashSet<>());
      reversed.put(i, new HashSet<>());
    }

  }
}
