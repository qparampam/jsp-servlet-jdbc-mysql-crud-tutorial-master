package crud.dao;

import crud.model.User;
import crud.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDAO{
    private Executor executor;


    public UserDaoJDBCImpl() {
        Connection connection = DBHelper.getInstance().getConnection();
        this.executor = new Executor(connection);
        createTable();
    }



    private void createTable() {
        try {
            executor.execUpdate("create table if not exists users (id bigint not null auto_increment," +
                    "name varchar(256)," +
                    "email varchar(256)," +
                    "country varchar(256)," +
                    "primary key (id))");
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public void insertUser(User user) throws SQLException {
        executor.execUpdate("insert into users (name, email, country) values " +
                "(\""+ user.getName() + "\", \"" + user.getEmail() + "\", \"" + user.getCountry() + "\" );");
    }

    public User selectUser(int id) throws SQLException {
        return executor.execQuery("select * from users where id='" + id + "'", result -> {
            result.next();
            String name = result.getString("name");
            String email = result.getString("email");
            String country = result.getString("country");
            return new User(id, name, email, country);
        });
    }

    public List<User> selectAllUsers() throws SQLException {
        List <User> users = new ArrayList < > ();
        return executor.execQuery("select * from users ", result -> {
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                String country = result.getString("country");
                users.add(new User(id, name, email, country));
            }
            return users;
        });
    }

    public void deleteUser(int id) throws SQLException {
        executor.execUpdate("delete from users  where id='" + id + "'");
    }

    public void updateUser(User user) throws SQLException {
        executor.execUpdate("UPDATE users SET name ='" + user.getName() + "',email='"
                + user.getEmail() + "', country='" + user.getCountry()
                +   "' WHERE id = '"
                + user.getId() + "'; ");

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}