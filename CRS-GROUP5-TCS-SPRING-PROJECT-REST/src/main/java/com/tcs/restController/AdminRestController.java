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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.Admin;
import com.tcs.bean.Course;
import com.tcs.bean.GradeCard;
import com.tcs.bean.Professor;
import com.tcs.dao.AdminDAOImpl;
import com.tcs.exception.AdminNotFoundException;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.StudentNotFoundException;
import com.tcs.service.AdminServiceInterface;
import com.tcs.service.CourseServiceInterface;
import com.tcs.service.AdminServiceImpl;


/**
 * @author VENKY_HARI
 *
 */

@RestController
@CrossOrigin
public class AdminRestController {
	
	@Autowired //CustomerDAO customerDAOOperation = new CustomerDAO();
	private AdminServiceInterface admins;
	
	@RequestMapping("/admin/{id}")
	public ResponseEntity getAdmin(@PathVariable("id") int id) throws SQLException, AdminNotFoundException {

		Admin adminId = admins.getId(id);
		if (adminId == null) {
			return new ResponseEntity("No admin found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(adminId, HttpStatus.OK);
	}

	@RequestMapping("/deletestudent/{id}")
	public ResponseEntity deleteStudent(@PathVariable int id) throws SQLException, StudentNotFoundException {
		String stud = admins.deleteStudent(id);

		return new ResponseEntity(stud, HttpStatus.OK);

	}
	@RequestMapping("/post/adminregister")
	public ResponseEntity createAdmin(@RequestBody Admin admin) throws SQLException {

		Admin admin1=admins.insert(admin);
		if (admin1 == null) {
			return new ResponseEntity("Admin registration failed ", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(admin1, HttpStatus.OK);
	}
	@RequestMapping("/put/admin/{id}")
	public ResponseEntity updateAdmin(@PathVariable int id, @RequestBody Admin admin) throws SQLException, AdminNotFoundException {

		Admin updateInfoStudent = admins.update(id, admin);
		if (updateInfoStudent == null) {
			return new ResponseEntity("No admin found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(updateInfoStudent, HttpStatus.OK);
	}
	@RequestMapping("post/approvestudent/{id}")
	public ResponseEntity approveStudent(@PathVariable int id) throws SQLException, StudentNotFoundException {
		String approve = admins.approveStudReg(id);
		

		return new ResponseEntity(approve, HttpStatus.OK);

	}
	@RequestMapping("/post/addcourse")
	public ResponseEntity addCourse(@RequestBody Course course) throws SQLException {

		Course info = admins.addCourses(course);
		if (info == null) {
			return new ResponseEntity("Course is not added", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(info, HttpStatus.OK);
	}
	
	@RequestMapping("/post/generategradecard/{studid}/{courseid}")
	public ResponseEntity generategradecard(@PathVariable("studid") int studentId, @PathVariable("courseid") int courseId) throws SQLException {
		String res = admins.generateGradeCard(studentId, courseId);
		if (res == null) {
			return new ResponseEntity("Grade card is not found for student id "+studentId+" for course id "+courseId, HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity(res, HttpStatus.OK);

	}
	
	@RequestMapping("/delete/course/{id}")
	public ResponseEntity deleteCourse(@PathVariable int id) throws CourseNotFoundException, SQLException {
		String course = admins.deleteCourse(id);

		return new ResponseEntity(course, HttpStatus.OK);

	}
	
	@RequestMapping("/post/addnewprofessor")
	public ResponseEntity addnewprofessor(@RequestBody Professor professor) throws SQLException {

		Professor info = admins.addNewProf(professor);
		if (info == null) {
			return new ResponseEntity("Professor is not added", HttpStatus.NOT_FOUND);
		}
		

		return new ResponseEntity(info, HttpStatus.OK);
	}
	
	@RequestMapping("/post/removeprofessor/{id}")
	public ResponseEntity removeprofessor(@PathVariable int id) throws SQLException, AdminNotFoundException {

		String info = admins.removeProf(id);

		return new ResponseEntity(info, HttpStatus.OK);
	}


}
