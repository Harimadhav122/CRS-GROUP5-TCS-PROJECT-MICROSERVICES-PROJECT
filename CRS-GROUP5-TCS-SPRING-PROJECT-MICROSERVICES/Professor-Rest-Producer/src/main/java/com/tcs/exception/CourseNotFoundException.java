/**
 * 
 */
package com.tcs.exception;

/**
 * @author VENKY_HARI
 *
 */
public class CourseNotFoundException extends Exception {
	private int id;
	public CourseNotFoundException(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		return "Course with id "+id+" not found";
	}
}
