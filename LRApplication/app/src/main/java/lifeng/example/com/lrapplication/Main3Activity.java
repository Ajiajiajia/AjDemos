package lifeng.example.com.lrapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static lifeng.example.com.lrapplication.R.id.toolbar;

public class Main3Activity extends AppCompatActivity {

    Button bt6;
    Button bt7;
    Button bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bt6=(Button)findViewById(R.id.button6);
        bt7=(Button)findViewById(R.id.button7);
        bt8=(Button)findViewById(R.id.button8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建构建器
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                // 设置参数
                builder.setTitle("请做出选择");
                builder.setIcon(R.mipmap.ic_launcher)
                        .setMessage("中国强大吗?")
                        .setPositiveButton("强", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main3Activity.this, "恭喜你答对了", Toast.LENGTH_LONG)
                                        .show();
                            }
                        } )
                        .setNegativeButton("一般", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main3Activity.this, "你答错了", Toast.LENGTH_LONG)
                                        .show();
                            }
                        })
                        .setNeutralButton("不知道", new DialogInterface.OnClickListener() {// 中间级

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        // TODO Auto-generated method stub
                        Toast.makeText(Main3Activity.this, "你答错了", Toast.LENGTH_LONG)
                                .show();
                    }
                });
                builder.create().show();
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建数据
                final String[] items = new String[] { "北京", "上海", "广州", "深圳" };
                // 创建对话框构建器
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                // 设置参数
                builder.setIcon(R.mipmap.ic_launcher).setTitle("提示")
                        .setItems(items, new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main3Activity.this, items[which],
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.create().show();
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建数据
                final String[] items = new String[] { "北京", "上海", "广州", "深圳" };
                // 创建对话框构建器
                AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                // 设置参数
                builder.setIcon(R.mipmap.ic_launcher).setTitle("提示")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                Toast.makeText(Main3Activity.this, items[which],
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.create().show();

            }
        });

    }

}
