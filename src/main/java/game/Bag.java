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
        initializeBagTiles();
    }

    private void initializeBagTiles() {
        addTiles('A', 9, 1, false);
        addTiles('B', 2, 3, false);
        addTiles('C', 2, 3, false);
        addTiles('D', 4, 2, false);
        addTiles('E', 12, 1, false);
        addTiles('F', 2, 4, false);
        addTiles('G', 3, 2, false);
        addTiles('H', 2, 4 ,false);
        addTiles('I', 9, 1, false);
        addTiles('J', 1, 8, false);
        addTiles('K', 1, 5, false);
        addTiles('L', 4, 1, false);
        addTiles('M', 2, 3, false);
        addTiles('N', 6, 1, false);
        addTiles('O', 8, 1, false);
        addTiles('P', 2, 3, false);
        addTiles('Q', 1, 10, false);
        addTiles('R', 6, 1, false);
        addTiles('S', 4, 1, false);
        addTiles('T', 6, 1, false);
        addTiles('U', 4, 1, false);
        addTiles('V', 2, 4, false);
        addTiles('W', 2, 4, false);
        addTiles('X', 1, 8, false);
        addTiles('Y', 2, 4, false);
        addTiles('Z', 1, 10, false);
        addTiles(BLANK_TILE, 2, 0, true); // Blank tiles
    }

    private void addTiles(char letter, int frequency, int score, boolean isBlank ) {
        for(int i=0; i<frequency; ++i) {
            bagTiles.add(new Tile(letter,score,isBlank));
        }
    }

    public List<Tile> drawTiles(int count) {
        List<Tile> drawn = new ArrayList<>();
        for (int i = 0; i < count && !bagTiles.isEmpty(); ++i) {
            drawn.add(drawTile());
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
