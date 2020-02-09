package service;

import entity.User;

import java.util.List;

public interface Service {
    public List<User> getUsers(String query);

}
