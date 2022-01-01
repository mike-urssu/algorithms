package hyperConnect;

public class Platformer {
    private final int[] tiles;
    private int position;

    public Platformer(int n, int position) {
        this.tiles = new int[n];
        for (int i = 0; i < n; i++)
            tiles[i] = i;
        this.position = position;
    }

    public void jumpLeft() {
        this.tiles[position] = -1;
        int index = position;

        int count = 0;
        while (count < 2) {
            if (tiles[index-- - 1] >= 0)
                count++;
        }
        this.position = index;
    }

    public void jumpRight() {
        this.tiles[position] = -1;
        int index = position;

        int count = 0;
        while (count < 2) {
            if (tiles[index++ + 1] >= 0)
                count++;
        }
        this.position = index;
    }

    public int position() {
        return tiles[position];
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(6, 3);
        System.out.println(platformer.position()); // should print 3

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
    }
}
