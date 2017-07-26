package autologin.weixinserver.com.weixinserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
;    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
        case R.id.button_1:
          Intent startiIntent = new Intent(this,LoginService.class);
            startService(startiIntent);
          break;
        case R.id.button_2:
            Intent stopIntent = new Intent(this,LoginService.class);
            stopService(stopIntent);
            break;
          default:
              break;
      }
    }
}
