package game;

import static utils.Constants.BLANK_TILE;

public class Tile {
    private final boolean isBlank;
    private char letter;
    private final int score;

    public Tile(char letter, int score, boolean isBlank) {
        this.isBlank = isBlank;
        this.score = isBlank ? 0 : score;
        this.letter = isBlank ? BLANK_TILE : letter;
    }

    public char getLetter() {
        return letter;
    }
    public int getScore() {
        return score;
    }
    public boolean isBlank() {
        return isBlank;
    }

    //Allows setting the letter once blank tile is used.
    public boolean setLetter(char chosenLetter) {
        if (isBlank) {
            this.letter = chosenLetter;
        }
        return false;
    }

}
