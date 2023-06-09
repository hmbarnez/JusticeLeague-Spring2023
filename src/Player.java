
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player implements Serializable {

    private int currentRoomID;
    private ArrayList<Room> rooms;
    private ArrayList<Item> playerInventory = new ArrayList<>();
    private int maxHP;
    private int attackDmg;
    private Armor armor;
    private Weapon weapon;
    private int currentHP;
    private int previousRoomID;

    private final ArrayList<Monster> MONSTERSLIST;
    private final ArrayList<Item> ITEMSLIST;

    public Player(Map map){
        this.currentRoomID = 1;
        this.rooms = map.readRooms();
        //this.playerInventory = new ArrayList<>();
        this.maxHP = 100;
        this.attackDmg = 10;
        this.armor = null;
        this.weapon = null;
        this.currentHP = maxHP;
        this.MONSTERSLIST = map.getMonstersArrayList();
        this.ITEMSLIST = map.getItemsArrayList();
        this.previousRoomID = 0;
    }

    //Author: Niecia
    public void move(int direction)
    {
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        previousRoomID = currentRoom.getRoomId();
        //Room nextRoom = null;

        direction -= 1;
       if(currentRoom.roomDirections[direction] == 0)
       {
           System.out.println("You can't go that way!");
       }
       else{
           //updates room
           // TODO Passive key check
         //   System.out.println(rooms.get(currentRoom.roomDirections[direction]-1));
           if(rooms.get(currentRoom.roomDirections[direction]-1).isLocked()){
               if(this.playerInventory.contains(ITEMSLIST.get(rooms.get(currentRoom.roomDirections[direction]-1).getKeyToUnlock()-1))){
                    rooms.get(currentRoom.roomDirections[direction]).setLocked(false);
                    System.out.println("Unlocking room ...");
                }
                else{
                     System.out.println("You don't have the key to unlock this room!");
                    return;
                }
            }
           this.setCurrentRoomID(currentRoom.roomDirections[direction]);
           currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
           System.out.println("Entering: " + currentRoom.getRoomName());
           System.out.println(currentRoom.getRoomDescription());

           //TODO Check for puzzle
           if((currentRoom.getPuzzle().getPuzzleId() != 0) && !(currentRoom.getPuzzle().isSolved())){
               currentRoom.getPuzzle().solvePuzzle();
               if(currentRoom.getPuzzle().isSolved()){
                   currentRoom.getRoomMonster().setIsAlive(false);
               }
           }
           
           if((currentRoom.getRoomMonster().getMonsterId() != 0) && (currentRoom.getRoomMonster().isAlive()))
           {
                System.out.println("\n------------ FIGHT -------------------");
                Combat();

           }
           

           //check to see if the room has been visited
           if (currentRoom.isVisited()){
               System.out.println("This room is familiar...");
           }

           //update the isVisited
           currentRoom.setVisited(true);
       }

    }

    //Author: Adrian Japa
    //used for engaging in combat. 
    // WORK IN PROGRESS
    public void Combat()
    {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int dropChance = random.nextInt(100);
        Monster monster = this.rooms.get(this.getCurrentRoomID() - 1).getRoomMonster();
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);

        Item bluePowerAide = this.getItemsArrayList().get(4);  
        Item appleJuice = this.getItemsArrayList().get(3);

        boolean combatStatus = true;

        //while loop for combat
        while(combatStatus)
        {
            //Print monster information
            System.out.println("\nYou have encountered a " + monster.getMonsterName() + "!");
            System.out.println("\tMonster Health: " + monster.getHealthPoints());
           
            //Print player information
            System.out.println("\tPlayer Health: " + this.getCurrentHP());
            System.out.println("\tPlayer Attack: " + this.getAttackDmg());
           
            System.out.println("\n\tWhat would you like to do?");

            //Print user input options
            System.out.println("\t1. Attack");
            System.out.println("\t2. Run");
            System.out.println("\t3. Use Item");
            System.out.println("\n------------ FIGHT -------------------");

            //Get user input
            int userInput = input.nextInt();
            
            //Switch statement for user input
            switch(userInput)
            {
                case 1:
                    // calculate player damage and reduce monster health
                    int playerDamage = this.getAttackDmg();
                    System.out.println("You dealt " + playerDamage + " damage!");
                    monster.setHealthPoints(monster.getHealthPoints() - playerDamage);
                    

                    // check if monster is defeated
                    if (monster.getHealthPoints() <= 0) 
                      {  
                        System.out.println("You defeated the " + monster.getMonsterName() + "!");
                        monster.setIsAlive(false);
                        combatStatus = false; // exit combat state

                        ////////////////DROP CHANCE
                        if (dropChance < 33) 
                        {
                            System.out.println("The " + monster.getMonsterName() + " dropped a " + bluePowerAide.getItemName() + "!");
                            currentRoom.addItem(bluePowerAide);
                        }
                        else if(dropChance < 66)
                        {
                            System.out.println("The " + monster.getMonsterName() + " dropped a " + appleJuice.getItemName() + "!");
                            currentRoom.addItem(appleJuice);
                        }
                        else
                        {
                            System.out.println("The " + monster.getMonsterName() + " dropped nothing!");
                        }
                          currentRoom.getRoomMonster().setIsAlive(false);
                          combatStatus = false; // exit combat state

                        return;

                    }

                        // remove monster from room
                        //currentRoom.setRoomMonster(null);
                        //currentRoom.getRoomMonster().setIsAlive(false);

                //    }

                    // monster attacks back
                    int monsterDamage = attackDmg;
                    System.out.println("The " + monster.getMonsterName() + " dealt " + monsterDamage + " damage!");
                //    player.reduceHealth(monsterDamage);
                    this.setCurrentHP(this.getCurrentHP()- monsterDamage);

                    // check if the player has died
                    if (this.getCurrentHP() <= 0) 
                    {
                        System.out.println("You died!");

                    //    Room previousRoom = rooms.get(previousRoomID - 1); // get previous room
                   
                  //     this.move(previousRoomID); // move player to previous room
                        this.setCurrentRoomID(previousRoomID);

                        this.setCurrentHP(this.getMaxHP() / 2); // restore 50% of max health
            //            Item item = new Item("Blue Powerade", "Restores 50 health"); // create item object
            //            currentRoom.addItem(item); // add item to room inventory

                //      player.setcurrentRoom(previousRoomID); // set player to previous room
                      currentRoom.addItem(bluePowerAide);
                //        player.playerInventory.add(bluePowerAide);
                        System.out.println("You are now in the " + this.rooms.get(this.getCurrentRoomID() - 1).getRoomName() + "!");
                        combatStatus = false; // exit combat state
                        
                    }
                    break;
                case 2:
                        System.out.println("You run away from the " + monster.getMonsterName() + "!");
                        this.setCurrentRoomID(previousRoomID);
            //             System.out.println("You are now in the " + this.rooms.get(this.getCurrentRoomID() - 1).getRoomName() + "!");
                        System.out.println("and have returned to the previous room!");
                    combatStatus = false; // exit combat state
                    break;
                case 3:
                    System.out.println("Which item would you like to use?");
                //    this.getPlayerInventory();
                    this.viewPlayerInventory();

                    int itemChoice = input.nextInt();
                    System.out.println("You used a " + this.playerInventory.get(itemChoice - 1).getItemName() + "!");
                    this.useItem(itemChoice);
                  //  this.getPlayerInventory();
                  
                    break;
                default:
                    System.out.println("Invalid command!");
            }
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
            this.rooms.get(bossKey.getRoomId()-1).getRoomMonster().setIsAlive(true);

        }else{
            System.out.println("You can't use this item!");
        }
    }



    //Getters
    public int getCurrentRoomID() {
        return currentRoomID;
    }
    // Author: Adrian Japa
    public int getPreviousRoomID()
    {
        return this.previousRoomID;
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

    public ArrayList<Item> getItemsArrayList()
    {
        return ITEMSLIST;
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
                "currentRoomID = " + currentRoomID +
                "\nPlayer Inventory = " + playerInventory +
                "\nHP = " + currentHP + "/" + maxHP +
                "\tattackDmg = " + attackDmg +
                "\nArmor = " + armor +
                "\nweapon = " + weapon +
                '}';
    }

    public boolean checkInventory(String string) {
        return false;
    }
}
