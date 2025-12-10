package business;

import java.util.Arrays;
import java.util.Objects;

public class Song {
    private String title;
    private String artist;
    private String album;
    private double rating;
    private String genre;
    private String [] tags;
    private int tagCount;

    public Song(String title, String artist, String album, double rating, String genre, String[] tags) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.rating = rating;
        this.genre = genre;
        this.tags = tags;
        this.tagCount = tags.length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String[] getTags() {
        return tags;
    }

    // You may not add the setTags method

    public int getTagCount() {
        return tagCount;
    }

    public void setTagCount(int tagCount) {
        this.tagCount = tagCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, album);
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", tagCount=" + tagCount +
                '}';
    }

    /**
     * Add a new tag to the song in sorted order
     * if the tag already exist it's not added
     * @param tag the tag to add
     * @return true if the tag was added false if already existed
     */

    public boolean addTag(String tag){
        // todo: ADD addTag() LOGIC
        // Should implement APPROPRIATE insert action
        // Question to ask yourself: Which is more appropriate here - overwrite or shift?
        // Reminder: Do not allow duplicate tags to be added!
        // Reminder: Make sure you insert in SORTED ORDER!
        if (tag==null){
            throw new IllegalArgumentException("tag cannot be null");
        }
        tag =tag.trim();

        if(tag.trim().isEmpty()){
            throw new IllegalArgumentException("tag cannot be empty");

        }
        //Not Adding duplicates
        if(containsTag(tag)){
            return false;
        }
        //Expanding the array
        if (tagCount==tags.length){
            tags=Arrays.copyOf(tags,tags.length+3);
        }
        //Find the corrected insertion point
        int insertIndex=0;
        while(insertIndex<tagCount&&tags[insertIndex].compareToIgnoreCase(tag)<0){
            insertIndex++;
        }
        //Shift elements to the right
        for (int i=tagCount;i>insertIndex;i--){
            tags[i]=tags[i-1];
        }
        //Insert the tag
        tags[insertIndex]=tag;
        tagCount++;
        return true;


    }
    public boolean removeTag(String tag){
        // todo: ADD removeTag() LOGIC
        // Should implement APPROPRIATE delete action
        // Question to ask yourself: Which is more appropriate here - overwrite or shift?
        /**
         * Removes a tag shifting the remaining entries
         * Throws exception if tag is not found
         *
         * @param tag tag to remove
         * @return true if removed
         */
        if (tag == null || tag.trim().isEmpty()) {
            throw new IllegalArgumentException("Tag cannot be null or empty.");
        }

        if (!containsTag(tag)) {
            throw new IllegalArgumentException("Tag not found: " + tag);
        }

        String[] newTags = new String[tagCount - 1];
        int i = 0;

        for (int j = 0; j < tagCount; j++) {
            if (!tags[j].equalsIgnoreCase(tag)) {
                newTags[i++] = tags[j];
            }
        }

        tags = newTags;
        tagCount--;
        return true;

    }

    /**
     * check weather the given tag exist in the collection
     * @param tag the tag to search
     * @return true if the tag exists, false if the tag is invalid if it's not present;
     */

    public boolean containsTag(String tag){
        // todo: ADD containsTag() LOGIC
        // Should implement binary search
        //   throw new UnsupportedOperationException("Not implemented yet");
        if (tag==null){
            throw new IllegalArgumentException("tag cannot be null");
        }
        tag =tag.trim();
        if(tag.trim().isEmpty()){
            throw new IllegalArgumentException("tag cannot be empty");

        }
        //Binary Search
        int low=0;
        int high=tagCount-1;

        while(low<=high){
            int mid=(low+high)/2;

            //compare middle elements with the target
            int compare= tags[mid].compareToIgnoreCase(tag);
            if (compare==0){//two strings are equel
                return true;
            } else if (compare<0) {//target elemet is after the middle element
                low=mid+1;

            }
            else {//target elemet is before the middle element
                high=mid-1;
            }

        }

        return false;
        //if it's not found

    }

    public String format(){
        // todo: ADD format() LOGIC
        /**
        * Returns formatted song detail
        * @return song information
        */
            StringBuilder sb = new StringBuilder();
            sb.append("Title: ").append(title).append("\n");
            sb.append("Artist: ").append(artist).append("\n");
            sb.append("Album: ").append(album).append("\n");
            sb.append("Rating: ").append(rating).append("\n");
            sb.append("Genre: ").append(genre).append("\n");
            sb.append("Tags: ");

            if (tagCount == 0) {
                sb.append("None");
            } else {
                for (int i = 0; i < tagCount; i++) {
                    sb.append(tags[i]);
                    if (i < tagCount - 1) sb.append(", ");
                }
            }
            return sb.toString();
        }


}
