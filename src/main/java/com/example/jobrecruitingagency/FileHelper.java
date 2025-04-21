package com.example.jobrecruitingagency;
import java.io.*;
import java.util.ArrayList;
public class FileHelper {

    public static <T> void saveToFile(String fileName, T object) throws IOException {
        ArrayList<T> list = loadFromFile(fileName);  // load existing data
        list.add(object); // add new object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);  // write full list
        }
    }


    public static <T> ArrayList<T> loadFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) return new ArrayList<>();  // return empty list if file doesn't exist

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
