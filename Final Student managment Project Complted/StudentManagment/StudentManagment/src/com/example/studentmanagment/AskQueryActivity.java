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

public class AskQueryActivity extends Activity implements
		OnItemSelectedListener, OnClickListener {
	SessionManager session;
	String studentId;
	Spinner s1;
	EditText t1;
	Button b1;
	String branch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ask_query);
		
		session = new SessionManager(getApplicationContext());

		session.checkLogin();

		studentId = session.getUserDetails();

		//studentId = getIntent().getStringExtra("email");
		Toast.makeText(AskQueryActivity.this, studentId, 2000).show();
		s1 = (Spinner) findViewById(R.id.spinner1);
		t1 = (EditText) findViewById(R.id.editText1);
		s1.setOnItemSelectedListener(this);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ask_query, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int index,
			long arg3) {
		// TODO Auto-generated method stub
		branch = s1.getSelectedItem().toString();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(branch.equals("Select Branch")){
			Toast.makeText(AskQueryActivity.this, "Please  select a department", 2000).show();
			
			
		}
		else
		{
			DataBaseHelper dh=new DataBaseHelper(getApplicationContext());
			SQLiteDatabase db=dh.getWritableDatabase();
			String description=t1.getText().toString();
			ContentValues cv=new ContentValues();
			cv.put("studentId",studentId);
			cv.put("department",branch);
			cv.put("description",description);
			long check= db.insert("query", null, cv);
			if (check>0)
			{
	
			Toast.makeText(this, "Record Successfully Inserted", 2000).show();
			}
			else
			{
				Toast.makeText(this, "Record Successfully Not Inserted", 2000).show();
				
				
			}

			
		}

	}

}
