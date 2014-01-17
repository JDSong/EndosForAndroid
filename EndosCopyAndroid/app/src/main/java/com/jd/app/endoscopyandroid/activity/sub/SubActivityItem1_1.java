package com.jd.app.endoscopyandroid.activity.sub;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jd.app.endoscopyandroid.R;

public class SubActivityItem1_1 extends Fragment {
	
	private String strRId;
	private String htmlPrefix;

	public static Fragment newInstance(Context context, String htmlPath, String idNumber) {
		SubActivityItem1_1 f = new SubActivityItem1_1();
		f.setRId(idNumber);
		f.setHtmlPrefix(htmlPath);
		return f;
	}
	
	public void setRId(String idNumber) {
		strRId = idNumber;
	}
	
	public void setHtmlPrefix(String prefix) {
		this.htmlPrefix = prefix;
	}
	
	private class SimpleWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
//		int rId = getActivity().getResources().getIdentifier("com.jd.app.endoscopyandroid.R:layout/layout_sub_" + strRId, null, null);
//		int rId = getActivity().getResources().getIdentifier("layout_sub" + strRId, "layout", getActivity().getApplicationContext().getPackageName());
		ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.layout_sub_webview, null);		
		
		WebView webView = (WebView) rootView.findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new SimpleWebClient());
		webView.loadUrl("file:///android_asset/" + htmlPrefix + strRId + ".html");

		return rootView;
	}
}