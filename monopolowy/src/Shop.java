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
        Product a = new Vodka("Sobieski", Volume.LITER.getVolume(), 39.50);
        Product b = new Beer("Na miodzie gryczanym", Volume.HALF.getVolume(), 5.50);
        Product c = new Beer("Na miodzie gryczanym", Volume.HALF.getVolume(), 5.50);
        Product d = new Beer("Lech", Volume.HALF.getVolume(), 2.50);

        DepotInterface depot = new Depot();
        try {
            depot.put(a);
            depot.put(b);
            depot.put(c);
            depot.take("Lech");
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(depot);
    }
}

