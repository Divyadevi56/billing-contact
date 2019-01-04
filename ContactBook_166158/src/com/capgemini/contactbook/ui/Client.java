package com.capgemini.contactbook.ui;

import java.util.Scanner;

import com.capgemini.contactbook.bean.EnquiryBean;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;






public class Client {
	static Scanner sc = new Scanner(System.in);
	static ContactBookService contactBookService = null;
	static ContactBookServiceImpl contactBookServiceImpl = null;
	static Logger logger = Logger.getRootLogger();
	public static void main(String[] args) {
		PropertyConfigurator.configure("resources//log4j.properties");
		 EnquiryBean enquiryBean = null;
		int enqryId = 0;
		int option = 0;
		while (true) {
			System.out.println("************Global Recruitments*************");
			System.out.println("Choose an operation");
			System.out.println("1.Enter Enquiry Details");
			System.out.println("2.View Enquiry Details on Id");
			System.out.println("0.Exit");
			System.out.println("****************");
			System.out.println("Please enter a choice");
			System.out.println("******************");
			try {
				option = sc.nextInt();
				switch (option) 
				{
				case 1:
					while (enquiryBean == null) {
						enquiryBean = populateBean();
					}
					try
					{
						
						contactBookService=new ContactBookServiceImpl();
						enqryId=contactBookService.addEnquiry(enquiryBean);
						System.out.println(enqryId);
					}
					catch (Exception e) {
						logger.error("exception occured", e);
						System.err.println("ERROR : "+ e.getMessage());
					}
					finally
					{
						enqryId=0;
						contactBookService=null;
						enquiryBean=null;
					}
					break;
				
				case 2:
					System.out.println(" Enter Enquiry No");
					enqryId = sc.nextInt();
					contactBookService = new ContactBookServiceImpl();
					enquiryBean = contactBookService.getEnquiryDetails(enqryId);
					System.out.println(enquiryBean);

					
					break;
				case 0:
					System.exit(0);
					break;
					default:
						break;
				}
			}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
		
	}
	private static EnquiryBean populateBean() throws ContactBookException {
		// TODO Auto-generated method stub
		EnquiryBean enquiryBean = new EnquiryBean();
		
		System.out.println("Enter First Name");
		enquiryBean.setfName(sc.next());
		System.out.println("Enter Last Name");
		enquiryBean.setlName(sc.next());
		System.out.println("Enter contact number");
		enquiryBean.setContactNo(sc.next());
		System.out.println("Enter preferred domain");
		enquiryBean. setpDomain(sc.next());
		System.out.println("Enter preferred location");
		enquiryBean. setpLocation(sc.next());
		
		try {

			if (ContactBookServiceImpl.validEnquiry(enquiryBean)) {
				return enquiryBean;
			} else {
				return null;
			}

		} catch (ContactBookException contactBookException) {
			logger.error("exception occured", contactBookException);
			System.err.println(contactBookException.getMessage() + "\n Try again..");
		}
		System.exit(0);

		return enquiryBean;
	}
}
