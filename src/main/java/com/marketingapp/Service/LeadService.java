package com.marketingapp.Service;

import java.util.List;

import com.marketingapp.Entites.Lead;

public interface LeadService {

	public void saveLead(Lead lead);
	public List<Lead>  getAllLeads();
	public void deleteLeadbyId(long id);
	public Lead findLeadById(long id);
}
