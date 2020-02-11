package service;

import entity.Person;

import java.util.List;

public interface Service {
    public List<Person> getUsers(String query);

}
