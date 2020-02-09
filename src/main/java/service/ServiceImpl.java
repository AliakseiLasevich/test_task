package service;

import dao.CvDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    private CvDao cvDao;

    @Transactional
    public List<User> getUsers(String query) {
        return cvDao.getUsers(query);
    }

}
