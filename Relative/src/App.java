import javax.swing.*;

/**
 * Created on 20.05.14.
 *
 * @author mk
 */
public class App {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ParticleModel model = new ParticleModel();
                AppView view = new AppView();
                AppController controller = new AppController(model, view);
                controller.control();
            }
        });

    }

}
