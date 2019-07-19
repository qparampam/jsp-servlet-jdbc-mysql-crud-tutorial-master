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
                    "login varchar(256)," +
                    "password varchar(256)," +
                    "role varchar(256)," +
                    "primary key (id))");
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    public void insertUser(User user) throws SQLException {
        executor.execUpdate("insert into users (name, login, password, role) values " +
                "(\""+ user.getName() + "\", \"" + user.getLogin() + "\", " +
                "\"" + user.getPassword() + "\", \""+ user.getRole() + "\" );");
    }

    public User selectUser(int id) throws SQLException {
        return executor.execQuery("select * from users where id='" + id + "'", result -> {
            result.next();
            String name = result.getString("name");
            String login = result.getString("login");
            String password = result.getString("password");
            String role = result.getString("role");
            return new User(id, name, login, password, role);
        });
    }

    public List<User> selectAllUsers() throws SQLException {
        List <User> users = new ArrayList < > ();
        return executor.execQuery("select * from users ", result -> {
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String login = result.getString("login");
                String password = result.getString("password");
                String role = result.getString("role");
                users.add(new User(id, name, login, password, role));
            }
            return users;
        });
    }

    public void deleteUser(int id) throws SQLException {
        executor.execUpdate("delete from users where id='" + id + "'");
    }

    public void updateUser(User user) throws SQLException {
        executor.execUpdate("UPDATE users SET name ='" + user.getName() + "',login='"
                + user.getLogin() + "', password='" + user.getPassword() + "', role='" + user.getRole()
                +   "' WHERE id = '"
                + user.getId() + "'; ");

    }

    @Override
    public User selectUserByLogin(String log) throws SQLException {
        return executor.execQuery("select * from users where login='" + log + "'", result -> {
            result.next();
            int id = result.getInt("id");
            String name = result.getString("name");
            String login = result.getString("login");
            String password = result.getString("password");
            String role = result.getString("role");
            return new User(id, name, login, password, role);
        });
    }
}