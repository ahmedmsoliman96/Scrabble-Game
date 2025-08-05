package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rack {
    private final List<Tile> rackTiles;

    public Rack() {
        this.rackTiles = new ArrayList<Tile>(7);
    }
    public List<Tile> getRackTiles() {
        return Collections.unmodifiableList(rackTiles);
    }

    public void addTile(Tile tile) {
        rackTiles.add(tile);
    }

    public void addTiles(List<Tile> tiles) {
        rackTiles.addAll(tiles);
    }

    public void clear() {
        rackTiles.clear();
    }

    public int size() {
        return rackTiles.size();
    }

    public boolean isFull() {
        return rackTiles.size() == 7;
    }

    public void removeTile(Tile tile) {
        rackTiles.remove(tile); // relies on equals() method
    }

    public Tile removeTileByIndex(int index) {
        Collections.swap(rackTiles, index, rackTiles.size() - 1);
        return rackTiles.removeLast();
    }

}
