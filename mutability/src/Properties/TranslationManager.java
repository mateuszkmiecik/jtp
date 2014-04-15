package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created on 15.04.14.
 *
 * @author mk
 */
public class TranslationManager {

    public static String getSentence(String key) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("lang.properties");
            prop.load(input);
        } catch (IOException e) {
            System.out.println("problem with IO");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("problem with IO");
                }
            }
        }
        String language = prop.getProperty("language");
        Properties words = new Properties();
        try {
            input = new FileInputStream("langs/" + language + ".properties");
            words.load(input);
        } catch (IOException e) {
            System.out.println("problem with IO");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("problem with IO");
                }
            }
        }

        return words.getProperty(key);
    }
}
