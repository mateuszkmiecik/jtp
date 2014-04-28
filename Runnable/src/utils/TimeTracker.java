package utils;

import java.util.ArrayList;

/**
 * Created on 29.04.14.
 *
 * @author mk
 */
public class TimeTracker {

    private static TimeTracker Instance = null;

    public static TimeTracker getInstance() {
        if (Instance == null) {
            Instance = new TimeTracker();
        }
        return Instance;
    }

    public ArrayList woodTimes = new ArrayList();
    public ArrayList fishTimes = new ArrayList();
    public ArrayList stoneTimes = new ArrayList();
    public ArrayList treeTimes = new ArrayList();
    public ArrayList houseTimes = new ArrayList();


}
