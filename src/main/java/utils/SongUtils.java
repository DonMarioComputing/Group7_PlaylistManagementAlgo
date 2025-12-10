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

    /**
     *
     * @param songs the array of songsto sort
     */
    public static void sortSongsByNumTags(Song [] songs){
        // todo: ADD sortSongsByNumTags() LOGIC
        // Should implement selection sort
//        throw new UnsupportedOperationException("Not implemented yet");

        if (songs==null){
            throw new IllegalArgumentException("songs can't be null");

        }
        //outerLoop going through each pos in the array
        for (int i=0;i<songs.length;i++){
            int maxIndex=i;//assuming max tag count is current index
            //innerLoop finding the highest tag count
            for (int j=i+1;j<songs.length;j++){
                if (songs[j].getTagCount()>songs[maxIndex].getTagCount()){
                    maxIndex=j;//finding the highest tag count
                }
            }
            //swaping the songs
            Song swap=songs[i];
            songs[i]=songs[maxIndex];
            songs[maxIndex]=swap;
        }
    }

    /**
     *
     * @param songs the array of song
     * @return the most common tag
     */

    public static String findMostCommonTag(Song [] songs){
        // todo: ADD findMostCommonTag() LOGIC
        //  throw new UnsupportedOperationException("Not implemented yet");

        if (songs==null||songs.length==0){
            throw new IllegalArgumentException("songs cant be null");
        }

        //finding the total tag

        int tagLength=0;
        for (int i=0;i< songs.length;i++){
            if (songs[i]!=null){
                tagLength+=songs[i].getTagCount();
            }
        }
        //creating newArrayrray with  total tagNumber
        String[] nArray= new String[tagLength];
        int tagCount=0;
        for (int i=0;i< songs.length;i++){
            if (songs[i]!=null){
                for (int j=0;j<songs[i].getTagCount();j++){
                    nArray[tagCount++]=songs[i].getTags()[j];//copying each tags
                }
            }
        }
        //if no found return null
        if (tagCount==0){
            return null;
        }
        //Counting the freq of each tag
        int maxFreq=0;
        String commenTag=null;

        for (int i=0;i<tagCount;i++){
            String tag=nArray[i];
            int freq=0;

//Counting the tag in the array
            for (int j=0;j<tagCount;j++){
                if (tag.equalsIgnoreCase(nArray[j])){
                    freq++;
                }
            }
            //updating thr tag with comon tag
            if (freq>maxFreq||freq==maxFreq){
                maxFreq=freq;
                commenTag=tag;
            }
        }
        //return mostCommon tag
        return commenTag;



    }
}


