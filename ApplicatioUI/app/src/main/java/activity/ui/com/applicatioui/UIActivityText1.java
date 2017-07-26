package activity.ui.com.applicatioui;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class UIActivityText1 extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    ImageView imageView;
    ProgressBar progressBar;
    String imageid = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uitext1_layout);
        Button start2Activity = (Button)findViewById(R.id.button_start2);
        Button editButton = (Button)findViewById(R.id.EditButton);
        Button chuanImage  = (Button)findViewById(R.id.chuangImage);
        start2Activity.setOnClickListener(this);
        editButton.setOnClickListener(this);
        chuanImage.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.EditText1);
        imageView = (ImageView)findViewById(R.id.image1);
        Button progressHideAndShow = (Button)findViewById(R.id.progressHideAndShow);
        progressHideAndShow.setOnClickListener(this);
        Button ProgressBarBtn2 = (Button)findViewById(R.id.ProgressBarBtn2);
        ProgressBarBtn2.setOnClickListener(this);
        Button dialogbutton = (Button)findViewById(R.id.DialogButton);
        dialogbutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start2:
                Intent intent = new Intent(UIActivityText1.this,UIActivityText2.class);
                Toast.makeText(UIActivityText1.this,"onclick start 2",Toast.LENGTH_SHORT);
                startActivity(intent);
                break;
            case R.id.EditButton:
                String text = editText.getText().toString();
                Toast.makeText(UIActivityText1.this,text,Toast.LENGTH_SHORT).show();
                break;
            case R.id.chuangImage:
                if (imageid.equals("1")){
                imageView.setImageResource(R.drawable.a03a);
                    imageid="0";
                }else {
                    imageView.setImageResource(R.drawable.a02a);
                    imageid="1";
                }
                break;
            case R.id.progressHideAndShow:
                ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar1);
                if (progressBar.getVisibility() == View.VISIBLE){
                    progressBar.setVisibility(View.GONE);
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ProgressBarBtn2:

                ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
                int pos = progressBar2.getProgress();
                if (pos==100){
                    progressBar2.setProgress(0);
                }else if (pos!=100){
                    pos = pos+10;
                    progressBar2.setProgress(pos);
                }
                break;
            case R.id.DialogButton:
/*                ProgressDialog dialog = new ProgressDialog(UIActivityText1.this);
                dialog.setMessage("this is someting important");
                dialog.setTitle("The dialog");
                dialog.setCancelable(true);*/

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(UIActivityText1.this);
                alertDialog.setTitle("this is AletDialog");
                alertDialog.setMessage("someting important");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
                break;
            default:
                break;
        }
    }
}
