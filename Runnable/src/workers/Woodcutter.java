package workers;

import depot.Depot;

/**
 * Created on 28.04.14.
 *
 * @author mk
 */
public class Woodcutter extends Thread {

    private Depot depot = Depot.getInstance();

    public Woodcutter() {
        super();
    }

    @Override
    public void run() {
        while(true) {
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

}
