package com.finzly.UtilityBillPay.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.NoResultException;
import javax.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.finzly.UtilityBillPay.entity.customerdetails;
import com.finzly.UtilityBillPay.exceptions.CustomerAlreadyExistsException;
import com.finzly.UtilityBillPay.exceptions.GlobalExceptionHandler;

@Repository
public class CustomerDao {

	    @Autowired
	    private SessionFactory sessionFactory;

	    public void addCustomer(customerdetails customerDetails) {
	        try (Session session = sessionFactory.openSession()) {
	            session.beginTransaction();
	            if (isAddressDuplicate(session, customerDetails.getAddress()) || isCustomerExists(session, customerDetails.getEmailid(), customerDetails.getMobileno())) {
	            	 // Check if the customer already exists based on email or mobile number
	            	GlobalExceptionHandler.getCustomerAlreadyExistsException("This address already Exists !!");
	                
	            }else {
	            	session.save(customerDetails);
	                session.getTransaction().commit();
	            	}
	            }
	        catch (CustomerAlreadyExistsException e) {
	            e.printStackTrace();
	            throw e; // Handle or log the exception as needed
	        }
	        }
	    
	            // Check if the customer already exists based on email or mobile number
	            
//	            
//	            if (!customerExists) {
//	                session.save(customerDetails);
//	                session.getTransaction().commit();
//	            } else {
//	            	GlobalExceptionHandler.getCustomerAlreadyExistsException("Customer Details Already Exists");
//	                session.getTransaction().rollback();
//	            }
//	        } catch (CustomerAlreadyExistsException e) {
//	            e.printStackTrace();
//	            throw e; // Handle or log the exception as needed
//	        }
//	    }

	    private boolean isCustomerExists(Session session, String emailId, String mobileNo) {
	        // Custom query to check if a customer with the same email or mobile number already exists
	        Long count = (Long) session.createQuery("SELECT COUNT(*) FROM customerdetails " +
	                "WHERE emailId = :email OR mobileNo = :mobile")
	                .setParameter("email", emailId)
	                .setParameter("mobile", mobileNo)
	                .uniqueResult();
	        return count != null && count > 0;
	    }
	    
	    private boolean isAddressDuplicate(Session session, String address) {
	        try {
	            // Custom query to check if a customer with the same address already exists
	            Long count = (Long) session.createQuery("SELECT COUNT(*) FROM customerdetails " +
	                    "WHERE address = :address")
	                    .setParameter("address", address)
	                    .uniqueResult();
	            return count != null && count > 0;
	        } catch (NoResultException e) {
	              return false;
	        }
	    }
	}



