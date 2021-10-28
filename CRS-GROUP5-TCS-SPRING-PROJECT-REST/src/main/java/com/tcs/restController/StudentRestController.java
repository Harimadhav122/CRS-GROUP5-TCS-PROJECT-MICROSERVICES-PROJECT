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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Student;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.GradeCardNotFoundException;
import com.tcs.exception.StudentNotFoundException;
import com.tcs.service.StudentServiceInterface;


@RestController
@CrossOrigin
public class StudentRestController {
	@Autowired //CustomerDAO customerDAOOperation = new CustomerDAO();
	private StudentServiceInterface students;

	@RequestMapping("/student/{id}")
	public ResponseEntity getStudent(@PathVariable("id") int id) throws SQLException, StudentNotFoundException {

		Student studentId = students.getId(id);
		if (studentId == null) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(studentId, HttpStatus.OK);
	}
	@RequestMapping("/post/studentregister")
	public ResponseEntity createStudent(@RequestBody Student student) throws SQLException {
		
		Student students1 = students.insert(student);
		if (students1 == null) {
			return new ResponseEntity("Registration failed ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(students1, HttpStatus.OK);
	}
	@RequestMapping("/put/student/{id}")
	public ResponseEntity updateStudent(@PathVariable int id, @RequestBody Student student) throws SQLException {

		Student updateInfoStudent = students.update(id, student);
		if (updateInfoStudent == null) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(updateInfoStudent, HttpStatus.OK);
	}
	@RequestMapping("/post/registercourse/{studid}/{courseid}")
	public ResponseEntity registercourse(@PathVariable("studid") int studentId, @PathVariable("courseid") int courseId) throws SQLException, CourseNotFoundException {

		String info = students.registerCourse(studentId, courseId);
		if (info == null) {
			return new ResponseEntity("No course found for ID " + courseId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(info, HttpStatus.OK);
	}
	@RequestMapping("/post/viewgradecard/{studid}/{courseid}")
	public ResponseEntity viewgradecard(@PathVariable("studid") int studentId, @PathVariable("courseid") int courseId) throws SQLException, GradeCardNotFoundException {

		List gradecard = students.viewGradeCard(studentId, courseId);
		if (gradecard == null) {
			return new ResponseEntity("No gradecard found for ID " + courseId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(gradecard, HttpStatus.OK);
	}

}
