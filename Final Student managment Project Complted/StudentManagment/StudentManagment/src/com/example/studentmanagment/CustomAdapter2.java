package com.example.studentmanagment;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter2 extends ArrayAdapter<String> {
	Integer layout;
	ArrayList<String> collegeId;
	ArrayList<String> subjectId;
	ArrayList<String> subjectName;
	ArrayList<String> semester;
	ViewAllStudentActivity context;

	public CustomAdapter2(ViewAllStudentActivity context, Integer layout,
			ArrayList<String> collegeId,
	ArrayList<String> subjectId,
	ArrayList<String> subjectName,
	ArrayList<String> semester) {
		super(context, layout, collegeId);
		this.collegeId= collegeId;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.semester=semester;
		this.layout = layout;
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater lt = context.getLayoutInflater();
		convertView = lt.inflate(layout, parent, false);
		TextView t1 = (TextView) convertView.findViewById(R.id.collegeId);
		TextView t2 = (TextView) convertView.findViewById(R.id.subjectId);
		TextView t3 = (TextView) convertView.findViewById(R.id.subjectName);
		TextView t4 = (TextView) convertView.findViewById(R.id.semester);
		
		t1.setText(collegeId.get(position));
		t2.setText(subjectId.get(position));
		t3.setText(subjectName.get(position));
		t4.setText(semester.get(position));
		MyTag m = new MyTag();
		m.s1 = collegeId.get(position);
		m.s2 = subjectId.get(position);
		m.s3 = subjectName.get(position);
		m.s4 = semester.get(position);
		convertView.setTag(m);
		return convertView;

	}

	class MyTag {
		String s1, s2, s3,s4;
	}

}
