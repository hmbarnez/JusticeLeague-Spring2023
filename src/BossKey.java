import java.io.Serializable;

public class BossKey extends Item implements Serializable {
    private int roomID;
            public BossKey(int ItemID, String ItemName, String ItemDesc, int ItemLocation) {
                super(ItemID, ItemName, ItemDesc, ItemLocation);
            }
    
            public boolean doesPlayerHaveKey() {
                return false;
            }
            
            public int getRoomId(){
                return this.roomID;
            }
}
