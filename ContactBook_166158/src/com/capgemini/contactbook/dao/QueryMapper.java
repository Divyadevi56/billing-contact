package com.capgemini.contactbook.dao;

public interface QueryMapper {
	public static final String insert_Query="Insert into enquiry values(enquiries.nextVal,?,?,?,?,?)";
	
	public static final String viewDetails_Query="select * from enquiry where enqryId=?";
}
