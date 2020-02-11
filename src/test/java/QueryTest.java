import builder.QueryBuilder;
import entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import service.Service;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")

public class QueryTest {

    @Autowired
    private Service service;

    @Autowired
    private QueryBuilder queryBuilder;

    @Test
    public void shouldReturnConcretePerson() {
        String concretePerson = queryBuilder.
                select().
                fromSourceTable("person").
                equal("surname", "Морская").
                and().
                equal("name", "Мария").
                and().
                equal("patronymic", "Васильевна").
                and().
                equal("gender", "female").
                build();
        List<Person> people = service.getUsers(concretePerson);
        Assert.assertEquals(1, people.size());
        Assert.assertEquals("Морская", people.get(0).getSurname());
        Assert.assertEquals("Мария", people.get(0).getName());
        Assert.assertEquals("Васильевна", people.get(0).getPatronymic());
    }

    @Test
    public void shouldReturnAllUsersByParameters() {
        String usersByParameters = queryBuilder.
                select().
                fromSourceTable("person").
                endWith("surname", "ов").
                or().
                equal("gender", "female").
                build();
        List<Person> people = service.getUsers(usersByParameters);
        Assert.assertEquals(3, people.size());

    }

}
