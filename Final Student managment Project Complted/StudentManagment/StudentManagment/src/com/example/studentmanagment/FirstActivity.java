package com.example.studentmanagment;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends Activity {
	private TextView mTv1,mTv2,mTv3;
	private Animation mAnim1,mAnim2,mAnim3;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		mTv1 = (TextView) findViewById(R.id.textView1);
		mTv2 = (TextView) findViewById(R.id.textView2);
		mTv3 = (TextView) findViewById(R.id.textView3);
		DataBaseHelper sql=new DataBaseHelper(getApplicationContext());
		sql.insertAdmin();

		mAnim1 = AnimationUtils.loadAnimation(this, R.anim.view_animation);
		mAnim2 = AnimationUtils.loadAnimation(this, R.anim.view_animation2);
		mAnim3 = AnimationUtils.loadAnimation(this, R.anim.view_animation3);


		Thread t = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					sleep(9000);
					Intent i = new Intent(getApplicationContext(),
							LoginActivity.class);
					startActivity(i);
					finish();

				} catch (Exception e) {
					// TODO: handle exception
				}

				super.run();
			}

		};
		t.start();

	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			mTv1.startAnimation(mAnim1);
			mTv2.startAnimation(mAnim2);
			mTv3.startAnimation(mAnim3);
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

}
