
import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private int currentRoomID;
    private ArrayList<Room> rooms;
    private ArrayList<Item> playerInventory;
    private int maxHP;
    private int attackDmg;
    private Armor armor;
    private Weapon weapon;
    private int currentHP;

    private final ArrayList<Monster> MONSTERSLIST;
    private final ArrayList<Item> ITEMSLIST;

    public Player(Map map){
        this.currentRoomID = 1;
        this.rooms = map.readRooms();
        this.playerInventory = new ArrayList<>();
        this.maxHP = 100;
        this.attackDmg = 10;
        this.armor = null;
        this.weapon = null;
        this.currentHP = maxHP;
        this.MONSTERSLIST = map.getMonstersArrayList();
        this.ITEMSLIST = map.getItemsArrayList();
    }

    //Author: Niecia
    public void move(int direction){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        direction -= 1;
       if(currentRoom.roomDirections[direction] == 0)
       {
           System.out.println("You can't go that way!");
       }
       else{
           //updates room
           //TODO Passive key check
//           if(rooms.get(currentRoom.roomDirections[direction]).isLocked){
//               //add isLocked to room and update map class
//               if (playerInventory.c)
//           }
           this.setCurrentRoomID(currentRoom.roomDirections[direction]);
           currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
           System.out.println("Entering: " + currentRoom.getRoomName());
           System.out.println(currentRoom.getRoomDescription());

           //TODO Check for puzzle
           if((currentRoom.getPuzzle().getPuzzleId() != 0) && !(currentRoom.getPuzzle().isSolved())){
               currentRoom.getPuzzle().solvePuzzle();
               if(currentRoom.getPuzzle().isSolved()){
                   //currentRoom.getRoomMonster().setIsAlive()
               }
           }
           //TODO Check for monster


           //check to see if the room has been visited
           if (currentRoom.isVisited()){
               System.out.println("This room is familiar...");
           }

           //update the isVisited
           currentRoom.setVisited(true);
       }

    }



    //Author: Harrison Barnes and Niecia Say
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
        System.out.println("Items in this room: ");
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
    public void pickupItem(int itemID){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID()-1);
        this.playerInventory.add(currentRoom.getRoomInventory().get(itemID - 1));
        System.out.println("You picked up " + currentRoom.getRoomInventory().get(itemID - 1).getItemName());
        currentRoom.removeItem(itemID);
        //System.out.println("TESTING " + currentRoom);
    }
        


    //Author: Brian Morga
    public void dropItem(int itemID){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID()-1);
        currentRoom.addItem(playerInventory.get(itemID-1));
        this.playerInventory.remove(itemID-1);
    }
    
    //Author: Brian Morga
    public void equipItem(int itemID){
        Item item = this.playerInventory.get(itemID-1);
        if(item instanceof Armor){
            if(this.armor == null){
                this.armor = (Armor) item;
                this.maxHP += this.armor.getArmorPoints();
                playerInventory.remove(itemID-1);
            } else {
                //place armor back in inventory when equipping new armor
                playerInventory.add(this.armor);
                this.maxHP -= this.armor.getArmorPoints();
                this.armor = (Armor) item;
                this.maxHP += this.armor.getArmorPoints();
                playerInventory.remove(itemID-1);
            }
            
        }else if(item instanceof Weapon){
            if(this.weapon == null){
            this.weapon = (Weapon) item;
            this.attackDmg += this.weapon.getWeaponDmg();
            playerInventory.remove(itemID-1);
            } else {
                //place weapon back in inventory when equipping new weapon
                playerInventory.add(this.weapon);
                this.attackDmg -= this.weapon.getWeaponDmg();
                this.weapon = (Weapon) item;
                this.attackDmg += this.weapon.getWeaponDmg();
                playerInventory.remove(itemID-1);
            }
        }else{
            System.out.println("You can't equip that item!");
        }
    }

    //Author: Brian Morga
    //method to use item in player inventory
    public void useItem(int itemID){
        Item item = this.playerInventory.get(itemID-1);
        Room currentRoom = this.rooms.get(currentRoomID-1);
        if(item instanceof ActiveKey){
            ActiveKey activeKey = (ActiveKey) item;
            currentRoom.roomMonster.setHealthRegen(activeKey.getRegenValue());// figure out what to do with this
        }else if(item instanceof Consumable){
            this.currentHP += ((Consumable) item).getHitPointsAdded();
            if (currentHP > maxHP){
                this.currentHP = maxHP;
            }
            this.playerInventory.remove(itemID - 1);
        }else if(item instanceof BossKey){
            BossKey bossKey = (BossKey) item;

            this.rooms.get(bossKey.getRoomId()-1).setMonster(MONSTERSLIST.get(bossKey.getBossID()-1)); // figure out what to do with this

        }else{
            System.out.println("You can't use this item!");
        }
    }

    //Author: Adrian Japa
    //I dont know your plan for these methods but i left them here,
    // just uncomment and commit/push them if you use them -harrison

//    public void getPlayer()
//    {
//        //TODO
//    }
//
//    //Method to calculate player damage reduction
//    public void takeDamage(int damage)
//    {
//        int actualDamageTaken = damage - this.armor.getArmorValue();
//        this.currentHP -= actualDamageTaken;
//        System.out.println(this.getPlayer(); + " has recieved " + actualDamageTaken + " damage.");
//        if(this.maxHP <= 0)
//        {
//            this.isAlive = false;
//            System.out.println(this.getPlayer(); + " has died.");
//        }
//
//    }
//    //used to see if player is alive or not after damage is taken
//    public boolean isAlive()
//    {
//        if(this.currentHP > 0)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//
//        )
//        return true;
//    }

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

    public int getCurrentHP()
    {
        return currentHP;
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

    public int setCurrentHP(int currentHP)
    {
        this.currentHP = currentHP;
        return currentHP;
    }
    private void setCurrentRoomID(int currentRoomID) {
        this.currentRoomID = currentRoomID;
    }

    public Room getCurrentRoom(){
        return this.rooms.get(currentRoomID-1);
    }
    @Override
    public String toString() {
        return "Player{" +
                "currentRoomID=" + currentRoomID +
                ", playerInventory=" + playerInventory +
                ", maxHP=" + maxHP +
                ", attackDmg=" + attackDmg +
                ", armor=" + armor +
                ", weapon=" + weapon +
                '}';
    }
}
