package com.capgemini.contactbook.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.util.DbConnection;



public class ContactBookDaoImpl  implements ContactBookDao{
	//------------------------ 1. HotelMenu Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:addEnquiry(EnquiryBean enqry)
			 - Input Parameters	:	EnquiryBean enqry
			 - Return Type		:	int
			 - Throws			:  	ClassNotFoundException, IOException, SQLException, ContactBookException
			 - Author			:	S,Harshitha
			 - Creation Date	:	19/12/2018
			 - Description		:	Retriving Enquiry Details
			 ********************************************************************************************************/

	
	

		Logger logger=Logger.getRootLogger();
		 public ContactBookDaoImpl() {
			PropertyConfigurator.configure("resources//log4j.properties");
			// TODO Auto-generated constructor stub
		}
		 @Override
	public int addEnquiry(EnquiryBean enqry) throws ClassNotFoundException, IOException, SQLException, ContactBookException {
		// TODO Auto-generated method stub
		Connection connection = DbConnection.getConnection();
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		int enquiryId = 0;
		int queryResult = 0;

		try {

			preparedStatement = connection
					.prepareStatement(QueryMapper.insert_Query);
            preparedStatement.setInt(1,enqry.getEnqryId());
			preparedStatement.setString(2, enqry.getfName());

			preparedStatement.setString(3, enqry.getlName());

			preparedStatement.setString(4, enqry.getContactNo());
			preparedStatement.setString(5, enqry.getpDomain());
			preparedStatement.setString(6, enqry.getpLocation());
			queryResult=preparedStatement.executeUpdate();
		
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		if(queryResult==0)
		{
			logger.error("Insertion failed ");
			throw new ContactBookException("Inserting Enquiry details failed ");

		}
		else
		{
			logger.info("Insertion  successfully:");
			return enquiryId;
		}
	
		
	}
		//------------------------ 1. HotelMenu Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:getEnquiryDetails(int EnquiryId)
			 - Input Parameters	:	int EnquiryId
			 - Return Type		:	EnquiryBean
			 - Throws			:  	ClassNotFoundException, IOException, SQLException, ContactBookException
			 - Author			:	S,Harshitha
			 - Creation Date	:	19/12/2018
			 - Description		:	Retriving Enquiry Details
			 ********************************************************************************************************/

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryId) throws SQLException, ClassNotFoundException, IOException {
		EnquiryBean enquiryBean = null;
		Connection connection = DbConnection.getConnection();
		

		ResultSet resultset = null;
		//Statement st = connection.createStatement();
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(QueryMapper.viewDetails_Query);
		preparedStatement.setInt(1, EnquiryId);
		resultset=preparedStatement.executeQuery();
		
		while (resultset.next()) {
			enquiryBean = new EnquiryBean();
		//	System.out.println(resultset.getInt(1));
			enquiryBean.setEnqryId(resultset.getInt(1));
			enquiryBean.setfName(resultset.getString(2));
			enquiryBean.setlName(resultset.getString(3));
			enquiryBean.setContactNo(resultset.getString(4));
			enquiryBean.setpDomain(resultset.getString(5));
			enquiryBean.setpLocation(resultset.getString(6));
			return enquiryBean;
		}
		if(enquiryBean  != null)
		{
			logger.info("Record Found Successfully");
			return enquiryBean;
		}
		else
		{
			logger.info("Record not Found");
			return null;
		}
		//return enquiryBean;
		
		
	}

		
}
