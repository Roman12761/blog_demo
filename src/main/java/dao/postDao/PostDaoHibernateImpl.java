package dao.postDao;

import javafx.geometry.Pos;
import model.Post;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

public class PostDaoHibernateImpl implements PostDao {
    @Override
    public Post create(Post post) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        post.setId((int) session.save(post));
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    public Post update(Post post) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    public void delete(Post post) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Post getById(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.get(Post.class, id);
    }
}
