package workers;

import depot.Depot;

import java.util.Date;

/**
 * Created on 27.04.14.
 *
 * @author mk
 */
public class Fisherman extends Thread {

    private int id;
    private Depot depot = Depot.getInstance();

    public Fisherman(int id) {
        super();
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            depot.setFish(depot.getFish() + 1);
            System.out.println(depot.getFish());
            try {
                //usypiamy wątek na 100 milisekund
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
