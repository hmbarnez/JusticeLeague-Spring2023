import java.io.Serializable;

public class PassiveKey extends Item implements Serializable {
        private int roomToUnlock;
        
        public PassiveKey(int ItemID, String ItemName, String ItemDesc, int roomToUnlock) {
            super(ItemID, ItemName, ItemDesc);
            this.roomToUnlock = roomToUnlock;
        }

        public int getRoomToUnlock(){
            return this.roomToUnlock;
        }
}
