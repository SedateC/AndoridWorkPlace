package com.perfence.sedatec.sharedperferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.broadcast.sedatec.filepersistencetest.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perferences_main);
        Button savedata = (Button)findViewById(R.id.per_b1);
        Button loaddata = (Button)findViewById(R.id.per_b2);
        savedata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("dataString",MODE_PRIVATE).edit();
                editor.putString("name","tom");
                editor.putInt("age",18);
                editor.putBoolean("married",false);
                editor.apply();
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
        });

        loaddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreference = getSharedPreferences("dataString",MODE_PRIVATE);
                Boolean b = sharedPreference.getBoolean("married",false);
                String name = sharedPreference.getString("name","");
                int age = sharedPreference.getInt("age",0);
                Log.d(TAG, "marrise is "+b+" String name is "+name+" age is "+age);

            }
        });
    }
}
