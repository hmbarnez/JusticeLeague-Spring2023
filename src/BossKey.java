import java.io.Serializable;

public class BossKey extends Item implements Serializable {
            public BossKey(int ItemID, String ItemName, String ItemDesc, int ItemLocation) {
                super(ItemID, ItemName, ItemDesc, ItemLocation);
            }
    
            public boolean doesPlayerHaveKey() {
                return false;
            }
}
