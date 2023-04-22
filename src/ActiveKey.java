import java.io.Serializable;

public class ActiveKey extends Item implements Serializable {
    private int value;
    
    public ActiveKey(int ItemID, String ItemName, String ItemDesc, int value) {
        super(ItemID, ItemName, ItemDesc, value);
        this.value = value;
    }

    public void useKey() {
        System.out.println("You used the key.");
    }
    public int getValue(){
        return this.value;
    }
}
