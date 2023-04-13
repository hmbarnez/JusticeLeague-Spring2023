import java.io.Serializable;

public class Consumable extends Item implements Serializable {
    private int hitPointsAdded;

    public Consumable(int ItemID, String ItemName, String ItemDesc, int ItemLocation, int hitPointsAdded) {
        super(ItemID, ItemName, ItemDesc, ItemLocation);
        this.hitPointsAdded = hitPointsAdded;
    }

    public int getHitPointsAdded() {
        return hitPointsAdded;
    }
}
