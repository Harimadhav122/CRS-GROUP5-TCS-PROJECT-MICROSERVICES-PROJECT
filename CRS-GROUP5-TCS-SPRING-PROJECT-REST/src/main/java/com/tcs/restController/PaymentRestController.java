/**
 * 
 */
package com.tcs.restController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcs.service.PaymentServiceInterface;
import com.tcs.bean.Payment;
import com.tcs.dao.PaymentDAOImpl;
import com.tcs.service.PaymentServiceImpl;
/**
 * @author VENKY_HARI
 *
 */
@RestController
@CrossOrigin
public class PaymentRestController {
	@Autowired //CustomerDAO customerDAOOperation = new CustomerDAO();
	private PaymentServiceInterface payments;
	
	@RequestMapping("/post/payment/student/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") int id) throws SQLException {

		List payment = payments.paymentList(id);
		if (payment == null) {
			return new ResponseEntity("No payment found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(payment, HttpStatus.OK);
	}
	@RequestMapping("/post/payment/{id}")
	public ResponseEntity createCustomer(@PathVariable int id, @RequestBody Payment payment) throws SQLException {
		
		String msg=payments.insert(id,payment);

		return new ResponseEntity(msg, HttpStatus.OK);
	}
}
