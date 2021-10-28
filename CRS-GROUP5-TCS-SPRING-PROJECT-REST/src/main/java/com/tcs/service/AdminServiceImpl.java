/**
 * 
 */
package com.tcs.service;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.bean.Admin;
import com.tcs.bean.Course;
import com.tcs.bean.Professor;
import com.tcs.dao.AdminDAOInterface;
import com.tcs.exception.AdminNotFoundException;
import com.tcs.exception.CourseNotFoundException;
import com.tcs.exception.StudentNotFoundException;

/**
 * @author VENKY_HARI
 *
 */
@Component
public class AdminServiceImpl implements AdminServiceInterface {
	@Autowired 
	private AdminDAOInterface admins;
	
	@Override
	public String approveStudReg(int id) throws SQLException, StudentNotFoundException {
		// TODO Auto-generated method stub
		return admins.approveStudReg(id);
	}

	@Override
	public String generateGradeCard(int studentId, int courseId) throws SQLException {
		// TODO Auto-generated method stub
		return admins.generateGradeCard(studentId,courseId);
	}

	@Override
	public Course addCourses(Course course) throws SQLException {
		// TODO Auto-generated method stub
		return admins.addCourses(course);
	}

	@Override
	public Admin getId(int id) throws SQLException, AdminNotFoundException {
		// TODO Auto-generated method stub
		return admins.getId(id);
	}

	@Override
	public String deleteStudent(int id) throws SQLException, StudentNotFoundException {
		// TODO Auto-generated method stub
		return admins.deleteStudent(id);
	}

	@Override
	public Admin insert(Admin admin) throws SQLException {
		// TODO Auto-generated method stub
		return admins.insert(admin);
	}

	@Override
	public Admin update(int id, Admin admin) throws SQLException, AdminNotFoundException {
		// TODO Auto-generated method stub
		return admins.update(id, admin);
	}
	public String deleteCourse(int id) throws CourseNotFoundException, SQLException{
		return admins.deleteCourse(id);
	}

	@Override
	public Professor addNewProf(Professor professor) throws SQLException {
		// TODO Auto-generated method stub
		return admins.addNewProf(professor);
	}

	@Override
	public String removeProf(int id) throws SQLException, AdminNotFoundException {
		// TODO Auto-generated method stub
		return admins.removeProf(id);
	}
}
