package e.kefch_000.e_school;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Notebook extends AppCompatActivity {

    private static final String TAG = Notebook.class.getName();
    String subject, bookType;
    EditText et;
    String s = "Some long string";
    String savedData, savedData2, savedData3;
    boolean dataIsSaved1, dataIsSaved2, dataIsSaved3;
    boolean isSB = false, isClasswork = false, isHomework = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);
        et = findViewById(R.id.editText);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            subject = String.valueOf(extras.getString("SUBJECT"));
            bookType = String.valueOf(extras.getString("BOOKTYPE"));
        } else errorShow("Null input data from Book Activity");
        checkType(bookType);
    }

    private void checkType(String bookType) {
        if (Objects.equals(bookType, "sb")) {
            isSB = true;
            isClasswork = false;
            isHomework = false;
        } else if (Objects.equals(bookType, "classwork")) {
            isSB = false;
            isClasswork = true;
            isHomework = false;
        } else if (Objects.equals(bookType, "homework")) {
            isSB = false;
            isClasswork = false;
            isHomework = true;
        } else errorShow("Type doesn't exist, probably bad input data from Book Activity");
    }

    private void errorShow(String t) {
        Toast.makeText(this, "CONTACT DEVELOPER ASAP", Toast.LENGTH_LONG).show();
        Log.wtf(TAG, t);
    }

    public void onHighlighted(View view) {
        SpannableStringBuilder sb = new SpannableStringBuilder(String.valueOf(et.getText()));
        s = String.valueOf(et.getText());
        Typeface robotoRegular = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");
        Typeface robotoBold = Typeface.createFromAsset(getAssets(), "fonts/roboto_bold.ttf");
        TypefaceSpan robotoRegularSpan = new CustomTypefaceSpan("", robotoRegular);
        TypefaceSpan robotoBoldSpan = new CustomTypefaceSpan("", robotoBold);
        int startSel = et.getSelectionStart();
        int endSel = et.getSelectionEnd();
        // sb.setSpan(robotoRegularSpan, 0, s.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(robotoBoldSpan, startSel, endSel, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(new ForegroundColorSpan(Color.RED), startSel, endSel, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        String selectedText = et.getText().toString().substring(startSel, endSel);
        Toast.makeText(this, selectedText, Toast.LENGTH_SHORT).show();
        et.setText(sb);
    }

    public void onSaved(View view) {
        int startSel = et.getSelectionStart();
        int endSel = et.getSelectionEnd();
        if (!dataIsSaved3) {
            if (!dataIsSaved1) {
                savedData = et.getText().toString().substring(startSel, endSel);
                dataIsSaved1 = true;
                Toast.makeText(this, "Data is saved", Toast.LENGTH_SHORT).show();
            } else if (!dataIsSaved2) {
                savedData2 = et.getText().toString().substring(startSel, endSel);
                dataIsSaved2 = true;
                Toast.makeText(this, "Second data is saved", Toast.LENGTH_SHORT).show();
            } else if (!dataIsSaved3) {
                savedData3 = et.getText().toString().substring(startSel, endSel);
                dataIsSaved3 = true;
                Toast.makeText(this, "Third data is saved", Toast.LENGTH_SHORT).show();
            }
        } else Toast.makeText(this, "You have already saved data", Toast.LENGTH_SHORT).show();
        SpannableStringBuilder sb = new SpannableStringBuilder(String.valueOf(et.getText()));
        s = String.valueOf(et.getText());
        sb.setSpan(new ForegroundColorSpan(Color.GREEN), startSel, endSel, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        String selectedText = et.getText().toString().substring(startSel, endSel);
        Toast.makeText(this, selectedText, Toast.LENGTH_SHORT).show();
        et.setText(sb);
    }

}
