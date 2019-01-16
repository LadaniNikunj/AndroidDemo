package com.example.admin.testapp1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.admin.testapp1.R.id.textView;

public class Button1Activity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();

        if(intent!=null){
            String data = intent.getStringExtra("data");
            Log.d("DEMO",data);
            textView.setText(data);
        }
    }

    public void process(View view) {
        Intent intent =null, chooser = null;

        if(view.getId() == R.id.launchMap) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.8777"));

            chooser = Intent.createChooser(intent, "Launch Maps");
            startActivity(chooser);
        }
        if(view.getId() == R.id.launchMarket) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.techgrains.gosurvey&hl=en"));

            chooser = Intent.createChooser(intent, "Launch Market");
            startActivity(chooser);
        }
        if(view.getId() == R.id.sendEmail) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto"));

            String[] to = {"nikunj.ladani@techgrains.com", "karan.patel@techgrains.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hi, this was sent from my app");
            intent.putExtra(Intent.EXTRA_TEXT, "Hey whats up, how you doing? this is my first email message");
            intent.setType("message/rfc822");

            chooser = Intent.createChooser(intent, "Send Email");
            startActivity(chooser);
        }

        if(view.getId() == R.id.sendImage) {
            Uri imageUri = Uri.parse("android.source://com.example.admin.testapp1/mipmap/ic_launcher/"+R.mipmap.ic_launcher);
            Log.d("DEMO", "imageUri : " + imageUri);

            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.putExtra(Intent.EXTRA_TEXT, "Hey I have attached this image");


            chooser = Intent.createChooser(intent, "Send Image");
            startActivity(chooser);
        }
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Hello from app", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER, 100, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
