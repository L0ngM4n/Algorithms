package graphs.exercise030817.shortestPathInMatrix;

/**
 * 11/09/2017
 */
public class Vertex implements Comparable<Vertex> {

    public int row;
    public int col;
    public int value;

    public Vertex(int value, int row, int col) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public String getKey() {
        return String.valueOf(row) + " " + String.valueOf(col);
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.value, o.value);
    }
}
