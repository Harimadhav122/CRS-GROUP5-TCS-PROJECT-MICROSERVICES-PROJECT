/**
 * 
 */
package com.tcs.restController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bean.GradeCard;
import com.tcs.service.GradeCardServiceInterface;

/**
 * @author VENKY_HARI
 *
 */
@RestController
@CrossOrigin
public class GradeCardRestController {
	@Autowired //CustomerDAO customerDAOOperation = new CustomerDAO();
	private GradeCardServiceInterface gradecards;
	
	@RequestMapping(value="/post/gradecard/{studid}/{courseid}")
	public ResponseEntity getCustomer(@PathVariable("studid") int sid, @PathVariable("courseid") int cid) throws SQLException {

		GradeCard gradecard = gradecards.getGrade(sid,cid);
		if (gradecard == null) {
			return new ResponseEntity("No gradecard found for ID " + sid, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(gradecard, HttpStatus.OK);
	}

}
