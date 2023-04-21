import java.io.Serializable;

public class PassiveKey extends Item implements Serializable {
        
        public PassiveKey(int ItemID, String ItemName, String ItemDesc, int ItemLocation) {
            super(ItemID, ItemName, ItemDesc, ItemLocation);
        }

        public boolean doesPlayerHaveItem() {
            return false;
        }
}
