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
//            itemsArrayList = readItems();
//            puzzlesArrayList = readPuzzles();
//            monstersArrayList = readMonsters();
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
                // checking for monsterId from monstersArrayList to add monster to room
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
                // checking for puzzleId from puzzlesArrayList to add puzzle to room
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

                roomArrayList.add(roomId,directions,isVisited,monsterId,puzzleId,itemsArrayList,roomName,roomDescription);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return roomArrayList;
    }

    public ArrayList<Monster> readMonsters(){
        ArrayList<Monster> monsters = new ArrayList<>();
        try{
            Scanner scan = new Scanner(new File("GameInformation/monstersInformation/txt"));
            while (scan.hasNextLine()){
                String[] lineSplit = scan.nextLine().split("~");

                int monsterId = Integer.parseInt(lineSplit[0]);
                int attackDmg = Integer.parseInt(lineSplit[1]);
                int healthPoints = Integer.parseInt(lineSplit[2]);
                String monsterName = lineSplit[3];
                String monsterDesc = lineSplit[4];
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

