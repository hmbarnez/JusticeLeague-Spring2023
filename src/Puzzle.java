import java.io.Serializable;

public class Puzzle implements Serializable {
    private int puzzleId;
    private int puzzleAttempts;
    private String puzzleName;
    private String puzzleDescription;
    private String puzzlePrompt;
    private String Q1;
    private String A1;
    private String Q2;
    private String A2;
    private String Q3;
    private String A3;


    public Puzzle(int puzzleId, int puzzleAttempts, String puzzleName, String puzzleDescription, String puzzlePrompt
                    , String Q1, String A1, String Q2, String A2, String Q3, String A3) {
        this.puzzleId = puzzleId;
        this.puzzleAttempts = puzzleAttempts;
        this.puzzleName = puzzleName;
        this.puzzleDescription = puzzleDescription;
        this.puzzlePrompt = puzzlePrompt;
        this.Q1 = Q1;
        this.A1 = A1;
        this.Q2 = Q2;
        this.A2 = A2;
        this.Q3 = Q3;
        this.A3 = A3;
    }

    public int getPuzzleId() {
        return puzzleId;
    }

    public int getPuzzleAttempts() {
        return puzzleAttempts;
    }

    public String getPuzzleName() {
        return puzzleName;
    }

    public String getPuzzleDescription() {
        return puzzleDescription;
    }

    public String getPuzzlePrompt() {
        return puzzlePrompt;
    }

    public String getQ1() {
        return Q1;
    }

    public String getA1() {
        return A1;
    }

    public String getQ2() {
        return Q2;
    }

    public String getA2() {
        return A2;
    }

    public String getQ3() {
        return Q3;
    }

    public String getA3() {
        return A3;
    }


    //no param constructor for if there are no puzzles in the room
    public Puzzle(){
        this.puzzleId = 0;
    }
}
