package examPrep150817;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 15/09/2017
 */
public class NestedRectangles {
  static List<Rectangle> rectangles = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String command;;

    while (!"End".equals(command = sc.nextLine())) {
      String[] tokens = command.split(" ");
      String name = tokens[0].substring(0, tokens[0].length() - 1);
      int x1 = Integer.parseInt(tokens[1]);
      int x2 = Integer.parseInt(tokens[2]);
      int y1 = Integer.parseInt(tokens[3]);
      int y2 = Integer.parseInt(tokens[4]);

      rectangles.add(new Rectangle(name, x1, x2, y1, y2));

    }

    for (Rectangle rectangle : rectangles) {
      if (rectangle.maxDepth == 0) {
        getDepth(rectangle);
      }
    }

    System.out.println();
  }

  private static void getDepth(Rectangle rectangle) {

    List<Rectangle> innerRectangles = new ArrayList<>();
    for (Rectangle current : rectangles) {
      if (rectangle != current && current.isInsideOf(rectangle)){
        if (current.maxDepth == 0) {
          getDepth(current);
        }
        innerRectangles.add(current);
      }
    }

    if (innerRectangles.size() == 0){
      rectangle.maxDepth = 1;
    } else {
      Rectangle biggest = innerRectangles.stream().sorted(Comparator.naturalOrder()).findFirst().get();
    }
  }

  static class Rectangle implements Comparable<Rectangle> {
    private String name;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public int maxDepth;

    public Rectangle(String name, int x1, int x2, int y1, int y2) {
      this.name = name;
      this.x1 = x1;
      this.x2 = x2;
      this.y1 = y1;
      this.y2 = y2;
    }

    @Override
    public String toString() {
      return name;
    }

    @Override
    public int compareTo(Rectangle o) {
       int result = Integer.compare(this.maxDepth, o.maxDepth);

       if (result == 0) {
           result = this.name.compareTo(o.name);
       }
       return result;
    }

    public boolean isInsideOf(Rectangle oR) {

       return this.x1 >= oR.x1
           && this.y1 <= oR.y1
           && this.x2 <= oR.x2
           && this.y2 >= oR.y2;

    }
  }
}
