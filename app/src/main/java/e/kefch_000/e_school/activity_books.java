package e.kefch_000.e_school;

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
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity_books extends AppCompatActivity {
String value = "Default";
EditText et;
String s = "Some long string";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            value = extras.getString("KEY");
            Toast.makeText(this,value + " Button was selected", Toast.LENGTH_LONG).show();
        }
        et=(EditText) findViewById(R.id.editText);




    }

    public void onClickBook1(View view)
    {

        SpannableStringBuilder sb = new SpannableStringBuilder(String.valueOf(et.getText()));
        s= String.valueOf(et.getText());
        Typeface robotoRegular = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");
        Typeface robotoBold = Typeface.createFromAsset(getAssets(), "fonts/roboto_bold.ttf");
        TypefaceSpan robotoRegularSpan = new CustomTypefaceSpan("", robotoRegular);
        TypefaceSpan robotoBoldSpan = new CustomTypefaceSpan("", robotoBold);
        int startSel = et.getSelectionStart();
        int endSel  = et.getSelectionEnd();
       // sb.setSpan(robotoRegularSpan, 0, s.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(robotoBoldSpan, startSel, endSel, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        //sb.setSpan(new ForegroundColorSpan(Color.YELLOW), startSel, endSel, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        String selectedText = et.getText().toString().substring(startSel, endSel);
        Toast.makeText(this, selectedText, Toast.LENGTH_SHORT).show();
        et.setText(sb);
    }

}
