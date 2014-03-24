package products;

/**
 * Created on 24.03.14.
 *
 * @author Mateusz Kmiecik
 */
public class Product {

    private String name;
    private final double voltage;
    private final double volume;
    private double price;

    public Product(String name, double voltage, double volume, double price) {
        this.name = name;
        this.voltage = voltage;
        this.volume = volume;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getVolume() {
        return volume;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", voltage: " + voltage +
                ", volume: " + volume +
                ", price: " + price +
                " PLN";
    }
}
