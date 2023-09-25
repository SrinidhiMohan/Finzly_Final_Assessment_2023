package com.finzly.UtilityBillPay.service;
import org.springframework.validation.annotation.Validated;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;
import javax.mail.internet.InternetAddress;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.finzly.UtilityBillPay.dao.CustomerDao;
import org.hibernate.SessionFactory;
import com.finzly.UtilityBillPay.entity.customerdetails;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finzly.UtilityBillPay.entity.login;

@Validated
@Service
public class CustomerService {
	
	 private Random random = new Random();
	 private Set<Integer> generatedNumbers = new HashSet<>();
	 @Autowired
	 private SessionFactory sessionFactory;
     @Autowired
     private CustomerDao customerDao;
    
	public List<customerdetails> getCustomerDetails(long id) {
		
		return customerDao.getCustomerDetails(id);
	}
     
     
    
    public void addCustomer(@Valid customerdetails customerDetails) {
    	Session session = sessionFactory.openSession();
        login lg = new login();
        lg.setCid(customerDetails.getCid());
        lg.setOtp(generateRandomUniqueNumber());
        session.save(lg);
        customerDetails.setLogin(lg);
		session.beginTransaction().commit();
		
    	customerDao.addCustomer(customerDetails);
   
    
    }
    
    // Validation for customer name
    public void validateCustomerName(@NotBlank(message = "Customer name is required") String customerName) {
        
    }
    
    // Validation for mobile number
    public void validateMobileNumber(@NotBlank(message = "Mobile number is required")
                                     @Pattern(regexp = "\\d{10}", message = "Invalid mobile number")
                                     String mobileNo) {
        
    }

    // Validation for email id
    public void validateEmailId(@NotBlank(message = "Email ID is required")
                                @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email address")
                                @Pattern(regexp = ".*@.*\\..*", message = "Invalid email format")
                                String emailId) {
        try {
        	InternetAddress internetAddress = new InternetAddress(emailId);
        	internetAddress.validate();
        }catch(Exception e){
        	e.getMessage();
        }
    }

    // Validation for address
    public void validateAddress(@NotBlank(message = "Address is required")
                                @Size(max = 255, message = "Address should not exceed 255 characters")
                                String address) {

    }
    
    
    // Generate a random unique five-digit number
    private int generateRandomUniqueNumber() {
        int min = 10000; // Minimum five-digit number
        int max = 99999; // Maximum five-digit number

        while (true) {
            int randomNumber = random.nextInt(max - min + 1) + min;

            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
                return randomNumber;
            }
        }
    }


}
    


