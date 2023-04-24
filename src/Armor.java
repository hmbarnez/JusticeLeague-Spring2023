
public class Armor extends Item  {
    private int armorPoints;

    public Armor(int ItemID, String ItemName, String ItemDesc, int armorPoints) {
        super(ItemID, ItemName, ItemDesc);
        this.armorPoints = armorPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }
}
