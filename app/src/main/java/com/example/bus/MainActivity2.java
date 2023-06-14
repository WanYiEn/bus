package com.example.bus;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView v11;
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity2_main);
        v11=findViewById(R.id.t1);
    }



}
