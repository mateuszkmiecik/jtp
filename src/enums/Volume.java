package enums;

/**
 * Created on 25.03.14.
 *
 * @author Mateusz Kmiecik
 */
public enum Volume {

    HALF(0.5),
    LITER(1.0);

    /**
     * Konstruktor enum Volume.
     *
     * @param volume
     */
    private Volume(double volume){
        this.volume = volume;
    }

    private double volume;

    public double getVolume(){
        return this.volume;
    }


}
