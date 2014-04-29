package workers;

import depot.Depot;
import org.jfree.data.time.SimpleTimePeriod;
import utils.TimeTracker;

import java.util.Date;

/**
 * Created on 27.04.14.
 *
 * @author mk
 */
public class Builder extends Thread {

    Depot depot = Depot.getInstance();
    private TimeTracker TT = TimeTracker.getInstance();

    private Date startTime;
    private Date endTime;

    public Builder() {
        super();
        startTime = new Date();
    }

    private boolean runner = true;

    @Override
    public void run() {
        while(runner) {
            if(depot.getFish() > 1 && depot.getStone() > 2 && depot.getWood() > 2){
                depot.setFish(depot.getFish()-2);
                depot.setStone(depot.getStone()-3);
                depot.setWood(depot.getWood()-3);
                depot.setHouses(depot.getHouses()+1);
            }
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminate(){
        this.runner = false;
        endTime = new Date();
        TT.houseTimes.add(new SimpleTimePeriod(startTime, endTime));
    }
}
