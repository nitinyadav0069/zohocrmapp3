package com.marketingapp.Controller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.Entites.Lead;
import com.marketingapp.Service.LeadService;
import com.marketingapp.Utility.EmailService;
import com.marketingapp.dto.LeadDto;


@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadservice;
	
	@Autowired
	private EmailService emailservice;
	
	//http://localhost:8080/create
    @RequestMapping("/create")
	public String viewCreatelead() {
		return "create_lead";
		
	}
    
    @RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute  Lead lead,Model model) {
		leadservice.saveLead(lead);
		emailservice.sendEmail(lead.getEmail(),"test","Welcome");
		model.addAttribute("msg","Record is Saved");
		return "create_lead";
	}
    
//    @RequestMapping("/saveLead")
//  	public String saveLead(
//  	@RequestParam("firstname")String firstName,
//  	@RequestParam("lastname")String lastName,
//  	@RequestParam("email")String email,
//  	@RequestParam("mobile")long mobile)
//    {
//       Lead lead = new Lead();
//       lead.setFirstname(firstName);
//       lead.setlastname(lastName);
//       lead.setEmail(email);
//       lead.setMobile(mobile);
//       
//       leadservice.saveLead(lead);
//       return "create_lead";
//  	}
    
//    @RequestMapping("/saveLead")
//    public String saveLead(LeadDto leadDto) {
//    	Lead lead = new Lead();
//        lead.setFirstname(leadDto.getFirstname());
//        lead.setlastname(leadDto.getLastname());
//        lead.setEmail(leadDto.getEmail());
//        lead.setMobile(leadDto.getMobile());
//        leadservice.saveLead(lead);
//    	return "create_lead";
//    }
//    
    
    //http://localhost:8080/listall
    @RequestMapping("/listall")
    public String getAllLeads(Model model) {
    	List<Lead> leads = leadservice.getAllLeads();
    	model.addAttribute("leads",leads);
    	return"search_result";    }
   
    @RequestMapping("/delete")
    public String deleteLeadById(@RequestParam("id") long id,Model model) {
    	leadservice.deleteLeadbyId(id);
    	List<Lead> leads = leadservice.getAllLeads();
    	model.addAttribute("leads",leads);
    	return"search_result";   
    }
    
    @RequestMapping("/update")
    public String getLeadById(@RequestParam("id") long id, Model model) {
    	 Lead lead = leadservice.findLeadById(id);
    	 model.addAttribute("lead", lead);
    	 return "update_lead";
    }
    
    @RequestMapping("/updateLead")
    public String updateLead(LeadDto dto,Model model) {
    	Lead l = new Lead();
         l.setId(dto.getId());
         l.setFirstname(dto.getFirstname());
         l.setlastname(dto.getLastname());
         l.setEmail(dto.getEmail());
         l.setMobile(dto.getMobile());
         
         leadservice.saveLead(l);
         
         List<Lead> leads = leadservice.getAllLeads();
     	model.addAttribute("leads",leads);
     	return"search_result"; 
         
    }
}
