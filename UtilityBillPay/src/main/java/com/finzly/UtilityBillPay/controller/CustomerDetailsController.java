package com.finzly.UtilityBillPay.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.UtilityBillPay.entity.customerdetails;
import com.finzly.UtilityBillPay.exceptions.CustomerAlreadyExistsException;
import com.finzly.UtilityBillPay.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "http://localhost:60879")
@RestController
public class CustomerDetailsController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("getCustomerDetails/{id}")
     public List<customerdetails> getCustomerDetails(@PathVariable long id){

    	return customerService.getCustomerDetails(id);
    }
      

    @PostMapping("addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody customerdetails customerDetails) {
        try { 
        customerService.validateCustomerName(customerDetails.getCustomername());
        customerService.validateMobileNumber(customerDetails.getMobileno());
        customerService.validateEmailId(customerDetails.getEmailid());
        customerService.validateAddress(customerDetails.getAddress());
        customerService.addCustomer(customerDetails);
        return ResponseEntity.ok("Customer details added successfully. \n"
        		                + "Customer id: "+customerDetails.getCid() +"\n"
        		                + "OTP: "+customerDetails.getLogin().getOtp());
        }catch(CustomerAlreadyExistsException e) {
        	return ResponseEntity.badRequest().body("Customer Details Already Exists");
        } 
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to register. Please enter valid details.");
        }
    }
    
  
    
}
