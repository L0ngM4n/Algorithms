package examPrep140817._04_Robbery;


import java.util.*;

/**
 * 14/09/2017
 */
public class Robbery {

    static boolean WHITE = true;
    static boolean[] colors;
    static int[] stepsTo;
    static int[] distTo;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        colors = new boolean[input.length];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = input[i].substring(input[i].length() - 1).equals("w");
        }
        int energy = Integer.parseInt(sc.nextLine());
        int waitCost = Integer.parseInt(sc.nextLine());
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());
        int edgeCount = Integer.parseInt(sc.nextLine());

        List<Edge>[] graph = initGraph(input);
        initHelperStructures(graph.length);
        fillGraph(sc, edgeCount, graph);

        dijkstra(graph, start, end, waitCost);

      int resultEnergy = energy - distTo[end];


      if (resultEnergy >= 0) {
        System.out.println(resultEnergy);
      } else {
        System.out.printf("Busted - need %d more energy", Math.abs(resultEnergy));
      }
    }


    private static void dijkstra(List<Edge>[] graph, int start, int end, int waitCost) {



        distTo[start] = 0;
        stepsTo[start] = 0;
        while (true) {
            int currentVertex = getCurrentVertex();
            if (currentVertex == -1) {
                break;
            }

            if (currentVertex == end) {
              break;
            }

            visit(graph, currentVertex, waitCost);
        }

    }

    private static void visit(List<Edge>[] graph, int vertex, int waitCost) {
        visited[vertex] = true;
        for (Edge edge : graph[vertex]) {
          int steps = stepsTo[vertex];
          boolean color = steps % 2 == 0 ? colors[edge.to] : !colors[edge.to];
          int distance = distTo[vertex] + edge.weight + (color ? 0 : waitCost);

          int child = edge.to;
          if( distTo[child] > distance) {
            distTo[child] = distance;
            stepsTo[child] = stepsTo[vertex] + (color ? 1 : 2);
          }
        }
    }

    private static void initHelperStructures(int size) {
        distTo = new int[size];
        stepsTo = new int[size];
        visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            distTo[i] = Integer.MAX_VALUE;
            stepsTo[i] = -1;
        }
    }


    private static int getCurrentVertex() {
        int lowestDist = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < distTo.length; i++) {
            if (!visited[i] && distTo[i] < lowestDist) {
                index = i;
                lowestDist = distTo[i];
            }
        }
        return index;

    }

    private static void fillGraph(Scanner sc, int edgeCount, List<Edge>[] graph) {
        for (int i = 0; i < edgeCount; i++) {
            int[] edgeArgs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeArgs[0];
            int to = edgeArgs[1];
            int weight = edgeArgs[2];

            graph[from].add(new Edge(to, weight));
        }
    }

    private static List<Edge>[] initGraph(String[] input) {
        List<Edge>[] graph = new List[input.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("%s, %s", to, weight);
        }
    }
}
