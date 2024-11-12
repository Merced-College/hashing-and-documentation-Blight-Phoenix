package hashingAndDocumentation;
/** SongProgram.java
    *Author: Jonathan Her
    *Date: 11/12/24
    */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SongProgram class provides functionality to load song records from a CSV file, 
 * retrieve song records by their ID, and display all loaded songs. It also includes 
 * a GUI for searching songs by their ID.
 */
public class SongProgram {

    /** 
     * HashMap to store SongRecords with the song's ID as the key.
     */
    private HashMap<String, SongRecord> songMap;

    /** 
     * Constructor initializes the songMap.
     */
    public SongProgram() {
        songMap = new HashMap<>();
    }

    /**
     * Loads songs from a specified CSV file and stores them in the songMap.
     *
     * @param filePath the path to the CSV file containing song records
     */
    public void loadSongsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Read the first line and do nothing with it
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                // Create a SongRecord from the line and add it to the map
                SongRecord song = new SongRecord(line);
                songMap.put(song.getId(), song);
            }
            System.out.println("Songs successfully loaded from CSV.");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    /**
     * Retrieves a SongRecord by its ID.
     *
     * @param id the ID of the song to retrieve
     * @return the SongRecord with the specified ID, or null if not found
     */
    public SongRecord getSongById(String id) {
        return songMap.get(id);
    }

    /**
     * Prints all loaded songs to the console.
     */
    public void printAllSongs() {
        for (SongRecord song : songMap.values()) {
            System.out.println(song);
        }
    }

    /**
     * Opens a GUI for searching songs by their ID.
     */
    public void openSearchGui() {
        // Create the main frame
        JFrame frame = new JFrame("Song Lookup");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold input and button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Label, Text Field, and Button
        JLabel label = new JLabel("Enter Song ID:");
        JTextField idField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Add label, text field, and button to panel
        panel.add(label);
        panel.add(idField);
        panel.add(searchButton);

        // Result area to display song details
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        // Add action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                SongRecord song = getSongById(id);
                if (song != null) {
                    resultArea.setText("Song Found:\n" + song.toString());
                } else {
                    resultArea.setText("Song with ID " + id + " not found.");
                }
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Main method to demonstrate functionality and open GUI.
     *
     * @param args command line arguments
     */
    public static void main2(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Open GUI for searching songs by ID
        program.openSearchGui();
    }

    /**
     * Main method to demonstrate functionality.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Demonstrate retrieving a song by ID
        String testId = "4BJqT0PrAfrxzMOxytFOIz";  // replace with an actual ID from your file
        SongRecord song = program.getSongById(testId);
        if (song != null) {
            System.out.println("Retrieved song: " + song);
        } else {
            System.out.println("Song with ID " + testId + " not found.");
        }

        // Print all songs
        program.printAllSongs();
    }
}
