
public class Weapon extends Item  {
    private int weaponDmg;

    public Weapon(int ItemID, String ItemName, String ItemDesc, int weaponDmg) {
        super(ItemID, ItemName, ItemDesc);
        this.weaponDmg = weaponDmg;
    }
    public int getWeaponDmg() {
        return weaponDmg;
    }
}
