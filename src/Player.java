
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
}
