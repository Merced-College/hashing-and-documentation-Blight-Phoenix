//package hashingAndDocumentation;

/**SongRecord
*Author:Jonathan Her
*Date: 11/12/24
*/

import java.util.List;
import java.util.Arrays;
import java.util.Objects;

/**
 * The SongRecord class represents a record of a song with various attributes.
 * It provides functionality to store, retrieve, and manipulate song data.
 */
public class SongRecord {
    // Instance variables
    private double valence;
    private int year;
    private double acousticness;
    private List<String> artists;
    private double danceability;
    private int durationMs;
    private double energy;
    private int explicit;
    private String id;
    private double instrumentalness;
    private int key;
    private double liveness;
    private double loudness;
    private int mode;
    private String name;
    private int popularity;
    private String releaseDate;
    private double speechiness;
    private double tempo;

    /**
     * Default constructor initializing all fields to default values.
     */
    public SongRecord() {
        this.valence = 0.0;
        this.year = 0;
        this.acousticness = 0.0;
        this.artists = Arrays.asList("Unknown Artist");
        this.danceability = 0.0;
        this.durationMs = 0;
        this.energy = 0.0;
        this.explicit = 0;
        this.id = "";
        this.instrumentalness = 0.0;
        this.key = 0;
        this.liveness = 0.0;
        this.loudness = 0.0;
        this.mode = 0;
        this.name = "Unknown Title";
        this.popularity = 0;
        this.releaseDate = "0";
        this.speechiness = 0.0;
        this.tempo = 0.0;
    }

    /**
     * Constructor that initializes the SongRecord object using a CSV string.
     *
     * @param data CSV string representing song attributes.
     * @throws IllegalArgumentException if data is malformed or missing fields.
     */
    public SongRecord(String data) {
        String[] fields = data.split(","); // Assuming comma-separated values
        
        //fields = data.split(",");//means no quotes in the record
        
        /*System.out.println("fields length " + fields.length);
        for(int i = 0; i < fields.length; i++) {
            System.out.println("fields " + i + " = " + fields[i]);
        }*/
        if (fields.length != 19) {
            throw new IllegalArgumentException("CSV data is malformed or missing fields.");
        }
        this.valence = Double.parseDouble(fields[0]);
        this.year = Integer.parseInt(fields[1]);
        this.acousticness = Double.parseDouble(fields[2]);
        this.artists = Arrays.asList(fields[3].replaceAll("[\\[\\]']", "").split(";"));
        this.danceability = Double.parseDouble(fields[4]);
        this.durationMs = Integer.parseInt(fields[5]);
        this.energy = Double.parseDouble(fields[6]);
        this.explicit = Integer.parseInt(fields[7]);
        this.id = fields[8];
        this.instrumentalness = Double.parseDouble(fields[9]);
        this.key = Integer.parseInt(fields[10]);
        this.liveness = Double.parseDouble(fields[11]);
        this.loudness = Double.parseDouble(fields[12]);
        this.mode = Integer.parseInt(fields[13]);
        this.name = fields[14];
        this.popularity = Integer.parseInt(fields[15]);
        this.releaseDate = fields[16];
        this.speechiness = Double.parseDouble(fields[17]);
        this.tempo = Double.parseDouble(fields[18]);
    }

    // Getters and setters for each field

    /**
     * Returns the valence of the song.
     *
     * @return valence of the song.
     */
    public double getValence() {
        return valence;
    }

    /**
     * Sets the valence of the song.
     *
     * @param valence valence of the song.
     */
    public void setValence(double valence) {
        this.valence = valence;
    }

    /**
     * Returns the year of release of the song.
     *
     * @return year of release.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of release of the song.
     *
     * @param year year of release.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the acousticness of the song.
     *
     * @return acousticness of the song.
     */
    public double getAcousticness() {
        return acousticness;
    }

    /**
     * Sets the acousticness of the song.
     *
     * @param acousticness acousticness of the song.
     */
    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    /**
     * Returns the list of artists of the song.
     *
     * @return list of artists.
     */
    public List<String> getArtists() {
        return artists;
    }

    /**
     * Sets the list of artists of the song.
     *
     * @param artists list of artists.
     */
    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    /**
     * Returns the danceability of the song.
     *
     * @return danceability of the song.
     */
    public double getDanceability() {
        return danceability;
    }

    /**
     * Sets the danceability of the song.
     *
     * @param danceability danceability of the song.
     */
    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    /**
     * Returns the duration of the song in milliseconds.
     *
     * @return duration of the song in milliseconds.
     */
    public int getDurationMs() {
        return durationMs;
    }

    /**
     * Sets the duration of the song in milliseconds.
     *
     * @param durationMs duration of the song in milliseconds.
     */
    public void setDurationMs(int durationMs) {
        this.durationMs = durationMs;
    }

    /**
     * Returns the energy level of the song.
     *
     * @return energy level of the song.
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Sets the energy level of the song.
     *
     * @param energy energy level of the song.
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    /**
     * Returns whether the song is explicit or not.
     *
     * @return 1 if explicit, 0 otherwise.
     */
    public int getExplicit() {
        return explicit;
    }

    /**
     * Sets whether the song is explicit or not.
     *
     * @param explicit 1 if explicit, 0 otherwise.
     */
    public void setExplicit(int explicit) {
        this.explicit = explicit;
    }

    /**
     * Returns the unique identifier of the song.
     *
     * @return unique identifier of the song.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the song.
     *
     * @param id unique identifier of the song.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the instrumentalness of the song.
     *
     * @return instrumentalness of the song.
     */
    public double getInstrumentalness() {
        return instrumentalness;
    }

    /**
     * Sets the instrumentalness of the song.
     *
     * @param instrumentalness instrumentalness of the song.
     */
    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    /**
     * Returns the key of the song.
     *
     * @return key of the song.
     */
    public int getKey() {
        return key;
    }

    /**
     * Sets the key of the song.
     *
     * @param key key of the song.
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Returns the liveness of the song.
     *
     * @return liveness of the song.
     */
    public double getLiveness() {
        return liveness;
    }

    /**
     * Sets the liveness of the song.
     *
     * @param liveness liveness of the song.
     */
    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    /**
     * Returns the loudness of the song.
     *
     * @return loudness of the song.
     */
    public double getLoudness() {
        return loudness;
    }

    /**
     * Sets the loudness of the song.
     *
     * @param loudness loudness of the song.
     */
    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    /**
     * Returns the mode of the song.
     *
     * @return mode of the song.
     */
    public int getMode() {
        return mode;
    }

    /**
     * Sets the mode of the song.
     *
     * @param mode mode of the song.
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    /**
     * Returns the name of the song.
     *
     * @return name of the song.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the song.
     *
     * @param
