package com.vicentcode.converte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PrincipalActivit extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        CardView cardMasa = findViewById(R.id.cardMasa);
        CardView cardTemp = findViewById(R.id.cardTemp);
        CardView CardLongi = findViewById(R.id.cardlongi);


        CardLongi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivit.this, MainActivity.class);
                PrincipalActivit.this.startActivity(intent);
            }
        });
        cardTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivit.this, TempActivity.class);
                PrincipalActivit.this.startActivity(intent);
            }
        });

        cardMasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(PrincipalActivit.this, MassActivity.class);
                PrincipalActivit.this.startActivity(intent);
            }
        });


    }
}