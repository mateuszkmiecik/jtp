package sermaker;

import java.io.*;
import java.util.logging.Logger;

/**
 * Created on 07.04.14.
 *
 * @author mk
 */
public class Serializer {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    public Employee emp;
    public Serializer() {
        emp = new Employee();
        emp.setEmployeeId(101);
        emp.setDepartment("Google");
        emp.setEmployeeName("Maciek");


    }

    public void create(){
        try {
            File f = new File("employee.ser");
            f.createNewFile();

            FileOutputStream fileOut = new FileOutputStream(f);
            LOGGER.info(f.getAbsolutePath());
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(emp);
            outStream.close();
            fileOut.close();
        } catch (Exception e){}
    }

    public void deserialize(File f){

        Employee emp = null;
        try {
            FileInputStream fileIn = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e){
            LOGGER.severe("File not found.");
        } catch (IOException e){
            LOGGER.severe("IO error happened.");
        } catch (ClassNotFoundException e){
            LOGGER.severe("Class not found");
        }

        LOGGER.info("Name: " + emp.getEmployeeName() + " [id: " + emp.getEmployeeId() + "]");

    }
}
