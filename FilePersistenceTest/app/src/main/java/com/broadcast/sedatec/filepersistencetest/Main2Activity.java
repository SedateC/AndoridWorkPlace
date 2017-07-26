package com.broadcast.sedatec.filepersistencetest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2Activity extends AppCompatActivity {
    private EditText editText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = (EditText)findViewById(R.id.edit_2);
        String inputText = load();
        if(""!=inputText&&inputText!=null){
            Log.d("message", inputText);
            editText.setText(inputText);
            editText.setSelection(inputText.length());
            Toast.makeText(this, "Restoring successed", Toast.LENGTH_SHORT).show();
        }
     /*   if (!TextUtils.isEmpty(inputText)){

        }*/

    }
    private  String load(){
        FileInputStream in =null;
        BufferedReader read = null;
        StringBuilder sb =  new StringBuilder();
        try {
            in = openFileInput("dataString");
            read = new BufferedReader(new InputStreamReader(in));
            String content;
            while ((content = read.readLine())!=null){
                sb.append(content);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(read!=null){
                try {
                    read.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }



}
