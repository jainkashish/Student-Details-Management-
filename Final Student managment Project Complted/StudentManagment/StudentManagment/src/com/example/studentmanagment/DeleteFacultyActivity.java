package com.example.studentmanagment;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteFacultyActivity extends Activity implements OnClickListener {
	EditText t1;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete_faculty);
		t1=(EditText)findViewById(R.id.editText1);
		b1=(Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete_faculty, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		DataBaseHelper dh1=new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db1=dh1.getWritableDatabase();
		String id= t1.getText().toString();
		int ans=db1.delete("faculty", "facultyId=?", new String[]{id});
		if(ans==1)
		{
			Toast.makeText(this, "Record Deleted", 2000).show();
		}
		else
		{
			Toast.makeText(this, "Record Not Present", 2000).show();
			
		}
		

	}

}
