import products.*;
import depot.*;
import exceptions.*;
import enums.*;

import java.util.ArrayList;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class Shop {

    public static void main(String[] args){


        DepotInterface depot = new Depot();
        depot.prepare();

        System.out.println(depot.currentSize()); // powinno byc 2

        try {
            depot.put(new Beer("Lech", Volume.HALF.getVolume(), 3.00));
            System.out.println(depot.currentSize()); // powinno byc 3
            depot.take("Lech");
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(depot.currentSize()); // powinno byc 2

        try {
            depot.take("Lech");
        } catch (Exception e) {
            System.out.println(e); // powinien rzucic NotFoundInDepotException
        }

        try {
            depot.put(new Beer("Lech", Volume.HALF.getVolume(), 3.00));
            depot.put(new Beer("Lech", Volume.HALF.getVolume(), 3.00));
            depot.put(new Beer("Lech", Volume.HALF.getVolume(), 3.00));
        } catch (Exception e) {
            System.out.println(e); // powinien rzucic FullDepotException
        }
    }
}

