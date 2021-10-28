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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Course;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.service.CourseServiceInterface;


/**
 * @author VENKY_HARI
 *
 */
@RestController
@CrossOrigin
public class CourseRestController {
	@Autowired //CustomerDAO customerDAOOperation = new CustomerDAO();
	private CourseServiceInterface courses;
	
	@RequestMapping("/courseslist")
	public List allCourses() throws SQLException {
		return courses.courseList();
	}
	
	@RequestMapping("/course/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") int id) throws CourseNotFoundException, SQLException {

		Course course = courses.getCourse(id);
		if (course == null) {
			return new ResponseEntity("No course found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(course, HttpStatus.OK);
	}

}
