package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdminHomeFacultyActivity extends Activity implements OnClickListener {
	Button b1,b2,b3,b4;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_home_faculty);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		b4=(Button) findViewById(R.id.button4);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_home_activity_faculty, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			Intent i=new Intent(AdminHomeFacultyActivity.this,InsertFacultyActivity.class);
			startActivity(i);
			break;
		case R.id.button2:
			Intent i2=new Intent(AdminHomeFacultyActivity.this,ViewAllFacultyActivity.class);
			startActivity(i2);
			break;
			
		case R.id.button3:
			Intent i3=new Intent(AdminHomeFacultyActivity.this,DeleteFacultyActivity.class);
			startActivity(i3);
			break;
		case R.id.button4:
			Intent i4=new Intent(AdminHomeFacultyActivity.this,UpdateFacultyActivity.class);
			startActivity(i4);
		
			break;

		default:
			break;
		}

		
	}

}
