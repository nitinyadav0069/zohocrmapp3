package com.marketingapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.Entites.Lead;
import com.marketingapp.Repository.LeadRepository;
import com.marketingapp.dto.LeadDto;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	//http://localhost:8080/api/leads
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	
	
	@PostMapping
	public void createLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/leads/1
	@DeleteMapping("/{id}")
	public void deleteLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
	
	//http://localhost:8080/api/leads/1
	@PutMapping("/{id}")
	public void updateLead(@RequestBody LeadDto dto,@PathVariable("id") long id) {
		Lead l = new Lead();
		l.setId(id);
		l.setFirstname(dto.getFirstname());
		l.setlastname(dto.getLastname());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		
		leadRepo.save(l);
	}
	
}
