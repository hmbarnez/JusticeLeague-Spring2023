import java.io.Serializable;
/*
 * Author: Adrian Japa
 * This class is in charge of creating the monsters that will be used in the game.
 */


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