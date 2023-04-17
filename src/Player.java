import java.io.Serializable;
/*
 * Author: Adrian Japa
 * This class is in charge of creating the player that will be used in the game.
 * As well as keeping track of inventory, explore, item pickup and drop, insepct, 
 * and other player related actions.
 */
public class Player implements Serializable 
{

    private Weapon weapon;
    private Armor armor;
    private int maxHP;
    private int currentHP;                  //added this to keep track of current HP
    private int attackDmg;
    private ArrayList<Item> playerInventory;
    private ArrayList<Room> rooms;
    private int currentRoom;                //keeps track of current room


    //constructor
    public Player(Map map)
    {

    }
    //For the move() method, you can update 
    //the currentRoom attribute based on the direction passed as a parameter.
    public void move(String direction)
    {
        //TODO
    }

    public void pickupItem(String itemName)
    {
        //TODO
    }
    //search the player's inventory for an item with the specified name, 
    //remove it from the player's inventory, and add it to the current room's inventory.
    public void dropItem(String itemName)
    {
        //TODO
    }
    //search the player's inventory for an item with the specified name, 
    //and print out its description.
    public void inspectItem(String itemName)
    {
        //TODO
    }
    //can be used for the key items?
    public void useItem(String itemName)
    {
        //TODO
    }
    //thought we needed a method to do this function
    //search the player's inventory for an item with the specified name,
    public void equipItem(String itemName)
    {
        //TODO
    }
    //print out the names of all items in the current room's inventory.
    public void exploreRoomInventory()
    {
        //TODO
    }
    //print out the names of all items in the player's inventory.
    public void viewPlayerInventory()
    {
        //TODO
    }


    //getters and setters!!


}
