
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player implements Serializable {

    private int currentRoomID;
    private ArrayList<Room> rooms;
    private ArrayList<Item> playerInventory;
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
        this.playerInventory = new ArrayList<>();
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
    public void move(int direction){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        //Room nextRoom = null;
        direction -= 1;
       if(currentRoom.roomDirections[direction] == 0)
       {
           System.out.println("You can't go that way!");
       }
       else{
           //updates room
<<<<<<< HEAD
           // TODO Passive key check
         //   System.out.println(rooms.get(currentRoom.roomDirections[direction]-1));
           if(rooms.get(currentRoom.roomDirections[direction]-1).isLocked()){
            System.out.println("Test");
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
=======
           //TODO Passive key check
//           if(rooms.get(currentRoom.roomDirections[direction]).isLocked){
//               //add isLocked to room and update map class
//               if (playerInventory.c)
//           }
            previousRoomID = currentRoom.getRoomId(); // Adrian 
            this.setCurrentRoomID(currentRoom.roomDirections[direction]);
            currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
           
>>>>>>> 44749790a07cb02e548ef4604ee339112197a0ad
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
           if((currentRoom.getRoomMonster().getMonsterId() != 0) && !(currentRoom.getRoomMonster().isAlive()))
           {
                Combat(null, currentRoom);

           }
           

           //check to see if the room has been visited
           if (currentRoom.isVisited()){
               System.out.println("This room is familiar...");
           }

           //update the isVisited
           currentRoom.setVisited(true);
       }
        //System.out.println(nextRoom.getRoomDescription() + " " + nextRoom.getRoomId());

    }

    //Author: Adrian Japa
    //used for engaging in combat. 
    // WORK IN PROGRESS
    public void Combat(Player player, Room currentRoom)
    {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int dropChance = random.nextInt(100);
        Monster monster = this.rooms.get(this.getCurrentRoomID() - 1).getRoomMonster();

<<<<<<< HEAD
=======
        Item bluePowerAide = player.getItemsArrayList().get(4);  
        Item appleJuice = player.getItemsArrayList().get(3);

        boolean combatStatus = true;

        //while loop for combat
        while(combatStatus)
        {
            //Print monster information
            System.out.println("You have encountered a " + monster.getMonsterName() + "!");
            System.out.println("Monster Health: " + monster.getHealthPoints());
           
            //Print player information
            System.out.println("Player Health: " + player.getCurrentHP());
            System.out.println("Player Attack: " + player.getAttackDmg());
           
            System.out.println("\nWhat would you like to do?");

            //Print user input options
            System.out.println("1. Attack");
            System.out.println("2. Run");
            System.out.println("3. Use Item");

            //Get user input
            int userInput = input.nextInt();
            
            //Switch statement for user input
            switch(userInput)
            {
                case 1:
                    // calculate player damage and reduce monster health
                    int playerDamage = player.getAttackDmg();
                    System.out.println("You dealt " + playerDamage + " damage!");
                    monster.setHealthPoints(monster.getHealthPoints() - playerDamage);
                    

                    // check if monster is defeated
                    if (monster.getHealthPoints() <= 0) 
                      {  
                        System.out.println("You defeated the " + monster.getMonsterName() + "!");
                        monster.setIsAlive();

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
                    }

                        // remove monster from room
                        currentRoom.removeMonster();
                        combatStatus = false; // exit combat state
                //    }

                    // monster attacks back
                    int monsterDamage = attackDmg;
                    System.out.println("The " + monster.getMonsterName() + " dealt " + monsterDamage + " damage!");
                //    player.reduceHealth(monsterDamage);
                    player.setCurrentHP(player.getCurrentHP()- monsterDamage);

                    // check if the player has died
                    if (player.getCurrentHP() <= 0) 
                    {
                        System.out.println("You died!");

                    //    Room previousRoom = rooms.get(previousRoomID - 1); // get previous room
                    //    TODO - MOVE PLAYER TO PREVIOUS ROOM
                       player.move(previousRoomID); // move player to previous room
                        

                        player.setCurrentHP(player.getMaxHP() / 2); // restore 50% of max health
            //            Item item = new Item("Blue Powerade", "Restores 50 health"); // create item object
            //            currentRoom.addItem(item); // add item to room inventory

                //      player.setcurrentRoom(previousRoomID); // set player to previous room
                //      currentRoom.addItem(bluePowerAide);
                //        player.playerInventory.add(bluePowerAide);
            
                        combatStatus = false; // exit combat state
                        
                    }
                    break;
                case 2:
                     System.out.println("You run away from the " + monster.getMonsterName() + "!");
                    combatStatus = false; // exit combat state
                    break;
                case 3:
                    System.out.println("Which item would you like to use?");
                    player.getPlayerInventory();
                    int itemChoice = input.nextInt();
                    player.useItem(itemChoice);
                    break;
                default:
                    System.out.println("Invalid command!");
            }
            }


        }

>>>>>>> 44749790a07cb02e548ef4604ee339112197a0ad
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
                "currentRoomID=" + currentRoomID +
                ", playerInventory=" + playerInventory +
                ", maxHP=" + maxHP +
                ", attackDmg=" + attackDmg +
                ", armor=" + armor +
                ", weapon=" + weapon +
                '}';
    }

    public boolean checkInventory(String string) {
        return false;
    }
}
