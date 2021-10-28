/**
 * 
 */
package com.tcs.restController;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Professor;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.ProfessorNotFoundException;
import com.tcs.exception.StudentNotFoundException;
import com.tcs.service.ProfessorServiceInterface;

/**
 * @author VENKY_HARI
 *
 */

@RestController
@CrossOrigin
public class ProfessorRestController {
	@Autowired //CustomerDAO customerDAOOperation = new CustomerDAO();
	private ProfessorServiceInterface professors;
	
	@RequestMapping("/prof/studentslist")
	public List getstudentList() throws SQLException {
		return professors.studentList();
	}
	@RequestMapping("/prof/courseslist")
	public List getcourseList() throws SQLException {
		return professors.courseList();
	}
	@RequestMapping("/professor/{id}")
	public ResponseEntity getprofessor(@PathVariable("id") int id) throws SQLException, ProfessorNotFoundException {

		Professor ProfessorId = professors.getId(id);
		if (ProfessorId == null) {
			return new ResponseEntity("No professor found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(ProfessorId, HttpStatus.OK);
	}
	@RequestMapping("/post/assigngrade/{studid}/{courseid}/{grade}")
	public ResponseEntity assignGrade(@PathVariable("studid") int studentId, @PathVariable("courseid") int courseId, @PathVariable("grade") String grade) throws SQLException, StudentNotFoundException, CourseNotFoundException {

		String ProfessorId = professors.assignGrade(studentId, courseId, grade);

		return new ResponseEntity(ProfessorId, HttpStatus.OK);
	}
	

}