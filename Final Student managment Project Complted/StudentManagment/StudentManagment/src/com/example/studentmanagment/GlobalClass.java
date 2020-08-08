package com.example.studentmanagment;

import android.app.Application;

public class GlobalClass extends Application {
	private String collegeId;
    private String facultyId;
    
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

}
