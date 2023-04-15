import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    private int roomId;
    public int[] roomDirections;
    private boolean isVisited;
    private Monster roomMonster;
    private Puzzle roomPuzzle;
    private ArrayList<Item> roomInventory;
    private String roomName;
    private String roomDescription;
}
