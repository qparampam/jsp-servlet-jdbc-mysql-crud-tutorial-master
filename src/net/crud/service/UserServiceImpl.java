package crud.service;

import crud.dao.UserDAO;
import crud.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl;

    private UserDAO userDAO = null;

    public static UserServiceImpl getInstance() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }


    //Добавляю
    @SuppressWarnings("ThrowFromFinallyBlock")
    public void addUser(User user) throws SQLException {
            userDAO.insertUser(user);
    }

    // первая страничка которая выбрасывается, как открывать страницу

    @SuppressWarnings("ThrowFromFinallyBlock")
    public List<User> getAllUser() throws SQLException {
        List <User> users;
        users =userDAO.selectAllUsers();

        return  users;
    }

    // беру юзера по id
    @SuppressWarnings("ThrowFromFinallyBlock")
    public User getUserId(int id) throws SQLException{
        User user;
        user = userDAO.selectUser(id);
        return user;
    }

    // обновляю
    @SuppressWarnings("ThrowFromFinallyBlock")
    public void updateUser (User user) throws SQLException {
            userDAO.updateUser(user);
    }

    @SuppressWarnings("ThrowFromFinallyBlock")
    public void deletedUser (int id) throws SQLException{
            userDAO.deleteUser(id);
    }
}
