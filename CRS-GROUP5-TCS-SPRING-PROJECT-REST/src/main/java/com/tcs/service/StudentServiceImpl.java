/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.bean.Student;
import com.tcs.dao.StudentDAOInterface;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.GradeCardNotFoundException;
import com.tcs.exception.StudentNotFoundException;


@Component
public class StudentServiceImpl implements StudentServiceInterface {
	@Autowired 
	private StudentDAOInterface students;
	
	@Override
	public Student getId(int id) throws SQLException, StudentNotFoundException {
		
		return students.getId(id);
	}

	@Override
	public Student update(int id, Student student)throws SQLException {
		// TODO Auto-generated method stub
		return students.update(id, student);
	}
	
	@Override
	public Student insert(Student student) throws SQLException {
		return students.insert(student);
	}

	@Override
	public String registerCourse(int studentId, int courseId) throws SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
		return students.registerCourse(studentId, courseId);
	}

	@Override
	public List viewGradeCard(int studentId, int courseId) throws SQLException, GradeCardNotFoundException {
		// TODO Auto-generated method stub
		return students.viewGradeCard(studentId, courseId);
	}
	
	
}
