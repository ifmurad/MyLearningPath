import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            Song song = new Song(title,duration);
            songs.add(song);
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for(Song song : songs) {
            if(song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if (trackNumber > 0 && trackNumber <= songs.size()) {
            Song song = songs.get(trackNumber-1);
            if (findSong(song.getTitle()) != null) {
                playlist.add(song);
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        return false;
    }

    public void printSongs() {
        System.out.println("This album contains following songs:");
        for (Song song : songs) {
            System.out.println(song.toString());
        }
    }
}
