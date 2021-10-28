/**
 * 
 */
package com.tcs.bean;

/**
 * @author VENKY_HARI
 *
 */
public class Payment {
	private int studentId;
	private int transactionId;
	private int amount;
	private String paymentMode;
	
	public Payment(int studentId, int transactionId, int amount, String paymentMode) {
		super();
		this.studentId = studentId;
		this.transactionId = transactionId;
		this.amount = amount;
		this.paymentMode=paymentMode;
	}
	/**
	 * @return the studentId
	 */
	public Payment() {
		
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
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
}
