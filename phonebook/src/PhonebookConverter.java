
import converter.Converter;

/**
 * Created on 31.03.14.
 *
 * @author mk
 */
public class PhonebookConverter {

    public static void main (String[] argv){

        Converter CSVConv = new Converter("./import/", "./export/");

        CSVConv.convert();
        CSVConv.export();

        CSVConv.printOccurencies();

    }
}
