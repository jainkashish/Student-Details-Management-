package com.example.studentmanagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

	// public static final String DATABASE_NAME = "studentmanagement.db";
	public static final String DATABASE_NAME = "studentmanagementnew.db";

	public static final String TABLE_Student = "student";
	public final static String tbl_name1 = "ten1";
	public final static String tbl_name2 = "twelf1";
	public final static String tbl_name3 = "sem11";
	public final static String tbl_name4 = "sem21";
	public final static String tbl_name5 = "sem31";
	public final static String tbl_name6 = "sem41";
	public final static String tbl_name7 = "sem51";
	public final static String tbl_name8 = "sem61";
	public final static String tbl_name9 = "sem71";
	public final static String tbl_name10 = "sem81";
	public final static String TABLE_BACK = "back";
	public final static String TABLE_FACULTY = "faculty";
	public final static String TABLE_Query = "query";
	public final static String TABLE_ANS = "ans";
	private static final String TABLE_ADMIN = "admin";

	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 13);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table "
				+ TABLE_ADMIN
				+ " (id integer primary key AUTOINCREMENT NOT NULL, username text, password text)");
		db.execSQL("create table "
				+ TABLE_Student
				+ " (branch text, year text, course text, name text , fname text, mname text, address text, paddress text, collegeId text primary key, dob text, contact text,  fcontact text, email text, password text, imagePath text)");

		String q1 = "create table "
				+ tbl_name1
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";
		String q2 = "create table "
				+ tbl_name2
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";

		db.execSQL(q1);
		db.execSQL(q2);

		String q3 = "create table "
				+ tbl_name3
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";
		String q4 = "create table "
				+ tbl_name4
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";

		db.execSQL(q3);
		db.execSQL(q4);

		String q5 = "create table "
				+ tbl_name5
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";
		String q6 = "create table "
				+ tbl_name6
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";

		db.execSQL(q5);
		db.execSQL(q6);

		String q7 = "create table "
				+ tbl_name7
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";
		String q8 = "create table "
				+ tbl_name8
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";

		db.execSQL(q7);
		db.execSQL(q8);

		String q9 = "create table "
				+ tbl_name9
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";
		String q10 = "create table "
				+ tbl_name10
				+ " (cid text primary key ,qualification text ,year text, percentage text,board text , collegeId text )";

		db.execSQL(q9);
		db.execSQL(q10);
		db.execSQL("create table "
				+ TABLE_BACK
				+ " (id integer primary key AUTOINCREMENT NOT NULL, collegeId text, subjectId text, subjectName text, semester text)");

		db.execSQL("create table "
				+ TABLE_FACULTY
				+ " (facultyId text primary key , name text, department text, contact text, email text, password text)");
		db.execSQL("create table "
				+ TABLE_Query
				+ " (queryId integer primary key AUTOINCREMENT NOT NULL , studentId text, department text, description text)");
		db.execSQL("create table "
				+ TABLE_ANS
				+ " (answerId integer primary key AUTOINCREMENT NOT NULL , queryId text, reply text , studentId text , description text)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public boolean insertAdmin() {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put("username", "admin");
		values.put("password", "password");

		Cursor cursor = db.rawQuery("select * from " + TABLE_ADMIN, null);
		if (cursor != null)
			cursor.moveToFirst();
		if (!cursor.moveToFirst()) {
			db.insert(TABLE_ADMIN, null, values);
		}
		return true;
	}

	public Boolean getAdminPassword(String username, String password) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(
				"select * from admin where username=? and password=?",
				new String[] { username, password });
		if (c.moveToFirst()) {
			return true;
		} else {
			return false;
		}

	}

}
