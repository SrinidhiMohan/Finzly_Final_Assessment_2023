package com.finzly.UtilityBillPay.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.finzly.UtilityBillPay.entity.Invoice;


@Repository
public class InvoiceDao {

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	SessionFactory factory;
	Date currentDate = new Date();
	public List<Invoice> getAllPaidBills(long id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Invoice.class);
//		criteria.add(Restrictions.and(Restrictions.eq("paymentstatus","paid"),Restrictions.eq("cid", id)));
		criteria.add(Restrictions.eq("paymentstatus","paid"));
		List<Invoice> pendingBillInvoice = criteria.list();
	    for (Invoice invoice : pendingBillInvoice) {
			invoice.setInvoicedate(currentDate);
			session.beginTransaction().commit();
		}	
		return pendingBillInvoice;
	}
	public List<Invoice> getAllPendingBills(long id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Invoice.class);
	//	criteria.add(Restrictions.and(Restrictions.eq("paymentstatus","pending"),Restrictions.eq("cid", id)));
		criteria.add(Restrictions.eq("paymentstatus","pending"));
		criteria.addOrder(Order.asc("billduedate"));
		List<Invoice> pendingBillInvoice = criteria.list();
	    for (Invoice invoice : pendingBillInvoice) {
			invoice.setInvoicedate(currentDate);
			session.beginTransaction().commit();
		}	
		return pendingBillInvoice;
	}

}
