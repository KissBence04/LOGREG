package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnbe,btnreg;
    private EditText felhnev,jelszo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(felhnev.getText().toString().trim().equals("") && jelszo.getText().toString().trim().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Nem töltött ki minden mezőt!",Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences sharedPreferences = getSharedPreferences("Adatok", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nev", felhnev.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,LoggedInActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void init()
    {
        btnbe=findViewById(R.id.BejelBTN);
        btnreg=findViewById(R.id.RegBTN);
        felhnev=findViewById(R.id.FelhET);
        jelszo=findViewById(R.id.JelszoET);
    }



}
