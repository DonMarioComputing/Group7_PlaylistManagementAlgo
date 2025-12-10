package app;

import business.Song;
import utils.SongFileUtils;
import utils.SongUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author michelle
 */
public class PlaylistApp {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Song[] songs = SongFileUtils.readSongFile("sampleSongInput.txt");

        boolean keepRunning = true;
        while (keepRunning) {
            displayMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> displayAllSongs(songs);
                case "2" -> sortSongsMenu(songs);
                case "3" -> searchByTag(songs);
                case "4" -> searchByTitle(songs);
                case "5" -> editSongTags(songs);
                case "6" -> displayMostPopularSong(songs);
                case "7" -> displayMostCommonTag(songs);
                case "0" -> {
                    keepRunning = false;
                    System.out.println("Exiting Playlist Application. Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Playlist Menu ---");
        System.out.println("1) Display all songs");
        System.out.println("2) Sort songs");
        System.out.println("3) Search songs by tag");
        System.out.println("4) Search song by title");
        System.out.println("5) Edit a song's tags");
        System.out.println("6) Find the most popular song");
        System.out.println("7) Find the most common tag");
        System.out.println("0) Exit");
        System.out.print("Enter your choice: ");

    }
}
