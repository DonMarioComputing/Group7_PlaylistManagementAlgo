package utils;

import business.Song;

import java.util.Arrays;

/**
 *
 * @author michelle
 */
public class SongUtils {

    public static Song[] searchByTag(Song [] songs, String tag){
        /**
         * @param songs  array of songs
         * @param tag the tag to search for
         * @return an array of songs that contain the given tag
         */

            // todo: ADD searchByTag() LOGIC
            // Should implement linear search, but not for a single result
            //  throw new UnsupportedOperationException("Not implemented yet");

            if (songs==null||tag==null||tag.trim().isEmpty()){
                throw new IllegalArgumentException("song array cannot be null or empty");

            }
            //creating a dublicate array with the same size
            Song[] results=new Song[songs.length];
            int count=0;//counting the matches found
            //check that the song contains the given tag or is it null
            for (Song s: songs){
                if (s!=null&&s.containsTag(tag)){
                    results[count++]=s;//Adding the matching song to the new array
                }
            }
            //creating an array with the actual number of matches found
            return Arrays.copyOf(results,count);
        }

        public static Song[] searchBySongTitle(Song [] songs, String songTitle){
        // todo: ADD searchBySongTitle() LOGIC
        // Should implement binary search
        throw new UnsupportedOperationException("Not implemented yet");
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
