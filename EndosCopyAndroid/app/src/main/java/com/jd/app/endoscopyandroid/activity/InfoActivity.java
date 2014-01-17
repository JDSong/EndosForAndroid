package com.jd.app.endoscopyandroid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jd.app.endoscopyandroid.R;

public class InfoActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_layout);
		
		ImageView ivBack = (ImageView) findViewById(R.id.ivBack);
		ivBack.setAlpha(100);
	}
}
