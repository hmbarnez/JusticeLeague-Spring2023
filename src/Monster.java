import java.io.Serializable;
import java.util.Random;
/*
 * Author: Adrian Japa
 * This class is in charge of creating the monsters that will be used in the game.
 */
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;


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


    

    // getters and setters
    public boolean isAlive() 
    {
        return isAlive;
    }

    public void setIsAlive(boolean b)
    {
        this.isAlive = b;
    }

    public String getMonsterName()
    {
        return monsterName;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public int setHealthPoints(int healthPoints) 
    {
        return this.healthPoints = healthPoints;
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