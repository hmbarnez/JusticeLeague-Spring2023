import java.io.Serializable;

public abstract class Item implements Serializable {
    private int ItemID;
    private String ItemName;
    private String ItemDesc;
    //private int ItemLocation;

    public Item(int ItemID, String ItemName, String ItemDesc) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.ItemDesc = ItemDesc;
        //this.ItemLocation = ItemLocation;
    }
    public int getItemID() {
        return ItemID;
    }
    public String getItemName() {
        return ItemName;
    }
    public String getItemDesc() {
        return ItemDesc;
    }
//    public int getItemLocation() {
//        return ItemLocation;
//    }

    @Override
    public String toString() {
        return "ItemName";
    }


    


}
