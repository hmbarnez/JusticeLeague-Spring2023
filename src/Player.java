
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


    //Author: Harrison Barnes
    //methods for game class to view player and room inventory in numbered order
    public boolean viewPlayerInventory(){
        if(!this.playerInventory.isEmpty()){
            for(int i=1; i< playerInventory.size()+1; i++){
                System.out.println(i + " " +playerInventory.get(i-1).toString());
            }
            return true;
        }else{
            System.out.println("You haven't picked up any items yet!");
        }
        return false;
    }

    //Author: Harrison Barnes
    public boolean viewRoomInventory(){
        //Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        ArrayList<Item> currentRoomInv = rooms.get(this.getCurrentRoomID()-1).getRoomInventory();
        if(!currentRoomInv.isEmpty()){
            for(int i=1; i < currentRoomInv.size()+1; i++){
                System.out.println(i + " " +currentRoomInv.get(i-1).toString());
            }
            return true;
        }else{
            System.out.println("There are no items in this room!");
        }
        return false;
    }


    //Author: Brian Morga
    //pick up item
    public void pickUpItem(int itemID){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID()-1);
        this.playerInventory.add(currentRoom.getRoomInventory().get(itemID-1));
        currentRoom.removeItem(itemID-1);
    }
        


    //Author: Brian Morga
    //drop item
    public void dropItem(int itemID){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID()-1);
        currentRoom.addItem(playerInventory.get(itemID-1));
        this.playerInventory.remove(itemID-1);
    }
    

    public void equipItem(int itemID){
        Item item = this.playerInventory.get(itemID-1);
        if(item instanceof Armor){
            this.armor = (Armor) item;
            this.maxHP += this.armor.getArmorPoints();
        }else if(item instanceof Weapon){
            this.weapon = (Weapon) item;
            this.attackDmg += this.weapon.getWeaponDmg();
        }
    }

    //Getters
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
