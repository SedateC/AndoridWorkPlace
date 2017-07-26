package activitytest.example.com.activitylifecycletest;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button starNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity =(Button)findViewById(R.id.start_dialog_activity);
        Log.d("message","onCreate");

        if(savedInstanceState!=null){
            String data = savedInstanceState.getString("datakey");
            Log.d("message",data);
        }
        starNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just type";
        outState.putString("datakey",tempData);
        Log.d("message","put data into Bundle");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message","onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("message","Restart");
    }

}
