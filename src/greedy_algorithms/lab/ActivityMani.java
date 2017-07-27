package greedy_algorithms.lab;

import java.util.ArrayList;
import java.util.List;

/**
 * 27/07/2017
 */
public class ActivityMani {

  public static void main(String[] args) {

    List<Activity> activities = new ArrayList<Activity>() {{
      add(new Activity(1, 4));
      add(new Activity(12, 14));
      add(new Activity(3, 5));
      add(new Activity(2, 13));
      add(new Activity(0, 6));
      add(new Activity(8, 12));
      add(new Activity(5, 7));
      add(new Activity(8, 11));
      add(new Activity(3, 8));
      add(new Activity(6, 10));
      add(new Activity(5, 9));
    }};

    activities.sort((o1, o2) -> o1.getFinish() <= o2.getFinish() ? -1 : 1);


  Activity lastActivity = activities.get(0);
      System.out.println(lastActivity);


    while (activities.size() > 0) {
      Activity current = activities.get(0);
      activities.remove(current);

      if (current.getStart() >= lastActivity.getFinish()) {
        lastActivity = current;
        System.out.println(lastActivity);

      }
    }


  }
}
