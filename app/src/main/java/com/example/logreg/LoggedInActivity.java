package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private Button ki;
    private TextView adatok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();

        final SharedPreferences sharedPreferences = getSharedPreferences("Adatok", Context.MODE_PRIVATE);
        String seged = "";
        seged = sharedPreferences.getString("nev","nincs ilyen érték");
        adatok.setText("Üdvözöljük "+seged+" !");

        ki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoggedInActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
            }
        });
    }

    public void init()
    {
        ki=findViewById(R.id.KilepesBTN);
        adatok=findViewById(R.id.AdatokTw);
    }
}
