/**
 * 
 */
package com.tcs.bean;

/**
 * @author VENKY_HARI
 *
 */
public class RegisteredCourses {
	private int studentId;
	private int courseId;
	
	public RegisteredCourses(int studentId, int courseId) {
		super();
		this.studentId=studentId;
		this.courseId=courseId;
	}
	
	public RegisteredCourses() {
		
	}
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
