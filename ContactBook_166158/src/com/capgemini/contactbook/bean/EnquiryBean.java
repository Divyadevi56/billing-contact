package com.capgemini.contactbook.bean;

public class EnquiryBean {
	@Override
	public String toString() {
		return "EnquiryBean [enqryId=" + enqryId + ", fName=" + fName + ", lName=" + lName + ", ContactNo=" + ContactNo
				+ ", pLocation=" + pLocation + ", pDomain=" + pDomain + "]";
	}
	private int enqryId;
	private String fName;
	private String lName;
	private String ContactNo;
	private String pLocation;
	private String pDomain;
	public int getEnqryId() {
		return enqryId;
	}
	public void setEnqryId(int enqryId) {
		this.enqryId = enqryId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getpLocation() {
		return pLocation;
	}
	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}
	public String getpDomain() {
		return pDomain;
	}
	public void setpDomain(String pDomain) {
		this.pDomain = pDomain;
	}

}
