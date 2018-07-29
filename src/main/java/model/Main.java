package model;

import dao.postDao.PostDao;
import dao.postDao.PostDaoHibernateImpl;
import dao.userDao.UserDao;
import dao.userDao.UserDaoHibernateImpl;
import javafx.geometry.Pos;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Roman");
        user.setLogin("lsssogin" + Double.valueOf(Math.random() * 1000).longValue());
        user.setPassword("pass");
        user.setPhotoURL("url");
        user.setActive(true);
        user.setRole(User.UserRole.ADMIN);

        Post post = new Post();
        post.setSummary("tratata"+ Double.valueOf(Math.random() * 1000).longValue());
        post.setDescription("desc");
        post.setDateOfCreating(LocalDateTime.now());
        post.setDateOfUpdating(LocalDateTime.now());
        post.setVisible(true);

        UserDao userDao = new UserDaoHibernateImpl();
        userDao.create(user);

        post.setAuthor(user);

        PostDao postDao = new PostDaoHibernateImpl();
        postDao.create(post);
        HibernateSessionFactory.shutdown();
    }
}
