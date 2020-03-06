package com.zhoushirui.lab06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.content.SharedPreferences;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    ImageView cookie;
    TextView counter;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cookie = findViewById(R.id.big_cookie);
        counter = findViewById(R.id.cookie_counter);
        sharedPreferences = getSharedPreferences("cc", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        counter.setText(sharedPreferences.getInt("cookies", 0) + " cookies");
        cookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = sharedPreferences.getInt("cookies", 0) + 1;
                editor.putInt("cookies", temp);
                editor.apply();
                counter.setText(temp + " cookies");
                Handler handler = new Handler();
                ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) cookie.getLayoutParams();
                lp.height = (int)(lp.height * 1.1);
                lp.width = (int)(lp.height * 1.1);
                cookie.setLayoutParams(lp);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) cookie.getLayoutParams();
                        lp.height = (int)(lp.height * 100.0/110.0);
                        lp.width = (int)(lp.height * 100.0/110.0);
                        cookie.setLayoutParams(lp);
                    }
                }, 100);
            }
        });
    }
}
