package com.broadcast.sedatec.filepersistencetest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        editText = (EditText)findViewById(R.id.edit_1);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputtext = editText.getText().toString();
        Log.d("message", "onDestroy: ");
        save(inputtext);
        Log.d("message", "onDestroy:111111 ");
    }

    private void save(String inputtext) {
        FileOutputStream out = null;
        BufferedWriter write = null;
        try {
              out = openFileOutput("dataString",Context.MODE_PRIVATE);
            write = new BufferedWriter(new OutputStreamWriter(out));
            write.write(inputtext);
        }catch ( IOException e ){
            e.printStackTrace();
        }finally {
            try {
                if (write!=null){
                    write.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }


}
