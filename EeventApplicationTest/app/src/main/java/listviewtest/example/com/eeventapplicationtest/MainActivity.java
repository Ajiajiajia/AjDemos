package listviewtest.example.com.eeventapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text_view1);
        textView.setTextSize(22);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_MOVE){
            textView.setText("it is moving,x="+event.getX()+",Y="+event.getY());
        }
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            textView.setText("it is downing,x="+event.getX()+",Y="+event.getY()+"presure:"+event.getPressure());
        }
        if (event.getAction()==MotionEvent.ACTION_UP){
            textView.setText("it is uping,x="+event.getX()+",Y="+event.getY());
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }
}
