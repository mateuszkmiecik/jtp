import java.io.*;
import java.util.*;
import enums.*;

/**
 * Created on 31.03.14.
 *
 * @author mk
 */
public class PhonebookConverter {

    public static void main (String[] argv){

        Scanner userInput = new Scanner(System.in);


        File file = new File("./import/");
        // Reading directory contents
        File[] files = file.listFiles();


        /* variables */
        BufferedReader br = null;
        String line = null;
        String split = ",";

        Map<String, Contact> contacts = new HashMap<String, Contact>();


        for (File f : files) {
            try {

                br = new BufferedReader(new FileReader(f));

                while( (line = br.readLine()) != null){

                    // single line in file
                    String[] contact = line.split(split, 3); // 3 fields

                    String name = contact[CSVFields.NAME];
                    String number;
                    String mail;
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

                                System.out.println("Conflict for: " + contact[CSVFields.NAME] + "");
                                System.out.println("[0] - " + tmp.getNumber());
                                System.out.println("[1] - " + contact[CSVFields.NUMBER]);
                                Integer input = -1;
                                while(input < 0 || input > 1){
                                    System.out.print("Which field is correct: ");
                                    input = userInput.nextInt();
                                }
                                System.out.println(input);


                            }
                        }

                        // mail
                        if(!tmp.getMail().equals(contact[1])){



                        }


                    }else{
                        // not found
                        contacts.put(contact[0], new Contact(contact[2], contact[1], 1));
                    }

                }


            } catch (Exception e){
                e.printStackTrace();
            } finally {

                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

        /*for(Map.Entry<String, Contact> entry : contacts.entrySet()){
            System.out.println("LUDZ [imie= " + entry.getKey() + " , object="
                    + entry.getValue().getNumber() + "]");
        }*/


    }

}
