import java.io.Serializable;

public abstract class Key extends Item implements Serializable {

    public Key(int ItemID, String ItemName, String ItemDesc, int ItemLocation) {
        super(ItemID, ItemName, ItemDesc, ItemLocation);
    }
}
