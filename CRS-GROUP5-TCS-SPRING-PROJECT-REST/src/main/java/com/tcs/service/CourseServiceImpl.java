package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.bean.Course;
import com.tcs.dao.CourseDAOInterface;
import com.tcs.exception.CourseNotFoundException;

@Component
public class CourseServiceImpl implements CourseServiceInterface {
	@Autowired 
	private CourseDAOInterface courses;

	@Override
	public List courseList() throws SQLException {
		// TODO Auto-generated method stub
		return courses.courseList();
	}

	@Override
	public Course getCourse(int id) throws CourseNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return courses.getCourse(id);
	}

}
