package village;

import com.google.common.collect.Iterables;
import depot.Depot;
import utils.Grapher;
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
    private List quarrymen = new ArrayList();
    private List builders = new ArrayList();

    public Village() {
    }


    Scanner in = new Scanner(System.in);

    public void startLife() throws InterruptedException {

        printVillage();

        boolean running = true;

        while(running){
            String[] args = getCommand();

            if (args[0].equals("stats")) {
                printVillage();
            } else if (args[0].equals("add")) {
                String[] newArgs = Arrays.copyOfRange(args, 1, args.length);
                commandAdd(newArgs);
            } else if (args[0].equals("remove")) {
                String[] newArgs = Arrays.copyOfRange(args, 1, args.length);
                commandRemove(newArgs);
            } else if (args[0].equals("exit")) {
                running = false;
                doExit();
            } else {
                System.out.println("Unknown command. Check README for help.");
            }

        }
    }

    private void printWorkers(){
        System.out.print(ansi().render(
                "Foresters: @|green " + foresters.size() + "|@ "));
        System.out.print(ansi().render(
                "Fishermen: @|blue " + fishermen.size() + "|@ "));
        System.out.print(ansi().render(
                "Builders: @|red " + builders.size() + "|@ "));
        System.out.print(ansi().render(
                "Woodcutters: @|yellow " + woodcutters.size() + "|@ "));
        System.out.println(ansi().render(
                "Quarrymen: @|white " + quarrymen.size() + "|@ "));
    }

    private void printVillage(){

        depot.printDepot();
        printWorkers();
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
            System.out.println("Available workers for: fish, wood, stone, tree, house");
        } else {
            if(args[0].equals("fish")){
                Fisherman f = new Fisherman();
                fishermen.add(f);
                f.start();

                printVillage();
                return;
            }

            if(args[0].equals("wood")){
                Woodcutter w = new Woodcutter();
                woodcutters.add(w);
                w.start();

                printVillage();
                return;
            }

            if(args[0].equals("stone")){
                Quarryman w = new Quarryman();
                quarrymen.add(w);
                w.start();

                printVillage();
                return;
            }

            if(args[0].equals("house")){
                Builder w = new Builder();
                builders.add(w);
                w.start();

                printVillage();
                return;
            }

            if(args[0].equals("tree")){
                Forester w = new Forester();
                foresters.add(w);
                w.start();

                printVillage();
                return;
            }

            System.out.println("Usage: add [worker]");
            System.out.println("Available workers for: fish, wood, stone, tree, house");
        }
    }

    private void commandRemove(String[] args){
        if (args.length == 0){
            System.out.println("Usage: remove [worker]");
            System.out.println("Available workers for: fish, wood, stone, tree, house");
        }else{

            if(args[0].equals("wood")){
                if(woodcutters.size() > 0){
                    Woodcutter w = (Woodcutter)woodcutters.get(0);
                    w.terminate();
                    woodcutters.remove(0);

                    printVillage();
                    return;
                }
            }
            if(args[0].equals("fish")){
                if(fishermen.size() > 0){
                    Fisherman f = (Fisherman)fishermen.get(0);
                    f.terminate();
                    fishermen.remove(0);

                    printVillage();
                    return;
                }
            }
            if(args[0].equals("stone")){
                if(quarrymen.size() > 0){
                    Quarryman f = (Quarryman)quarrymen.get(0);
                    f.terminate();
                    quarrymen.remove(0);

                    printVillage();
                    return;
                }
            }
            if(args[0].equals("tree")){
                if(foresters.size() > 0){
                    Forester f = (Forester)foresters.get(0);
                    f.terminate();
                    foresters.remove(0);

                    printVillage();
                    return;
                }
            }
            if(args[0].equals("house")){
                if(builders.size() > 0){
                    Builder f = (Builder)builders.get(0);
                    f.terminate();
                    builders.remove(0);

                    printVillage();
                    return;
                }
            }
        }
    }

    private void doExit(){
        while(builders.size() > 0){
            Builder f = (Builder)builders.get(0);
            f.terminate();
            builders.remove(0);
        }
        while(foresters.size() > 0){
            Forester f = (Forester)foresters.get(0);
            f.terminate();
            foresters.remove(0);
        }
        while(quarrymen.size() > 0){
            Quarryman f = (Quarryman)quarrymen.get(0);
            f.terminate();
            quarrymen.remove(0);
        }
        while(fishermen.size() > 0) {
            Fisherman f = (Fisherman) fishermen.get(0);
            f.terminate();
            fishermen.remove(0);
        }
        while(woodcutters.size() > 0){
            Woodcutter w = (Woodcutter)woodcutters.get(0);
            w.terminate();
            woodcutters.remove(0);
        }

        Grapher.makeGraph();
    }
}
