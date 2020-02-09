package dao;

import entity.User;

import java.util.List;

public interface CvDao {
    List<User> getUsers(String query);
}
