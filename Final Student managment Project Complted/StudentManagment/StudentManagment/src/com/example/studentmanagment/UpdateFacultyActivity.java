package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdateFacultyActivity extends Activity implements OnClickListener {
	String branch, year, course, name, fname, mname, address, paddress,
			collegeId, dob, contact, fcontact, email;
	EditText t1, t2, t3, t4, t5, t6;
	Button b1, b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_faculty);

		t1 = (EditText) findViewById(R.id.editText1);
		t2 = (EditText) findViewById(R.id.editText2);
		t3 = (EditText) findViewById(R.id.editText3);
		t4 = (EditText) findViewById(R.id.editText4);
		t5 = (EditText) findViewById(R.id.editText5);
		t6 = (EditText) findViewById(R.id.editText6);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_faculty, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			String path;
			collegeId = t1.getText().toString();
			DataBaseHelper dh1 = new DataBaseHelper(getApplicationContext());
			SQLiteDatabase db1 = dh1.getReadableDatabase();
			String q = "select  *  from faculty where facultyId=?";

			Cursor c = db1.rawQuery(q, new String[] { collegeId });
			if (c.moveToFirst()) {

				t2.setText(c.getString(1));
				t3.setText(c.getString(2));
				t4.setText(c.getString(3));
				t5.setText(c.getString(4));
				t6.setText(c.getString(5));

			} else {
				Toast.makeText(this, "Record Not Present", 2000).show();
			}
			break;
		case R.id.button2:

			DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
			SQLiteDatabase db = dh.getWritableDatabase();

			ContentValues cv1 = new ContentValues();
			cv1.put("name", t2.getText().toString());
			cv1.put("department", t3.getText().toString());

			cv1.put("contact", t4.getText().toString());
			cv1.put("email", t5.getText().toString());
			cv1.put("password", t6.getText().toString());

			int ans = db.update("faculty", cv1, "facultyId=?",
					new String[] { t1.getText().toString() });
			if (ans == 1) {

				Toast.makeText(this, "Record Updated", 2000).show();

			} else {

				Toast.makeText(this, "Record Not Updated", 2000).show();

			}

			break;

		default:
			break;
		}
	}

}
