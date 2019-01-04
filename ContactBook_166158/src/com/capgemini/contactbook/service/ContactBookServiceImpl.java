package com.capgemini.contactbook.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.exception.ContactBookException;


public class ContactBookServiceImpl implements ContactBookService {
	ContactBookDao contactbookdao=new ContactBookDaoImpl();
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ClassNotFoundException, IOException, SQLException, ContactBookException {
		
		// TODO Auto-generated method stub
		int enqryId;
		enqryId=contactbookdao.addEnquiry(enqry);
		return enqryId;
		
	}

	public static boolean validEnquiry(EnquiryBean enquirybean) throws ContactBookException {
		List<String> validationErrors = new ArrayList<String>();
		if (!(isValidfName(enquirybean.getfName()))) {
			validationErrors.add("\nFirst Name cant be Alpha numeric");
		}
		if (!(isValidlName(enquirybean.getlName()))) {
			validationErrors.add("\nLast Name cant be Alpha numeric");
		}

		if (!(validationErrors.isEmpty())) {

			System.err.println(validationErrors + " ");
			return false;
		}
		return true;
	}

	private static boolean isValidfName(String fname) {
		Pattern namePattern = Pattern.compile("[A-Za-z]*");
		Matcher nameMatcher = namePattern.matcher(fname);
		return nameMatcher.matches();

	}
	private static boolean isValidlName(String lname) {
		Pattern namePattern = Pattern.compile("[A-Za-z]*");
		Matcher nameMatcher = namePattern.matcher(lname);
		return nameMatcher.matches();

	}
	private boolean isValidPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		Pattern phonePattern=Pattern.compile("[6-9][0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		
			return phoneMatcher.matches();
		
			
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryId) throws SQLException, ClassNotFoundException, IOException {
		EnquiryBean enquirybean;
		enquirybean = contactbookdao.getEnquiryDetails(EnquiryId);
		return enquirybean;
	}

	

	
	}

	
	

