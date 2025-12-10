package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class SongUtils {

    public static Song[] searchByTag(Song [] songs, String tag){
        // todo: ADD searchByTag() LOGIC
        // Should implement linear search, but not for a single result
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Performs a binary search on a sorted array of Songs to find a song with the given title
     *
     * @param songs the array of Songs to search
     * @param songTitle the title to search for
     * @return the Song with the specified title, if not null
     * @throws IllegalArgumentException if songs or songTitle is null or empty
     */
    public static Song[] searchBySongTitle(Song [] songs, String songTitle){
        // todo: ADD searchBySongTitle() LOGIC
        // Should implement binary search
        if (songs == null || songTitle == null || songTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid song array or song title.");
        }

        int low = 0, high = songs.length - 1;
        String target = songTitle.toLowerCase();

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = target.compareTo(songs[mid].getTitle().toLowerCase());

            if (cmp == 0) return songs[mid];
            if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }

        return null;
    }

    /**
     * Finds and returns the Song with the highest rating in the array
     * If multiple songs have the same highest rating, return the first one
     *
     * @param songs the array of Songs to search
     * @return the most popular Song
     * @throws IllegalArgumentException if songs is null or empty
     */
    public static Song findMostPopular(Song [] songs){
        // todo: ADD findMostPopular() LOGIC
        if (songs == null || songs.length == 0) {
            throw new IllegalArgumentException("Song array cannot be null or empty.");
        }

        Song mostPopular = songs[0];
        for (int i = 1; i < songs.length; i++) {
            if (songs[i].getRating() > mostPopular.getRating()) {
                mostPopular = songs[i];
            }
        }

        return mostPopular;

    }

    /**
     * Sorts an array of Songs in ascending order by song title
     * Implements a Bubble Sort using nested loops
     *
     * @param songs the array of Songs to sort
     * @throws IllegalArgumentException if songs is null
     */
    public static void sortSongsBySongTitle(Song [] songs){
        // todo: ADD sortSongsBySongTitle() LOGIC
        // Should implement for-loop based bubble sort
        if (songs == null) {
            throw new IllegalArgumentException("Song array cannot be null.");
        }

        int n = songs.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (songs[j].getTitle().compareToIgnoreCase(songs[j + 1].getTitle()) > 0) {
                    Song temp = songs[j];
                    songs[j] = songs[j + 1];
                    songs[j + 1] = temp;
                }
            }
        }
    }

    public static void sortSongsByNumTags(Song [] songs){
        // todo: ADD sortSongsByNumTags() LOGIC
        // Should implement selection sort
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static String findMostCommonTag(Song [] songs){
        // todo: ADD findMostCommonTag() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
