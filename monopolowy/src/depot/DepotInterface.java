package depot;

import exceptions.*;
import products.*;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public interface DepotInterface  {

    public void put(Product product)  throws FullDepotException;
    public Product take(String name)  throws NotFoundInDepotException;
    public String toString();

    public void prepare();
    public int currentSize();

}
