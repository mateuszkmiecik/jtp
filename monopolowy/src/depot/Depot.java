package depot;
import exceptions.FullDepotException;
import products.*;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class Depot {
    final static int maxProductsInDepot = 100;
    private Product products[];
    private int currentIndex;

    public Depot() {
        this.products = new Product[maxProductsInDepot];
        currentIndex = 0;
    }

    public void put(Product product) throws FullDepotException {
        try {
            this.products[currentIndex] = product;
            currentIndex++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new FullDepotException();
        }
    }
}
