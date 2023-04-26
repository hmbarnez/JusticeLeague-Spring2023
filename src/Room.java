/**
 * author : Niecia
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    private int roomId;
    public int[] roomDirections;
    private boolean isVisited;
    public Monster roomMonster;
    private Puzzle roomPuzzle;
    private ArrayList<Item> roomInventory;
    private String roomName;
    private String roomDescription;
    private boolean isLocked;
    private int keyToUnlock;

    public Room(int roomId, int[] roomDirections, boolean isVisited, Monster roomMonster, Puzzle roomPuzzle, ArrayList<Item> roomInventory, String roomName, String roomDescription, boolean isLocked, int keyToUnlock) {
        this.roomId = roomId;
        this.roomDirections = roomDirections;
        this.isVisited = isVisited;
        this.roomMonster = roomMonster;
        this.roomPuzzle = roomPuzzle;
        this.roomInventory = roomInventory;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.isLocked = isLocked;
        this.keyToUnlock = keyToUnlock;
    }

    //add item
    public void addItem(Item item){
        this.roomInventory.add(item);
    }

    //remove item
    public void removeItem(int itemID)
    {
        this.roomInventory.remove(itemID-1) ;
    }

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

    public Puzzle getPuzzle() {
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

    public boolean isLocked() {
        return isLocked;
    }

    public int getKeyToUnlock() {
        return keyToUnlock;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void setMonster(Monster monster) {
        this.roomMonster =  monster;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

   

    //add toString
    @Override
    public String toString() {
        return "Room {" +
                "ID = " + roomId +
                "\nRoom Monster = " + roomMonster +
                "\nRoom Puzzle = " + roomPuzzle +
                "\nRoom Inventory = " + roomInventory +
                "\nRoom Name = '" + roomName + '\'' +
                "\nDoor locked? = " + isLocked +
                '}';
    }
    //Author: Adrian
    public void removeMonster() 
    {   
        this.roomMonster = null;
    }
}
