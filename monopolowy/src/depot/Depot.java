package depot;
import exceptions.*;
import products.*;

import java.util.ArrayList;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class Depot implements DepotInterface {
    final static int maxProductsInDepot = 100;
    private ArrayList<Product> products;

    /**
     * Domyślny konstruktor.
     */
    public Depot() {
        this.products = new ArrayList<Product>();
    }

    /**
     * Metoda dodaje produkt do magazynu.
     * @param product Produkt.
     * @throws FullDepotException Magazyn jest pełny.
     */
    public void put(Product product) throws FullDepotException {
        if(products.size() == maxProductsInDepot) throw new FullDepotException();

        products.add(product);
    }

    private Product find(String name) throws NotFoundInDepotException {
        for(Product product : products) {
            if(product.getName() == name) return product;
        }

        throw new NotFoundInDepotException();
    }

    public Product take(String name) throws NotFoundInDepotException {
        Product product = this.find(name);
        products.remove(product);
        return product;
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
