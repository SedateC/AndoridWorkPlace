package activity.listui.com.listviewui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListUIText1 extends AppCompatActivity {
    private String[] fruit ={"Apple","Banana","Orange","Watermelon,Pear",
            "Apple","Banana","Orange","Watermelon,Pear","Apple","Banana","Orange","Watermelon,Pear"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listuitext1_layout);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListUIText1.this,android.R.layout.simple_list_item_1,fruit);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
    }
}

