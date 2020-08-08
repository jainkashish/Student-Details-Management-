package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class InsertFacultyActivity extends Activity implements
OnItemSelectedListener, OnClickListener {
	EditText t1, t2, t4, t5, t6;
	Button b1;
	Spinner s1;
	String branch;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_faculty);
		t1 = (EditText) findViewById(R.id.editText1);
		t2 = (EditText) findViewById(R.id.editText2);
		s1 = (Spinner) findViewById(R.id.spinner1);
		t4 = (EditText) findViewById(R.id.editText4);
		t5 = (EditText) findViewById(R.id.editText5);
		t6 = (EditText) findViewById(R.id.editText6);
		s1.setOnItemSelectedListener(this);
		
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert_faculty, menu);
		return true;
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int index,
			long arg3) {
		// TODO Auto-generated method stub
		branch = s1.getSelectedItem().toString();
		Toast.makeText(this, branch, 2000).show();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}



	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db = dh.getWritableDatabase();
		ContentValues cv2 = new ContentValues();
		cv2.put("facultyId", t1.getText().toString());
		cv2.put("name", t2.getText().toString());
		cv2.put("department", branch);
		cv2.put("contact", t4.getText().toString());
		cv2.put("email", t5.getText().toString());

		cv2.put("password", t6.getText().toString());

		long check2 = db.insert("faculty", null, cv2);
		if (check2 > 0) {

			Toast.makeText(this, "Record Successfully Inserted", 2000).show();
			Intent i = new Intent(InsertFacultyActivity.this,
					AdminHomePageActivity.class);
			startActivity(i);
		} else {
			Toast.makeText(this, "Record Successfully Not Inserted", 2000)
					.show();

		}

	}

}
