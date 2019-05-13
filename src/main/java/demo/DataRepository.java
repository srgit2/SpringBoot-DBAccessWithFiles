package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return jdbcTemplate.query("SELECT * FROM USERS",
                (rs, rowNum) -> {
                                    System.out.println(" " +  rs.getObject("ID") + "-" + rs.getObject("FirstName")
                                                        + "-" + rs.getObject("LastName") + "-" + rs.getObject("Email"));
                                    return new User(rs.getInt("ID"), rs.getString("FirstName"),
                                                        rs.getString("LastName"), rs.getString("Email"));
                                }
                                );
    }

    @Transactional(readOnly = true)
    public List<User> findUserByID(int id){
        return jdbcTemplate.query("SELECT * FROM Users WHERE ID = ?", new Integer[]{id},
                (rs, rowNum) -> {
                       System.out.println(rs.getObject("ID") + "-" + rs.getObject("FirstName") + "-" +
                            rs.getObject("LastName") + "-" + rs.getObject("Email"));
                       return new User(rs.getInt("ID"), rs.getString("FirstName"),
                               rs.getString("LastName"), rs.getString("Email"));
                }
        );
    }
}
