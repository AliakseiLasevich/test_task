package dao;

import entity.Person;
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
    public List<Person> getUsers(String query) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createNativeQuery(query, Person.class).list();
    }
}
