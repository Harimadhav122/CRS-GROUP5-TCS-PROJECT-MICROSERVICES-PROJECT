/**
 * 
 */
package com.tcs.dao;

import java.sql.SQLException;

import com.tcs.bean.GradeCard;

/**
 * @author VENKY_HARI
 *
 */
public interface GradeCardDAOInterface {
	public GradeCard getGrade(int studentId, int courseId) throws SQLException;
}
