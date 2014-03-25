package exceptions;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class NotFoundInDepotException extends Exception {
    public String toString() {
        return "Product not found in depot.";
    }
}
