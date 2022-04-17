package com.aj.view;

import org.springframework.stereotype.Service;

@Service
public class LeadDataService {

	public LeadAcquisitionPage get(String formId)
	{
		return new LeadAcquisitionPage();
	}
}
