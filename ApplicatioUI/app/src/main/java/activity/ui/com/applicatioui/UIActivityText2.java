package activity.ui.com.applicatioui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UIActivityText2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.includetitle_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
       // setContentView(R.layout.relative_text1);
       // setContent    View(R.layout.relative_text2);
       //setContentView(R.layout.precent_layout);
    }
}
