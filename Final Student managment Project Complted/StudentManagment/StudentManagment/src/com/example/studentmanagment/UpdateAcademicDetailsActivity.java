package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateAcademicDetailsActivity extends Activity implements
		OnClickListener {
	Button b1, b2;
	EditText t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15,
			t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28,
			t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39, t40, t41;
	String collegeId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_academic_details);
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
		b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_academic_details, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button2:
			collegeId = t41.getText().toString();
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









			
			
			

			break;
		case R.id.button1:
			DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
			SQLiteDatabase db = dh.getWritableDatabase();
		
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

			long check2 = db.update("ten1", cv2, "collegeId=?", new String[]{collegeId});
			

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

			long check3 = db.update("twelf1", cv3, "collegeId=?", new String[]{collegeId});
			
			
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
			long check4 = db.update("sem11", cv4, "collegeId=?", new String[]{collegeId});
			
			
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
			long check5 = db.update("sem21", cv5, "collegeId=?", new String[]{collegeId});


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
			long check6 = db.update("sem31", cv6, "collegeId=?", new String[]{collegeId});

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
			long check7 = db.update("sem41", cv7, "collegeId=?", new String[]{collegeId});

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
			long check8 =db.update("sem51", cv8, "collegeId=?", new String[]{collegeId});

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
			long check9 = db.update("sem61", cv9, "collegeId=?", new String[]{collegeId});
			
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
			long check10 = db.update("sem71", cv10, "collegeId=?", new String[]{collegeId});

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
			long check11 = db.update("sem81", cv11, "collegeId=?", new String[]{collegeId});


			if (  check2 > 0 && check3 > 0 && check4 > 0 && check5 > 0 && check6 > 0 && check7 > 0 && check8 > 0 && check9 > 0 && check10 > 0 && check11 > 0) {

				Toast.makeText(this, "Record  Successfully Updated", 2000)
						.show();
				Intent i=new Intent(UpdateAcademicDetailsActivity.this,AdminHomePageActivity.class);
				startActivity(i);
			} else {
				Toast.makeText(this, "Record Successfully Not Updated", 2000)
						.show();

			}


			break;

		default:
			break;
		}

	}

}
