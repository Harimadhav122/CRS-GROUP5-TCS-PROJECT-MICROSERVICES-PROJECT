/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import com.tcs.bean.Payment;

/**
 * @author VENKY_HARI
 *
 */
public interface PaymentServiceInterface {
	public List paymentList(int id) throws SQLException;
	public String insert(int id, Payment payment) throws SQLException;
}
