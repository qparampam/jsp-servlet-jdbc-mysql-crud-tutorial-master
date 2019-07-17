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
//    public static SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(User.class);
//        configuration.setProperty("hibernate.dialect", PropertyReader.getProperty("dialect"));
//        configuration.setProperty("hibernate.connection.driver_class", PropertyReader.getProperty("driver"));
//        configuration.setProperty("hibernate.connection.url", PropertyReader.getProperty("url"));
//        configuration.setProperty("hibernate.connection.username", PropertyReader.getProperty("username"));
//        configuration.setProperty("hibernate.connection.password", PropertyReader.getProperty("password"));
//        configuration.setProperty("hibernate.show_sql","true");
//        configuration.setProperty("hibernate.hbm2ddl.auto","update");
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//        return configuration.buildSessionFactory(serviceRegistry);
//    }


    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", PropertyReader.getProperty("dialect"));
        configuration.setProperty("hibernate.connection.driver_class", PropertyReader.getProperty("driver"));
        configuration.setProperty("hibernate.connection.url", PropertyReader.getProperty("url"));
        configuration.setProperty("hibernate.connection.username", PropertyReader.getProperty("username"));
        configuration.setProperty("hibernate.connection.password", PropertyReader.getProperty("password"));
        configuration.setProperty("hibernate.show_sql", PropertyReader.getProperty("show_sql"));
        configuration.setProperty("hibernate/hbm2ddl.auto",PropertyReader.getProperty("hbm2ddl.auto"));
        return configuration;
    }
    public static SessionFactory getSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
