package Book;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.HashMap;
import java.util.*;

public class BookList {

    private Connection conn = null;
    private PreparedStatement ps = null;
//    private static final String FILE_PATH = "books.json";
//    private Map<String ,String> jsonData;
//    private Gson gson;


    public BookList() {
        init();
//        jsonData = new HashMap<>();
//        gson = new Gson();
//        loadFromFile();
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO book (id, name, author, qty) VALUES (?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, book.getId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getQty());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    public Book findBook(String name) {
        String sql = "SELECT * FROM book WHERE name = ?";
        Book book = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                book = new Book(id, name, author, qty);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return book;
//        String json = jsonData.get(name);
//        if (json != null) {
//            return gson.fromJson(json, Book.class);
//        }
//        return null;
    }

    public void setBookQty(Book book) {
        String sql = "UPDATE book SET qty = ? WHERE name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, book.getQty());
            ps.setString(2, book.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
//        String json = gson.toJson(book);
//        jsonData.put(book.getName(), json); // 存储或更新书籍信息
//        saveToFile();
    }

    public void init() {
            String url = "jdbc:mysql://localhost:3306/booklist";
            String user = "root";
            String pwd = "112588";
            String driver = "com.mysql.cj.jdbc.Driver";

            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pwd);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

    }
    private void closeResources() {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private void saveToFile() {
//        try (Writer writer = new FileWriter(FILE_PATH)) {
//            gson.toJson(jsonData, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void loadFromFile() {
//        try (Reader reader = new FileReader(FILE_PATH)) {
//            Type type = new TypeToken<Map<String, String>>() {}.getType();
//            jsonData = gson.fromJson(reader, type);
//            if (jsonData == null) {
//                jsonData = new HashMap<>();
//            }
//        } catch (FileNotFoundException e) {
//            jsonData = new HashMap<>();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}