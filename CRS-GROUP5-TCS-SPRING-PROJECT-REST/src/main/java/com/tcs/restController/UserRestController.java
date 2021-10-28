/**
 * 
 */
package com.tcs.restController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Admin;
import com.tcs.exception.UserNotFoundException;
import com.tcs.service.UserServiceInterface;

/**
 * @author VENKY_HARI
 *
 */
@RestController
@CrossOrigin
public class UserRestController {
	@Autowired //CustomerDAO customerDAOOperation = new CustomerDAO();
	private UserServiceInterface users;
	
	@RequestMapping("/studentlogin/{id}/{pass}")
	public ResponseEntity studentLogin(@PathVariable("id") int userId, @PathVariable("pass") String password) throws SQLException, UserNotFoundException {
		String stud = users.studentLogin(userId, password);
		if (stud == null) {
			return new ResponseEntity("UserId or password is incorrect", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(stud, HttpStatus.OK);

	}
	
	@RequestMapping("/professorlogin/{id}/{pass}")
	public ResponseEntity professorLogin(@PathVariable("id") int userId, @PathVariable("pass") String password) throws SQLException, UserNotFoundException {
		String prof = users.professorLogin(userId, password);
		if (prof == null) {
			return new ResponseEntity("UserId or password is incorrect", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(prof, HttpStatus.OK);

	}
	
	@RequestMapping("/adminlogin/{id}/{pass}")
	public ResponseEntity adminLogin(@PathVariable("id") int userId, @PathVariable("pass") String password) throws SQLException, UserNotFoundException {
		String admin = users.AdminLogin(userId, password);
		if (admin == null) {
			return new ResponseEntity("UserId or password is incorrect", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(admin, HttpStatus.OK);

	}

}
