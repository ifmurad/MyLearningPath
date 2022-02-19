import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class AlbumRunner {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);

        play(playList);
    }
    private static void printPlayList(LinkedList<Song> playList) {
        System.out.println("===================================");
        for (Song song : playList) {
            System.out.println(song);
        }
        System.out.println("===================================");
    }

    private static void play(LinkedList<Song> playList) {
        boolean quit = false;
        boolean goingForward = false;
        Song currentSong = playList.getFirst();
        ListIterator<Song> playListIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Playing music:\n" + currentSong + "\n");
            menuOfOptions();
        }
        while (!quit) {
            System.out.println("Choose an option to perform:");
            boolean flag = false;
            int option = 0;
            while (!flag) {
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    if(option < 0 || option > 6) {
                        System.out.println("You have to enter an integer between 0 and 6 inclusively.");
                    }
                    flag = true;
                } else {
                    System.out.println("You have to enter an integer between 0 and 6 inclusively.\n" +
                            "Choose an option to perform:");
                }
                scanner.nextLine();
            }
            switch (option) {
                case 0 -> quit = true;
                case 1 -> {
                    if(!goingForward) {
                        currentSong = playListIterator.next();
                        goingForward = true;
                    }
                    if(playListIterator.hasNext()) {
                        currentSong = playListIterator.next();
                        System.out.println("Playing music:\n" + currentSong + "\n");
                    } else {
                        currentSong = playList.getFirst();
                        while (playListIterator.hasPrevious()) {
                            playListIterator.previous();
                        }
                        System.out.println("Playing music:\n" + currentSong + "\n");
                        goingForward = false;
                    }
                }
                case 2 -> {
                    if(goingForward) {
                        currentSong = playListIterator.previous();
                        goingForward = false;
                    }
                    if(playListIterator.hasPrevious()) {
                        currentSong = playListIterator.previous();
                        System.out.println("Playing music:\n" + currentSong + "\n");
                    } else {
                        currentSong = playList.getLast();
                        while (playListIterator.hasNext()) {
                            playListIterator.next();
                        }
                        System.out.println("Playing music:\n" + currentSong + "\n");
                        goingForward = true;
                    }
                }
                case 3 -> System.out.println("Playing music:\n" + currentSong + "\n");
                case 4 -> {
                    playListIterator.remove();
                    System.out.println("Current song is successfully removed from the playlist.");
                }
                case 5 -> printPlayList(playList);
                case 6 -> menuOfOptions();
            }
        }
    }

    private static void menuOfOptions() {
        System.out.println("""
                Menu of options:
                Press
                
                0 - Quit
                1 - Skip forward to the next song
                2 - Skip backwards to the previous song
                3 - Replay the current song
                4 - Remove the song
                5 - List the songs
                6 - Print available actions
                """);
    }
}
