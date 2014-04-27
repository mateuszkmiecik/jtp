package workers;

import depot.Depot;

import java.util.Date;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Created on 27.04.14.
 *
 * @author mk
 */
public class Fisherman extends Thread {

    private int id;
    private Depot depot = Depot.getInstance();

    public Fisherman() {
        super();
    }

    @Override
    public void run() {
        while(true) {
            depot.setFish(depot.getFish() + 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
