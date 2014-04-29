package workers;

import depot.Depot;
import org.jfree.data.time.SimpleTimePeriod;
import utils.TimeTracker;

import java.util.Date;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Created on 27.04.14.
 *
 * @author mk
 */
public class Fisherman extends Thread {

    private Depot depot = Depot.getInstance();
    private TimeTracker TT = TimeTracker.getInstance();

    private Date startTime;
    private Date endTime;

    public Fisherman() {
        super();
        startTime = new Date();
    }

    private boolean runner = true;

    @Override
    public void run() {
        while(runner) {
            depot.setFish(depot.getFish() + 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminate(){
        this.runner = false;
        endTime = new Date();
        TT.fishTimes.add(new SimpleTimePeriod(startTime, endTime));
    }

}
