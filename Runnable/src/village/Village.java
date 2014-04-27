package village;

import workers.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 27.04.14.
 *
 * @author mk
 */
public class Village {


    public Village() {
    }

    public void startLive() throws InterruptedException {

        new Fisherman(1).start();
        Thread.sleep(400);
        new Fisherman(2).start();
    }
}
