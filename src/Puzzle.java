import java.io.Serializable;
import java.util.Scanner;

/*
 * Author: Jay Tak
 * This class is responsible for detailing the elements of the game's puzzles.
 */

public class Puzzle implements Serializable {
    private int puzzleId;
    private int puzzleAttempts;
    private String puzzleName;
    private String puzzleDescription;
    private String puzzlePrompt;
    private String q1;
    private String a1;
    private String q2;
    private String a2;
    private String q3;
    private String a3;
    private boolean isSolved;


    public Puzzle(int puzzleId, int puzzleAttempts, String puzzleName, String puzzleDescription, String puzzlePrompt
            , String q1, String a1, String q2, String a2, String q3, String a3, boolean isSolved) {
        this.puzzleId = puzzleId;
        this.puzzleAttempts = puzzleAttempts;
        this.puzzleName = puzzleName;
        this.puzzleDescription = puzzleDescription;
        this.puzzlePrompt = puzzlePrompt;
        this.q1 = q1;
        this.a1 = a1;
        this.q2 = q2;
        this.a2 = a2;
        this.q3 = q3;
        this.a3 = a3;
        this.isSolved = isSolved;
    }

    public void solvePuzzle() {
        Scanner scan = new Scanner(System.in);
        int tempAttempts = this.puzzleAttempts;
        String[] quesArray = {q1, q2, q3};
        String[] ansArray = {a1, a2, a3};
        int i = 0;
        while (tempAttempts != 0) {
            System.out.println(quesArray[i]);
            String answer = scan.nextLine();
            if (answer.equals(ansArray[i])) {
                System.out.println("Correct!");
                if (i == 2) {
                    System.out.println("You completed the puzzle!");
                    isSolved = true;
                    break;
                }
                i++;
            } else {
                System.out.println("Wrong! Try Again.");
                tempAttempts--;
                if (tempAttempts == 0) {
                    System.out.println("You failed the puzzle!");
                    break;
                }
            }
        }
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
        return q1;
    }

    public String getA1() {
        return a1;
    }

    public String getQ2() {
        return q2;
    }

    public String getA2() {
        return a2;
    }

    public String getQ3() {
        return q3;
    }

    public String getA3() {
        return a3;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "puzzleId=" + puzzleId +
                ", puzzleAttempts=" + puzzleAttempts +
                ", puzzleName='" + puzzleName + '\'' +
                ", puzzleDescription='" + puzzleDescription + '\'' +
                ", puzzlePrompt='" + puzzlePrompt + '\'' +
                ", q1='" + q1 + '\'' +
                ", a1='" + a1 + '\'' +
                ", q2='" + q2 + '\'' +
                ", a2='" + a2 + '\'' +
                ", q3='" + q3 + '\'' +
                ", a3='" + a3 + '\'' +
                ", isSolved=" + isSolved +
                '}';
    }
}
