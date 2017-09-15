package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 14/09/2017
 */
public class Robbery {

    static boolean[] color;
    static int[] stepsTo;
    static int[] distTo;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        color = new boolean[input.length];

        for (int i = 0; i < color.length; i++) {
            color[i] = input[i].substring(input[i].length() - 1).equals("w");
        }
        int energy = Integer.parseInt(sc.nextLine());
        int waitCost = Integer.parseInt(sc.nextLine());
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());
        int edgeCount = Integer.parseInt(sc.nextLine());

        List<Node>[] graph = initGraph(input);
        initHelperStructures(graph.length);
        fillGraph(sc, edgeCount, graph);

        dijkstra(graph, start, end, waitCost);
    }


    private static void dijkstra(List<Node>[] graph, int start, int end, int waitCost) {

        distTo[start] = 0;

        int currentVertex = getCurrentVertex();

        while (true) {
            if (currentVertex == -1) {
                break;
            }

            visit(graph, currentVertex, waitCost);
        }

        System.out.println();
    }

    private static void visit(List<Node>[] graph, int vertex, int waitCost) {
        visited[vertex] = true;
        for (Node node : graph[vertex]) {
            
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

    private static void fillGraph(Scanner sc, int edgeCount, List<Node>[] graph) {
        for (int i = 0; i < edgeCount; i++) {
            int[] edgeArgs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeArgs[0];
            int to = edgeArgs[1];
            int weight = edgeArgs[2];

            graph[from].add(new Node(to, weight));
        }
    }

    private static List<Node>[] initGraph(String[] input) {
        List<Node>[] graph = new List[input.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    private static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("%s, %s", to, weight);
        }
    }
}
