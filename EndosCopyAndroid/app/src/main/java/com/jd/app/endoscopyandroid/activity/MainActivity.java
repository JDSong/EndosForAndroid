package com.jd.app.endoscopyandroid.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.jd.app.endoscopyandroid.R;


public class MainActivity extends Activity {
    
	private Button btInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_layout);
		
		btInfo = (Button) findViewById(R.id.btInfo);
        
        btInfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String activityName = "com.jd.app.endoscopyandroid.activity.InfoActivity";
				try {
					Intent intent = new Intent(MainActivity.this, Class.forName(activityName));
					startActivity(intent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public void goSubMenu(View v) {
		String pageNumber = (String) v.getTag();
			
		if (pageNumber != null && pageNumber.length() > 0) {
			
			String activityName = "com.jd.app.endoscopyandroid.activity.SubActivity" + pageNumber;
			try {
				Intent intent = new Intent(this, Class.forName(activityName));
				startActivity(intent);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
