package com.example.studentmanagment;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener, OnItemSelectedListener {
	EditText t1,t2;
	Button b1;
	Spinner s1;
	String selectedValue;
	private DataBaseHelper sql=null;
	// Session Manager Class
    SessionManager session;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		session = new SessionManager(getApplicationContext());            
		t1=(EditText) findViewById(R.id.editText1);
		t2=(EditText) findViewById(R.id.editText2);
		s1=(Spinner) findViewById(R.id.spinner1);
		b1=(Button)findViewById(R.id.button1);
		 s1.setOnItemSelectedListener(this);
	       
		b1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.admin:
			Intent i=new Intent(this,AdminLoginActivity.class);
			startActivity(i);
			break;
				default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			
			if(selectedValue.equals("Student")){
				DataBaseHelper dh=new DataBaseHelper(getApplicationContext());
				String email=t1.getText().toString();
				String password=t2.getText().toString();
				
				SQLiteDatabase db1=dh.getReadableDatabase();
				String q="select * from student where  collegeId=? and password=?";
				Cursor c=db1.rawQuery(q, new String[]{email,password});
				if(c.moveToFirst())
				{
					session.createLoginSession(email);
					Toast.makeText(this, "You Are Logged In",2000).show();
					Intent i=new Intent(this,StudentHomePageActivity.class);
					//i.putExtra("email", email);
					startActivity(i);
					
				}
						else
				{
					Toast.makeText(this, "Your enterted Wrong details",2000).show();
					
				}
				
			}
			else if (selectedValue.equals("Faculty")){
				DataBaseHelper dh=new DataBaseHelper(getApplicationContext());
				String email=t1.getText().toString();
				String password=t2.getText().toString();
				
				SQLiteDatabase db1=dh.getReadableDatabase();
				String q="select * from faculty where facultyId=? and password=?";
				Cursor c=db1.rawQuery(q, new String[]{email,password});
				if(c.moveToFirst())
				{
					Toast.makeText(this, "You Are Logged In",2000).show();
					Intent i=new Intent(this,FacultyHomePageActivity.class);
					session.createLoginSession(email);
					//i.putExtra("email", email);
					startActivity(i);
					
				}
						else
				{
					Toast.makeText(this, "Your enterted Wrong details",2000).show();
					
				}
				
			}
			else
			{
				Toast.makeText(LoginActivity.this, "Please Select Login Type", Toast.LENGTH_LONG).show();
			}
			
			
			
		
			
			
			break;

		default:
			break;
		}

		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		selectedValue=s1.getSelectedItem().toString();
			
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
