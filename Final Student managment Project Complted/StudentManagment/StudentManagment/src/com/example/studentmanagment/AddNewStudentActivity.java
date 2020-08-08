package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class AddNewStudentActivity extends Activity implements OnItemSelectedListener, OnClickListener {
	Spinner s1,s2,s3;
	Button b1;
	String branch,year,course;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_student);
		s1=(Spinner) findViewById(R.id.spinner1);
		s2=(Spinner) findViewById(R.id.spinner2);
		s3=(Spinner) findViewById(R.id.spinner3);
        s1.setOnItemSelectedListener(this);
        s2.setOnItemSelectedListener(this);
        s3.setOnItemSelectedListener(this);
        b1=(Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new_student, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int index,
			long arg3) {
		// TODO Auto-generated method stub
		 branch=s1.getSelectedItem().toString();
		 year=s2.getSelectedItem().toString();
		 course=s3.getSelectedItem().toString();
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		 Intent i=new Intent(AddNewStudentActivity.this,InsertPersonalDetailsActivity.class);
		 i.putExtra("branch", branch);
		 i.putExtra("year",year);
		 i.putExtra("course",course);
		 startActivity(i);

		
	}

}
