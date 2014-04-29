package utils;

import org.jfree.data.time.SimpleTimePeriod;

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

    public ArrayList<SimpleTimePeriod> woodTimes = new ArrayList<SimpleTimePeriod>();
    public ArrayList<SimpleTimePeriod> fishTimes = new ArrayList<SimpleTimePeriod>();
    public ArrayList<SimpleTimePeriod> stoneTimes = new ArrayList<SimpleTimePeriod>();
    public ArrayList<SimpleTimePeriod> treeTimes = new ArrayList<SimpleTimePeriod>();
    public ArrayList<SimpleTimePeriod> houseTimes = new ArrayList<SimpleTimePeriod>();

}
