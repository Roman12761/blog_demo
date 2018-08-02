package dao.postDao;

import dao.HibernateDaoTemplate;
import dao.userDao.UserDao;
import model.Post;
import model.User;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

public class PostDaoHibernateImpl extends HibernateDaoTemplate<Post> implements PostDao {


}
