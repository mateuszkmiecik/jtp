package Sorter;

import com.google.common.base.Splitter;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.*;

/**
 * Created on 15.04.14.
 *
 * @author mk
 */
public class Sorter {

    public void sortCSV(){
        List<String> list = new ArrayList<String>();
        try {
            List<String> list_tmp = FileUtils.readLines(new File("import/file-full.csv"));
            Collections.sort(list_tmp);
            for(String l : list_tmp){
                Iterable<String> row =
                        Splitter.on(',')
                                .trimResults()
                                .omitEmptyStrings()
                                .split(l);

                list.add(row.iterator().next());
            }

            FileUtils.writeLines(new File("output.txt"), list);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
