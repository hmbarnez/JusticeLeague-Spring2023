import java.io.Serializable;

public class ActiveKey extends Item implements Serializable {
    private int regenValue;
    
    public ActiveKey(int ItemID, String ItemName, String ItemDesc, int value) {
        super(ItemID, ItemName, ItemDesc);
        this.regenValue = value;
    }

    public void useKey() {
        System.out.println("You used the key.");
    }
    public int getRegenValue(){
        return this.regenValue;
    }
}
