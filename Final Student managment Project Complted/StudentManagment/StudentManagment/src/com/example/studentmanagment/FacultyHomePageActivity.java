package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FacultyHomePageActivity extends Activity implements
		OnClickListener {
	Button b1, b2, b3;
	String email, department;
	SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faculty_home_page);
		session = new SessionManager(getApplicationContext());

		session.checkLogin();

		// email=getIntent().getStringExtra("email");
		email = session.getUserDetails();

		//email = getIntent().getStringExtra("email");
		Toast.makeText(FacultyHomePageActivity.this, email, 2000).show();

		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(this);

		DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db1 = dh.getReadableDatabase();
		String q = "select department from faculty where  facultyId=?";
		Cursor c = db1.rawQuery(q, new String[] { email });
		if (c.moveToFirst()) {
			department = c.getString(0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.faculty_home_page, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			Intent i = new Intent(FacultyHomePageActivity.this,
					ViewFacultyDeatilsActivity.class);
			//i.putExtra("email", email);
			startActivity(i);
			break;
		case R.id.button2:
			Intent i2 = new Intent(FacultyHomePageActivity.this,
					ViewQueryActivity.class);
			//i2.putExtra("email", email);
			i2.putExtra("department", department);

			startActivity(i2);
			break;

		case R.id.button3:
			Intent i3 = new Intent(FacultyHomePageActivity.this,
					AddNewStudentActivity.class);
						startActivity(i3);
			break;

		default:
			break;
		}

	}

}
