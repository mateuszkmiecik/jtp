package converter;

import contact.Contact;
import enums.CSVFields;

import java.io.*;
import java.util.*;

/**
 * Created on 31.03.14.
 *
 * @author mk
 */
public class Converter {

    String importDir;
    String exportDir;

    File[] files;

    Scanner userInput = new Scanner(System.in);

    Map<String, Contact> contacts = new HashMap<String, Contact>();
    SortedSet<String> keys;

    public Converter(String importDir, String exportDir) {

        this.importDir = importDir;
        this.exportDir = exportDir;

        File file = new File("./import/");
        // Reading directory content
        files = file.listFiles();

    }

    public void convert(){
        BufferedReader br = null;
        String line = null;
        String split = ",";

        for (File f : files) {
            try {

                br = new BufferedReader(new FileReader(f));

                while( (line = br.readLine()) != null){

                    // single line in file
                    String[] contact = line.split(split, 3); // 3 fields

                    String name = contact[CSVFields.NAME];
                    String number = contact[CSVFields.NUMBER];
                    String mail = contact[CSVFields.MAIL];
                    Integer occurence;

                    Contact tmp = contacts.get(name);
                    if(tmp != null){
                        // found, resolve any conflicts

                        occurence = tmp.getOccurrence() + 1;

                        // number
                        if(!tmp.getNumber().equals(contact[CSVFields.NUMBER])){

                            if(tmp.getNumber().isEmpty()){

                                number = contact[CSVFields.NUMBER];

                            } else if ( contact[CSVFields.NUMBER].isEmpty() ){

                                number = tmp.getNumber();

                            } else {
                                // resolve conflict

                                String[] options = { tmp.getNumber(), contact[CSVFields.NUMBER] };

                                System.out.println("Conflict for: " + contact[CSVFields.NAME]);
                                System.out.println("[0] - " + tmp.getNumber());
                                System.out.println("[1] - " + contact[CSVFields.NUMBER]);
                                Integer input = -1;
                                while(input < 0 || input > 1){
                                    System.out.print("Which field is correct: ");
                                    input = userInput.nextInt();
                                }
                                number = options[input];

                            }
                        }

                        // mail
                        if(!tmp.getMail().equals(contact[1])){

                            if(tmp.getMail().isEmpty()){

                                mail = contact[CSVFields.MAIL];

                            } else if ( contact[CSVFields.MAIL].isEmpty() ){

                                mail = tmp.getMail();

                            } else {
                                // resolve conflict

                                String[] options = { tmp.getMail(), contact[CSVFields.MAIL] };

                                System.out.println("Conflict for: " + contact[CSVFields.NAME]);
                                System.out.println("[0] - " + tmp.getMail());
                                System.out.println("[1] - " + contact[CSVFields.MAIL]);
                                Integer input = -1;
                                while(input < 0 || input > 1){
                                    System.out.print("Which field is correct: ");
                                    input = userInput.nextInt();
                                }
                                mail = options[input];

                            }
                        }

                        contacts.put(name, new Contact(number, mail, occurence));

                    }else{
                        // not found
                        contacts.put(contact[CSVFields.NAME], new Contact(contact[CSVFields.NUMBER], contact[CSVFields.MAIL], 1));
                    }

                }


            } catch (Exception e){
                e.printStackTrace();
            } finally {

                if (br != null) try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public void export(){
        File fileExport = new File(exportDir + "export.csv");
        try {

            System.out.println("--------------");
            System.out.println("Exporting file");
            System.out.println("--------------");

            if (fileExport.exists()) {
                fileExport.delete();
            }
            fileExport.createNewFile();

            FileWriter fw = new FileWriter(fileExport.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            keys = new TreeSet<String>(contacts.keySet());
            for (String key : keys) {
                Contact value = contacts.get(key);
                String newLine = key + ","
                        + value.getMail() + ","
                        + value.getNumber() + "\n";
                bw.write(newLine);
                System.out.println(key + ": " + value.getOccurrence());
            }

            bw.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printOccurencies(){
        for (String key : keys) {
            Contact value = contacts.get(key);
            System.out.println(key + ": " + value.getOccurrence());
        }

    }


}
