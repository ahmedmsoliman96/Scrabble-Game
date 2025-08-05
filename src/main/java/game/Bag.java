package game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static utils.Constants.BLANK_TILE;

public class Bag {
    private final List<Tile> bagTiles;
    private final Random random;

    Bag() {
        bagTiles = new ArrayList<Tile>();
        random = new Random();
        this.initializeBagTiles();
    }

    private void initializeBagTiles() {
        this.addTiles('A', 9, 1, false);
        this.addTiles('B', 2, 3, false);
        this.addTiles('C', 2, 3, false);
        this.addTiles('D', 4, 2, false);
        this.addTiles('E', 12, 1, false);
        this.addTiles('F', 2, 4, false);
        this.addTiles('G', 3, 2, false);
        this.addTiles('H', 2, 4 ,false);
        this.addTiles('I', 9, 1, false);
        this.addTiles('J', 1, 8, false);
        this.addTiles('K', 1, 5, false);
        this.addTiles('L', 4, 1, false);
        this.addTiles('M', 2, 3, false);
        this.addTiles('N', 6, 1, false);
        this.addTiles('O', 8, 1, false);
        this.addTiles('P', 2, 3, false);
        this.addTiles('Q', 1, 10, false);
        this.addTiles('R', 6, 1, false);
        this.addTiles('S', 4, 1, false);
        this.addTiles('T', 6, 1, false);
        this.addTiles('U', 4, 1, false);
        this.addTiles('V', 2, 4, false);
        this.addTiles('W', 2, 4, false);
        this.addTiles('X', 1, 8, false);
        this.addTiles('Y', 2, 4, false);
        this.addTiles('Z', 1, 10, false);
        this.addTiles(BLANK_TILE, 2, 0, true); // Blank tiles
    }

    private void addTiles(char letter, int frequency, int score, boolean isBlank ) {
        for(int i=0; i<frequency; ++i) {
            bagTiles.add(new Tile(letter,score,isBlank));
        }
    }

    public List<Tile> drawTiles(int count) {
        List<Tile> drawn = new ArrayList<>();
        for (int i = 0; i < count && !bagTiles.isEmpty(); ++i) {
            drawn.add(this.drawTile());
        }
        return drawn;
    }

    public Tile drawTile() {
        if (bagTiles.isEmpty()) {
            return null;
        }
        int index = random.nextInt(bagTiles.size());
        Collections.swap(bagTiles, index, bagTiles.size() - 1);
        return bagTiles.removeLast();
    }

    public void addTile(Tile tile) {
        bagTiles.add(tile);
    }

    public boolean isEmpty(){
        return bagTiles.isEmpty();
    }

    public int Size() {
        return bagTiles.size();
    }
}
