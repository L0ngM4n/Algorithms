package greedy_algorithms.lab;

/**
 * 27/07/2017
 */
public class Activity {


    private int start;
    private int finish;

     public Activity(int start, int finish) {
       this.start = start;
       this.finish = finish;
     }

  public int getStart() {
    return start;
  }

  public int getFinish() {
    return finish;
  }

  @Override
  public String toString() {
    return String.format("Start = %d, Finish = %d", start, finish);
  }
}
