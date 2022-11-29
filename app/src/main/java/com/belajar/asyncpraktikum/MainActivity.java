package com.belajar.asyncpraktikum;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String DEMO_ASYNC = "DemoAsync";
    // deklarasi type component
    private TextView tv_status;
    private ProgressBar pb;
    private  Button bt_start;
    AsyncTask at;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisiasi
        tv_status = findViewById(R.id.tv_status);
        bt_start = findViewById(R.id.bt_start);
        pb = findViewById(R.id.pb);

        // logika click button start progrss
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inisialisasi Class AscyncTask
                AscyncTask ac = new AscyncTask(MainActivity.this,pb);
                // menjalankan class / background thread
                ac.execute();
            }
        });


    }


    public void toSecondActivity(View view) {
        startActivity(new Intent(MainActivity.this,MainActivity2.class));
    }
}
