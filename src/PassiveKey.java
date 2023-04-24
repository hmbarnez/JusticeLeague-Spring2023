

public class PassiveKey extends Item  {
        private int roomToUnlock;
        
        public PassiveKey(int ItemID, String ItemName, String ItemDesc, int roomToUnlock) {
            super(ItemID, ItemName, ItemDesc);
            this.roomToUnlock = roomToUnlock;
        }

        public int getRoomToUnlock(){
            return this.roomToUnlock;
        }

        public boolean doesPlayerHaveKey() {
            return false;
        }
}
