package single;

/**
 * Created on 23.04.14.
 *
 * @author mk
 */
public class Ton {
    private int number = 0;

    private static Ton Instance = null;
    private Ton() {}

    public static Ton getInstance() {
        if (Instance==null) {
            Instance=new Ton();
        }
        return Instance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
