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

    public Room(int roomId, int[] roomDirections, boolean isVisited, Monster roomMonster, Puzzle roomPuzzle, ArrayList<Item> roomInventory, String roomName, String roomDescription) {
        this.roomId = roomId;
        this.roomDirections = roomDirections;
        this.isVisited = isVisited;
        this.roomMonster = roomMonster;
        this.roomPuzzle = roomPuzzle;
        this.roomInventory = roomInventory;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    //add item method
    public void addItem(Item item){
        this.roomInventory.add(item);
    }

    //TODO :
    //remove item : Room
   /* public void removeItem(Item item) {
        int index = -1;
        for (int i = 0; i < roomInventory.size(); i++) {
            if (roomInventory.get(i).getName().equals(item.getName())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            roomInventory.remove(index);
        }
    }*/
    //
    public int getRoomId() {
        return roomId;
    }

    public int[] getRoomDirections() {
        return roomDirections;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public Monster getRoomMonster() {
        return roomMonster;
    }

    public Puzzle getRoomPuzzle() {
        return roomPuzzle;
    }

    public ArrayList<Item> getRoomInventory() {
        return roomInventory;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    //add toString
}
