package interviewQuestion;

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
