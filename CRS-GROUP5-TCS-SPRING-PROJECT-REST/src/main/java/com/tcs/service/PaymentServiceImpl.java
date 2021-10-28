/**
 * 
 */
package com.tcs.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tcs.bean.Payment;
import com.tcs.dao.PaymentDAOInterface;

/**
 * @author VENKY_HARI
 *
 */
@Component
public class PaymentServiceImpl implements PaymentServiceInterface {
	
	@Autowired 
	private PaymentDAOInterface payments;

	@Override
	public List paymentList(int id) throws SQLException {
		// TODO Auto-generated method stub
		return payments.list(id);
	}

	@Override
	public String insert(int id, Payment payment) throws SQLException {
		// TODO Auto-generated method stub
		return payments.insert(id, payment);
	}

	
}
