import java.awt.event.*;


/**
 * Created on 20.05.14.
 *
 * @author mk
 */
public class AppController {

    private ActionListener actionListener;
    private AppView appView;
    private ParticleModel model;


    public AppController(ParticleModel model, AppView view) {
        this.model = model;
        this.appView = view;
    }

    public void control() {
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                convertButtonOnClick();
            }
        };
        appView.getConvertButton().addActionListener(actionListener);
    }

    private void convertButtonOnClick() {

        try {
            double energy = Double.parseDouble(appView.getParticleEnergy());
            model.setEnergy(energy);
        } catch(NumberFormatException e) {
            appView.setVelocity("Invalid input!");
            return;
        }

        model.setName(appView.getSelectedParticle());
        model.setUnit(appView.getSelectedUnit());
        model.countRelativeVelocity();
        appView.setVelocity(model.getRelativeVelocity().toString());
    }
}
