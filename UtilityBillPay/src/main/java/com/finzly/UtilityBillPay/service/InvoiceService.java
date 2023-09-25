package com.finzly.UtilityBillPay.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finzly.UtilityBillPay.dao.InvoiceDao;
import com.finzly.UtilityBillPay.entity.Invoice;


@Service
public class InvoiceService {
	
	
	@Autowired
	private InvoiceDao invoiceDao;
	
	public List<Invoice> getAllPaidBills(long id) {
	
		return invoiceDao.getAllPaidBills(id);
	}

	public List<Invoice> getAllPendingBills(long id) {
	
		return invoiceDao.getAllPendingBills(id);
	}

}
