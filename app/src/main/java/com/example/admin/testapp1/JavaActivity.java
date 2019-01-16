package com.example.admin.testapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JavaActivity extends AppCompatActivity {

    LinearLayout ll;
    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ll = new LinearLayout(this);
        t = new TextView(this);
        b = new Button(this);

        LinearLayout.LayoutParams dimentions = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(dimentions);

        LinearLayout.LayoutParams viewDimentions = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        t.setLayoutParams(viewDimentions);
        b.setLayoutParams(viewDimentions);

        ll.setOrientation(LinearLayout.VERTICAL);
        t.setText("Hello World");
        b.setText("Button Here");

        setContentView(ll);
//        setContentView(R.layout.activity_java);
    }

}
