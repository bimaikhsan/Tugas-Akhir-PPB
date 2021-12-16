package tugasakhirppb.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class berita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        WebView MyWebView = findViewById(R.id.berita);
        MyWebView.setWebViewClient(new WebViewClient());
        MyWebView.loadUrl("https://www.bola.net/");
    }
}