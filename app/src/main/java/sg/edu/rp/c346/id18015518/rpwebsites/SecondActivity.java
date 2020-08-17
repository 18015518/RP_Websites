package sg.edu.rp.c346.id18015518.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity{

    WebView wvPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        wvPage = findViewById(R.id.webViewMyPage);

        Intent intentReceive = getIntent();
        String url = intentReceive.getStringExtra("url");

        wvPage.setWebViewClient(new WebViewClient());
        WebSettings webSettings = wvPage.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);

        wvPage.loadUrl(url);


    }
}
