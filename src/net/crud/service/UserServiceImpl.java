package crud.service;

import crud.dao.DBHelper;
import crud.dao.UserDAO;
import crud.dao.UserDaoFactory;
import crud.dao.UserDaoHibernateImpl;
import crud.model.User;
import org.hibernate.SessionFactory;
import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl;
    private UserDAO userDAO;

    private UserDaoFactory userDaoFactory = new UserDaoFactory();

    private UserServiceImpl(){
//        SessionFactory sessionFactory = DBHelper.getSessionFactory(DBHelper.getConfiguration());
//        userDAO = new UserDaoHibernateImpl(sessionFactory);

        userDAO = userDaoFactory.WhoIsWho();
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
            userDAO.insertUser(user);
    }

    public User getUserLogin(String login) throws SQLException {
        User user = userDAO.selectUserByLogin(login);
        return user;
    }

    // первая страничка которая выбрасывается, как открывать страницу

    @SuppressWarnings("ThrowFromFinallyBlock")
    public List<User> getAllUser() throws SQLException {
        List <User> users;
        users = userDAO.selectAllUsers();

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
