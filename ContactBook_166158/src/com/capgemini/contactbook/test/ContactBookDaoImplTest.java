package com.capgemini.contactbook.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;



public class ContactBookDaoImplTest {
	static ContactBookDaoImpl dao;
	static EnquiryBean enquiryBean;
	
	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new ContactBookDaoImpl();
		enquiryBean= new EnquiryBean();
	}
	@Test
	public void testAddEnquiry() {
		enquiryBean.setfName("Yuvanesh");
		enquiryBean.setlName("Abi");
		enquiryBean.setContactNo("90033662090");
		enquiryBean.setpDomain("Java");
		enquiryBean.setpLocation("Pune");
		
		
		
		assertEquals(enquiryBean,enquiryBean);
	}

	@Test
	public void testGetEnquiryDetails() throws ClassNotFoundException, SQLException, IOException {
		assertNotNull(dao.getEnquiryDetails(1001));
	}

}
