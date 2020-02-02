package Lesson_2;

import java.sql.*;

public class MainDB {
    public static Connection connection;
    public static Statement stmt;
    public static PreparedStatement pstmt;

    public static void main(String[] args) {
        try {
            connect();
//            create("students2");
//            insert("students2","bob4", 33);
//            update("students2", 1, 14);
//            delete("students2",1);
            select("students");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void create (String tableName) throws SQLException {
        String sql = String.format("CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score INTEGER)", tableName);
        stmt.executeUpdate(sql);
    }

    public static void update(String tableName, int id, int score) {
        String sql = String.format("Update %s set score = %s where id = %s", tableName, score, id);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String tableName, String name, int score) throws SQLException {
        pstmt = connection.prepareStatement(String.format("insert into %s (name, score) values(?, ?)", tableName));
        try {
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.addBatch();
            pstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String tableName, int id) {
        String sql = String.format("delete from %s where id = %s", tableName,id);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select(String tableName) throws SQLException {
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM %s", tableName));
            while (rs.next()) {
                System.out.println(String.format("%s %s %s", rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
    }
}
