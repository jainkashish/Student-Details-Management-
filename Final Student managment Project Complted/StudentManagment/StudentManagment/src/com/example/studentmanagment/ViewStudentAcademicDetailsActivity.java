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

public class ViewStudentAcademicDetailsActivity extends Activity implements
		OnClickListener {
	Button b1;
	EditText t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15,
			t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28,
			t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39, t40, t41;
	String collegeId;
	SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_student_academic_details);
		session = new SessionManager(getApplicationContext());

		session.checkLogin();

		collegeId = session.getUserDetails();

		//collegeId = getIntent().getStringExtra("email");
		Toast.makeText(ViewStudentAcademicDetailsActivity.this, collegeId, 2000)
				.show();
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
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
		DataBaseHelper dh1 = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db1 = dh1.getReadableDatabase();
		String q = "select qualification  , year , percentage, board from ten1 where collegeId=?";

		Cursor c = db1.rawQuery(q, new String[] { collegeId });
		if (c.moveToFirst()) {

			t1.setText(c.getString(0));
			t2.setText(c.getString(1));
			t3.setText(c.getString(2));
			t4.setText(c.getString(3));
		}
		
		
		String q2 = "select qualification  , year , percentage, board from twelf1 where collegeId=?";

		Cursor c2 = db1.rawQuery(q2, new String[] { collegeId });
		if (c2.moveToFirst()) {

			t5.setText(c2.getString(0));
			t6.setText(c2.getString(1));
			t7.setText(c2.getString(2));
			t8.setText(c2.getString(3));
		}
		
		String q3 = "select qualification  , year , percentage, board from sem11 where collegeId=?";

		Cursor c3 = db1.rawQuery(q3, new String[] { collegeId });
		if (c3.moveToFirst()) {

			t9.setText(c3.getString(0));
			t10.setText(c3.getString(1));
			t11.setText(c3.getString(2));
			t12.setText(c3.getString(3));
		}
		
		String q4 = "select qualification  , year , percentage, board from sem21 where collegeId=?";

		Cursor c4 = db1.rawQuery(q4, new String[] { collegeId });
		if (c4.moveToFirst()) {

			t13.setText(c4.getString(0));
			t14.setText(c4.getString(1));
			t15.setText(c4.getString(2));
			t16.setText(c4.getString(3));
		}
		
		String q5 = "select qualification  , year , percentage, board from sem31 where collegeId=?";

		Cursor c5 = db1.rawQuery(q5, new String[] { collegeId });
		if (c5.moveToFirst()) {

			t17.setText(c5.getString(0));
			t18.setText(c5.getString(1));
			t19.setText(c5.getString(2));
			t20.setText(c5.getString(3));
		}
		
		String q6 = "select qualification  , year , percentage, board from sem41 where collegeId=?";

		Cursor c6 = db1.rawQuery(q6, new String[] { collegeId });
		if (c6.moveToFirst()) {

			t21.setText(c6.getString(0));
			t22.setText(c6.getString(1));
			t23.setText(c6.getString(2));
			t24.setText(c6.getString(3));
		}
		
		
		String q7 = "select qualification  , year , percentage, board from sem51 where collegeId=?";

		Cursor c7 = db1.rawQuery(q7, new String[] { collegeId });
		if (c7.moveToFirst()) {

			t25.setText(c7.getString(0));
			t26.setText(c7.getString(1));
			t27.setText(c7.getString(2));
			t28.setText(c7.getString(3));
		}
		
		String q8 = "select qualification  , year , percentage, board from sem61 where collegeId=?";

		Cursor c8 = db1.rawQuery(q8, new String[] { collegeId });
		if (c8.moveToFirst()) {

			t29.setText(c8.getString(0));
			t30.setText(c8.getString(1));
			t31.setText(c8.getString(2));
			t32.setText(c8.getString(3));
		}
		
		
		String q9 = "select qualification  , year , percentage, board from sem71 where collegeId=?";

		Cursor c9 = db1.rawQuery(q9, new String[] { collegeId });
		if (c9.moveToFirst()) {

			t33.setText(c9.getString(0));
			t34.setText(c9.getString(1));
			t35.setText(c9.getString(2));
			t36.setText(c9.getString(3));
		}
		
		String q10 = "select qualification  , year , percentage, board from sem81 where collegeId=?";

		Cursor c10 = db1.rawQuery(q10, new String[] { collegeId });
		if (c10.moveToFirst()) {

			t37.setText(c10.getString(0));
			t38.setText(c10.getString(1));
			t39.setText(c10.getString(2));
			t40.setText(c10.getString(3));
		
		}





	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_student_academic_details, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent(ViewStudentAcademicDetailsActivity.this,StudentHomePageActivity.class);
		startActivity(i);
		
		
	}

}
