
public class BossKey extends Item  {
    private int roomID;
    private int bossID;

    public BossKey(int ItemID, String ItemName, String ItemDesc, int roomID, int bossID) {
        super(ItemID, ItemName, ItemDesc);
        this.roomID = roomID;
        this.bossID = bossID;
    }

    public boolean doesPlayerHaveKey() {
        return false;
    }

    public int getRoomId() {
        return this.roomID;
    }

    public int getBossID() {
        return bossID;
    }
}
