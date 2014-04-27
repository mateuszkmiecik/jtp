package workers;

import depot.Depot;

import java.util.Date;

/**
 * Created on 27.04.14.
 *
 * @author mk
 */
public class Builder extends Thread {

    Depot depot = Depot.getInstance();
    public void run(){
        Date date = new Date();
        System.out.println(date.getTime());
    }
}
