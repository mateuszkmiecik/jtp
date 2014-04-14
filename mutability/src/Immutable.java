/**
 * Created on 14.04.14.
 *
 * @author mk
 */
public class Immutable {
    char[] arr = { 'a', 'b', 'c', 'd' };

    public char[] getChars(){
        return arr.clone();
    }
}
