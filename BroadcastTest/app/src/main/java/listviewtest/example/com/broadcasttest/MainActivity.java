package listviewtest.example.com.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private LocalReceiver localReceiver;

    private LocalBroadcastManager localBroadcastManager;

    private IntentFilter intentFilter2;

   private NetworkChangeReceiver networkChangeReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter2= new IntentFilter();
        intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter2);
        localBroadcastManager = LocalBroadcastManager.getInstance(this); // 获取实例
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent); // 发送本地广播
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter); // 注册本地广播监听器

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent("android.intent.action.BOOT_COMPLETED");
                sendBroadcast(intent);
                return  true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }

    }

  class NetworkChangeReceiver extends BroadcastReceiver {

      @Override
       public void onReceive(Context context, Intent intent) {
           ConnectivityManager connectionManager = (ConnectivityManager)
                  getSystemService(Context.CONNECTIVITY_SERVICE);
           NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
           if (networkInfo != null && networkInfo.isAvailable()) {
               Toast.makeText(context, "network is available",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network is unavailable",
                       Toast.LENGTH_SHORT).show();
          }

       }

   }

}

