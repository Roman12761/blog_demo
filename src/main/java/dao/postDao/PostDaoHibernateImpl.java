package dao.postDao;

import dao.HibernateDaoTemplate;
import model.Post;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

public class PostDaoHibernateImpl implements PostDao {

    private static HibernateDaoTemplate<Post> hibernateTemplate = new HibernateDaoTemplate<>();

    @Override
    public int create(Post post) {
        return hibernateTemplate.create(post);
    }

    @Override
    public void update(Post post) {
        hibernateTemplate.update(post);
    }

    @Override
    public void delete(Post post) {
        hibernateTemplate.delete(post);
    }

    @Override
    public Post getById(Class<Post> postClass, int id) {
        return hibernateTemplate.getById(postClass, id);
    }
}
