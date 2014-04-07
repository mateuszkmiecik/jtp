package classloader;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created on 06.04.14.
 *
 * @author mk
 */
public class JarFilter implements FilenameFilter {
    private String ext;

    public JarFilter(String ext) {
        this.ext = ext.toLowerCase();
    }

    @Override
    public boolean accept(File file, String s) {
        return s.toLowerCase().endsWith(this.ext);
    }
}
