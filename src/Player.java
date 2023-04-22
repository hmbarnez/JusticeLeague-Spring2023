
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

    //Author: Niecia
    public void move(int direction){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        Room nextRoom = null;

       int index = direction-1;
       if(currentRoom.roomDirections[index] == 0)
       {
           System.out.println("No room.");
       }
       else{
           //updates room
           setCurrentRoomID(currentRoom.roomDirections[index]);
           currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
       }
        System.out.println(nextRoom.getRoomDescription() + " " + nextRoom.getRoomId());


        //check to see if the room has been visited
        if (nextRoom.isVisited()){
            System.out.println("This room is familiar...");
        }
        //update the isVisited
        nextRoom.setVisited(true);
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
        ArrayList<Item> currentRoomInv = currentRoom.getRoomInventory();
        if(!currentRoomInv.isEmpty()){
            for(int i=0; i < currentRoomInv.size(); i++){
                if(currentRoomInv.get(i).getItemID() == itemID){
                    this.playerInventory.add(currentRoomInv.get(i));
                    currentRoomInv.remove(i);
                    System.out.println("You picked up the item!");
                    return;
                }
            }
            System.out.println("That item is not in this room!");
        }else{
            System.out.println("There are no items in this room!");
        }
    }

    //Author: Brian Morga
    //drop item
    public void dropItem(int itemID){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID()-1);
        ArrayList<Item> currentRoomInv = currentRoom.getRoomInventory();
        if(!this.playerInventory.isEmpty()){
            for(int i=0; i < this.playerInventory.size(); i++){
                if(this.playerInventory.get(i).getItemID() == itemID){
                    currentRoomInv.add(this.playerInventory.get(i));
                    this.playerInventory.remove(i);
                    System.out.println("You dropped the item!");
                    return;
                }
            }
            System.out.println("That item is not in your inventory!");
        }else{
            System.out.println("You don't have any items to drop!");
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

    private void setCurrentRoomID(int currentRoomID) {
        this.currentRoomID = currentRoomID;
    }
}
