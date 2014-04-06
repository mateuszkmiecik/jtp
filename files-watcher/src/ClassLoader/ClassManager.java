package ClassLoader;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import java.io.*;

/**
 * Created on 06.04.14.
 *
 * @author mk
 */
public class ClassManager extends ClassLoader {
    private String dir;
    private File[] files;

    private Hashtable cache = new Hashtable();

    public ClassManager(String dir) {
        super(ClassManager.class.getClassLoader());

        this.dir = dir;

        File file = new File(dir);
        files = file.listFiles(new JarFilter(".jar"));
        for(File f : files)
            System.out.println("File: "+dir+File.separator+f.getName());

    }



    public void load(){





    }
}
