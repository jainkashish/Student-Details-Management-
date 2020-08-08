package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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

public class SearchStudentActivity extends Activity implements OnClickListener {
	EditText t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15;
	Button b1, b2;
	String collegeId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_student);
		t11 = (EditText) findViewById(R.id.editText11);

		t2 = (EditText) findViewById(R.id.editText2);
		t3 = (EditText) findViewById(R.id.editText3);
		t4 = (EditText) findViewById(R.id.editText4);
		t5 = (EditText) findViewById(R.id.editText5);
		t6 = (EditText) findViewById(R.id.editText6);
		t7 = (EditText) findViewById(R.id.editText7);
		t8 = (EditText) findViewById(R.id.editText8);
		t9 = (EditText) findViewById(R.id.editText9);
		t10 = (EditText) findViewById(R.id.editText10);
		t12 = (EditText) findViewById(R.id.editText12);

		t13 = (EditText) findViewById(R.id.editText13);
		t14 = (EditText) findViewById(R.id.editText14);
		t15 = (EditText) findViewById(R.id.editText15);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_student, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			switch (arg0.getId()) {
			case R.id.button1:
				String path;
				collegeId = t11.getText().toString();
				DataBaseHelper dh1 = new DataBaseHelper(getApplicationContext());
				SQLiteDatabase db1 = dh1.getReadableDatabase();
				String q = "select branch , year , course , name  , fname , mname , address , paddress , dob , contact ,  fcontact , email , password , imagePath from student where collegeId=?";

				Cursor c = db1.rawQuery(q, new String[] { collegeId });
				if (c.moveToFirst()) {

					t2.setText(c.getString(3));
					t3.setText(c.getString(4));
					t4.setText(c.getString(5));
					t5.setText(c.getString(6));
					t6.setText(c.getString(7));
					t7.setText(c.getString(8));
					t8.setText(c.getString(9));
					t9.setText(c.getString(10));
					t10.setText(c.getString(11));
					t12.setText(c.getString(12));
					t13.setText(c.getString(0));
					t14.setText(c.getString(1));
					t15.setText(c.getString(2));

				} else {
					Toast.makeText(this, "Record Not Present", 2000).show();
				}

				break;
			case R.id.button2:
				Intent i=new Intent(SearchStudentActivity.this,AdminHomeStudentActivity.class);
				startActivity(i);

				break;

			default:
				break;
			}

		}
	}
}
