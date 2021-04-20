package com.example.tasbeehapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private TextView tv;
     private Button btn,save_btn,rtr_btn;
    int count=0;
     SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        save_btn = findViewById(R.id.save_btn);
        rtr_btn = findViewById(R.id.rtr_btn);
        sp = getSharedPreferences("name",MODE_PRIVATE);

    }

    public void btn(View view) {

        count++;
        tv.setText(""+count);

        }


    public void save_btn(View view) {
        if (view.getId() == R.id.save_btn) {
            String save = tv.getText().toString();
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("name",save);
            editor.commit();
            //tv.setText(""+count);
        } else if (view.getId() == R.id.rtr_btn) {
            String save = sp.getString("name","s1");
            tv.setText(""+save);
            //tv.setText(""+count);
        }
    }

}
