package com.example.admin.testapp1;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("working");

        Log.d("DEMO", "onCreate was called");

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new VivzHandler());

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(o);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEMO", "Button 6 was clicked");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("DEMO", "onStart was called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DEMO", "onResume was called");

        counter++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DEMO", "onPause was called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("DEMO", "onStop was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("DEMO", "onRestart was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("DEMO", "onDestroy was called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counter", counter);
        Log.d("DEMO", counter+ " was saved");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        counter = savedInstanceState.getInt("counter");
        Log.d("DEMO", counter+ " was restored");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("DEMO", "orientation changed");
        Log.d("DEMO", ""+newConfig.orientation);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d("DEMO", "welcome to landscape mode");
        } else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("DEMO", "welcome to portraint mode");
        }
    }

    public void clickMe(View v) {
        if(v.getId() == R.id.button1) {
            Log.d("DEMO", "Button 1 was clicked");
            //Intent intent = new Intent(MainActivity.this,Button1Activity.class);
            Intent intent = new Intent();
            intent.setClassName("com.example.admin.testapp1", "com.example.admin.testapp1.Button1Activity");
            intent.putExtra("data","Button 1 clicked");
            startActivity(intent);
//            finish();
        } else if(v.getId() == R.id.button2) {
            Log.d("DEMO", "Button 2 was clicked");
            Intent intent = new Intent(MainActivity.this,JavaActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        Log.d("DEMO", "Button 3 was clicked");
    }

    class VivzHandler implements OnClickListener {

        @Override
        public void onClick(View v) {
            Log.d("DEMO", "Button 4 was clicked");
        }
    }

    OnClickListener o = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("DEMO", "Button 5 was clicked");
        }
    };
}
