package examPrep150817;

import java.util.*;

/**
 * 15/09/2017
 */
public class MessageSharing {

  private static int lastStep = 0;
  private static Map<String, Integer> visited = new Hashtable<>();
  private static Set<String> left;


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String[] people = sc.nextLine().substring(7).trim().split(", ");
    left = new HashSet<String>(Arrays.asList(people));
    String[] connections = sc.nextLine().substring(12).trim().split(", ");
    String[] starts = sc.nextLine().substring(6).trim().split(", ");

    Map<String, List<String>> graph = new HashMap<>();

    for (String person : people) {
      graph.put(person, new ArrayList<>());
    }
    for (String connection : connections) {
      String[] con = connection.split(" - ");
      String p1 = con[0];
      String p2 = con[1];

     graph.get(p1).add(p2);
     graph.get(p2).add(p1);
    }



    StringJoiner sj = new StringJoiner(", ");
    bfs(graph, starts);

    if (left.size() > 0) {
      for (String s : left) {
        sj.add(s);
      }
      System.out.printf("Cannot reach: %s", sj.toString());
    }else {
      System.out.printf("All people reached in %d steps\n", lastStep);

          visited.entrySet().stream().filter(e -> e.getValue() == lastStep)
              .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
              .forEach(e -> sj.add(e.getKey()));

      System.out.printf("People at last step: %s", sj.toString());
    }


  }

  private static void bfs(Map<String, List<String>> graph, String[] starts) {

    Queue<String> queue = new LinkedList<>();


    for (String start : starts) {

      queue.add(start);
      visited.put(start, 0);
      left.remove(start);
    }

    while (queue.size() > 0) {
      String current = queue.poll();

      if (visited.get(current) > lastStep) {
        lastStep = visited.get(current);
      }
      for (String child : graph.get(current)) {
        if(!visited.containsKey(child)){
          visited.put(child, lastStep + 1);
          left.remove(child);
          queue.add(child);
        }
      }
    }
  }
}
