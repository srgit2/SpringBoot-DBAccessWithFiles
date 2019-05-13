package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.util.List;

@SpringBootApplication
public class DBAcessApplication implements CommandLineRunner {

    @Autowired
    DataRepository dataRepository;

    public static void main(String[] args) {
        SpringApplication.run(DBAcessApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Getting all users data:..");
        dataRepository.getAllUsers().stream()
            .forEach(user -> System.out.println(user.toString()));
        System.out.println("Getting data for user : 3 " );
        dataRepository.findUserByID(3).stream()
                .forEach(user -> System.out.println(user.toString()));

    }
}
