/**
 * 
 */
package com.tcs.restController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Student;
import com.tcs.service.RegisteredCoursesServiceInterface;

/**
 * @author VENKY_HARI
 *
 */
@RestController
@CrossOrigin
public class RegisteredCoursesRestController {
	@Autowired //CustomerDAO customerDAOOperation = new CustomerDAO();
	private RegisteredCoursesServiceInterface courses;
	
	@RequestMapping("/post/student/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") int id) throws SQLException {

		List regcourses = courses.registeredcoursesList(id);
		if (regcourses == null) {
			return new ResponseEntity("No registered courses found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(regcourses, HttpStatus.OK);
	}

}
