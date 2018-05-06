package listviewtest.example.com.listviewtest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BasicListViewActivity extends AppCompatActivity {

    private  String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape",
    "Pineapple","Strawberry","Cherry","Mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(BasicListViewActivity.this,
                R.layout.support_simple_spinner_dropdown_item,data);
        ListView listView=(ListView)findViewById(R.id.list_view2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String fruit_name=data[position];
 //               Toast.makeText(BasicListViewActivity.this,fruit_name,Toast.LENGTH_LONG).show();
                final AlertDialog.Builder alertDialog=new AlertDialog.Builder(BasicListViewActivity.this);
                alertDialog.setTitle("我们是物联网专业");
              //  alertDialog.setMessage(fruit_name);
                alertDialog.setSingleChoiceItems(new String[]{"apple", "mengo", "pear"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.setNegativeButton("取消",null);
                alertDialog.setPositiveButton("确定",null);

                alertDialog.show();

            }
        });
    }
}
