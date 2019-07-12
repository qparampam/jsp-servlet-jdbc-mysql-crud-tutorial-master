package crud.service;

import crud.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void addUser(User user) throws SQLException;
    List<User> getAllUser() throws SQLException;
    User getUserId(int id) throws SQLException;
    void updateUser (User user) throws SQLException;
    void deletedUser (int id) throws SQLException;


}
