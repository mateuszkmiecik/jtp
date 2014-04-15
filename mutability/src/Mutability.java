import ObjectTypes.MutsManager;
import Sorter.Sorter;

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

        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("lang.properties");
            prop.load(input);
        } catch (IOException e){
            System.out.println("problem with IO");
        } finally {
            if (input != null){
                try {
                    input.close();
                } catch (IOException e){
                    System.out.println("problem with IO");
                }
            }
        }
        String language = prop.getProperty("language");
        Properties words = new Properties();
        try {
            input = new FileInputStream("langs/"+language+".properties");
            words.load(input);
        } catch (IOException e){
            System.out.println("problem with IO");
        } finally {
            if (input != null){
                try {
                    input.close();
                } catch (IOException e){
                    System.out.println("problem with IO");
                }
            }
        }

        MutsManager MM = new MutsManager();
        MM.testMutable();
        System.out.println();
        MM.testImmutable();

    }
}
