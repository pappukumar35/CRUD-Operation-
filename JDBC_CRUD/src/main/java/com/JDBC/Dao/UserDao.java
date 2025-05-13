package com.JDBC.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.JDBC.entity.User;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert section for the user
    public boolean insertUser(User user) {
    	boolean status=false;
        try {
            String INSERT_SQL_QUERY = "INSERT INTO users (name, email, gender, city) VALUES (?, ?, ?, ?)";
            int count = jdbcTemplate.update(INSERT_SQL_QUERY,
                    user.getName(),
                    user.getEmail(),
                    user.getGender(),
                    user.getCity());

           if( count > 0) {
        	   status=true;
           }
           else {
        	   status=false;
           }
        } catch (Exception e) {
        	status=false;
            e.printStackTrace();
        }
        return false;
    }

    // Update section for the user
    public boolean updateUser(User user) {
    	boolean status=false;
        try {
            String UPDATE_SQL_QUERY = "UPDATE users SET name=?, gender=?, city=? WHERE email=?";
            int count = jdbcTemplate.update(UPDATE_SQL_QUERY,
                    user.getName(),
                    user.getGender(),
                    user.getCity(),
                    user.getEmail());

            if(count > 0) {
            	status=true;
            }
            else {
            	status=false;
            }
        } catch (Exception e) {
        	status=false;
            e.printStackTrace();
        }
        return false;
    }

    // Delete section for the user
    public boolean deleteUserByEmail(String email) {
    	boolean status=false;
        try {
            String DELETE_SQL_QUERY = "DELETE FROM users WHERE email=?";
            int count = jdbcTemplate.update(DELETE_SQL_QUERY, email);
            if(count > 0) {
            	status=true;
            }
            else {
            	status=false;
            }
        } catch (Exception e) {
        	status=false;
            e.printStackTrace();
        }
        return false;
    }

    
	/* select all user */
    
    public List<User> getAllUsers(){
    	String SELECT_SQL_QUERY="SELECT * FROM users";
    	return jdbcTemplate.query(SELECT_SQL_QUERY, new UserRowMapper());
    }
    
    
    // Select user by email
    public User getUserByEmail(String email) {
        String SELECT_SQL_QUERY = "SELECT * FROM users WHERE email=?";
        try {
            return jdbcTemplate.queryForObject(SELECT_SQL_QUERY, new Object[]{email}, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null; // or handle with custom exception
        }
    }

    // RowMapper implementation for User
    private static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setCity(rs.getString("city"));
            return user;
        }
    }
}
