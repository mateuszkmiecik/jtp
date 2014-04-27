/**
 * Created on 27.04.14.
 *
 * @author mk
 */
import org.fusesource.jansi.AnsiConsole;
import village.Village;
import workers.Builder;
import workers.Fisherman;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class App {

    public static void main(String[] args){


        Village village = new Village();
        try {
            village.startLive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//        Runnable[] runners = new Runnable[10];
//        Thread[] threads = new Thread[10];
//
//        for(int i=0; i<10; i++) {
//            runners[i] = new Fisherman(i);
//        }
//
//        for(int i=0; i<10; i++) {
//            threads[i] = new Thread(runners[i]);
//        }
//
//        for(int i=0; i<10; i++) {
//            threads[i].start();
//        }



    }
}
