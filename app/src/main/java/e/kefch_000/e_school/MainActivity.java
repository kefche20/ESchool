package e.kefch_000.e_school;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        LogStuff("Screen orientation set to landscape.");
    }

    @OnClick(R.id.button1)
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Changing activity", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, activity_books.class);
        LogStuff("some button clicked");
        i.putExtra("SUBJECT", "bulgarian");
        startActivity(i);
    }

    @OnClick(R.id.button2)
    public void onClickSec(View view) {
        Toast.makeText(view.getContext(), "Changing activity", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, activity_books.class);
        i.putExtra("SUBJECT", "english");
        startActivity(i);
    }

    @OnClick(R.id.button3)
    public void onClickThird(View view) {
        Toast.makeText(view.getContext(), "Changing activity", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, activity_books.class);
        i.putExtra("SUBJECT", "maths");
        startActivity(i);
    }

    public void LogStuff(String t) {
        Log.wtf(TAG, t);
    }
}
