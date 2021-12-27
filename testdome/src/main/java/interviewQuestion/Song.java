package interviewQuestion;

/**
 * A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist. Otherwise, the playlist will end with the last song which points to null.
 * <p>
 * Implement a function isRepeatingPlaylist that, efficiently with respect to time used, returns true if a playlist is repeating or false if it is not.
 * <p>
 * For example, the following code prints "true" as both songs point to each other.
 * <p>
 * Song first = new Song("Hello");
 * Song second = new Song("Eye of the tiger");
 * <p>
 * first.setNextSong(second);
 * second.setNextSong(first);
 * <p>
 * System.out.println(first.isRepeatingPlaylist());
 */
public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        Song now = this;
        Song next = this;

        if (now.nextSong == null)
            return false;

        while (next != null && next.nextSong != null) {
            now = now.nextSong;
            next = next.nextSong.nextSong;

            if (now == next)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
