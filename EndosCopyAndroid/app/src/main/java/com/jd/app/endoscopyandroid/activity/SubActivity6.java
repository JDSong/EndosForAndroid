package com.jd.app.endoscopyandroid.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.TextView;

import com.jd.app.endoscopyandroid.R;

public class SubActivity6 extends FragmentActivity {
	
	private ViewPager 			viewPager;
	private ViewPagerAdapter 	adapter;
	
	private static final String HTML_PATH = "html_5/conview";
	private static final int	PAGE_COUNT = 1;
	private static final String PAGE_NUMBER = "6";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar_layout);
        
        Resources res = getResources();
        
        TextView tvKr = (TextView) findViewById(R.id.txtTitleKr);
        int resID = getResources().getIdentifier("top_button" + PAGE_NUMBER, "string", getApplicationContext().getPackageName());
        tvKr.setText(res.getString(resID));
        TextView tvEng = (TextView) findViewById(R.id.txtTitleEng);
        resID = getResources().getIdentifier("top_button" + PAGE_NUMBER + "_eng", "string", getApplicationContext().getPackageName());
        tvEng.setText(res.getString(resID));
        setUpView();
    }
    
    private void setUpView(){    	
	   	viewPager = (ViewPager) findViewById(R.id.viewPager);
	    adapter = new ViewPagerAdapter(getApplicationContext(),getSupportFragmentManager(), HTML_PATH, PAGE_COUNT);     
	    viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
    }
}