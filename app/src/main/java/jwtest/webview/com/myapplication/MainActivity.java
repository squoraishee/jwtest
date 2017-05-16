package jwtest.webview.com.myapplication;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;

import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    private JWPlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jwplayer = "<html><body><div style='position:relative; overflow:hidden;'><iframe src='https://content.jwplatform.com/players/Rd8LnswY-RO5tFT3n.html' width='200' height='200' frameborder='0' scrolling='auto'></iframe></div></body></html>";
        String youtube = "<iframe id='ytplayer' type='text/html' width='640' height='360' src='https://www.youtube.com/embed/M7lc1UVf-VE?autoplay=1&origin=http://example.com' frameborder='0'></iframe>";

        webView = (WebView)findViewById(R.id.test_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.loadData(jwplayer,  "text/html; charset=UTF-8", null);
        //loadNativePlayer();

    }

    public void loadNativePlayer() {
        playerView.setVisibility(View.VISIBLE);
        playerView = (JWPlayerView) findViewById(R.id.playerView);
        PlaylistItem pi = new PlaylistItem.Builder()
                        .file("https://content.jwplatform.com/manifests/gFGOwEll.m3u8")
                        .title("BipBop")
                        .description("A video player testing video.")
                        .build();
        playerView.load(pi);
        playerView.play();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //playerView.onResume();
    }

    @Override
    protected void onPause() {
        //playerView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        //playerView.onDestroy();
        super.onDestroy();
    }

    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
