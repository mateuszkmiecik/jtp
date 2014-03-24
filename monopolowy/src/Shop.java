import products.*;
import depot.*;
import exceptions.*;

import java.util.ArrayList;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class Shop {

    public static void main(String[] args){
        Product a = new Vodka("Sobieski", 0.7, 39.50);
        Product b = new Beer("Na miodzie gryczanym", 0.5, 5.50);
        Product c = new Beer("Na miodzie gryczanym", 0.5, 5.50);

        DepotInterface depot = new Depot();
        try {
            depot.put(a);
            depot.put(b);
            depot.put(c);
        } catch (FullDepotException e) {

        }

        System.out.println(depot);
    }
}

