package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CvDaoImpl implements CvDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers(String query) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createNativeQuery(query, User.class).list();
    }
}
