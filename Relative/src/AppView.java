import javax.swing.*;
import java.awt.*;

/**
 * Created on 20.05.14.
 *
 * @author mk
 */
public class AppView {
    private JFrame mainWindow;

    private JButton convertButton;
    private JLabel particleVelocity;
    private JComboBox energyUnitsList;
    private JList availableParticlesList;
    private JTextField particleEnergyArea;

    private String [] energyUnits = {"eV", "keV", "MeV", "GeV", "TeV"};
    private String [] availableParticles = {"Helium", "Proton", "Carbon", "Lithium", "Neutron"};


    public AppView() {
        mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);

        createNewView();
    }

    private void createNewView() {
        mainWindow.setSize(480,290);
        mainWindow.setTitle("Relative Velocity Converter");
        mainWindow.setLocationRelativeTo(null);

        mainWindow.getContentPane().setLayout(null);

        JLabel particlesListLabel = new JLabel("Available particles:");
        particlesListLabel.setBounds(10,10, 200, 20);
        particlesListLabel.setVisible(true);
        mainWindow.getContentPane().add(particlesListLabel);

        availableParticlesList = new JList(availableParticles);
        availableParticlesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        availableParticlesList.setBounds(210,10,260,90);
        availableParticlesList.setSelectedIndex(0);
        availableParticlesList.setVisible(true);
        mainWindow.getContentPane().add(availableParticlesList);

        JLabel particleEnergyLabel = new JLabel("Particle energy:");
        particleEnergyLabel.setBounds(10, 120, 200, 20);
        particleEnergyLabel.setVisible(true);
        mainWindow.getContentPane().add(particleEnergyLabel);

        particleEnergyArea = new JTextField();
        particleEnergyArea.setBounds(210, 120, 260, 20);
        particleEnergyArea.setVisible(true);
        mainWindow.getContentPane().add(particleEnergyArea);

        energyUnitsList = new JComboBox(energyUnits);
        energyUnitsList.setBounds(210, 150, 260, 20);
        energyUnitsList.setSelectedIndex(2);
        energyUnitsList.setBackground(Color.white);
        energyUnitsList.setVisible(true);
        mainWindow.getContentPane().add(energyUnitsList);

        JLabel particleVelocityLabel = new JLabel("Particle relative velocity:");
        particleVelocityLabel.setBounds(10, 180, 478, 20);
        particleVelocityLabel.setVisible(true);
        mainWindow.getContentPane().add(particleVelocityLabel);

        particleVelocity = new JLabel("Click \"Convert!\" to show.");
        particleVelocity.setBounds(210, 180, 270, 20);
        particleVelocity.setVisible(true);
        mainWindow.getContentPane().add(particleVelocity);

        convertButton = new JButton("Convert!");
        convertButton.setBounds(210, 210, 160, 40);
        mainWindow.getContentPane().add(convertButton);
    }

    public JButton getConvertButton() {
        return convertButton;
    }

    public String getSelectedParticle() {
        return availableParticlesList.getSelectedValue().toString();
    }

    public String getParticleEnergy() {
        return particleEnergyArea.getText();
    }

    public String getSelectedUnit() {
        return energyUnitsList.getSelectedItem().toString();
    }

    public void setVelocity(String velocity) {
        particleVelocity.setText(velocity);
    }
}
