/**
 * 
 */
package com.tcs.constant;

/**
 * @author VENKY_HARI
 *
 */
public class SQLQueriesConstants {
	public static final String VIEW_LIST_STUDENTS = "select * from students";
	public static final String VIEW_SELECTED_STUDENT = "select * from students where studentId= ?";
	public static final String DELETE_SELECTED_ID_STUDENT_DATA = "delete from students where studentId= ?";
	
	public static final String PAYMENT_NOTIFY = "select * from paymentnotification where paymentId=?";
	
	public static final String VIEW_LIST_PROFESSORS = "select * from professors";
	public static final String VIEW_SELECTED_PROFESSOR = "select * from professors where ProfessorId= ?";
	public static final String DELETE_SELECTED_ID_PROFESSOR_DATA = "delete from professors where ProfessorId= ?";
	
	public static final String VIEW_ADMIN = "select * from admins";
	public static final String VIEW_SELECTED_ID_ADMIN = "select * from admins where adminId= ?";
	
	public static final String DELETE_SELECTED_ID_STUDENT = "delete from students where studentId= ?";
	
	public static final String VIEW_COURSE = "select * from courses";
	public static final String VIEW_SELECTED_COURSE = "select * from courses where courseId= ?";
	public static final String DELETE_SELECTED_COURSE = "delete from courses where courseId= ?";
	
	public static final String VIEW_USER = "select * from users where userId= ?";
	
	public static final String VIEW_REGISTERED_COURSES = "select * from registeredcourses where studentId= ?";
	
	public static final String DELETE_SELECTED_USER = "delete from users where userId= ?";
}