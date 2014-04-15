import ObjectTypes.MutsManager;
import Sorter.Sorter;

/**
 * Created on 14.04.14.
 *
 * @author mk
 */
public class Mutability {

    public static void main(String[] argv){

        Sorter s = new Sorter();
        s.sortCSV();


        MutsManager MM = new MutsManager();
        MM.testMutable();
        System.out.println();
        MM.testImmutable();

    }
}
