import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.*;

import classloader.*;

import sermaker.Serializer;
import watcher.*;

/**
 * Created on 02.04.14.
 *
 * @author mk
 */
public class FilesWatcher {
    public static void main(String[] argv) throws IOException, InterruptedException {

        Path libFolder = Paths.get("./lib/");
        Path watchFolder = Paths.get("./folder/");

        MainWatcher MW = new MainWatcher(watchFolder);


        Serializer s = new Serializer();
        s.create();

        MW.watch();
    }
}
