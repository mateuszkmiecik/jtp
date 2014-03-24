import products.*;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class Shop {

    public static void main(String[] args){
        Product a = new Vodka("Sobieski", 0.7, 39.50);
        Product b = new Beer("Na miodzie gryczanym", 0.5, 5.50);

        System.out.println(a);
        System.out.println(b);
    }
}
