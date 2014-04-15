import ObjectTypes.MutsManager;
import Sorter.Sorter;

import Properties.*;

import java.io.*;
import java.util.*;

/**
 * Created on 14.04.14.
 *
 * @author mk
 */
public class Mutability {

    public static void main(String[] argv){

        Sorter s = new Sorter();
        s.sortCSV();


        /*-----*/

        System.out.println(TranslationManager.getSentence("shouldBe"));

        MutsManager MM = new MutsManager();
        MM.testMutable();
        System.out.println();
        MM.testImmutable();

    }
}
