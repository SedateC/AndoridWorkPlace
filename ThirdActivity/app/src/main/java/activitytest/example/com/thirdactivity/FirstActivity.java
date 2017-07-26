package activitytest.example.com.thirdactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstlayout);
        Button button = (Button)findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent("example.com.thirdactivity.ACTION_START");
                startActivity(intent);*/

             /*   Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);*/
              /*  Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

            /*    String data  = "hellow this is the first messaage string";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("data",data);
                startActivity(intent);*/

                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);


            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returndata = data.getStringExtra("datareturn");
                    Log.d("message", returndata);
                }
                default:
                break ;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
        Toast.makeText(this, "you click add", Toast.LENGTH_SHORT).show();
            break;
            case R.id.close:
                finish();
            break;
            case R.id.delete_item:
                Toast.makeText(this,"you click delete",Toast.LENGTH_SHORT).show();

        default:
        }
        return true;
    }

}
