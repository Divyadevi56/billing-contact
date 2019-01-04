package com.capgemini.contactbook.service;

import java.io.IOException;
import java.sql.SQLException;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.exception.ContactBookException;


public interface ContactBookService {

	public int addEnquiry(EnquiryBean enqry) throws ClassNotFoundException, IOException, SQLException, ContactBookException;
	public EnquiryBean getEnquiryDetails(int EnquiryId) throws SQLException, ClassNotFoundException, IOException;
	

}
