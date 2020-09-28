package DataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseTable {

    private Statement stmt;
    private String tableName;

    public DataBaseTable(Statement stmt, String tableName) {
        this.stmt = stmt;
        this.tableName = tableName;
    }

//    * Создание таблицы
    public void createTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score INTEGER)");
    }
//    * Добавление записи в таблицу
    public void addEntry(String name, Integer score) throws SQLException {
        stmt.executeUpdate("INSERT INTO " + tableName + " (name, score) VALUES (\'" + name + "\', " + score + ");");
    }

//    * Получение записи из таблицы по ID
   public void infoEntry(Integer id) throws SQLException {
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE id = " + id + ";");
        System.out.println(
                "id = " + resultSet.getString("id") +
                ", name = " + resultSet.getString("name") +
                ", score = " + resultSet.getString("score"));
    }


//    * Удаление записи из таблицы по ID
    public void deleteEntry(Integer id)  throws SQLException {
        stmt.executeUpdate("DELETE FROM " + tableName + " WHERE id = " + id);
    }

//    * Удаление таблицы
    public void deleteTable() throws SQLException{
        stmt.executeUpdate(" DROP TABLE IF EXISTS " +  tableName + ";");
    }

    public void readFile() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            String[] mass = scanner.nextLine().split(" ");
            try {
                addEntry(mass[1], Integer.parseInt(mass[2]));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
