import ObjectTypes.Immutable;
import ObjectTypes.Mutable;

import com.google.common.base.Splitter;

import java.io.*;
import java.util.*;



/**
 * Created on 14.04.14.
 *
 * @author mk
 */
public class Mutability {

    public static void main(String[] argv){

        BufferedReader br = null;
        String line = null;

        try {
            br = new BufferedReader(new FileReader(new File("import/file-full.csv")));

            while( (line = br.readLine()) != null){

                Iterable<String> row =
                        Splitter.on(',')
                                .trimResults()
                                .omitEmptyStrings()
                                .split(line);
                Iterator<String> i = row.iterator();
                while(i.hasNext()){
                    System.out.println(i.toString());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        System.out.println(words.getProperty("shouldBe"));

        String s = "ABC";
        Boolean equal = s.equals(s.toLowerCase());

        System.out.println("String s = \"ABC\";");
        System.out.println("check: s.equals(s.toLowerCase())");
        System.out.println("This should be [false]: " + equal);



        System.out.println();


        Mutable tmp = new Mutable();
        System.out.println("This should be different after changes:");
        System.out.print(tmp.getChars());
        System.out.print(" == ");
        char[] a = tmp.getChars();
        a[1] = 'l';
        System.out.println(tmp.getChars());
        System.out.println("Array a[]:");
        System.out.println(a);


        System.out.println();


        Immutable tmp2 = new Immutable();
        System.out.println("This should stay the same after changes:");
        System.out.print(tmp2.getChars());
        System.out.print(" == ");
        char[] b = tmp2.getChars();
        b[1] = 'l';
        System.out.println(tmp2.getChars());
        System.out.println("Array b[]:");
        System.out.println(b);

    }
}
