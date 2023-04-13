import java.io.Serializable;

public class PuzzleKey extends Key implements Serializable {
    public PuzzleKey(int ItemID, String ItemName, String ItemDesc, int ItemLocation) {
        super(ItemID, ItemName, ItemDesc, ItemLocation);
    }

    public void usePuzzleKey() {
        System.out.println("You used the puzzle key.");
    }
}
