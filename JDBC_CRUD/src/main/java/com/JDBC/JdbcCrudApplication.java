package com.JDBC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.JDBC.Dao.UserDao;
import com.JDBC.entity.User;

@SpringBootApplication
public class JdbcCrudApplication  implements CommandLineRunner{  

	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * User user1=new User("pappu2","pappu@gmail.com","male","chennai"); User
		 * user2=new User("vicky","vicky@gmail.com","male","chennai"); boolean
		 * status=userDao.insertUser(user2); if(status) {
		 * System.out.println("User insert successfully"); } else {
		 * System.out.println("User insert failed error"); }
		 */
		 		
		
		
		/* update section */
		/*
		 * User user=new User("vicky","vicky@gmail.com","male","bihar"); boolean
		 * status=userDao.updateUser(user); if(status) {
		 * System.out.println("User update successfully"); }else {
		 * System.out.println("User update faild error"); }
		 */
		
		
		/* Delete user section */
		
		/*
		 * boolean status=userDao.deleteUserByEmail("vicky@gmail.com"); if(status) {
		 * System.out.println("user delete successfully"); }else {
		 * System.out.println("user faild error"); }
		 */
		
		
		
		/* select one user email id throw search */
		
		/*
		 * User user=userDao.getUserByEmail("pappu@gmail.com");
		 * System.out.println("Name:"+user.getName());
		 * System.out.println("Email:"+user.getEmail());
		 * System.out.println("Gender:"+user.getGender());
		 * System.out.println("City:"+user.getCity());
		 */
		 
		
		
		/* select ALl user section */
		List<User>list=userDao.getAllUsers();
		for(User user:list) {
			System.out.println("Name:"+user.getName());
			System.out.println("Name:"+user.getEmail());
			System.out.println("Name:"+user.getGender());
			System.out.println("Name:"+user.getCity());
			System.out.println("----------------------------------");
		}
		
	}

}
