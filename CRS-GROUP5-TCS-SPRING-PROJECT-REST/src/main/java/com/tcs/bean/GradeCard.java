/**
 * 
 */
package com.tcs.bean;

/**
 * @author VENKY_HARI
 *
 */
public class GradeCard {
	private int studentId;
	private int courseId;
	private String grade;
	
	public GradeCard(int studentId, int courseId, String grade) {
		// TODO Auto-generated constructor stub
		super();
		this.studentId=studentId;
		this.courseId=courseId;
		this.grade=grade;
		
	}
	
	public GradeCard() {
		
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
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
