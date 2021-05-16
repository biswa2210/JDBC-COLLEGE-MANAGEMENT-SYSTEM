package com.staff.attendence;

public class Attendance {
	private int staffid;
	private String enroll;
	private String name;
	private String chckTime;
	private String date;
	private String designation;
	public int getStaffid() {
		return staffid;
	}
	/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getEnroll() {
		return enroll;
	}
	public void setEnroll(String enroll) {
		this.enroll = enroll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChckTime() {
		return chckTime;
	}
	public void setChckTime(String chckTime) {
		this.chckTime = chckTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Attendance(int staffid, String enroll, String name, String chckTime, String date,
			String designation) {
		super();
		this.staffid = staffid;
		this.enroll = enroll;
		this.name = name;
		this.chckTime = chckTime;
		this.date = date;
		this.designation = designation;
	}
	public Attendance(String enroll, String name, String chckTime, String date, String designation) {
		super();
		this.enroll = enroll;
		this.name = name;
		this.chckTime = chckTime;
		this.date = date;
		this.designation = designation;
	}
	public Attendance() {
		super();
	}
	@Override
	public String toString() {
		return "Attendance [staffid=" + staffid + ", enroll=" + enroll + ", name=" + name + ", chckTime="
				+ chckTime + ", date=" + date + ", designation=" + designation + "]";
	}
	
	
}
