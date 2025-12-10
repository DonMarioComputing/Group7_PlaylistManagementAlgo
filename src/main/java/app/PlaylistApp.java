package app;

import business.Song;
import utils.SongFileUtils;
import utils.SongUtils;

import java.util.Arrays;
import java.util.Scanner;

import static PlaylistApp.scanner;

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

            /**
             * @author DonMario
             */
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

    /**
     * @author DonMario
     */
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

    /**
     * Display all songs in the given array
     * @param songs is the array
     * @author Nassim
     */

    private static void displayAllSongs(Song[] songs) {
        System.out.println("All songs");
        for (Song song : songs){
            //looping through every song and printing
            System.out.println(song.format());
        }
    }

    /**
     * puser need to choose how to sort
     * tags or by title
     * @param songs is the array
     * @author Nassim
     */
    private static void sortSongsMenu(Song[] songs){
        // Read user input
        String choice=scanner.nextLine().trim();
//Switchng the options
        switch (choice){
            case "1"->{
                //sorting by tags
                SongUtils.sortSongsByNumTags(songs);
                displayAllSongs(songs);
            }
            case "2"->{
                // by title
                SongUtils.sortSongsBySongTitle(songs);
                displayAllSongs(songs);
            }
            default -> System.out.println("invalid");
        }
    }
    /**
     * Searches for songs that contain a specific tag.
     * If matches are found, they are displayed; otherwise,
     * no match
     *
     * @param songs is an array
     * @author Nassim
     */
    private static void searchByTag(Song[] songs){
        //user input
        String tag= scanner.nextLine().trim();
        //search song with given tag
        Song[] tSong=SongUtils.searchByTag(songs,tag);
        //check if anything found
        if (tSong.length==0){
            System.out.println("no song found by this"+tag);

        }else {
            //prining matching songs
            System.out.println("the song u searched for");
            for (Song song : tSong) {
                System.out.println(song.format());
            }
        }
    }

//Search for a specific song based on song title (and display it if present)

    /**
     * Searches for a song by title using binary search
     * Songs array is sorted by title before searching
     *
     * @param songs array of Song objects
     * @author DonMario
     */
    private static void searchByTitle(Song[] songs) {
        System.out.print("Enter song title to search: ");
        String title = PlaylistApp.scanner.nextLine().trim();

        // Sort by title before binary search
        SongUtils.sortSongsBySongTitle(songs);
        Song[] found = SongUtils.searchBySongTitle(songs, title);

        if (found == null) {
            System.out.println("Song not found: " + title);
        } else {
            System.out.println("Song found:");
            for (int i=0;i< found.length;i++) {
                System.out.println(found[i].format());
            }

        }
    }

//Choose a song to edit, then
//o Add an tag to the specified song
//o Remove an tag from the specified song

    /**
     * Allows the user to add or remove tags from a specific song
     *
     * @param songs array of Song objects
     * @author DonMario
     */
    private static void editSongTags(Song[] songs) {
        System.out.print("Enter the title of the song to edit: ");
        String title = PlaylistApp.scanner.nextLine().trim();

        // Sort by title before binary search
        SongUtils.sortSongsBySongTitle(songs);
        Song song = SongUtils.searchBySongTitle(songs, title);

        if (song == null) {
            System.out.println("Song not found: " + title);
            return;
        }

        System.out.println("Editing tags for: " + song.getTitle());
        System.out.println("Current tags: " + Arrays.toString(song.getTags()));
        System.out.println("1) Add a tag");
        System.out.println("2) Remove a tag");
        System.out.print("Enter choice: ");
        String choice = PlaylistApp.scanner.nextLine().trim();

        switch (choice) {
            case "1" -> {
                System.out.print("Enter tag to add: ");
                String tagToAdd = PlaylistApp.scanner.nextLine().trim();
                try {
                    if (song.addTag(tagToAdd)) {
                        System.out.println("Tag added successfully.");
                    } else {
                        System.out.println("Tag already exists.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            case "2" -> {
                System.out.print("Enter tag to remove: ");
                String tagToRemove = PlaylistApp.scanner.nextLine().trim();
                try {
                    song.removeTag(tagToRemove);
                    System.out.println("Tag removed successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            default -> System.out.println("Invalid choice for editing tags.");
        }
    }
    /**
     * Finds and displays the most popular song
     *
     * @param songs array of Song objects
     * @author DonMario
     */
    private static void displayMostPopularSong(Song[] songs) {
        try {
            Song popular = SongUtils.findMostPopular(songs);
            System.out.println("\n--- Most Popular Song ---");
            System.out.println(popular.format());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Finds and displays the most common tag across all songs
     *
     * @param songs array of Song objects
     * @author DonMario
     */
    private static void displayMostCommonTag(Song[] songs) {
        try {
            String commonTag = SongUtils.findMostCommonTag(songs);
            if (commonTag != null) {
                System.out.println("Most common tag in playlist: " + commonTag);
            } else {
                System.out.println("No tags found in the playlist.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

