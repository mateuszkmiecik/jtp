package workers;

import depot.Depot;

/**
 * Created on 28.04.14.
 *
 * @author mk
 */
public class Forester extends Thread {
    private Depot depot = Depot.getInstance();

    public Forester() {
        super();
    }

    private boolean runner = true;

    @Override
    public void run() {
        while(runner) {
            if(depot.getFish() > 0){
                depot.setFish(depot.getFish()-1);
                depot.setTrees(depot.getTrees()+1);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminate(){
        this.runner = false;
    }

}
