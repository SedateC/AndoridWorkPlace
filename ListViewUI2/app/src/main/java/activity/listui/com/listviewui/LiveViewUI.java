package activity.listui.com.listviewui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LiveViewUI extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_view_ui_layout);
        initFruit();
      /*  FruitAdapter fruitAdapter = new FruitAdapter(LiveViewUI.this,R. layout.fruititem_layout,fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(LiveViewUI.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });*/
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);*/
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager );
        FruitRecyclerAdparter fruitRecyclerAdparter = new FruitRecyclerAdparter(fruitList);
        recyclerView.setAdapter(fruitRecyclerAdparter);

    }
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<length;i++){
            sb.append(name);
        }
        return sb.toString();
    }

    private void initFruit(){
        for (int i=0;i<4;i++){
            Fruit apple = new Fruit(getRandomLengthName("apple"),R.drawable.behance);
            fruitList.add(apple);
            Fruit apple1 = new Fruit(getRandomLengthName("apple"),R.drawable.bell);
            fruitList.add(apple1);
            Fruit apple2 = new Fruit(getRandomLengthName("apple"),R.drawable.bin);
            fruitList.add(apple2);
            Fruit apple3 = new Fruit(getRandomLengthName("apple"),R.drawable.block);
            fruitList.add(apple3);
            Fruit apple4 = new Fruit(getRandomLengthName("apple"),R.drawable.book);
            fruitList.add(apple4);
            Fruit apple5 = new Fruit(getRandomLengthName("apple"),R.drawable.book_1);
            fruitList.add(apple5);
            Fruit apple6 = new Fruit(getRandomLengthName("apple"),R.drawable.book_2);
            fruitList.add(apple6);
        }
    }

}
