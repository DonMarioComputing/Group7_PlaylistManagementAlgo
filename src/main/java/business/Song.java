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

    public boolean addTag(String tag){
        // todo: ADD addTag() LOGIC
        // Should implement APPROPRIATE insert action
        // Question to ask yourself: Which is more appropriate here - overwrite or shift?
        // Reminder: Do not allow duplicate tags to be added!
        // Reminder: Make sure you insert in SORTED ORDER!
        throw new UnsupportedOperationException("Not implemented yet");
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

    public boolean containsTag(String tag){
        // todo: ADD containsTag() LOGIC
        // Should implement binary search
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String format(){
        // todo: ADD format() LOGIC
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
