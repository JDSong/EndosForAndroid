package com.jd.app.endoscopyandroid.activity;

import com.jd.app.endoscopyandroid.activity.sub.SubActivityItem1_1;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	private Context context;
	public static int totalPage = 0;
	private String  htmlPath;
	
	public ViewPagerAdapter(Context context, FragmentManager fm, String htmlPath, int totalNumber) {
		super(fm);	
		this.context=context;
		totalPage = totalNumber;	
		this.htmlPath = htmlPath; 
		}
	@Override
	public Fragment getItem(int position) {
		Fragment f = new Fragment();
		f=SubActivityItem1_1.newInstance(context, htmlPath, String.valueOf(position + 1));	
		return f;
	}
	@Override
	public int getCount() {
		return totalPage;
	}

}
