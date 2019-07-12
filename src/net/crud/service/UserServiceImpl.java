package crud.service;

import crud.dao.DBHelper;
import crud.dao.UserDAO;
import crud.dao.UserDaoImpl;
import crud.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl;
    private final Connection connection;

    private UserDAO userDAO;


    private UserServiceImpl() {
        this.connection = DBHelper.getInstance().getConnection();
        userDAO = new UserDaoImpl(connection);
    }



    public static UserServiceImpl getInstance() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }




    //Добавляю
    @SuppressWarnings("ThrowFromFinallyBlock")
    public void addUser(User user) throws SQLException {
        try {
            connection.setAutoCommit(false);
            userDAO.insertUser(user);
            connection.commit();
        } catch (SQLException e) {
                connection.rollback();
        } finally {
                connection.setAutoCommit(true);
        }
    }

    // первая страничка которая выбрасывается, как открывать страницу

    @SuppressWarnings("ThrowFromFinallyBlock")
    public List<User> getAllUser() throws SQLException {
        List <User> users = null;
        try {
            connection.setAutoCommit(false);
            users =userDAO.selectAllUsers();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new SQLException(e);
            }

        }
        return  users;
    }

    // беру юзера по id
    @SuppressWarnings("ThrowFromFinallyBlock")
    public User getUserId(int id) throws SQLException{
        User user = null;
        try {
            connection.setAutoCommit(false);
            user = userDAO.selectUser(id);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new SQLException(e);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
        return user;
    }

    // обновляю
    @SuppressWarnings("ThrowFromFinallyBlock")
    public void updateUser (User user) throws SQLException {
        try {
            connection.setAutoCommit(false);
            userDAO.updateUser(user);
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
    }

    @SuppressWarnings("ThrowFromFinallyBlock")
    public void deletedUser (int id) throws SQLException{
        try {
            connection.setAutoCommit(false);
            userDAO.deleteUser(id);
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
    }
}
