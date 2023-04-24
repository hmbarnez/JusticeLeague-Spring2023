import java.io.*;
import java.util.Scanner;

public class Game {
    private static Map map;
    private static Player player;
    //private static Scanner scan;
    public static void main(String[] args) {
        //map = new Map();
        //Main Menu
        mainMenuIntro();
    }
    /*Author: Harrison Barnes
     * Game class takes in user input to control the user's character.
     * The newGame method is where the main input loop is found.
     * The mainMenuIntro method asks the user to start a new game or load from previous save.
     * Items and Room inventory menus displays all items in the room and allows user to take further action or do nothing.
     */
    public static void newGame(Player playerPara){
        if(playerPara != null){
            player = playerPara;
        }
        Scanner scan = new Scanner(System.in);
        //trying something different with scan might change later
        //scan = new Scanner(System.in);

        while(true){
            //might change later but for now if user input is not an int value the user has to enter input again
            try {
                printUserOptions();
                int userInput = Integer.parseInt(scan.nextLine());
                //displays user options and gets user input
                System.out.println("__________________________________________________");
                switch (userInput) {
                    case 1,2,3,4 -> {
                        player.move(userInput);
                    }
//                    System.out.println("1. N");
//                    System.out.println("2. E");
//                    System.out.println("3. S");
//                    System.out.println("4. W");
//                    System.out.println("5. Inventory");
//                    System.out.println("6. Search Room");
//                    System.out.println("7. Save Game");
//                    System.out.println("8. Exit Game");
                    case 5 ->
                        //calls inventory menu method
                        //opens up inventory menu and allows user to interact specified item in their inventory
                            viewPlayerInventoryMenu();
                    case 6 ->
                        //search room method
                        //displays room inventory and allows user to pickup items or return to this menu
                            roomInventoryMenu();
                    case 7 -> saveGame();
                    case 8 -> System.exit(0);
                    case 55 -> {
                        //used for testing and seeing player's stats
                        System.out.println(player);
                    }
                    case 66 -> {
                        //used for testing and seeing player's stats
                        System.out.println(player.getCurrentRoom());
                    }
                    default -> printErrorMessage();
                }
            }catch (NumberFormatException e){
                printErrorMessage();
            }
            //end of try catch block
        }
    }


