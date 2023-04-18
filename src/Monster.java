import java.io.Serializable;
/*
 * Author: Adrian Japa
 * This class is in charge of creating the monsters that will be used in the game.
 */
private String name;
private String dialogue;
private boolean isAlive;
private int attackDmg;
private int health;

public class Monster implements Serializable 
{   
    // constructor
    public Monster(String name, String dialogue, int attackDmg, int health)
    {
        this.name = name;
        this.dialogue = dialogue;
        this.attackDmg = attackDmg;
        this.health = health;
        this.isAlive = true;
    }

    // getters and setters

    //Method of attack to target
    public void attack(Player player)
    {
        int damageDealt = this.attackDmg;
        Systout.out.println(this.name + " attacks " 
        + player.getPlayer() + " for " + damageDealt + " damage.");
        player.takeDamage(damageDealt);
        if(!player.isAlive())
        {
            System.out.println(player.getPlayer() + " has died.");
        }
    }
}
