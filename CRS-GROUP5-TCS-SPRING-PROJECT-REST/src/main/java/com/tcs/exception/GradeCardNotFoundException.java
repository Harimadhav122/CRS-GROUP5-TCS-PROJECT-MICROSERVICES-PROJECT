/**
 * 
 */
package com.tcs.exception;

/**
 * @author VENKY_HARI
 *
 */
public class GradeCardNotFoundException extends Exception {
	private int sid;
	private int cid;
	public GradeCardNotFoundException(int sid, int cid) {
		this.sid=sid;
		this.cid=cid;
	}
	public String getMessage() {
		return "Grade card is not found for student id "+sid+" for course id "+cid;
	}
}
