package com.midimistromedia.hw1;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    private int mainActivityCount=0;
    private int request_Code=1;
    private TextView myCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCount = findViewById(R.id.textView);

        Button to2ndActivity = findViewById(R.id.button);
        to2ndActivity.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent secondAct = new Intent("com.android.main.SecondActivity");
                        //secondAct.putExtra("mainActivityCount",mainActivityCount);
                        startActivity(secondAct);
                    }
                }
        );

        Button clearCount = findViewById(R.id.button3);
        clearCount.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainActivityCount=0;
                        myCount.setText(Integer.toString(mainActivityCount));
                    }
                }
        );
    }

    public void onRestart(){
        super.onRestart();
        mainActivityCount++;
        myCount.setText(Integer.toString(mainActivityCount));
        Log.d("MainActivityCount",Integer.toString(mainActivityCount));
    }
}
