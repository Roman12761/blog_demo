package dao;

import model.User;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

public class HibernateDaoTemplate<T>{
    public int create(T t) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        int generatedId = (int) session.save(t);
        session.getTransaction().commit();
        session.close();
        return generatedId;
    }

    public void update(T t) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T t) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    public T getById(Class<T> tClass, int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.get(tClass, id);
    }
}
