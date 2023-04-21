
import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private int currentRoomID;
    private ArrayList<Room> rooms;
    private ArrayList<Item> playerInventory;
    private int  maxHP;
    private int attackDmg;
    private Armor armor;
    private Weapon weapon;

    public Player(Map map){
        this.currentRoomID = 1;
        this.rooms = map.readRooms();
        this.playerInventory = new ArrayList<>();
        this.maxHP = 100;
        this.attackDmg = 10;
    }

    //move rooms: associated with numbers
/*
    public void move(String direction){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        Room nextRoom = null;

        if ("n".equals(direction)) {
            nextRoom
        } else if ("s".equals(direction)) {
            nextRoom
        } else if ("e".equals(direction)) {
            nextRoom
        } else if ("w".equals(direction)) {
            nextRoom
        } else {
            System.out.println("Wrong input");
            return;
        }

        if(nextRoom == null){
            System.out.println("No Room");
            return;
        }

        //updates room id
        this.setCurrentRoomID(nextRoom.getRoomId());
        //prints the description of the room being moved to
        System.out.println(nextRoom.getDescription() + " " + nextRoom.getRoomId());

        //check to see if the room has been visited
        if (nextRoom.isVisited()){
            System.out.println("This room is familiar...");
        }

        //update the isVisited
        nextRoom.setVisited();
    }
    */
    //search room : inspect room:see and pick up item
    public void exploreRoom(){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID()-1);
        if (currentRoom.getRoomInventory().isEmpty())
        {
            System.out.println("There is no item in this room.");
        } else {
            System.out.println("List of items in this room " + currentRoom.getRoomInventory());
        }

    }

    public int getCurrentRoomID() {
        return currentRoomID;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
