package com.perfence.sedatec.sharedperferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.broadcast.sedatec.filepersistencetest.R;

public class LoginActivity extends BaseActivity {
    private SharedPreferences pref ;
    private SharedPreferences.Editor editor;
    private EditText editAccount;
    private EditText editpassword;
    private CheckBox rememberCheck;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginremember_layout);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editAccount = (EditText)findViewById(R.id.edit_Account);
        editpassword = (EditText)findViewById(R.id.edit_password);
        rememberCheck = (CheckBox)findViewById(R.id.checkbox_checkRemember);
        login =(Button) findViewById(R.id.button_login);
        boolean ischeck = pref.getBoolean("remember_check",false);
        if (ischeck){
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            editAccount.setText(account);
            editpassword.setText(password);
            Log.d("message", "onCreate: "+account);
            rememberCheck.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = editAccount.getText().toString();
                String password = editpassword.getText().toString();
                if (account.equals("adimin")&&password.equals("123456")){
                    editor= pref.edit();
                    if (rememberCheck.isChecked()){
                        editor.putString("account",account);
                        editor.putString("password",password);
                        editor.putBoolean("remember_check",true);
                    }else {
                        editor.clear();
                    }
                        editor.apply();
                    Intent intent = new Intent(LoginActivity.this,FinishAcivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "account or password error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
