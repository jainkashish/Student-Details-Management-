package com.example.studentmanagment;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends Activity implements OnClickListener {
	EditText t1,t2;
	Button b1;
	private DataBaseHelper sql=null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_login);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(this);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_login, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		sql= new DataBaseHelper(getApplicationContext());
		if(t1.getText().toString().equals("")){
			t1.setError("Please Enter username");
		}else if(t2.getText().toString().equals("")){
			t2.setError("Please  Enter password");
		}
		else if(sql.getAdminPassword(t1.getText().toString(),t2.getText().toString()))
		{
		Toast.makeText(getApplicationContext(), "your are Logged in", 2000).show();
		Intent i1=new Intent(this,AdminHomePageActivity.class);
		startActivity(i1);
		}
		else {
			Toast.makeText(getApplicationContext(), "Incorrect details", 2000).show();
		}

		
	}

}
