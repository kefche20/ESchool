package e.kefch_000.e_school;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;

public class activity_books extends AppCompatActivity {

    private static final String TAG = activity_books.class.getName();
    String value = "Default";
    EditText et;
    String s = "Some long string";
    String savedData, savedData2, savedData3;
    boolean dataIsSaved1, dataIsSaved2, dataIsSaved3 = false;
    @BindView(R.id.kniga1)
    Button kniga1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            value = extras.getString("SUBJECT");
        } else
            errorShow("Subject type is null. You have probably messed up intent keys in MainActivity");
        value = bookType(value);
    }

    public String bookType(String subject) {
        if (subject == "bulgarian") {
            kniga1.setText("Bulgarian Student's Book");
            return "bulgarian";
        } else if (subject == "english") {
            kniga1.setText("English Student's Book");
            return "english";
        } else if (subject == "maths") {
            kniga1.setText("Maths Book");
            return "maths";
        } else
            errorShow("Subject type doesn't exist. You have probably messed up giving the subject in MainActivity");
        return null;

    }

    public void onClickBook1(View view) {
        Intent i = new Intent(this, Notebook.class);
        i.putExtra("SUBJECT", value);
        i.putExtra("BOOKTYPE", "sb");
        startActivity(i);
    }

    public void onClickBook2(View view) {
        Intent i = new Intent(this, Notebook.class);
        i.putExtra("SUBJECT", value);
        i.putExtra("BOOKTYPE", "classwork");
        startActivity(i);
    }

    public void onClickBook3(View view) {

    }

    private void errorShow(String t) {
        Toast.makeText(this, "CONTACT DEVELOPER ASAP", Toast.LENGTH_LONG).show();
        Log.wtf(TAG, t);
    }

}
