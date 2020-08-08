package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdminHomeStudentActivity extends Activity implements
		OnClickListener {
	Button b1, b2, b3, b4, b5, b6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_admin_home);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
		b6 = (Button) findViewById(R.id.button6);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_home, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			Intent i = new Intent(AdminHomeStudentActivity.this,
					AddNewStudentActivity.class);
			startActivity(i);

			break;
		case R.id.button2:
			Intent i2 = new Intent(AdminHomeStudentActivity.this,
					UpdateStudentPageActivity.class);
			startActivity(i2);

			break;
		case R.id.button3:
			Intent i3 = new Intent(AdminHomeStudentActivity.this,
					DeleteStudentActivity.class);
			startActivity(i3);

			break;
		case R.id.button4:
			Intent i4 = new Intent(AdminHomeStudentActivity.this,
					SearchStudentActivity.class);
			startActivity(i4);

			break;
		case R.id.button5:
			Intent i5 = new Intent(AdminHomeStudentActivity.this,
					BackHomePageActivity.class);
			startActivity(i5);

			break;
		case R.id.button6:
			Intent i6 = new Intent(AdminHomeStudentActivity.this,
					ViewAllStudentActivity.class);
			startActivity(i6);

			break;

		default:
			break;
		}

	}

}
