package com.vegibazar.dao.api;

import java.util.List;

import com.vegibazar.dao.entity.Feedback;


public interface FeedbackAPI {
	
	public List<Feedback> getAllFeedbak();
	public boolean addFeedback(Feedback feedback);
	public boolean deleteFeedback(Feedback feedback);
	public boolean updateFeedback(Feedback feedback);

}
