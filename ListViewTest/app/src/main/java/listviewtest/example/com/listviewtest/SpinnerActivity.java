package listviewtest.example.com.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {
    private  String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape",
            "Pineapple","Strawberry","Cherry","Mango"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(SpinnerActivity.this,
                R.layout.support_simple_spinner_dropdown_item,data);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(SpinnerActivity.this,R.layout.support_simple_spinner_dropdown_item,data);
        autoCompleteTextView.setAdapter(adapter1);


    }
}
