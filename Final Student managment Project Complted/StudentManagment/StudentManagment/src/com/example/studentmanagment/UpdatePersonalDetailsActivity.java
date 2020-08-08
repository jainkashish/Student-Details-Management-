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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdatePersonalDetailsActivity extends Activity implements
		OnClickListener {
	String branch, year, course, name, fname, mname, address, paddress,
			collegeId, dob, contact, fcontact, email;
	EditText t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15;
	ImageView iv1;
	Button b1, b2;
	String realPath = null,imagePath,b4Mail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_personal_details);
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
		iv1 = (ImageView) findViewById(R.id.imageView1);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);

		iv1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int reqcode = 1;
				Intent action = new Intent(Intent.ACTION_GET_CONTENT);
				action = action.setType("*/*").addCategory(
						Intent.CATEGORY_OPENABLE);
				startActivityForResult(action, reqcode);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_personal_details, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
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
				t8.setText(c.getString(11));
				t9.setText(c.getString(9));
				t10.setText(c.getString(10));
				t12.setText(c.getString(12));
				t13.setText(c.getString(0));
				t14.setText(c.getString(1));
				t15.setText(c.getString(2));
				imagePath=c.getString(13);
				BitmapFactory.Options bmOptions = new BitmapFactory.Options();
				Bitmap bitmap = BitmapFactory.decodeFile(c.getString(13),bmOptions);
				if(bitmap!=null)
				{
					bitmap = Bitmap.createBitmap(bitmap);
					iv1.setImageBitmap(bitmap);
				}
				else
				{
					//iv1.setBackgroundResource(R.drawable.file);
				}
			
			} else {
				Toast.makeText(this, "Record Not Present", 2000).show();
			}
						break;
		case R.id.button2:
			if(realPath==null){
				
			}
			else
			{
				imagePath=realPath;
			}
			
			DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
			SQLiteDatabase db = dh.getWritableDatabase();
			
			ContentValues cv1 = new ContentValues();
			cv1.put("branch", t13.getText().toString());
			cv1.put("year", t14.getText().toString());
			cv1.put("course", t15.getText().toString());
			cv1.put("name", t2.getText().toString());
			cv1.put("fname", t3.getText().toString());
			cv1.put("mname", t4.getText().toString());
			cv1.put("address",t5.getText().toString());
			cv1.put("paddress", t6.getText().toString());
			cv1.put("dob", t7.getText().toString());
			cv1.put("contact", t9.getText().toString());
			cv1.put("fcontact", t10.getText().toString());
			cv1.put("email", t8.getText().toString());
			cv1.put("password", t12.getText().toString());
			cv1.put("imagePath", imagePath);
			
			int ans=db.update("student", cv1, "collegeId=?", new String[]{t11.getText().toString()});
			if(ans==1)
			{

				Toast.makeText(this, "Record Updated", 2000).show();
			
				
			}
			else
			{
				

				Toast.makeText(this, "Record Not Updated", 2000).show();
			
			}
			


			

			break;

		default:
			break;
		}
	}
	@Override
	protected void onActivityResult(int reqCode, int resCode, Intent data) {
		if(resCode == Activity.RESULT_OK && data != null){
			// SDK < API11
			if (Build.VERSION.SDK_INT < 11)
				realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());

			// SDK >= 11 && SDK < 19
			else if (Build.VERSION.SDK_INT < 19)
				realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());

			// SDK > 19 (Android 4.4)
			else
				realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());

			Uri uriFromPath = Uri.fromFile(new File(realPath));

			//display selected image

			Bitmap bitmap = null;
			try {
				bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uriFromPath));
				if(bitmap!=null)
					iv1.setImageBitmap(bitmap);
				else{
					
				}
					//iv1.setBackgroundResource(R.drawable.file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
