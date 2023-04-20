import java.util.Scanner;

public class Game {
    private static Map map;
    private static Player player;
    public static void main(String[] args) {
        //Main Menu
        mainMenuIntro();
    }


    public static void newGame(){
        map = new Map();
        player = new Player(map);
        Scanner scan = new Scanner(System.in);

        while(true){
            //might change later but for now if user input is not an int value the user has to enter input again
            try {
                //displays user options and gets user input
                printUserOptions();
                int userInput = Integer.parseInt(scan.nextLine());

                if(userInput == 0){//MOVE OPTION
                    printMoveDirections();
                    userInput = Integer.parseInt(scan.nextLine());
                    player.move(userInput);
                }else if(userInput ==1){//INVENTORY OPTION
                    player.viewPlayerInventory();
                }
            }catch (NumberFormatException e){
                printErrorMessage();
            }
            //end of try catch block
        }
    }



    public static void mainMenuIntro(){
        System.out.println("Welcome to: Let Me Go!");
        boolean validInput = false;
        int input = 0;
        while(true){
            System.out.println("Enter the corresponding number to choose an option: ");
            System.out.println("1. New Game");
            System.out.println("2. Load Game");
            Scanner scan = new Scanner(System.in);
            try{
                input = Integer.parseInt(scan.nextLine());
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
                System.err.println("That input is not valid!");
                System.out.println("___________________________________________");
            }
        }

    }

    //TODO change return type to Player i think
    public static void loadGame(){
        //does nothing rn
    }

    // methods to remove some print statements from main method
    //basically a view.java for now
    public static void printUserOptions(){
        System.out.println("_____________________");
        System.out.println("What do you want to do next?");
        System.out.println("1. Move");
        System.out.println("2. Inventory");
        System.out.println("3. Search Room");
        System.out.println();
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
        System.out.println("1. Pickup");
        System.out.println("2. Exit");
    }
    public static void printErrorMessage(){
        System.err.println("Whoops! Your input was invalid. Try again!");
    }

}