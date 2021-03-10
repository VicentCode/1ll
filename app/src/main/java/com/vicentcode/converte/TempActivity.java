package com.vicentcode.converte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class TempActivity extends AppCompatActivity {
    String c = "Celsius ";
    String f = "Fahrenheit";
    String k = "Kelvin ";
    String TAG = "--ALERT--";
    String unidad1, unidad2;
    Double resultado;
    String resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        initList();


    }

    private void initList() {
        ArrayList<Longitud_Item> mLongiList = new ArrayList<>();
        mLongiList.add(new Longitud_Item(f, R.drawable.metro));
        mLongiList.add(new Longitud_Item(c, R.drawable.km));
        mLongiList.add(new Longitud_Item(k, R.drawable.km));

        EditText conver = findViewById(R.id.edTemp);
        EditText conver1 = findViewById(R.id.edTemp2);
        Spinner spinnerLongi = findViewById(R.id.spinnerTemp);
        Spinner spinnerLongi2 = findViewById(R.id.spinnerTemp2);
        ImageButton del1 = findViewById(R.id.dellTemp1);
        ImageButton del2 = findViewById(R.id.dellTemp2);
        LongitudAdapter mAdapter = new LongitudAdapter(this, mLongiList);



        spinnerLongi.setAdapter(mAdapter);
        spinnerLongi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Longitud_Item clickedItem = (Longitud_Item) parent.getItemAtPosition(position);
                unidad1 = clickedItem.getLongiName();



               /* btnLongi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        valorED = conver.getText().toString();
                        valorINT = Double.valueOf(valorED);
                        converte(valorINT, txtResult);
                        conver.setText("123456");
                    }
                });*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        spinnerLongi2.setAdapter(mAdapter);
        spinnerLongi2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Longitud_Item clickedItem = (Longitud_Item) parent.getItemAtPosition(position);
                unidad2 = clickedItem.getLongiName();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        conver.setOnClickListener(v -> {
            if(conver.getText().toString().isEmpty()) {
                Log.e(TAG, "Hola bb, ED == null String, Alert");
            }else{
                converteED(Double.parseDouble(String.valueOf(conver.getText())), conver1);
            }

        });
        conver1.setOnClickListener(v -> {

            if(conver1.getText().toString().isEmpty()) {
                Log.e(TAG, "Hola bb, ED == null String, Alert");
            }else{
                converteED1(Double.parseDouble(String.valueOf(conver1.getText())), conver);
            }
        });

        del1.setOnClickListener(v -> {
            conver.getText().clear();
            conver1.getText().clear();
        });
        del2.setOnClickListener(v -> {
            conver1.getText().clear();
            conver.getText().clear();
        });





    }



    public void converteED (Double valor, EditText showED) {

        if (unidad1.equals(f) && unidad2.equals(f)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(f) && unidad2.equals(c)) {
            resultado = (valor-32 ) * 5/9;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(f) && unidad2.equals(k)) {
            resultado = (valor - 32) + 5/9 + 273.15;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(c) && unidad2.equals(f)) {
            resultado = (valor * 9/5) + 32 ;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(c) && unidad2.equals(k)) {
            resultado = valor +273.15 ;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(k) && unidad2.equals(f)) {
            resultado = (valor -273.15) * 9/5 + 32;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(k) && unidad2.equals(c)) {
            resultado = valor -273.15;
            showED.setText(resultados = String.valueOf(resultado));

        }
    }

    public void converteED1 (Double valor, EditText showED) {

        if (unidad2.equals(f) && unidad1.equals(f)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(f) && unidad1.equals(c)) {
            resultado = (valor-32 ) * 5/9;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(f) && unidad1.equals(k)) {
            resultado = (valor - 32) + 5/9 + 273.15;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(c) && unidad1.equals(f)) {
            resultado = (valor * 9/5) + 32 ;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(c) && unidad1.equals(k)) {
            resultado = valor +273.15 ;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(k) && unidad1.equals(f)) {
            resultado = (valor -273.15) * 9/5 + 32;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(k) && unidad1.equals(c)) {
            resultado = valor -273.15;
            showED.setText(resultados = String.valueOf(resultado));

        }
    }

}