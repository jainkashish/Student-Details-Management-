package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StudentHomePageActivity extends Activity implements
		OnClickListener {
	Button b1, b2, b3, b4;
	String email;
	SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_home_page);
		
		session = new SessionManager(getApplicationContext());

		session.checkLogin();

		// email=getIntent().getStringExtra("email");
		email = session.getUserDetails();
		
		Toast.makeText(StudentHomePageActivity.this, email, 2000).show();

		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);

		b4 = (Button) findViewById(R.id.button4);
		b4.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_home_page, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			Intent i = new Intent(StudentHomePageActivity.this,
					ViewStudentPersonalDetailsActivity.class);
			// i.putExtra("email", email);
			startActivity(i);
			break;
		case R.id.button2:
			Intent i2 = new Intent(StudentHomePageActivity.this,
					ViewStudentAcademicDetailsActivity.class);
			// i2.putExtra("email", email);

			startActivity(i2);
			break;

		case R.id.button3:
			Intent i3 = new Intent(StudentHomePageActivity.this,
					AskQueryActivity.class);
			// i3.putExtra("email", email);
			startActivity(i3);
			break;
		case R.id.button4:
			Intent i4 = new Intent(StudentHomePageActivity.this,
					ViewRepliesActivity.class);
			// i4.putExtra("email", email);
			startActivity(i4);
			break;

		default:
			break;
		}

	}

}
