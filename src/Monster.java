import java.io.Serializable;
/*
 * Author: Adrian Japa
 * This class is in charge of creating the monsters that will be used in the game.
 */
import java.util.Scanner;


public class Monster implements Serializable
{
    private int monsterId;
    private String monsterName;
    private String dialogue;
    private boolean isAlive;
    private int attackDmg;
    private int healthPoints;
    private int healthRegen;

    // constructor
    public Monster(int monsterId,String name, String dialogue, int attackDmg, int health, boolean isAlive, int healthRegen)
    {
        this.monsterId = monsterId;
        this.monsterName = name;
        this.dialogue = dialogue;
        this.attackDmg = attackDmg;
        this.healthPoints = health;
        this.isAlive = isAlive;
        this.healthRegen = healthRegen;
    }
    //no param constructor for if there are no monsters in the room
    public Monster(){
        this.monsterId = 0;
        this.monsterName = "";
        this.dialogue = "";
        this.attackDmg = 0;
        this.healthPoints = 0;
        this.isAlive = false;
        this.healthRegen = 0;
    }


    //Method of attack to target
//    public void attack(Player player)
//    {
//        int damageDealt = this.attackDmg;
//        Systout.out.println(this.name + " attacks "
//                + player.getPlayer() + " for " + damageDealt + " damage.");
//        player.takeDamage(damageDealt);
//        if(!player.isAlive())
//        {
//            System.out.println(player.getPlayer() + " has died.");
//        }
//    }
    
    //Author: Adrian Japa
    //used for engaging in combat. 
    // WORK IN PROGRESS
    public void combat(Player player, Room currentRoom)
    {
        Scanner input = new Scanner(System.in);
        Random random = new Random();



        boolean combatStatus = true;

        //while loop for combat
        while(combatStatus)
        {
            //Print monster information
            System.out.println("You have encountered a " + this.monsterName + "!");
            System.out.println("Monster Health: " + this.healthPoints);
           
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
                    healthPoints -= playerDamage;

                    // check if monster is defeated
                    if (healthPoints <= 0) {
                        System.out.println("You defeated the " + monsterName + "!");

                      ///////// 
                        // 33% chance of monster dropping item
                        if (random.nextInt(3) == 0) {
                            String itemName = "Consumable Item"; // change this to actual item name
                            Item item = new Item(itemName, "Description"); // create item object
                            currentRoom.addItem(item); // add item to room inventory
                            System.out.println("The " + monsterName + " dropped a " + itemName + "!");
                        }

                        // remove monster from room
                        currentRoom.removeMonster();
                        combatStatus = false; // exit combat state
                    }

                    // monster attacks back
                    int monsterDamage = attackDmg;
                    System.out.println("The " + monsterName + " dealt " + monsterDamage + " damage!");
                    player.reduceHealth(monsterDamage);

                    // check if the player has died
                    if (player.getCurrentHP() <= 0) {
                        System.out.println("You died!");
                        player.setCurrentHP(player.getMaxHP() / 2); // restore 50% of max health
                        Item item = new Item("Blue Powerade", "Restores 50 health"); // create item object
                        currentRoom.addItem(item); // add item to room inventory
                        combatStatus = false; // exit combat state
                    }
                    break;
                case 2:
                     System.out.println("You run away from the " + monsterName + "!");
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


    }



    // getters and setters


    public int getMonsterId() {
        return monsterId;
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public void setHealthRegen(int healthRegen) {
        this.healthRegen = healthRegen;
    }

    @Override
    public String toString() {
        if(this.monsterId == 0){
            return "No Monster in this Room";
        }
        return "Monster{" +
                "monsterId=" + monsterId +
                ", monsterName='" + monsterName + '\'' +
                ", isAlive=" + isAlive +
                '}';
    }
}