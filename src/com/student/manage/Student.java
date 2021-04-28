package com.student.manage;

public class Student {
	
	private int StudentId;
	private String StudentNm;
	private String StudentENno;
	private String StudentRGno;
	private String StudentPHno;
	private String StudentCity;
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentNm() {
		return StudentNm;
	}
	public void setStudentNm(String studentNm) {
		StudentNm = studentNm;
	}
	public String getStudentENno() {
		return StudentENno;
	}
	public void setStudentENno(String studentENno) {
		StudentENno = studentENno;
	}
	public String getStudentRGno() {
		return StudentRGno;
	}
	public void setStudentRGno(String studentRGno) {
		StudentRGno = studentRGno;
	}
	public String getStudentPHno() {
		return StudentPHno;
	}
	public void setStudentPHno(String studentPHno) {
		StudentPHno = studentPHno;
	}
	public String getStudentCity() {
		return StudentCity;
	}
	public void setStudentCity(String studentCity) {
		StudentCity = studentCity;
	}
	public Student(int studentId, String studentNm, String studentENno, String studentRGno, String studentPHno,
			String studentCity) {
		super();
		StudentId = studentId;
		StudentNm = studentNm;
		StudentENno = studentENno;
		StudentRGno = studentRGno;
		StudentPHno = studentPHno;
		StudentCity = studentCity;
	}
	public Student(String studentNm, String studentENno, String studentRGno, String studentPHno, String studentCity) {
		super();
		StudentNm = studentNm;
		StudentENno = studentENno;
		StudentRGno = studentRGno;
		StudentPHno = studentPHno;
		StudentCity = studentCity;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentNm=" + StudentNm + ", StudentENno=" + StudentENno
				+ ", StudentRGno=" + StudentRGno + ", StudentPHno=" + StudentPHno + ", StudentCity=" + StudentCity
				+ "]";
	}
	

}
