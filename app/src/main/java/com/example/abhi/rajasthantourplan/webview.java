package com.example.abhi.rajasthantourplan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    WebView wbv1;
    ProgressDialog progressDialog;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        wbv1 = findViewById(R.id.wbv1);
        wbv1.setWebViewClient(new myWebClient());
        String url;
        if (transport_new.count == 1)
            url = "http://www.airindia.in/";
        else if (transport_new.count == 2)
            url = "https://www.irctc.co.in/eticketing/loginHome.jsf";
        else if (transport_new.count == 3)
            url = "http://transport.rajasthan.gov.in/rsrtc/";
        else if (transport_new.count == 4)
            url = "http://rtdc.tourism.rajasthan.gov.in/Client/HotelList.aspx";
    }

    public class myWebClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressDialog = new ProgressDialog(webview.this);
            progressDialog.setMessage("Please Wait..");
            progressDialog.show();
            progressDialog.setCancelable(true);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }

    }

}