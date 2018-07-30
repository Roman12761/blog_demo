package dao.userDao;

import dao.Dao;
import dao.HibernateDaoTemplate;
import model.Post;
import model.User;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    private static HibernateDaoTemplate<User> hibernateTemplate = new HibernateDaoTemplate<>();

    @Override
    public int create(User user) {
        return hibernateTemplate.create(user);
    }

    @Override
    public void update(User user) {
        hibernateTemplate.update(user);
    }

    @Override
    public void delete(User user) {
        hibernateTemplate.delete(user);
    }

    @Override
    public User getById(Class<User> userClass, int id) {
        return hibernateTemplate.getById(userClass, id);
    }
}
