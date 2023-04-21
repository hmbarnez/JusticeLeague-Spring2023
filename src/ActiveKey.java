import java.io.Serializable;

public class ActiveKey extends Item implements Serializable {
    
    public ActiveKey(int ItemID, String ItemName, String ItemDesc, int ItemLocation) {
        super(ItemID, ItemName, ItemDesc, ItemLocation);
    }

    public void useKey() {
        System.out.println("You used the key.");
    }
}
