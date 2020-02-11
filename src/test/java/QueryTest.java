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
    public void shouldReturnConcreteUser() {
        String query = queryBuilder.
                select().
                fromSourceTable("person").
                equal("name", "Морская Мария Васильевна").
                and().
                equal("gender", "female").
                build();
        List<Person> people = service.getUsers(query);
        Assert.assertEquals("Морская Мария Васильевна", people.get(0).getName());
        Assert.assertEquals(1, people.size());
    }

    @Test
    public void shouldReturnAllUsersByParameters() {
        String query = queryBuilder.
                select().
                fromSourceTable("person").
                endWith("name", "ов" ).
                or().
                equal("gender", "female").
                build();
        List<Person> people = service.getUsers(query);
        Assert.assertEquals(2, people.size());

    }

}
