package com.jd.app.endoscopyandroid.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jd.app.endoscopyandroid.R;

public class SubActivity5 extends FragmentActivity {
	
	private ViewPager 			viewPager;
	private ViewPagerAdapter 	adapter;
	private List<Button>		btns = new ArrayList<Button>();
	private TextView		 	tvSubtitle;	
	private String[] 		 	subtitles;
	private LinearLayout		mainLayout;	
	private static final int    PAGE_INDICATOR_SIZE = 10;
	
	private static final String HTML_PATH = "html_6/biopsyview";
	private static final int	PAGE_COUNT = 3;
	private static final String PAGE_NUMBER = "5";
	
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
        tvSubtitle = (TextView) findViewById(R.id.txtSubTitle);
    	subtitles = res.getStringArray(R.array.page5s_subtitles);
    	mainLayout = (LinearLayout) findViewById(R.id.mainLlayout);
    	
        setUpView();
        setTab();
    }
    
    private void setUpView(){    	
	   	viewPager = (ViewPager) findViewById(R.id.viewPager);
	    adapter = new ViewPagerAdapter(getApplicationContext(),getSupportFragmentManager(), HTML_PATH, PAGE_COUNT);     
	    viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
		initButton();
    }
    
    private void setTab(){
			viewPager.setOnPageChangeListener(new OnPageChangeListener(){
			    		
						@Override
						public void onPageScrollStateChanged(int position) {}
						@Override
						public void onPageScrolled(int arg0, float arg1, int arg2) {}
						@Override
						public void onPageSelected(int position) {
							// TODO Auto-generated method stub
							btnAction(position);
						}
						
					});

    }
    
    private void btnAction(int action){
    	
    	tvSubtitle.setText(subtitles[action]);
    	
    	for(int i = 0; i < btns.size(); i++) {
    		if (i == action) {
    			btns.get(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_cell_red));
    		} else {
    			btns.get(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_cell));
    		}
    	}
    }
    
    private void initButton(){
    	/*
    	 * Button b = new Button(this);
			RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			rl.addRule(RelativeLayout.ALIGN_BOTTOM);
			b.setLayoutParams(rl);
			((RelativeLayout) findViewById(R.id.myLayout)).addView(b);
    	 */
    	if (subtitles != null && subtitles.length > 0) {
    		tvSubtitle.setText(subtitles[0]);
    	}
    	
    	LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
    	View childLayout = inflater.inflate(R.layout.footer_5, null);
    	mainLayout.addView(childLayout);
    	
    	for( int i = 0; i < PAGE_COUNT; i++ )
    	{
    	    String buttonID = "btn" + (i + 1);
    	    int resID = getResources().getIdentifier(buttonID, "id", getApplicationContext().getPackageName());
    	    Button aBtn = (Button) findViewById(resID); 
    	    btns.add(aBtn);
    	    setButton(aBtn, "", PAGE_INDICATOR_SIZE, PAGE_INDICATOR_SIZE);
    	}
    }
    
    private void setButton(Button btn,String text,int h, int w){

    	ViewGroup.LayoutParams params = btn.getLayoutParams();
    	params.width = w;
    	params.height = h;
    	btn.setText(text);
    	btn.setLayoutParams(params);
    }
}