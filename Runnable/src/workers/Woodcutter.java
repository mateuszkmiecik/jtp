package workers;

import depot.Depot;
import org.jfree.data.time.SimpleTimePeriod;
import utils.TimeTracker;

import java.util.Date;

/**
 * Created on 28.04.14.
 *
 * @author mk
 */
public class Woodcutter extends Thread {

    private Depot depot = Depot.getInstance();
    private TimeTracker TT = TimeTracker.getInstance();

    private Date startTime;
    private Date endTime;

    public Woodcutter() {
        super();
        startTime = new Date();
    }

    private boolean runner = true;

    @Override
    public void run() {
        while(runner) {
            if(depot.getFish() > 0 && depot.getTrees() > 0){
                depot.setFish(depot.getFish()-1);
                depot.setWood(depot.getWood()+1);
                depot.setTrees(depot.getTrees()-1);
            }
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
        TT.woodTimes.add(new SimpleTimePeriod(startTime, endTime));
    }

}
