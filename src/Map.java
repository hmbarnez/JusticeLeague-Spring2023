import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Map implements Serializable {
    private ArrayList<Room> roomArrayList;
    private ArrayList<Item> itemsArrayList;
    private ArrayList<Monster> monstersArrayList;
    private ArrayList<Puzzle> puzzlesArrayList;

    public Map() {roomArrayList = new ArrayList<>();}
    public ArrayList<Room> readRooms(){

        try {
            Scanner scan = new Scanner(new File("GameInformation/finalProjectMap.txt"));
            itemsArrayList = readItems();
            puzzlesArrayList = readPuzzles();
            monstersArrayList = readMonsters();
            while (scan.hasNextLine()){
                int[] directions = new int[4];// array of int values of the roomId next to the current room
                /* directions array room parameters
                0 roomId
                1-4 directions
                5 isVisited
                6 monsterId
                7 puzzleId
                8 itemId - all items in the room
                9 roomName
                10 roomDescription
                 */
                String[] roomArray = scan.nextLine().split("~");

                int roomId = Integer.parseInt(roomArray[0]);
                directions[0] = Integer.parseInt(roomArray[1]);
                directions[1] = Integer.parseInt(roomArray[2]);
                directions[2] = Integer.parseInt(roomArray[3]);
                directions[3] = Integer.parseInt(roomArray[4]);
                boolean isVisited = Boolean.parseBoolean(roomArray[5]);

                // checks the id of the monster located in the room
                // then goes through the list of monsters and adds the correct monster to the room
                int monsterId = Integer.parseInt(roomArray[6]);
                Monster tempMons = null;
                if (!(monsterId==0)){
                    for (Monster x: monstersArrayList){
                        if(monsterId == x.getMonsterId()){
                            tempMons = x;
                        }
                    }
                }else{
                    //empty monster place holder for rooms without monsters
                    tempMons = new Monster();//TODO add no param constructor to monster class for place holder monster -Harrison
                }

                // checks the id of the puzzle located in the room
                // then goes through the list of puzzles and adds the correct puzzle to the room
                int puzzleId = Integer.parseInt(roomArray[7]);
                Puzzle tempPuzz = null;
                if (!(puzzleId==0)){
                    for (Puzzle x: puzzlesArrayList){
                        if(puzzleId == x.getPuzzId()){
                            tempPuzz = x;
                        }
                    }
                }else{
                    //empty puzzle place holder for rooms without puzzles
                    tempPuzz = new Puzzle();
                }

                roomArrayList.add(roomId,directions,isVisited,monsterId,puzzleId,ITEMSARRAYLISTNEEDTOCHANGE,roomName,roomDescription);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return roomArrayList;
    }



    //readMonsters method reads the monsters information text document and returns a list of every monster
    public ArrayList<Monster> readMonsters(){
        ArrayList<Monster> monsters = new ArrayList<>();
        try{
            Scanner scan = new Scanner(new File("GameInformation/monstersInformation.txt"));
            while (scan.hasNextLine()){
                String[] lineSplit = scan.nextLine().split("~");

                int monsterId = Integer.parseInt(lineSplit[0]);
                int attackDmg = Integer.parseInt(lineSplit[1]);
                int healthPoints = Integer.parseInt(lineSplit[2]);
                String monsterName = lineSplit[3];
                String monsterDesc = lineSplit[4];
                monsters.add(new Monster(monsterId, attackDmg, healthPoints, monsterName, monsterDesc));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return monsters;
    }

    //readPuzzles method reads the puzzles information text document and returns a list of every puzzle
    public ArrayList<Puzzle> readPuzzles() {
        ArrayList<Puzzle> puzzles = new ArrayList<>();
        try{
            Scanner scan = new Scanner(new File("GameInformation/puzzlesInformation.txt"));
            while(scan.hasNextLine()){
                // 0-10
                String[] lineSplit = scan.nextLine().split("~");
                int puzzleId = Integer.parseInt(lineSplit[0]);
                int puzzleAttempts = Integer.parseInt(lineSplit[1]);
                String puzzleName = lineSplit[2];
                String puzzleDescription = lineSplit[3];
                String puzzlePrompt = lineSplit[4];
                String q1 = lineSplit[5];
                String a1 = lineSplit[6];
                String q2 = lineSplit[7];
                String a2 = lineSplit[8];
                String q3 = lineSplit[9];
                String a3 = lineSplit[10];
                puzzles.add(new Puzzle(puzzleId, puzzleAttempts, puzzleName, puzzleDescription, puzzlePrompt,q1,a1,q2,a2,q3,a3));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return puzzles;
    }
}

