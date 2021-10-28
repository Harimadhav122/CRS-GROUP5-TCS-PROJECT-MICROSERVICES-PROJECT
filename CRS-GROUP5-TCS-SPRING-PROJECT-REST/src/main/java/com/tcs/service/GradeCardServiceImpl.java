/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.bean.GradeCard;
import com.tcs.dao.GradeCardDAOInterface;

/**
 * @author VENKY_HARI
 *
 */
@Component
public class GradeCardServiceImpl implements GradeCardServiceInterface{
	@Autowired 
	private GradeCardDAOInterface gradecards;

	@Override
	public GradeCard getGrade(int studentId, int courseId) throws SQLException {
		// TODO Auto-generated method stub
		return gradecards.getGrade(studentId, courseId);
	}

}
