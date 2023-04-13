import java.io.Serializable;

public class Weapon extends Item implements Serializable {
    private int weaponDmg;

    public Weapon(int ItemID, String ItemName, String ItemDesc, int ItemLocation, int weaponDmg) {
        super(ItemID, ItemName, ItemDesc, ItemLocation);
        this.weaponDmg = weaponDmg;
    }
    public int getWeaponDmg() {
        return weaponDmg;
    }
}
