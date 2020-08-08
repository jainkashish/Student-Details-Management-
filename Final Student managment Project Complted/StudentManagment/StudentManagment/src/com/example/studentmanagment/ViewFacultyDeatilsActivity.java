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
import android.widget.EditText;
import android.widget.Toast;

public class ViewFacultyDeatilsActivity extends Activity implements
		OnClickListener {
	EditText t1, t2, t3, t4, t5, t6;
	Button b1;
	String email;
	SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_faculty_deatils);
		  session = new SessionManager(getApplicationContext());
	        
	        session.checkLogin();
	        
			email = session.getUserDetails();

		//email = getIntent().getStringExtra("email");
		Toast.makeText(ViewFacultyDeatilsActivity.this, email, 2000).show();
		t1 = (EditText) findViewById(R.id.editText1);
		t2 = (EditText) findViewById(R.id.editText2);
		t3 = (EditText) findViewById(R.id.editText3);
		t4 = (EditText) findViewById(R.id.editText4);
		t5 = (EditText) findViewById(R.id.editText5);
		t6 = (EditText) findViewById(R.id.editText6);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		DataBaseHelper dh1 = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db1 = dh1.getReadableDatabase();
		String q = "select  *  from faculty where facultyId=?";

		Cursor c = db1.rawQuery(q, new String[] { email });
		if (c.moveToFirst()) {

			t1.setText("Id : "+c.getString(0));

			t2.setText("Name : "+c.getString(1));
			t3.setText("Department : "+c.getString(2));
			t4.setText("Contact : "+c.getString(3));
			t5.setText("Email : "+c.getString(4));
			t6.setText("Password : "+c.getString(5));

		} else {
			Toast.makeText(this, "Record Not Present", 2000).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_faculty_deatils, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i = new Intent(ViewFacultyDeatilsActivity.this,
				FacultyHomePageActivity.class);
		startActivity(i);

	}

}
