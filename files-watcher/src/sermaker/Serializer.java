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



    }
}
