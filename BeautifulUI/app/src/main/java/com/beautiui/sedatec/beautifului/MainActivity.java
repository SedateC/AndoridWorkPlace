package com.beautiui.sedatec.beautifului;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputTest;
    private Button send;
    private RecyclerView msgMRecyclerView;
    private MsgAdapter msgAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        inputTest = (EditText) findViewById(R.id.input_text);
        send =(Button)findViewById(R.id.send);
        msgMRecyclerView=(RecyclerView)findViewById(R.id.msg_recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msgMRecyclerView.setLayoutManager(linearLayoutManager); //注意设置布局管理器  消息布局适配器
        msgAdapter = new MsgAdapter(msgList);
        msgMRecyclerView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MESSAGE", "you click this");
                String content = inputTest.getText().toString();
                Log.d("MESSAGE", content);
            if (!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    Log.d("MESSAGE", msg.getContent());
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size()-1); //当有新消息时候刷新演示
                    msgMRecyclerView.scrollToPosition(msgList.size()-1);//将LISTVIEW定位到最后一行
                    inputTest.setText("");
                }
            }
        });
    }

    private  void initMsg (){
        Msg msg1 = new Msg("hellow guy",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 =new Msg("hellow what are you sad?",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 =new Msg("hellow WOWO I said",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

}
