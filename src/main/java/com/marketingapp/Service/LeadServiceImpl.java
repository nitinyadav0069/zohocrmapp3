package com.marketingapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.Entites.Lead;
import com.marketingapp.Repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	public LeadRepository leadRepo;


	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);		
	}


	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}


	@Override
	public void deleteLeadbyId(long id) {
        leadRepo.deleteById(id);		
	}


	@Override
	public Lead findLeadById(long id) {
     Optional<Lead> findById = leadRepo.findById(id);
		    return findById.get();
	}




}
