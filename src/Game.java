import java.util.Scanner;

public class Game {
    private static Map map;
    private static Player player;
    private static Scanner scan;
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        //Main Menu
        mainMenuIntro();
    }


    public static void newGame(){
        map = new Map();
        player = new Player(map);
        //trying something different with scan might change later
        //scan = new Scanner(System.in);

        while(true){
            //might change later but for now if user input is not an int value the user has to enter input again
            try {
                int userInput = Integer.parseInt(scan.nextLine());
                //displays user options and gets user input
                printUserOptions();
                switch (userInput) {
                    case 1 -> {
                        printMoveDirections();
                        player.move(userInput);
                    }
                    case 2 ->
                        //calls inventory menu method
                        //opens up inventory menu and allows user to interact specified item in their inventory
                            viewInventoryMenu();
                    case 3 ->
                        //search room method
                        //displays room inventory and allows user to pickup items or return to this menu
                            roomInventoryMenu();
                    case 4 -> saveGame();
                    case 5 -> System.exit(0);
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
        boolean validInput = false;
        while(!validInput){
            System.out.println("Enter the corresponding number to choose an option: ");
            System.out.println("1. New Game");
            System.out.println("2. Load Game");
            //Scanner scan = new Scanner(System.in);
            try{
                int input = Integer.parseInt(scan.nextLine());
                switch (input){
                    case 1:
                        newGame();
                        break;
                    case 2:
                        loadGame();
                        break;
                    default:
                        System.err.println("That input is not valid!");
                }
            }catch (NumberFormatException e){
                printErrorMessage();
            }
        }

    }

    //inventory menu
    public static void viewInventoryMenu(){
        System.out.println("Choose one of the following: ");
        player.viewPlayerInventory();
        boolean exitItemMenu = false;
        while (!exitItemMenu){
            try{
                int itemChoiceId = Integer.parseInt(scan.nextLine());
                System.out.println("Need to change but this prompt. Choose what to do with this item: ");
                printSelectedItemOptions();
                int userInput = Integer.parseInt(scan.nextLine());

                switch (userInput){
                    case 1:
                        player.dropItem(itemChoiceId);
                        exitItemMenu = true;
                        break;
                    case 2:
                        player.equipItem(itemChoiceId);
                        exitItemMenu = true;
                        break;
                    case 3:
                        player.useItem(itemChoiceId);
                        exitItemMenu = true;
                        break;
                    case 4:
                        exitItemMenu = true;
                        break;
                    default:
                        printErrorMessage();
                }

            }catch (NumberFormatException e){
                printErrorMessage();
            }
        }
        System.out.println("Delete this sout but end of inventory method");
    }

    public static void roomInventoryMenu(){
        printRoomItemOptions();
        player.printRoomInventory();
        boolean exitItemInventory = false;
        while(!exitItemInventory){
            try {
                int itemChoiceId = Integer.parseInt(scan.nextLine());
                switch (itemChoiceId){
                    case 0:
                        exitItemInventory = true;
                        break;
                    case 1:
                        player.pickupItem(itemChoiceId);
                        break;
                }
            }catch (NumberFormatException e){
                printErrorMessage();
            }

        }
        System.out.println("Delete this sout but end of inventory method");

    }


    public static void loadGame(){
        //TODO load method also change return type to: Player
    }

    public static void saveGame(){
        //TODO save method
    }

    // methods to remove some print statements from main method
    //basically a view.java for now
    public static void printUserOptions(){
        System.out.println("_____________________");
        System.out.println("What do you want to do next?");
        System.out.println("1. Move");
        System.out.println("2. Inventory");
        System.out.println("3. Search Room");
        System.out.println("4. Save Game");
        System.out.println("5. Exit Game");
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
    }
    public static void printRoomItemOptions(){
//        System.out.println("1. Pickup");
//        System.out.println("2. Exit");
        System.out.println("0. Drop");
        System.out.println("or Choose Corresponding Item # to pickup: ");
    }
    public static void printErrorMessage(){
        System.err.println("Whoops! Your input was invalid. Try again!");
    }

}