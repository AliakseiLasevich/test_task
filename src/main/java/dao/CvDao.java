package dao;

import entity.Person;

import java.util.List;

public interface CvDao {
    List<Person> getUsers(String query);
}
