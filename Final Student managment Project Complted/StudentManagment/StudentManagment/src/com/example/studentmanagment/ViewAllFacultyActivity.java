package com.example.studentmanagment;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ListView;

public class ViewAllFacultyActivity extends Activity {
	ListView listView;
	ArrayList<String> collegeId;
	ArrayList<String> subjectId;
	ArrayList<String> subjectName;
	ArrayList<String> semester;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_all_faculty);
		listView = (ListView) findViewById(R.id.listView1);
		collegeId = new ArrayList<String>();
		subjectId= new ArrayList<String>();
		subjectName = new ArrayList<String>();
		semester = new ArrayList<String>();
		DataBaseHelper dh=new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db = dh.getReadableDatabase();
		String st = "select * from faculty";
		Cursor c = db.rawQuery(st, null);
		while (c.moveToNext()) {
			collegeId.add(c.getString(0));
			subjectId.add(c.getString(1));
			subjectName.add(c.getString(2));
			semester.add(c.getString(5));
		}
		CustomAdapter3 ad = new CustomAdapter3(this, R.layout.list_item,collegeId,
				subjectId,subjectName,semester);
		listView.setAdapter(ad);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_all_back, menu);
		return true;
	}

}
