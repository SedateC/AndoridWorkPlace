package com.database.sedatec.databasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MydatabaseHelper mydatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydatabaseHelper = new MydatabaseHelper(this,"BookStore.db",null,2);
        Button button = (Button)findViewById(R.id.create_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydatabaseHelper.getWritableDatabase();
            }
        });
    }
}
