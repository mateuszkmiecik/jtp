package classloader;


import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created on 06.04.14.
 *
 * @author mk
 */
public class ClassManager extends ClassLoader {
    private File dir;
    private File[] files;

    private Hashtable classes = new Hashtable();
    private Hashtable filesDone = new Hashtable();

    public ClassManager(Path dir) {
        super(ClassManager.class.getClassLoader());

        this.dir = dir.toFile();

        files = this.dir.listFiles(new JarFilter(".jar"));
        for(File f : files)
            System.out.println("File: "+dir+File.separator+f.getName());

    }

    public Class loadClass(String className) throws ClassNotFoundException {
        return findClass(className);
    }

    public Class findClass(String className){
        Class result = null;
        result = (Class) classes.get(className);

        if(result != null){
            return result;
        }

        try {
            return findSystemClass(className);
        } catch (ClassNotFoundException e) { }

        for(File f : files){
            if (filesDone.get(f) == null){
                filesDone.put(f, true);
                try {
                    JarFile jarFile = new JarFile(f);
                    Enumeration e = jarFile.entries();

                    URL[] urls = { new URL("jar:file:" + f+ "!/") };
                    URLClassLoader cl = URLClassLoader.newInstance(urls);

                    while (e.hasMoreElements()) {
                        JarEntry je = (JarEntry) e.nextElement();
                        if(je.isDirectory() || !je.getName().endsWith(".class")){
                            continue;
                        }
                        // -6 because of .class
                        String c = je.getName().substring(0,je.getName().length()-6);
                        c = c.replace('/', '.');

                        Class newClass = cl.loadClass(className);
                        classes.put(className, newClass);

                    }

                } catch (Exception e){ }
            }

        }
        return (Class) classes.get(className);
    }

}
