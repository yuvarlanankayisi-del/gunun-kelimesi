package com.gununkelimesi.app;
import android.app.Activity; import android.graphics.Color; import android.os.Bundle;
import android.webkit.WebSettings; import android.webkit.WebView;
public class MainActivity extends Activity {
  WebView web;
  @Override protected void onCreate(Bundle b) {
    super.onCreate(b);
    getWindow().setStatusBarColor(Color.parseColor("#15110d"));
    getWindow().setNavigationBarColor(Color.parseColor("#15110d"));
    web = new WebView(this); web.setBackgroundColor(Color.parseColor("#1b1612"));
    WebSettings s = web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
    s.setAllowFileAccess(true); s.setAllowFileAccessFromFileURLs(false); s.setAllowUniversalAccessFromFileURLs(false);
    setContentView(web); web.loadUrl("file:///android_asset/index.html");
  }
  @Override public void onBackPressed() {
    web.evaluateJavascript("window.onBack&&window.onBack()", v -> { if (!"true".equals(v)) finish(); });
  }
}
