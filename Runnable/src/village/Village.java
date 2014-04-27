package village;

import com.google.common.collect.Iterables;
import depot.Depot;
import workers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;
import com.google.common.base.Splitter;

/**
 * Created on 27.04.14.
 *
 * @author mk
 */
public class Village {

    private Depot depot = Depot.getInstance();
    private List fishermen = new ArrayList();
    private List woodcutters = new ArrayList();
    private List foresters = new ArrayList();

    public Village() {
    }


    Scanner in = new Scanner(System.in);

    public void startLife() throws InterruptedException {

        printVillage();
        printInfo();

        boolean running = true;

        while(running) {
            String[] args = getCommand();

            if (args[0].equals("stats")) {
                printVillage();
            } else if (args[0].equals("add")) {
                String[] newArgs = Arrays.copyOfRange(args, 1, args.length);
                commandAdd(newArgs);
            } else if (args[0].equals("exit")) {
                running = false;
            } else {
                System.out.println("Unknown command.");
                printInfo();
            }




        }
    }

    private void printWorkers(){
        System.out.print(ansi().render(
                "Fishermen: @|green " + fishermen.size() + "|@ "));
        System.out.print(ansi().render(
                "Woodcutters: @|blue " + woodcutters.size() + "|@ "));
        System.out.println(ansi().render(
                "Foresters: @|red " + foresters.size() + "|@ "));
    }

    private void printVillage(){

        depot.printDepot();
        printWorkers();
    }

    private void printInfo(){
        System.out.println("If you dont know what to do type 'help'");
    }

    private String[] getCommand(){

        String choice = in.nextLine();
        while(choice.isEmpty()){
            choice = in.nextLine();
        }
        Iterable<String> c = Splitter.on(' ').omitEmptyStrings().trimResults().split(choice);
        String[] a = Iterables.toArray(c, String.class);
        return a;
    }

    private void commandAdd(String[] args){
        if(args.length == 0){
            System.out.println("Usage: add [worker]");
            System.out.println("Available workers: fish, wood, stone, forest");
        } else {
            if(args[0].equals("fish")){
                Fisherman f = new Fisherman();
                fishermen.add(f);
                f.start();

                printVillage();
                return;
            }
        }
    }
}
