/**
 * 
 */
package com.tcs.bean;

/**
 * @author VENKY_HARI
 *
 */
public class Course {
	private int courseId;
	private String courseDesc;
	private int amount;
	private String catalogName;
	
	public Course(int courseId, String courseDesc, int amount, String catalogName) {
		// TODO Auto-generated constructor stub
		super();
		this.courseId=courseId;
		this.courseDesc=courseDesc;
		this.amount=amount;
		this.catalogName=catalogName;
	}
	
	public Course() {
		
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
	 * @return the courseDesc
	 */
	public String getCourseDesc() {
		return courseDesc;
	}
	/**
	 * @param courseDesc the courseDesc to set
	 */
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the catalogId
	 */
	public String getCatalogName() {
		return catalogName;
	}
	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

}
