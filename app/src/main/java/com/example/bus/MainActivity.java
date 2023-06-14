package com.example.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView t1;
    private Button b1;
    private EditText t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        t1=findViewById(R.id.t1);

        t3=findViewById(R.id.t3);
        b1=findViewById(R.id.b1);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View kk) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url="http://bus.wuhancloud.cn:9087/website/web/420100/line/027-905-1.do?Type=LineDetail\n";
                HTTP a1=new HTTP();
                a1.get(url, new HTTP.CallBack() {
                    @Override
                    public void success(String s) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                t1.setText(s);
                            }
                        });
                    }

                    @Override
                    public void failure(String s) {

                    }
                });
            }
        }).start();

        Intent kk1=new Intent(MainActivity.this,MainActivity2.class);

        startActivity(kk1);

    }

}