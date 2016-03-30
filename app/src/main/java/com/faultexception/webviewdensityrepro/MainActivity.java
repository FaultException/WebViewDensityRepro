package com.faultexception.webviewdensityrepro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView locationView = (TextView) findViewById(R.id.location);

        final WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/test.html");
        webView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                locationView.setText("Scroll: " + scrollX);
            }
        });

        Button scroll = (Button) findViewById(R.id.scroll_button);
        scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.scrollTo(webView.getWidth(), 0);
            }
        });

        Button scrollJs = (Button) findViewById(R.id.scrolljs_button);
        scrollJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.evaluateJavascript("window.scrollTo(window.innerWidth, 0);", null);
            }
        });
    }
}
