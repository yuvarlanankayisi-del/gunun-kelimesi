package com.gununkelimesi.app;
import android.app.Activity; import android.graphics.Color; import android.os.Bundle;
import android.webkit.WebSettings; import android.webkit.WebView;
public class MainActivity extends Activity {
  WebView web;
  @Override protected void onCreate(Bundle b) {
    super.onCreate(b);
    getWindow().setStatusBarColor(Color.parseColor("#f6eedd"));
    getWindow().setNavigationBarColor(Color.parseColor("#f6eedd"));
    web = new WebView(this); web.setBackgroundColor(Color.parseColor("#f6eedd"));
    WebSettings s = web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
    s.setAllowFileAccess(true); s.setAllowFileAccessFromFileURLs(false); s.setAllowUniversalAccessFromFileURLs(false);
    int f=android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR|(android.os.Build.VERSION.SDK_INT>=26?android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR:0);getWindow().getDecorView().setSystemUiVisibility(f);setContentView(web); web.loadUrl("file:///android_asset/index.html");
  }
  @Override public void onBackPressed() {
    web.evaluateJavascript("window.onBack&&window.onBack()", v -> { if (!"true".equals(v)) finish(); });
  }
}
