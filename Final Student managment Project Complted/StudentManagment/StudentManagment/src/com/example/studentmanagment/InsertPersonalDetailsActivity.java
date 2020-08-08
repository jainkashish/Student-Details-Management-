package com.example.studentmanagment;

import java.io.File;
import java.io.FileNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class InsertPersonalDetailsActivity extends Activity implements
		OnClickListener {
	String branch, year, course,name,fname,mname,address,paddress,collegeId,dob,contact,fcontact,email;
	EditText t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
	ImageView iv1;
	Button b1;
	String realPath="";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_personal_details);
		Intent i = getIntent();
		branch = i.getStringExtra("branch");
		year = i.getStringExtra("year");
		course = i.getStringExtra("course");
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
		b1 = (Button) findViewById(R.id.editText11);
		iv1 = (ImageView) findViewById(R.id.imageView1);
		b1.setOnClickListener(this);
		iv1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int reqcode = 1;
				Intent action = new Intent(Intent.ACTION_GET_CONTENT);
				action = action.setType("*/*").addCategory(Intent.CATEGORY_OPENABLE);
				startActivityForResult(action, reqcode);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert_personal_details, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.editText11:
			collegeId=t1.getText().toString();
			name=t2.getText().toString();
			fname=t3.getText().toString();
			mname=t4.getText().toString();
			address=t5.getText().toString();
			paddress=t6.getText().toString();
			dob=t7.getText().toString();
			contact=t9.getText().toString();
			email=t8.getText().toString();
			fcontact=t10.getText().toString();
			Intent i=new Intent(InsertPersonalDetailsActivity.this,InsertAcadmicDetailsActivity.class);
			i.putExtra("imagePath", realPath);
			i.putExtra("collegeId", collegeId);
			i.putExtra("name", name);
			i.putExtra("fname", fname);
			i.putExtra("mname", mname);
			i.putExtra("address", address);
			i.putExtra("paddress", paddress);
			i.putExtra("dob", dob);
			i.putExtra("contact", contact);
			i.putExtra("fcontact", fcontact);
			i.putExtra("email", email);
			i.putExtra("branch", branch);
			i.putExtra("year",year);
			i.putExtra("course",course);
			 
			
			startActivity(i);

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
				else
					iv1.setBackgroundResource(R.drawable.file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
