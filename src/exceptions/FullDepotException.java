package exceptions;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class FullDepotException extends Exception {
    public String toString() {
        return "Depot is full.";
    }
}
