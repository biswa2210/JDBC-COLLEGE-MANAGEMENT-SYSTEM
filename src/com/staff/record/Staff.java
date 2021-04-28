package com.staff.record;

public class Staff {
	private int StaffId;
	private String StaffNm;
	private String StaffENno;
	private String StaffDG;
	private String StaffPHno;
	private String StaffCity;
	public int getStaffId() {
		return StaffId;
	}
	public void setStaffId(int staffId) {
		StaffId = staffId;
	}
	public String getStaffNm() {
		return StaffNm;
	}
	public void setStaffNm(String staffNm) {
		StaffNm = staffNm;
	}
	public String getStaffENno() {
		return StaffENno;
	}
	public void setStaffENno(String staffENno) {
		StaffENno = staffENno;
	}
	public String getStaffDG() {
		return StaffDG;
	}
	public void setStaffDG(String staffDG) {
		StaffDG = staffDG;
	}
	public String getStaffPHno() {
		return StaffPHno;
	}
	public void setStaffPHno(String staffPHno) {
		StaffPHno = staffPHno;
	}
	public String getStaffCity() {
		return StaffCity;
	}
	public void setStaffCity(String staffCity) {
		StaffCity = staffCity;
	}
	public Staff(int staffId, String staffNm, String staffENno, String staffDG, String staffPHno, String staffCity) {
		super();
		StaffId = staffId;
		StaffNm = staffNm;
		StaffENno = staffENno;
		StaffDG = staffDG;
		StaffPHno = staffPHno;
		StaffCity = staffCity;
	}
	public Staff(String staffNm, String staffENno, String staffDG, String staffPHno, String staffCity) {
		super();
		StaffNm = staffNm;
		StaffENno = staffENno;
		StaffDG = staffDG;
		StaffPHno = staffPHno;
		StaffCity = staffCity;
	}
	public Staff() {
		super();
	}
	@Override
	public String toString() {
		return "Staff [StaffId=" + StaffId + ", StaffNm=" + StaffNm + ", StaffENno=" + StaffENno + ", StaffDG="
				+ StaffDG + ", StaffPHno=" + StaffPHno + ", StaffCity=" + StaffCity + "]";
	}
	
}
