package crud.dao;

import crud.model.User;
import crud.util.PropertyReader;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static DBHelper dbHelper;

    private DBHelper(){}


    public static Connection getConnection() {
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


    public static SessionFactory getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", PropertyReader.getProperty("dialect"));
        configuration.setProperty("hibernate.connection.driver_class", PropertyReader.getProperty("driver"));
        configuration.setProperty("hibernate.connection.url", PropertyReader.getProperty("url"));
        configuration.setProperty("hibernate.connection.username", PropertyReader.getProperty("username"));
        configuration.setProperty("hibernate.connection.password", PropertyReader.getProperty("password"));
        configuration.setProperty("hibernate.show_sql", PropertyReader.getProperty("show_sql"));
        configuration.setProperty("hibernate/hbm2ddl.auto",PropertyReader.getProperty("hbm2ddl.auto"));
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
//    public static SessionFactory getSessionFactory(Configuration configuration) {
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
//        builder.applySettings(configuration.getProperties());
//        ServiceRegistry serviceRegistry = builder.build();
//        return configuration.buildSessionFactory(serviceRegistry);
//    }

    public static DBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

}
