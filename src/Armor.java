import java.io.Serializable;

public class Armor extends Item implements Serializable {
    private int armorPoints;

    public Armor(int ItemID, String ItemName, String ItemDesc, int ItemLocation, int armorPoints) {
        super(ItemID, ItemName, ItemDesc, ItemLocation);
        this.armorPoints = armorPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }
}
