package depot;

/**
 * Created on 23.04.14.
 *
 * @author mk
 */
public class Depot {
    private int fish;
    private int wood;
    private int trees;
    private int stone;
    private int houses;

    private static Depot Instance = null;
    private Depot() {
        fish = 0;
        wood = 0;
        trees = 10;
        stone = 0;
        houses = 0;
    }

    public static Depot getInstance() {
        if (Instance==null) {
            Instance=new Depot();
        }
        return Instance;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getFish() {
        return fish;
    }

    public void setFish(int fish) {
        this.fish = fish;
    }

    public int getTrees() {
        return trees;
    }

    public void setTrees(int trees) {
        this.trees = trees;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }
}
