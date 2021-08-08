package com.example.progressbarthread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {
    private Button mbtnstart;
    private CircularProgressIndicator indicator;


    private Handler mainhandler=  mainhandler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int progress= (int) msg.obj;
            indicator.setProgress(progress);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicator=findViewById(R.id.progressbar);
        mbtnstart=findViewById(R.id.btnstart);
        mbtnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkerThread workerThread=new WorkerThread("async",mainhandler);
                workerThread.start();

            }
        });
    }
}