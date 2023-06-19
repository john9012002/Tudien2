import java.util.*;
import java.io.*;

public class DictionaryData {
    private Map<String, String> dictionary = new HashMap<>();

    public DictionaryData() {
        loadData();
    }

    public void loadData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("tudien.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                dictionary.put(parts[0], parts[1]);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading data");
        }
    }

    public void saveData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tudien.dat"));
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    public String search(String word) {
        String result = dictionary.get(word);
        if (result == null) {
            return "Not found";
        } else {
            return result;
        }
    }

    public void add(String word, String definition) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, definition);
            saveData();
            System.out.println("Added " + word);
        } else {
            System.out.println(word + " already exists");
        }
    }

    public void delete(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            saveData();
            System.out.println("Deleted " + word);
        } else {
            System.out.println(word + " not found");
        }
    }

    public void edit(String word, String definition) {
        if (dictionary.containsKey(word)) {
            dictionary.put(word, definition);
            saveData();
            System.out.println("Edited " + word);
        } else {
            System.out.println(word + " not found");
        }
    }
}