package workers;

import depot.Depot;

/**
 * Created on 28.04.14.
 *
 * @author mk
 */
public class Quarryman extends Thread {
    private Depot depot = Depot.getInstance();

    public Quarryman() {
        super();
    }

    @Override
    public void run() {
        while(true) {
            if(depot.getFish() > 0){
                depot.setFish(depot.getFish()-1);
                depot.setStone(depot.getStone()+1);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
