package com.example.studentmanagment;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ViewQueryActivity extends Activity implements OnItemClickListener {
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
		setContentView(R.layout.activity_view_query);

		department = getIntent().getStringExtra("department");
		Toast.makeText(ViewQueryActivity.this, department, 2000).show();

		listView = (ListView) findViewById(R.id.listView1);
		listView.setOnItemClickListener(this);

		collegeId = new ArrayList<String>();
		subjectId = new ArrayList<String>();
		subjectName = new ArrayList<String>();
		semester = new ArrayList<String>();
		DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
		SQLiteDatabase db = dh.getReadableDatabase();
		Cursor c = db.rawQuery("select * from query where department=? ",
				new String[] { department });
		while (c.moveToNext()) {
			collegeId.add(c.getString(0));
			subjectId.add(c.getString(1));
			subjectName.add(c.getString(2));
			semester.add(c.getString(3));
		}
		CustomAdapter4 ad = new CustomAdapter4(this, R.layout.list_item,
				collegeId, subjectId, subjectName, semester);
		listView.setAdapter(ad);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_query, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		// selected item

		String selected = ((TextView) view.findViewById(R.id.collegeId))
				.getText().toString();
		String selected2 = ((TextView) view.findViewById(R.id.subjectId))
				.getText().toString();
		String selected3 = ((TextView) view.findViewById(R.id.semester))
				.getText().toString();



		Intent i=new Intent(ViewQueryActivity.this,ReplyActivity.class);
        i.putExtra("queryId", selected);
        i.putExtra("studentId", selected2);
        i.putExtra("description", selected3);
        
        startActivity(i);
		
	}

}
