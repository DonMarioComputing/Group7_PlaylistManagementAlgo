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


    }

    public static Song findMostPopular(Song [] songs){
        // todo: ADD findMostPopular() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void sortSongsBySongTitle(Song [] songs){
        // todo: ADD sortSongsBySongTitle() LOGIC
        // Should implement for-loop based bubble sort
        throw new UnsupportedOperationException("Not implemented yet");
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
