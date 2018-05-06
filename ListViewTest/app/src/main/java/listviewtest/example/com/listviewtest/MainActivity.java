package listviewtest.example.com.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<FruitModel> fruitModelList = new ArrayList<FruitModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits(); // 初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitModelList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FruitModel fruitModel = fruitModelList.get(position);
                Toast.makeText(MainActivity.this, fruitModel.getName(), Toast.LENGTH_SHORT).show();
                Intent startbasicActivity=new Intent(MainActivity.this,BasicListViewActivity.class);
                startActivity(startbasicActivity);
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            FruitModel apple = new FruitModel("Apple", R.drawable.apple_pic);
            fruitModelList.add(apple);
            FruitModel banana = new FruitModel("Banana", R.drawable.banana_pic);
            fruitModelList.add(banana);
            FruitModel orange = new FruitModel("Orange", R.drawable.orange_pic);
            fruitModelList.add(orange);
            FruitModel watermelon = new FruitModel("Watermelon", R.drawable.watermelon_pic);
            fruitModelList.add(watermelon);
            FruitModel pear = new FruitModel("Pear", R.drawable.pear_pic);
            fruitModelList.add(pear);
            FruitModel grape = new FruitModel("Grape", R.drawable.grape_pic);
            fruitModelList.add(grape);
            FruitModel pineapple = new FruitModel("Pineapple", R.drawable.pineapple_pic);
            fruitModelList.add(pineapple);
            FruitModel strawberry = new FruitModel("Strawberry", R.drawable.strawberry_pic);
            fruitModelList.add(strawberry);
            FruitModel cherry = new FruitModel("Cherry", R.drawable.cherry_pic);
            fruitModelList.add(cherry);
            FruitModel mango = new FruitModel("Mango", R.drawable.mango_pic);
            fruitModelList.add(mango);
        }
    }
}
