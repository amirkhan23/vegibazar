package com.vegibazar.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.entity.Feedback;
import com.vegibazar.dao.impl.FeedbackApiImpl;

@Service
@Transactional
public class FeedbackService {

	@Autowired
	FeedbackApiImpl fai;
	
	public List<Feedback> getAllFeedbak(){
		return fai.getAllFeedbak();
		
	}
	public boolean addFeedback(Feedback feedback){
		return fai.addFeedback(feedback);
		
	}
	public boolean deleteFeedback(Feedback feedback){
		return fai.deleteFeedback(feedback);
		
	}
	public boolean updateFeedback(Feedback feedback){
		return fai.updateFeedback(feedback);
		
	}
	
	
}
