package lifeng.example.com.lrapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    EditText et1;
    EditText et2;
    Button  bt1;
    Button  bt2;
    String  TAG="lirenxuyuan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);
        et1=(EditText)findViewById(R.id.editText1);
        et1=(EditText)findViewById(R.id.editText2);
        bt1=(Button)findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);

        tv1.setText("这是我们通过程序修改的信息");
        tv1.setTextSize(20);
        tv1.setTextColor(Color.RED);
        tv1.getText();
        et1.getText();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,tv1.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(myIntent);
            }
        });
        this.registerForContextMenu(tv1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         setIconEnable(menu,true);
         menu.add(0,1,3,"开始").setIcon(R.mipmap.ic_launcher);
         menu.add(0,2,2,"启动").setIcon(R.mipmap.ic_launcher);
         menu.add(0,3,1,"进入");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 1:
                Toast.makeText(MainActivity.this,"开发菜单",Toast.LENGTH_LONG).show();
                Intent main3activiyt_intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(main3activiyt_intent);
                break;
            case 2:
                Toast.makeText(MainActivity.this,"启动菜单",Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this,"进入菜单",Toast.LENGTH_LONG).show();

            default:
                 break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        setIconEnable(menu,true);
        menu.setHeaderTitle("设置字号");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.add(0,1,1,"10号");
        menu.add(0,2,1,"16号").setIcon(R.mipmap.ic_launcher);
        menu.add(0,3,1,"22号").setIcon(R.mipmap.ic_launcher);
        menu.add(0,4,1,"28号");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                tv1.setTextSize(10);
                break;
            case 2:
                tv1.setTextSize(16);
                 break;
            case 3:
                tv1.setTextSize(22);
                break;
            case 4:
                tv1.setTextSize(28);
                break;

            default:
                break;
              }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"this is on start running!");
    }

    /**
     * Activity创建或者从后台重新回到前台时调用
     * @param savedInstanceState
     */
    /*
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }
*/
    /**
     * Activity创建或者从被覆盖、后台重新回到前台时调用
     * @param savedInstanceState
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }
    /**
     * Activity被覆盖到下面或锁屏时调用
     * @param savedInstanceState
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
    /**
     * 退出当前Activity或者跳转到新的Activity时调用
     * @param savedInstanceState
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }
    /**
     * 退出当前Activity调用，调用之后Activity就结束了
     * @param savedInstanceState
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * Activity从后台重新回到前台时调用
     * @param savedInstanceState
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    private void setIconEnable(Menu menu, boolean enable)

    {
        try
        {
            //未知的类
            Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            m.setAccessible(true);
            //MenuBuilder实现Menu接口，创建菜单时，传进来的menu其实就是MenuBuilder对象(java的多态特征)
            m.invoke(menu, enable);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
