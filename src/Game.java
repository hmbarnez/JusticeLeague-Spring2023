import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Game {
//    private static Map map;
//    private static Player player;
    public static void main(String[] args) {
        //Main Menu
        mainMenuIntro();
    }


    public static void newGame(){
//        map = new Map();
//        player = new Player(map);

        Scanner scan = new Scanner(System.in);
        boolean isGameOver = false;

        while(!isGameOver){
            //might change later but for now if user input is not an int value the user has to enter input again
            try {
                System.out.println("_____________________");
                System.out.println("What do you want to do next?");
                System.out.println("1. Move");
                System.out.println("2.");
                int userInput = Integer.parseInt(scan.nextLine());

                if(userInput == 0){

                }
            }catch (NumberFormatException e){
                System.err.println("Whoops! Your input was invalid. Try again!");
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
}