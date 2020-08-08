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
import android.widget.ImageView;
import android.widget.Toast;

public class InsertBackActivity extends Activity implements OnClickListener {
	EditText t1, t2, t3, t4;
	Button b1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_back);
		t1 = (EditText) findViewById(R.id.editText1);
		t2 = (EditText) findViewById(R.id.editText2);
		t3 = (EditText) findViewById(R.id.editText3);
		t4 = (EditText) findViewById(R.id.editText4);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert_back, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db = dh.getWritableDatabase();
		ContentValues cv2 = new ContentValues();
		cv2.put("collegeId", t1.getText().toString());
		cv2.put("subjectId", t2.getText().toString());
		cv2.put("subjectName", t3.getText().toString());
		cv2.put("semester", t4.getText().toString());
		

		long check2 = db.insert("back", null, cv2);
		if ( check2 > 0) {

			Toast.makeText(this, "Record Successfully Inserted", 2000)
					.show();
			Intent i=new Intent(InsertBackActivity.this,AdminHomePageActivity.class);
			startActivity(i);
		} else {
			Toast.makeText(this, "Record Successfully Not Inserted", 2000)
					.show();

		}


		
	}

}
