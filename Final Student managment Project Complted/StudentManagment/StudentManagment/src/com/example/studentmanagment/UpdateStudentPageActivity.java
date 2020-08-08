package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UpdateStudentPageActivity extends Activity implements OnClickListener {
	Button b1,b2,b3,b4;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_student_page);
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
		getMenuInflater().inflate(R.menu.update_student_page, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			Intent i=new Intent(UpdateStudentPageActivity.this,UpdateAcademicDetailsActivity.class);
			startActivity(i);
			break;
		case R.id.button2:
			Intent i2=new Intent(UpdateStudentPageActivity.this,DeleteBackActivity.class);
			startActivity(i2);
			break;
			
		case R.id.button3:
			Intent i3=new Intent(UpdateStudentPageActivity.this,UpdatePersonalDetailsActivity.class);
			startActivity(i3);
			break;
		case R.id.button4:
			Intent i4=new Intent(UpdateStudentPageActivity.this,AdminHomeStudentActivity.class);
			startActivity(i4);
		
			break;

		default:
			break;
		}

		
	}

}
