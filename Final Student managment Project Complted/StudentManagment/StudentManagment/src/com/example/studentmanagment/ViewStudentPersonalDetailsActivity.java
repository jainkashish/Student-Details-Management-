package com.example.studentmanagment;

import java.io.File;
import java.io.FileNotFoundException;


import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewStudentPersonalDetailsActivity extends Activity implements
		OnClickListener {
	String branch, year, course, name, fname, mname, address, paddress,
			collegeId, dob, contact, fcontact, email;
	TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15,
			t16;
	ImageView iv1;
	Button b1;
	String realPath = null, imagePath;
	SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_student_personal_details);
		session = new SessionManager(getApplicationContext());

		session.checkLogin();

		email = session.getUserDetails();

		//email = getIntent().getStringExtra("email");
		Toast.makeText(ViewStudentPersonalDetailsActivity.this, email, 2000)
				.show();

		t2 = (TextView) findViewById(R.id.TextView2);
		t3 = (TextView) findViewById(R.id.TextView3);
		t4 = (TextView) findViewById(R.id.TextView4);
		t5 = (TextView) findViewById(R.id.TextView5);
		t6 = (TextView) findViewById(R.id.TextView6);
		t7 = (TextView) findViewById(R.id.TextView7);
		t8 = (TextView) findViewById(R.id.TextView8);
		t9 = (TextView) findViewById(R.id.TextView9);
		t10 = (TextView) findViewById(R.id.TextView10);
		t12 = (TextView) findViewById(R.id.TextView12);

		t13 = (TextView) findViewById(R.id.TextView13);
		t14 = (TextView) findViewById(R.id.TextView14);
		t15 = (TextView) findViewById(R.id.TextView15);
		t16 = (TextView) findViewById(R.id.TextView16);
		b1 = (Button) findViewById(R.id.button1);
		iv1 = (ImageView) findViewById(R.id.imageView1);
		b1.setOnClickListener(this);
		DataBaseHelper dh1 = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db1 = dh1.getReadableDatabase();
		String q = "select branch , year , course , name  , fname , mname , address , paddress , dob , contact ,  fcontact , email , password , imagePath ,collegeId from student where collegeId=?";

		Cursor c = db1.rawQuery(q, new String[] { email });
		if (c.moveToFirst()) {

			t2.setText("Name : " + c.getString(3));
			t3.setText("Father's Name : " + c.getString(4));
			t4.setText("Mother's Name : " + c.getString(5));
			t5.setText("Address : " + c.getString(6));
			t6.setText("Permanent Address : " + c.getString(7));
			t7.setText("DOB : " + c.getString(8));
			t8.setText("Email : " + c.getString(11));
			t9.setText("Contact : " + c.getString(9));
			t10.setText("Father's : " + c.getString(10));
			t12.setText("Password : " + c.getString(12));
			t13.setText("Department :" + c.getString(0));
			t14.setText("Year : " + c.getString(1));
			t15.setText("Course : " + c.getString(2));
			t16.setText("College Id : " + c.getString(14));
			imagePath = c.getString(13);
			BitmapFactory.Options bmOptions = new BitmapFactory.Options();
			Bitmap bitmap = BitmapFactory
					.decodeFile(c.getString(13), bmOptions);
			if (bitmap != null) {
				bitmap = Bitmap.createBitmap(bitmap);
				iv1.setImageBitmap(bitmap);
			} else {
				iv1.setBackgroundResource(R.drawable.file);
			}

		} else {
			Toast.makeText(this, "Record  Not Present", 2000).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_student_personal_details, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i = new Intent(ViewStudentPersonalDetailsActivity.this,
				StudentHomePageActivity.class);
		startActivity(i);
	}

}
