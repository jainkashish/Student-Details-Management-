package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertAcadmicDetailsActivity extends Activity implements OnClickListener {
	String branch, year, course,name,fname,mname,address,paddress,collegeId,dob,contact,fcontact,email,imagePath;
	String tena,tenb,tenc,tend;
	String twa,twb,twc,twd;
	String sem1a,sem1b,sem1c,sem1d;
	String sem2a,sem2b,sem2c,sem2d;
	String sem3a,sem3b,sem3c,sem3d;
	String sem4a,sem4b,sem4c,sem4d;
	String sem5a,sem5b,sem5c,sem5d;
	String sem6a,sem6b,sem6c,sem6d;
	String sem7a,sem7b,sem7c,sem7d;
	String sem8a,sem8b,sem8c,sem8d;
	String password;
	Button b1;
	EditText t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_acadmic_details);
		Intent i = getIntent();
		branch = i.getStringExtra("branch");
		year = i.getStringExtra("year");
		course = i.getStringExtra("course");
		name= i.getStringExtra("name");
		fname= i.getStringExtra("fname");
		mname= i.getStringExtra("mname");
		address= i.getStringExtra("address");
		paddress= i.getStringExtra("paddress");
		collegeId= i.getStringExtra("collegeId");
		dob= i.getStringExtra("dob");
		contact= i.getStringExtra("contact");
		fcontact= i.getStringExtra("fcontact");
		email= i.getStringExtra("email");
		imagePath= i.getStringExtra("imagePath");
		/*
		Toast.makeText(this, branch, Toast.LENGTH_LONG).show();
		Toast.makeText(this, year, Toast.LENGTH_LONG).show();
		Toast.makeText(this, course, Toast.LENGTH_LONG).show();
		Toast.makeText(this, name, Toast.LENGTH_LONG).show();
		Toast.makeText(this, fname, Toast.LENGTH_LONG).show();
		Toast.makeText(this, mname, Toast.LENGTH_LONG).show();
		Toast.makeText(this, address, Toast.LENGTH_LONG).show();
		Toast.makeText(this, paddress, Toast.LENGTH_LONG).show();
		Toast.makeText(this, collegeId, Toast.LENGTH_LONG).show();
		Toast.makeText(this, dob, Toast.LENGTH_LONG).show();
		Toast.makeText(this, contact, Toast.LENGTH_LONG).show();
		Toast.makeText(this, fcontact, Toast.LENGTH_LONG).show();
		Toast.makeText(this, email, Toast.LENGTH_LONG).show();
		Toast.makeText(this, imagePath, Toast.LENGTH_LONG).show();
		*/
		t1 = (EditText) findViewById(R.id.editText1);
		t2 = (EditText) findViewById(R.id.editText2);
		t3 = (EditText) findViewById(R.id.editText3);
		t4 = (EditText) findViewById(R.id.editText4);
		t5 = (EditText) findViewById(R.id.editText5);
		t6 = (EditText) findViewById(R.id.editText6);
		t7 = (EditText) findViewById(R.id.editText7);
		t8 = (EditText) findViewById(R.id.editText8);
		t9 = (EditText) findViewById(R.id.editText9);
		t10 = (EditText) findViewById(R.id.editText10);
		
		t11 = (EditText) findViewById(R.id.editText11);
		t12 = (EditText) findViewById(R.id.editText12);
		t13 = (EditText) findViewById(R.id.editText13);
		t14 = (EditText) findViewById(R.id.editText14);
		t15 = (EditText) findViewById(R.id.editText15);
		t16 = (EditText) findViewById(R.id.editText16);
		t17 = (EditText) findViewById(R.id.editText17);
		t18 = (EditText) findViewById(R.id.editText18);
		t19 = (EditText) findViewById(R.id.editText19);
		t20 = (EditText) findViewById(R.id.editText20);
		
		t21 = (EditText) findViewById(R.id.editText21);
		t22 = (EditText) findViewById(R.id.editText22);
		t23 = (EditText) findViewById(R.id.editText23);
		t24 = (EditText) findViewById(R.id.editText24);
		t25 = (EditText) findViewById(R.id.editText25);
		t26 = (EditText) findViewById(R.id.editText26);
		t27 = (EditText) findViewById(R.id.editText27);
		t28 = (EditText) findViewById(R.id.editText28);
		t29 = (EditText) findViewById(R.id.editText29);
		t30 = (EditText) findViewById(R.id.editText30);
		
		t31 = (EditText) findViewById(R.id.editText31);
		t32 = (EditText) findViewById(R.id.editText32);
		t33 = (EditText) findViewById(R.id.editText33);
		t34 = (EditText) findViewById(R.id.editText34);
		t35 = (EditText) findViewById(R.id.editText35);
		t36 = (EditText) findViewById(R.id.editText36);
		t37 = (EditText) findViewById(R.id.editText37);
		t38 = (EditText) findViewById(R.id.editText38);
		t39 = (EditText) findViewById(R.id.editText39);
		t40 = (EditText) findViewById(R.id.editText40);
		t41 = (EditText) findViewById(R.id.editText41);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert_acadmic_details, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db = dh.getWritableDatabase();
		
		ContentValues cv1 = new ContentValues();
		cv1.put("branch", branch);
		cv1.put("year", year);
		cv1.put("course", course);
		cv1.put("name", name);
		cv1.put("fname", fname);
		cv1.put("mname", mname);
		cv1.put("address", address);
		cv1.put("paddress", paddress);
		cv1.put("collegeId", collegeId);
		cv1.put("dob", dob);
		cv1.put("contact", contact);
		cv1.put("fcontact", fcontact);
		cv1.put("email", email);
		cv1.put("password", t41.getText().toString());
		cv1.put("imagePath", imagePath);
		
		long check1 = db.insert("student", null, cv1);


		String qualification = t1.getText().toString();
		String year = t2.getText().toString();
		String percentage = t3.getText().toString();
		String board = t4.getText().toString();

		ContentValues cv2 = new ContentValues();
		cv2.put("qualification", qualification);
		cv2.put("year", year);
		cv2.put("percentage", percentage);
		cv2.put("board", board);
		cv2.put("collegeId", collegeId);

		long check2 = db.insert("ten1", null, cv2);
		

		String qualification2 = t5.getText().toString();
		String year2 = t6.getText().toString();
		String percentage2 = t7.getText().toString();
		String board2 = t8.getText().toString();

		ContentValues cv3 = new ContentValues();
		cv3.put("qualification", qualification2);
		cv3.put("year", year2);
		cv3.put("percentage", percentage2);
		cv3.put("board", board2);
		cv3.put("collegeId",collegeId);

		long check3 = db.insert("twelf1", null, cv3);
		
		
		String qualification3 = t9.getText().toString();
		String year3 = t10.getText().toString();
		String percentage3 = t11.getText().toString();
		String board3 = t12.getText().toString();
		ContentValues cv4 = new ContentValues();
		cv4.put("qualification", qualification3);
		cv4.put("year", year3);
		cv4.put("percentage", percentage3);
		cv4.put("board", board3);
		cv4.put("collegeId", collegeId);
		long check4 = db.insert("sem11", null, cv4);
		
		
		String qualification4 = t13.getText().toString();
		String year4 = t14.getText().toString();
		String percentage4 = t15.getText().toString();
		String board4 = t16.getText().toString();
		ContentValues cv5 = new ContentValues();
		cv5.put("qualification", qualification4);
		cv5.put("year", year4);
		cv5.put("percentage", percentage4);
		cv5.put("board", board4);
		cv5.put("collegeId", collegeId);
		long check5 = db.insert("sem21", null, cv5);


		String qualification5 = t17.getText().toString();
		String year5 = t18.getText().toString();
		String percentage5 = t19.getText().toString();
		String board5 = t20.getText().toString();
		ContentValues cv6 = new ContentValues();
		cv6.put("qualification", qualification5);
		cv6.put("year", year5);
		cv6.put("percentage", percentage5);
		cv6.put("board", board5);
		cv6.put("collegeId", collegeId);
		long check6 = db.insert("sem31", null, cv6);

		String qualification6 = t21.getText().toString();
		String year6 = t22.getText().toString();
		String percentage6 = t23.getText().toString();
		String board6 = t24.getText().toString();
		ContentValues cv7 = new ContentValues();
		cv7.put("qualification", qualification6);
		cv7.put("year", year6);
		cv7.put("percentage", percentage6);
		cv7.put("board", board6);
		cv7.put("collegeId", collegeId);
		long check7 = db.insert("sem41", null, cv7);

		String qualification7 = t25.getText().toString();
		String year7 = t26.getText().toString();
		String percentage7 = t27.getText().toString();
		String board7 = t28.getText().toString();
		ContentValues cv8 = new ContentValues();
		cv8.put("qualification", qualification7);
		cv8.put("year", year7);
		cv8.put("percentage", percentage7);
		cv8.put("board", board7);
		cv8.put("collegeId", collegeId);
		long check8 = db.insert("sem51", null, cv8);

		String qualification8 = t29.getText().toString();
		String year8 = t30.getText().toString();
		String percentage8 = t31.getText().toString();
		String board8 = t32.getText().toString();
		ContentValues cv9 = new ContentValues();
		cv9.put("qualification", qualification8);
		cv9.put("year", year8);
		cv9.put("percentage", percentage8);
		cv9.put("board", board8);
		cv9.put("collegeId", collegeId);
		long check9 = db.insert("sem61", null, cv9);
		
		String qualification9 = t33.getText().toString();
		String year9 = t34.getText().toString();
		String percentage9 = t35.getText().toString();
		String board9 = t36.getText().toString();
		ContentValues cv10 = new ContentValues();
		cv10.put("qualification", qualification9);
		cv10.put("year", year9);
		cv10.put("percentage", percentage9);
		cv10.put("board", board9);
		cv10.put("collegeId", collegeId);
		long check10 = db.insert("sem71", null, cv10);

		String qualification10 = t37.getText().toString();
		String year10 = t38.getText().toString();
		String percentage10 = t39.getText().toString();
		String board10 = t40.getText().toString();
		ContentValues cv11 = new ContentValues();
		cv11.put("qualification", qualification10);
		cv11.put("year", year10);
		cv11.put("percentage", percentage10);
		cv11.put("board", board10);
		cv11.put("collegeId", collegeId);
		long check11 = db.insert("sem81", null, cv11);


		if (check1 > 0 && check2 > 0 && check3 > 0 && check4 > 0 && check5 > 0 && check6 > 0 && check7 > 0 && check8 > 0 && check9 > 0 && check10 > 0 && check11 > 0) {

			Toast.makeText(this, "Record Successfully Inserted", 2000)
					.show();
			Intent i=new Intent(InsertAcadmicDetailsActivity.this,AdminHomePageActivity.class);
			startActivity(i);
		} else {
			Toast.makeText(this, "Record Successfully Not Inserted", 2000)
					.show();

		}

		
	}

}
