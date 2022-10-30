package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;


    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));
            return user;
        }
    };
    public void add(User user){
        this.jdbcTemplate.update("INSERT INTO users(id,name,password) VALUES(?,?,?)",user.getId(),user.getName(),user.getPassword());
    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");
    }

    public User getId(String id){
        String sql = "SELECT * FROM users WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql,this.rowMapper,id);
    }

    public int getCount(){
        String sql = "SELECT count(*) FROM users";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<User> getAll(){
        String sql = "SELECT * FROM users";
        return this.jdbcTemplate.query(sql,this.rowMapper);
    }
}
