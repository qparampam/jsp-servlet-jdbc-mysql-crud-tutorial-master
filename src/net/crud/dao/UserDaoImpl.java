package crud.dao;

import crud.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class UserDaoImpl implements UserDAO {
    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void insertUser(User user){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public User selectUser(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            transaction.commit();
            session.close();
            return user;
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return null;
        }
    }

    public List<User> selectAllUsers() {
        List<User> list;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM User");
            list = query.list();
            transaction.commit();
            session.close();
            return list;
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            return null;
        }
    }

    public void deleteUser(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
            session.close();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
        }
    }

    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

//    public static void main(String[] args) {
//        UserDaoImpl userDao = new UserDaoImpl(DBHelper.getSessionFactory(DBHelper.getConfiguration()));
//        userDao.insertUser(new User(1,"2","3","4"));
//    }
}
