package crud.dao;

import crud.util.PropertyReader;
import org.hibernate.SessionFactory;

public class UserDaoFactory {
    private String technology = PropertyReader.getProperty("hibernate");


    public UserDAO WhoIsWho(){

        if(technology.equals("hibernate")){
            return new UserDaoHibernateImpl(DBHelper.getConfiguration());
        } else {
            return new UserDaoJDBCImpl();
        }
    }
}
