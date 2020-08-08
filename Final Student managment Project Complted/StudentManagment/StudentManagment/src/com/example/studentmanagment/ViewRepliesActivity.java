package com.example.studentmanagment;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class ViewRepliesActivity extends Activity {
	String studentId;
	ListView listView;
	ArrayList<String> collegeId;
	ArrayList<String> subjectId;
	ArrayList<String> subjectName;
	ArrayList<String> semester;
	String department;
	SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_replies);
		session = new SessionManager(getApplicationContext());

		session.checkLogin();

		studentId = session.getUserDetails();
		Toast.makeText(ViewRepliesActivity.this, studentId, 2000).show();
		listView = (ListView) findViewById(R.id.listView1);

		collegeId = new ArrayList<String>();
		subjectId = new ArrayList<String>();
		subjectName = new ArrayList<String>();
		semester = new ArrayList<String>();
		DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db = dh.getReadableDatabase();
		Cursor c = db.rawQuery("select * from ans where studentId=? ",
				new String[] { studentId });
		while (c.moveToNext()) {

			/*
			 * Toast.makeText(ViewRepliesActivity.this, c.getString(0),
			 * 2000).show(); Toast.makeText(ViewRepliesActivity.this,
			 * c.getString(1), 2000).show();
			 * Toast.makeText(ViewRepliesActivity.this, c.getString(2),
			 * 2000).show(); Toast.makeText(ViewRepliesActivity.this,
			 * c.getString(3), 2000).show();
			 * Toast.makeText(ViewRepliesActivity.this, c.getString(4),
			 * 2000).show();
			 */
			collegeId.add(c.getString(0));
			subjectId.add(c.getString(1));
			subjectName.add(c.getString(4));
			semester.add(c.getString(2));

		}
		CustomAdapter5 ad = new CustomAdapter5(this, R.layout.list_item,
				collegeId, subjectId, subjectName, semester);
		listView.setAdapter(ad);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_replies, menu);
		return true;
	}

}
