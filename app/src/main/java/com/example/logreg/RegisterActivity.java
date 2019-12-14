package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btnreg,btnvissza;
    private EditText email,felhnev,jelszo,teljNev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        btnvissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().trim().equals("")
                && felhnev.getText().toString().trim().equals("")
                && jelszo.getText().toString().trim().equals("")
                && teljNev.getText().toString().trim().equals(""))
                {
                    Toast.makeText(RegisterActivity.this,"Nincs kitöltve minden mező! Sikertelen regisztráció!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Toast.makeText(RegisterActivity.this,"Sikeres regisztráció",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    public void init()
    {
        btnreg=findViewById(R.id.RegisztracioBTN);
        btnvissza=findViewById(R.id.VisszaBTN);
        email=findViewById(R.id.emailET);
        felhnev=findViewById(R.id.felhET);
        jelszo=findViewById(R.id.jelszoET);
        teljNev=findViewById(R.id.TNevET);
    }
}
