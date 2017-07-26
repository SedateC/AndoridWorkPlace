package activitytest.example.com.thirdactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button = (Button) findViewById(R.id.button_2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         /*       Intent intent = getIntent();
                final String data = intent.getStringExtra("data");
                Log.d("secondmessage",data);
                Toast.makeText(SecondActivity.this,data,Toast.LENGTH_SHORT).show();*/

                Intent intent = new Intent();
                intent.putExtra("datareturn","hellow firstActivity");
                setResult(RESULT_OK,intent);
                Log.d("message",String.valueOf(RESULT_OK));
                finish();

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("backmessage","hellow firstActivity turn back");
        setResult(RESULT_OK,intent);
        finish();
    }
}
