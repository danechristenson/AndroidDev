package ca.nait.dmit.webviewdemo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        String targetUrl = intent.getStringExtra("TARGET_URL");
        WebView webView = (WebView) findViewById(R.id.targetWebview);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(targetUrl);
    }
}
