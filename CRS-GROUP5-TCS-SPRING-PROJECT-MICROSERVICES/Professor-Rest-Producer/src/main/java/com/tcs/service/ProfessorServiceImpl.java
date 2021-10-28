/**
 * 
 */
package com.tcs.service;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.bean.Professor;
import com.tcs.dao.ProfessorDAOInterface;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.ProfessorNotFoundException;
import com.tcs.exception.StudentNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
@Component
public class ProfessorServiceImpl implements ProfessorServiceInterface {
	@Autowired 
	private ProfessorDAOInterface professors;

	@Override
	public List studentList() throws SQLException {
		// TODO Auto-generated method stub
		return professors.studentList();
	}

	@Override
	public Professor getId(int id) throws SQLException, ProfessorNotFoundException {
		// TODO Auto-generated method stub
		return professors.getId(id);
	}

	@Override
	public String assignGrade(int studentId, int courseId, String grade) throws SQLException, StudentNotFoundException, CourseNotFoundException {
		// TODO Auto-generated method stub
		return professors.assignGrade(studentId, courseId, grade);
	}

	@Override
	public List courseList() throws SQLException {
		// TODO Auto-generated method stub
		return professors.courseList();
	}

	
}
