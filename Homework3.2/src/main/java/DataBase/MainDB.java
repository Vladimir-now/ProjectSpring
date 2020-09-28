package DataBase;

/**
 * 1. Создать CRUD операции:
 *      1 метод создание таблицы
 *      2 метод для добавления записи
 *      3 метод для получения записи
 *      4 метод для удаления записи
 *      5 удаление таблицы
 * 2. Обновить данные в БД из файла (файл приложен test.txt)
 */

import java.io.FileNotFoundException;
import java.sql.*;


public class MainDB {

    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();
            DataBaseTable dbt = new DataBaseTable(stmt, "student");
            try {
                dbt.readFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
//            dbt.createTable();
//            dbt.addEntry("Alex", 40);
//            dbt.deleteEntry(3);
//            dbt.deleteTable();
//            dbt.infoEntry(2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
