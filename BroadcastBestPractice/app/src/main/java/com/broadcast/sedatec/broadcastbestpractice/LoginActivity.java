package com.broadcast.sedatec.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylogin);
        accountEdit = (EditText) findViewById(R.id.edit_Account);
        passwordEdit = (EditText) findViewById(R.id.edit_password);
        loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String account =   accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin")&&password.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "ERROR PASSWORD", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
