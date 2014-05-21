/**
 * Created on 20.05.14.
 *
 * @author mk
 */
public class ParticleModel {
    double mass;
    double relativeVelocity;

    String unit;
    String name;
    double energy;

    private enum availableUnits {
        eV, keV, MeV, GeV, TeV;
    }

    private enum availableNames {
        Helium, Proton, Carbon, Lithium, Neutron;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public Double getRelativeVelocity() {
        return this.relativeVelocity;
    }

    public void countRelativeVelocity() {
        energy = convertEnergyUnit();
        mass = getParticleMass();

        relativeVelocity = Math.sqrt(1- Math.pow((mass/(mass+energy)), 2));
    }

    private double getParticleMass() {										/* particle mass * c^2 [MeV] */
        availableNames conversion = availableNames.valueOf(name);
        switch(conversion) {
            case Helium:
                return 3728.4;
            case Proton:
                return 938.27203;
            case Carbon:
                return 11187.9;
            case Lithium:
                return 6466;
            case Neutron:
                return 939.56536;
            default:
                return 0;

        }
    }

    private double convertEnergyUnit() {
        availableUnits conversion = availableUnits.valueOf(unit);
        switch(conversion) {
            case eV:
                return energy/1e6;
            case keV:
                return energy/1e3;
            case MeV:
                return energy;
            case GeV:
                return energy*(1e3);
            case TeV:
                return energy*(1e6);
            default:
                return energy;
        }
    }
}
