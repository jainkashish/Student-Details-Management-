package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ReplyActivity extends Activity implements OnClickListener{
	String queryId,description,studentId;
	TextView t1;
	EditText t2;
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reply);
		queryId = getIntent().getStringExtra("queryId");
		studentId = getIntent().getStringExtra("studentId");
		description = getIntent().getStringExtra("description");
		
		
		
		t1=(TextView) findViewById(R.id.textView1);
		t2=(EditText) findViewById(R.id.editText1);
		b1=(Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reply, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		String reply=t2.getText().toString();	
		DataBaseHelper dh=new DataBaseHelper(getApplicationContext());
			SQLiteDatabase db=dh.getWritableDatabase();
			ContentValues cv=new ContentValues();
			cv.put("studentId",studentId);
			cv.put("queryId",queryId);
			cv.put("reply",reply);
			cv.put("description",description);
			Toast.makeText(ReplyActivity.this, queryId + "  " +studentId+ " " +description + " " + reply  , 2000  ).show();
			long check= db.insert("ans", null, cv);
			if (check>0)
			{
	
			Toast.makeText(this, "Record Successfully Inserted", 2000).show();
			}
			else
			{
				Toast.makeText(this, "Record Successfully Not Inserted", 2000).show();
				
				
			}

			
		

	}

}
