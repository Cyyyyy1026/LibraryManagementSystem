package Book;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.*;

public class BookList {
    private static final String FILE_PATH = "books.json";
    private Map<String ,String> jsonData;
    private Gson gson;


    public BookList() {
        jsonData = new HashMap<>();
        gson = new Gson();
        loadFromFile();
    }

    public void addBook(Book book) {
        String json = gson.toJson(book);
        jsonData.put(book.getName(), json);
        saveToFile();
    }

    public Book findBook(String name) {
        String json = jsonData.get(name);
        if (json != null) {
            return gson.fromJson(json, Book.class);
        }
        return null;
    }

    public Map<String, Book> getAllBooks() {
        Map<String, Book> books = new HashMap<>();
        for (Map.Entry<String, String> entry : jsonData.entrySet()) {
            books.put(entry.getKey(), gson.fromJson(entry.getValue(), Book.class));
        }
        return books;
    }

    public void setBookQty(Book book) {
        String json = gson.toJson(book);
        jsonData.put(book.getName(), json); // 存储或更新书籍信息
        saveToFile();
    }

    private void saveToFile() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(jsonData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            jsonData = gson.fromJson(reader, type);
            if (jsonData == null) {
                jsonData = new HashMap<>();
            }
        } catch (FileNotFoundException e) {
            jsonData = new HashMap<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}