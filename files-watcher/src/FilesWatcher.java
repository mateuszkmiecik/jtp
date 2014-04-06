import java.io.IOException;
import java.nio.file.*;
import ClassLoader.*;

/**
 * Created on 02.04.14.
 *
 * @author mk
 */
public class FilesWatcher {
    public static void main(String[] argv) throws IOException, InterruptedException {


        Path libFolder = Paths.get("./lib/");

        WatchService watchService = FileSystems.getDefault().newWatchService();
        libFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

//        boolean valid = true;
//        do {
//            WatchKey watchKey = watchService.take();
//
//            for (WatchEvent<?> event : watchKey.pollEvents()) {
//                WatchEvent.Kind kind = event.kind();
//                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
//                    String fileName = event.context().toString();
//                    System.out.println("File Created:" + fileName);
//                }
//            }
//            valid = watchKey.reset();
//
//
//
//        } while (valid);

        System.out.println("hmm");

        ClassManager CM = new ClassManager("lib");
    }
}
