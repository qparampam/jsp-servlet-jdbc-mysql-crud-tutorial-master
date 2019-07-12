package crud.dao;

import crud.util.PropertyReader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static DBHelper dbHelper;

    private DBHelper(){}

    public Connection getConnection() {
        Connection connection;
        try {
            Class.forName(PropertyReader.getProperty("driver"));

            String url = PropertyReader.getProperty("url");
            String username = PropertyReader.getProperty("username");
            String password = PropertyReader.getProperty("password");

            connection = DriverManager.getConnection(url,username,password);

            return connection;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static DBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }
}
