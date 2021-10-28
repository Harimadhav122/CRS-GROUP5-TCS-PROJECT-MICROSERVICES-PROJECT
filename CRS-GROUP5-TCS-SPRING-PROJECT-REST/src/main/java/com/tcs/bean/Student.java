/**
 * 
 */
package com.tcs.bean;

/**
 * @author VENKY_HARI
 *
 */
public class Student {
	private int studentId;
	private String studentName;
	private String studentDept;
	private String status;
	private String password;
	
	/**
	 * @param studentId
	 * @param studentRollNo
	 * @param studentDept
	 */
	public Student(int studentId, String studentName, String studentDept, String status, String password) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.status=status;
		this.password=password;
		
	}
	
	public Student(int studentId, String studentName, String studentDept, String status) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.status=status;
		
	}
	/**
	 * @return the studentId
	 */
	public Student() {
		
	}
	/**
	 * @param l the studentId to set
	 */
	public void setStudentId(int l) {
		this.studentId = l;
	}
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @return the studentRollNo
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentRollNo the studentRollNo to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the studentDept
	 */
	public String getStudentDept() {
		return studentDept;
	}
	/**
	 * @param studentDept the studentDept to set
	 */
	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
