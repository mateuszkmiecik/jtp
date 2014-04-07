package watcher;

import sermaker.Serializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import java.util.logging.Logger;


/**
 * Created on 07.04.14.
 *
 * @author mk
 */
public class MainWatcher {

    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    private Path watchDir;

    Serializer s = new Serializer();

    public MainWatcher(Path watchDir) {
        this.watchDir = watchDir;
    }

    public void watch() throws IOException, InterruptedException {

        LOGGER.info("watching service started...");

        WatchService watchService = FileSystems.getDefault().newWatchService();
        watchDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        boolean valid = true;
        do {
            WatchKey watchKey = watchService.take();

            for (WatchEvent<?> event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {

                    String fileName = event.context().toString();
                    File f = (Paths.get(watchDir + File.separator + fileName).toFile());

                    analyze(f);
                }
            }

            valid = watchKey.reset();

        } while (valid);
    }

    void analyze(File f){

        if(f.isDirectory()){ return; }

        String fileName = f.getName();

        if( fileName.endsWith(".png") ||
            fileName.endsWith(".jpg") ){

            moveFile(f, "img");
            LOGGER.info("moving image: " + f.getName());
            return;

        }

        if( fileName.endsWith(".mp3")){
            moveFile(f, "music");
            LOGGER.info("moving music file: " + f.getName());
            return;
        }

        if( fileName.endsWith(".ser")){

            s.deserialize(f);
            return;

        }

    }

    void moveFile(File f, String p){

        String fileName = f.getName();

        if(!Paths.get(watchDir + File.separator + p).toFile().exists()){
            (new File(watchDir + File.separator + p)).mkdir();
        }

        Path dest = Paths.get(watchDir + File.separator + p + File.separator + fileName);
        f.renameTo(dest.toFile());

    }
}
