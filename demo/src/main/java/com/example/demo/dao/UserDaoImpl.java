package com.example.demo.dao;

import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("fromMySQL")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Users getUserById(int id) {
        String sql = "select id, userName, email from users where id = ?";

        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }

    @Override
    public Users saveUser(Users users) {
        String sql = "insert into users (id, userName, email) values (?, ?, ?)";
        jdbcTemplate.update(sql, users.getId(), users.getUserName(), users.getUserName());
        return users; // studentRepository.save(student);
    }

    @Override
    public Users updateUser(Users users) {
        return null;
    }

    @Override
    public void deleteUserById(int id) {
        String sql = "delete from users where id = ?";
        jdbcTemplate.update(sql, id);
    }

}
