package com.ruju.mylearn;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.HashMap;

public class Page6 extends Activity {

    WebView mWebView;

    public class MyJsEvent {

        @JavascriptInterface
        public void myJs(String toast) {
            Toast.makeText(Page6.this, toast, Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page6);
        mWebView = findViewById(R.id.mwebView);

//        HashMap<String, String> map = new HashMap<>();
//        map.put("token", "xxxxxxxxxxx");
//        map.put("my_header","header");
//        mWebView.loadUrl("https://m.baidu.com",map);

        WebView.setWebContentsDebuggingEnabled(true);
        mWebView.loadUrl("https://m.baidu.com");

//        CookieManager cookieManager=CookieManager.getInstance();
//        cookieManager.setAcceptCookie(true);
//        cookieManager.setCookie("doman","cookie");
//        cookieManager.removeAllCookies();


        //mWebView.loadUrl("file:///android_asset/test.html");
        mWebView.addJavascriptInterface(new MyJsEvent(), "MyJsApp");

        mWebView.loadUrl("javascript:javaCallJS");

        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, url);
//                //return true;
//            }
//        });
        mWebView.setWebChromeClient(new WebChromeClient() {
        });

    }

    @Override
    public void onBackPressed() {

        WebBackForwardList webBackForwardList = mWebView.copyBackForwardList();
        WebHistoryItem historyItem = webBackForwardList.getItemAtIndex(0);
        String historyUrl = historyItem.getUrl();

        if (mWebView != null && mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
