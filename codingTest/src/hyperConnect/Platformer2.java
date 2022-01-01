package hyperConnect;

import java.util.HashSet;
import java.util.Set;

public class Platformer2 {
    private final Set<Integer> deletedTiles;
    private int position;

    public Platformer2(int n, int position) {
        this.deletedTiles = new HashSet<>();
        this.position = position;
    }

    public void jumpLeft() {
        int index = position;
        int count = 0;
        while (count < 2) {
            if (!deletedTiles.contains(index-- - 1))
                count++;
        }
        deletedTiles.add(position);
        position = index;
    }

    public void jumpRight() {
        int index = position;
        int count = 0;
        while (count < 2) {
            if (!deletedTiles.contains(index++ + 1))
                count++;
        }
        deletedTiles.add(position);
        position = index;
    }

    public int position() {
        return position;
    }

    public static void main(String[] args) {
        Platformer2 platformer = new Platformer2(6, 3);
        System.out.println(platformer.position()); // should print 3

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
    }
}
