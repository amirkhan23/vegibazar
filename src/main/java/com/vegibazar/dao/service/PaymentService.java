package com.vegibazar.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.entity.Payment;
import com.vegibazar.dao.impl.PaymentApiImpl;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	PaymentApiImpl pai;
	
	public boolean addPayment(Payment payment) {
		return pai.addPayment(payment);
		
		
	}
	

}
