package com.example.yf.creatorshirt.mvp.ui.activity;

import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.yf.creatorshirt.R;
import com.example.yf.creatorshirt.mvp.ui.activity.base.BaseActivity;
import com.example.yf.creatorshirt.mvp.ui.view.DialogAlert;
import com.example.yf.creatorshirt.mvp.view.BaseWebView;
import com.example.yf.creatorshirt.utils.LogUtil;

import java.io.File;

import butterknife.BindView;

public class ServerActivity extends BaseActivity {
    private static final String TAG = "KKK";
    @BindView(R.id.webView)
    BaseWebView mWebView;

    private String url;

    @Override
    protected void inject() {

    }

    @Override
    public void initData() {
        super.initData();
        if (getIntent().getExtras() != null) {
            url = getIntent().getExtras().getString("url");
            LogUtil.e("TAG", "initData: " + url);
        }
    }


    @Override
    protected void initView() {
        if (url.contains("https")) {
            mAppBarTitle.setText("更多图片");
        } else {
            mAppBarTitle.setText("用户协议说明");
        }
        mWebView.loadUrl(url);
        mAppBarBack.setOnClickListener(v -> finish());
        mWebView.setWebViewClient(new ViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    protected int getView() {
        return R.layout.activity_server;
    }

    private class ViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return true;
        }
    }
}