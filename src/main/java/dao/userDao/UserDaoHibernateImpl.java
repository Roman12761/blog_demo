package dao.userDao;

import dao.Dao;
import model.User;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    @Override
    public User create(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        user.setId((int) session.save(user));
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public void delete(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getById(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.get(User.class, id);
    }
}