    //Main menu
    public static void mainMenuIntro(){
        System.out.println("Welcome to: Let Me Go!");
        Scanner scan = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput){
            System.out.println("Enter the corresponding number to choose an option: ");
            System.out.println("1. New Game");
            System.out.println("2. Load Game");
            System.out.println("__________________________________________________");
            //Scanner scan = new Scanner(System.in);
            try{
                int input = Integer.parseInt(scan.nextLine());
                switch (input) {
                    case 1 -> {
                        System.out.println("Game Intro here");
                        newGame(new Player(new Map()));
                    }
                    case 2 -> {
                        player = loadGame();
                        newGame(player);
                    }
                    default -> System.err.println("That input is not valid!");
                }
            }catch (NumberFormatException e){
                System.out.println("MAINMENU_ERROR");
                printErrorMessage();
            }
        }

    }

    //move menu not used
    public static void moveMenu(){

        boolean exitMoveMenu = false;
        Scanner scan = new Scanner(System.in);
        while(!exitMoveMenu){
            try {

                printMoveDirections();
                int moveDirection = Integer.parseInt(scan.nextLine());
                switch (moveDirection) {
                    case 1 -> {
                        player.move(0);
                        exitMoveMenu = true;
                    }
                    case 2 -> {
                        player.move(1);
                        exitMoveMenu = true;
                    }
                    case 3 -> {
                        player.move(2);
                        exitMoveMenu = true;
                    }
                    case 4 -> {
                        player.move(3);
                        exitMoveMenu = true;
                    }
                    default -> printErrorMessage();
                }
            }catch (NumberFormatException e){
                //System.out.println("MOVEMENU_ERROR");
                printErrorMessage();
            }
        }
        //System.out.println("test sout, end of move menu");
    }


    //inventory menu
    public static void viewPlayerInventoryMenu(){
        System.out.println("Choose Corresponding Item # to interact with (or 0 to exit): ");
        Scanner scan = new Scanner(System.in);
        
        //viewPlayerInventory returns true if there is something in the ArrayList
        //if playerInventory ArrayList is empty, the while loop is skipped
        
        boolean exitItemMenu = player.viewPlayerInventory();
        System.out.println("__________________________________________________");
        while (exitItemMenu){
            try{
                int itemChoiceId = Integer.parseInt(scan.nextLine());
                if(itemChoiceId < 0 || itemChoiceId > player.getPlayerInventory().size()){
                    printErrorMessage();
                    break;
                }
                else if(itemChoiceId == 0){
                    exitItemMenu = false;
                    break;
                }
                System.out.println(player.getPlayerInventory().get(itemChoiceId-1)); //Author Brian
                System.out.println(player.getPlayerInventory().get(itemChoiceId-1).getItemDesc()); //Author Brian
                System.out.println("__________________________________________________");
                System.out.println("Choose what to do with this item: ");
                printSelectedItemOptions();
                int userInput = Integer.parseInt(scan.nextLine());

                switch (userInput) {
                    case 1 -> {
                        player.dropItem(itemChoiceId);
                        exitItemMenu = false;
                       System.out.println("Item Dropped");

                    }
                    case 2 -> {
                        player.equipItem(itemChoiceId);
                        exitItemMenu = false;
                        System.out.println("Item Equipped");
                    }
                    case 3 -> {
                        player.useItem(itemChoiceId);
                        exitItemMenu = false;
                        System.out.println("Item Used");
                    }
                    case 4 -> exitItemMenu = false;
                    default -> printErrorMessage();
                }

            }catch (NumberFormatException e){
                //System.out.println("INVMENU_ERROR");
                printErrorMessage();
            }
        }
        //System.out.println("Delete this sout but end of inventory method");
    }

    //viewPlayerInventory returns true if there is something in the ArrayList
    //if playerInventory ArrayList is empty, the while loop is skipped
    public static void roomInventoryMenu(){
        Scanner scan = new Scanner(System.in);
        //printRoomItemOptions();
        boolean exitRoomInventory = player.viewRoomInventory();
        while(exitRoomInventory){
            try {
                printRoomItemOptions();
                //System.out.println("TESTING "+ player.getCurrentRoom().getRoomInventory().size());
                int itemChoiceId = Integer.parseInt(scan.nextLine());
//                switch (itemChoiceId) {
//                    case 0 -> exitRoomInventory = false;
//                    case 1 -> if;
//                    default -> printErrorMessage();
//                }
                if(itemChoiceId == 0){
                    break;
                }else if(itemChoiceId > 0 && itemChoiceId <= player.getCurrentRoom().getRoomInventory().size()){
                    player.pickupItem(itemChoiceId);
                    break;
                }else {
                    printErrorMessage();
                }

            }catch (NumberFormatException e){
                //System.out.println("ROOMINVMENU_ERROR");
                printErrorMessage();
            }

        }
        //System.out.println("Delete this sout but end of inventory method");

    }


    public static Player loadGame(){
        Object temp = player;
        try {
            ObjectInputStream loader = new ObjectInputStream(new FileInputStream("saves/GameSave.bin"));
            temp = loader.readObject();
        } catch (IOException e) {
            System.err.println("That save name does not exist!");
            //return p1;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (Player) temp;
    }

    public static void saveGame(){
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("saves/GameSave.bin"));
            writer.writeObject(player);
            System.out.println("game saved");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    // methods to remove some print statements from main method
    //basically a view.java for now
    public static void printUserOptions(){
        System.out.println("__________________________________________________");
        System.out.println("What do you want to do next?");
        //System.out.println("1. Move");
        System.out.println("1. North");
        System.out.println("2. East");
        System.out.println("3. South");
        System.out.println("4. West");
        System.out.println("5. Inventory");
        System.out.println("6. Search Room");
        System.out.println("7. Save Game");
        System.out.println("8. Exit Game");
        System.out.println("__________________________________________________");
    }
    public static void printMoveDirections(){
        System.out.println("1. North");
        System.out.println("2. East");
        System.out.println("3. South");
        System.out.println("4. West");
        System.out.println("Enter number direction to move: ");
    }
    //Might have to move inventory option prints to the player class
    public static void printSelectedItemOptions(){
        System.out.println("1. Drop");
        System.out.println("2. Equip");
        System.out.println("3. Use");
        System.out.println("4. Exit");
        System.out.println("__________________________________________________");    }
    public static void printRoomItemOptions(){
        //System.out.println("1. Pickup Item");
        System.out.println("__________________________________________________");
        System.out.println("Choose Corresponding Item # to pickup (or 0 to exit): ");
        

    }
    public static void printErrorMessage(){
        System.err.println("Whoops! Your input was invalid. Try again!");
    }

}