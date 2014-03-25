package depot;
import enums.Volume;
import exceptions.*;
import products.*;

import java.util.ArrayList;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class Depot implements DepotInterface {
    final static int maxProductsInDepot = 3;
    private ArrayList<Product> products;

    /**
     * Domyślny konstruktor.
     */
    public Depot() {
        this.products = new ArrayList<Product>();
    }

    public final void prepare(){
        Product a = new Vodka("Sobieski", Volume.LITER.getVolume(), 39.50);
        Product b = new Beer("Na miodzie gryczanym", Volume.HALF.getVolume(), 5.50);
        Product c = new Beer("Na miodzie gryczanym", Volume.HALF.getVolume(), 5.50);
        Product d = new Beer("Lech", Volume.HALF.getVolume(), 2.50);

        try {
            put(a);
            put(b);
        } catch (Exception e){
            System.out.println(e);
        }
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

    /**
     * Zwraca aktualna ilosc produktow w magazynie.
     * @return
     */
    public int currentSize(){
        return products.size();
    }

    private Product find(String name) throws NotFoundInDepotException {
        for(Product product : products) {
            if(product.getName().equals(name)) return product;
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
