package com.smartdroffice.web;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartdroffice.dao.ClientBillingRepository;
import com.smartdroffice.dao.ClientRepository;
import com.smartdroffice.dao.InsuranceRepository;
import com.smartdroffice.dao.PatientRepository;
import com.smartdroffice.domain.Client;
import com.smartdroffice.domain.ClientBilling;
import com.smartdroffice.domain.Insurance;
import com.smartdroffice.domain.Patient;

@RestController
@RequestMapping("/clientservice")
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private InsuranceRepository insuranceRepo;
	
	@Autowired
	private ClientBillingRepository clientBillingRepo;
	
	@RequestMapping(value="/getClientById/{clientId}", method = RequestMethod.GET)
	public @ResponseBody Client getClientById(@PathVariable BigInteger clientId){
		return clientRepo.findClientByClientId(clientId);
	}
	
	@RequestMapping(value="/addClient", method = RequestMethod.POST)
	public @ResponseBody Client addClient(@RequestBody Client client){
		return clientRepo.save(client);
	}
	
	@RequestMapping(value="/addClientBilling", method = RequestMethod.POST)
	public @ResponseBody String addClientBilling(@RequestBody ClientBilling clientBilling){
		Client client = clientRepo.findClientByClientId(clientBilling.getClientId());
		if(client != null){
			List<ClientBilling> clientBillings = client.getClientBillings();
			if(clientBillings != null && clientBillings.size() > 0){
				clientBillings.add(clientBilling);
			}else{
				clientBillings = new ArrayList<>();
				clientBillings.add(clientBilling);
			}
			client.setClientBillings(clientBillings);
			clientRepo.save(client);
		}else{
			return "CLIENT NOT FOUND";
		}
		return "CLIENT BILLING ADDED";
	}
	
	@RequestMapping(value="/addPatient", method = RequestMethod.POST)
	public @ResponseBody void addPatient(@RequestBody Patient patient, HttpServletResponse response){
		Client client = clientRepo.findClientByClientId(patient.getClientId());
		if(client != null){
			patientRepo.save(patient);
		}else{
			 response.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		response.setStatus(HttpStatus.ACCEPTED.value());
	}
	
	@RequestMapping(value="/addPatients", method = RequestMethod.POST)
	public @ResponseBody void addPatients(@RequestBody List<Patient> patients, HttpServletResponse response){
		if(patients != null && patients.size() >0){
			Client client = clientRepo.findClientByClientId(patients.get(0).getClientId());
			if(client != null){
				patients.forEach(p -> patientRepo.save(p));
			}else{
				 response.setStatus(HttpStatus.BAD_REQUEST.value());
			}
		}else{
			 response.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		 response.setStatus(HttpStatus.CREATED.value());
	}
	
	@RequestMapping(value="/getPatients/{clientId}", method = RequestMethod.GET)
	public @ResponseBody List<Patient> getPatients(@PathVariable BigInteger clientId){
		return patientRepo.findPatientsByClientId(clientId);     
	}
	
	@RequestMapping(value="/addInsurance", method = RequestMethod.POST)
	public @ResponseBody String addInsurance(@RequestBody Insurance insurance){
		if(insurance != null){
			Client client = clientRepo.findClientByClientId(insurance.getClientId());
			if(client != null){
				insuranceRepo.save(insurance);
			}else{
				return "CLIENT NOT FOUND";
			}
		}else{
			return "Empty Insurance Object";
		}
		return "INSURANCE ADDED";
	}
	
	@RequestMapping(value="/getInsurances/{clientId}", method = RequestMethod.GET)
	public @ResponseBody List<Insurance> getInsurances(@PathVariable BigInteger clientId){
		return insuranceRepo.findByClientId(clientId);
	}
	
//	@RequestMapping(value="/addClientBilling", method = RequestMethod.POST)
//	public @ResponseBody String addClientBilling1(@RequestBody ClientBilling clientBilling){
//		if(clientBilling != null){
//			Client client = clientRepo.findClientByClientId(clientBilling.getClientId());
//			if(client != null){
//				clientBillingRepo.save(clientBilling);
//			}else{
//				return "CLIENT NOT FOUND";
//			}
//		}else{
//			return "Empty Insurance Object";
//		}
//		return "CLIENT BILLING ADDED";		
//	}
}


