package examPrep150817;

import java.util.*;

/**
 * 15/09/2017
 */
public class Bridges {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] bridges = sc.nextLine().split("\\s+");

    List<String> found = new ArrayList<>();
    Set<Integer> idx = new HashSet<>();

    int lastBridge = 0;

    for (int i = 0; i < bridges.length; i++) {

      for (int j = lastBridge; j < i; j++) {

        String start = bridges[j];
        String end = bridges[i];

        if (start.equals(end)) {
          lastBridge = i;
          found.add(start + " " + end);
          idx.add(i);
          idx.add(j);
        }
      }
    }
    StringJoiner sj = new StringJoiner(" ");
    for (int i = 0; i < bridges.length; i++) {

      String bridge = bridges[i];
      if (idx.contains(i)) {
        sj.add(bridge);
      } else {
        sj.add("X");

      }
    }
    int numOfB = found.size();
    String s = numOfB > 1 ? "bridges" : "bridge";
    String text = String.format("%d %s found", numOfB, s);

    System.out.println(numOfB > 0 ? text : "No bridges found");
    System.out.println(sj.toString());
  }
}
