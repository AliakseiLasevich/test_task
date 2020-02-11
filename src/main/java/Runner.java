
import builder.QueryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Runner {

    static ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    public static void main(String[] args) {
        QueryBuilder sqlQueryBuilder = context.getBean(QueryBuilder.class);
//        String query = sqlQueryBuilder.
//                select().
//                fromSourceTable("person").
//                equal("name", "Петр Петров").
//                and().
//                equal("gender", "male").
//                build();
        String query = sqlQueryBuilder.
                select().
                fromSourceTable("person").
                endWith("name", "ов" ).
                or().
                equal("gender", "female").
                build();
        Service service = context.getBean(Service.class);
        service.getUsers(query).forEach(System.out::println);

    }

    static void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/cv?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
