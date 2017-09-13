package graphs.exercise030817.shortestPathInMatrix;

import java.util.*;

/**
 * 11/09/2017
 */
public class ShortestPathInMatrix {

    public static void main(String[] args) {
        Map<Vertex, List<Vertex>> graph = new HashMap<>();
        MyGraphById myGraph = new MyGraphById();

        int[][] matrix = readMatrix();

        buildGraph(myGraph, matrix);

        System.out.println();

    }

    private static void buildGraph(MyGraphById graph, int[][] matrix) {

        int row = matrix.length;
        for (int r = 0; r < row; r++) {
            int col = matrix[r].length;

            for (int c = 0; c < col; c++) {
                int value = matrix[r][c];
                Vertex vertex = new Vertex(value, r, c);

                graph.addVertex(vertex);

                graph.addChildren(vertex.getKey(), getChildren(matrix, r, c));

            }
        }

    }

    private static boolean isInMatrix(int[][] matrix, int row, int col) {

        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }

    private static List<Vertex> getChildren(int[][] matrix, int row, int col) {

        List<Vertex> children = new ArrayList<>();
        int up = row + 1;
        if(isInMatrix(matrix, up, col)) {

            Vertex above = new Vertex(matrix[up][col], up, col);
            children.add(above);
        }
        int down = row - 1;
        if(isInMatrix(matrix, down, col)) {
            Vertex below = new Vertex(matrix[down][col], down, col);
            children.add(below);
        }
        int left = col - 1;
        if(isInMatrix(matrix, row, left)) {
            Vertex toTheLeft = new Vertex(matrix[row][left], row, left);
            children.add(toTheLeft);
        }
        int right = col + 1;
        if(isInMatrix(matrix, row, right)) {
            Vertex toTheLeft = new Vertex(matrix[row][right], row, right);
            children.add(toTheLeft);
        }

        return children;
    }

    private static int[][] readMatrix() {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int col = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {

            matrix[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

}
