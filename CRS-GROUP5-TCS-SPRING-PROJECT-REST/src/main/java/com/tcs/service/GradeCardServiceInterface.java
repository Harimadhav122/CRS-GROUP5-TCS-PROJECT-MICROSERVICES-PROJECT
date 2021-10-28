/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;

import com.tcs.bean.GradeCard;

/**
 * @author VENKY_HARI
 *
 */
public interface GradeCardServiceInterface {
	public GradeCard getGrade(int studentId, int courseId) throws SQLException;

}
