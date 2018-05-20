package e.kefch_000.e_school;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import butterknife.BindView;

public class Book extends AppCompatActivity {

    private static final String TAG = Book.class.getName();
    String value;
    @BindView(R.id.webView1)
    WebView webview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("SUBJECT");
        } else
            errorShow("Subject type is null. You have probably messed up intent keys in MainActivity");
        webview1.loadUrl(bookType(value));
    }

    public String bookType(String subject) {
        //TODO:Replace the URLs with real ones
        if (subject == "bulgarian") {
            return "https://bing.com";
        } else if (subject == "english") {
            return "https://microsoft.com";
        } else if (subject == "maths") {
            return "https://amazon.co.uk";
        } else
            errorShow("Subject type doesn't exist. You have probably messed up giving the subject in MainActivity");
        return "https://google.com";
    }

    private void errorShow(String t) {
        Toast.makeText(this, "CONTACT DEVELOPER ASAP", Toast.LENGTH_LONG).show();
        Log.wtf(TAG, t);
    }

}
