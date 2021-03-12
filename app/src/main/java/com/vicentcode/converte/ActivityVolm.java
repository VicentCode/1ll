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

public class ActivityVolm extends AppCompatActivity {
    String mc = "Metro cubico";
    String l = "Litro";
    String ml = "Mililitro";
    String pc = "Pie cubico";
    String pilc = "Pulgada cubica";
    String TAG = "--ALERT--";
    String unidad1, unidad2;
    Double resultado;

    String resultados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volm);
        initList();


    }

    private void initList() {
        ArrayList<Longitud_Item> mLongiList = new ArrayList<>();
        mLongiList.add(new Longitud_Item(l, R.drawable.metro));
        mLongiList.add(new Longitud_Item(mc, R.drawable.km));
        mLongiList.add(new Longitud_Item(ml, R.drawable.km));
        mLongiList.add(new Longitud_Item(pc, R.drawable.km));
        mLongiList.add(new Longitud_Item(pilc, R.drawable.km));


        EditText conver = findViewById(R.id.edvoll);
        EditText conver1 = findViewById(R.id.edVol2);
        Spinner spinnerLongi = findViewById(R.id.spinnerVoll);
        Spinner spinnerLongi2 = findViewById(R.id.spinnerVol2);
        ImageButton del1 = findViewById(R.id.dellVol1);
        ImageButton del2 = findViewById(R.id.dellVol2);
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
            if (conver.getText().toString().isEmpty()) {
                Log.e(TAG, "Hola bb, ED == null String, Alert");
            } else {
                converteED(Double.parseDouble(String.valueOf(conver.getText())), conver1);
            }

        });
        conver1.setOnClickListener(v -> {

            if (conver1.getText().toString().isEmpty()) {
                Log.e(TAG, "Hola bb, ED == null String, Alert");
            } else {
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


    public void converteED(Double valor, EditText showED) {

        if (unidad1.equals(l) && unidad2.equals(l)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(l) && unidad2.equals(mc)) {
            resultado = valor / 1000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(l) && unidad2.equals(ml)) {
            resultado = valor * 1000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(l) && unidad2.equals(pc)) {
            resultado = valor / 28.317;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(l) && unidad2.equals(pilc)) {
            resultado = valor * 61.024;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(mc) && unidad2.equals(l)) {
            resultado = valor * 1000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(mc) && unidad2.equals(pc)) {
            resultado = valor * 35.315;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(mc) && unidad2.equals(pilc)) {
            resultado = valor * 61024;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(mc) && unidad2.equals(ml)) {
            resultado = valor * 2.237;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(ml) && unidad2.equals(l)) {
            resultado = valor / 1000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(ml) && unidad2.equals(mc)) {
            resultado = valor / 1e+6;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad1.equals(ml) && unidad2.equals(pc)) {
            resultado = valor / 28317;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(ml) && unidad2.equals(pilc)) {
            resultado = valor / 16.387;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad1.equals(pc) && unidad2.equals(l)) {
            resultado = valor * 28.317;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(pc) && unidad2.equals(mc)) {
            resultado = valor / 35.315;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad1.equals(pc) && unidad2.equals(ml)) {
            resultado = valor * 28317;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(pc) && unidad2.equals(pilc)) {
            resultado = valor * 1728;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad1.equals(pilc) && unidad2.equals(l)) {
            resultado = valor / 61.024;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(pilc) && unidad2.equals(mc)) {
            resultado = valor / 61024;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad1.equals(pilc) && unidad2.equals(ml)) {
            resultado = valor * 16.387;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(pilc) && unidad2.equals(pc)) {
            resultado = valor / 1728;
            showED.setText(resultados = String.valueOf(resultado));
        }
    }

    public void converteED1(Double valor, EditText showED) {

        if (unidad2.equals(l) && unidad1.equals(l)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(l) && unidad1.equals(mc)) {
            resultado = valor / 1000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(l) && unidad1.equals(ml)) {
            resultado = valor * 1000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(l) && unidad1.equals(pc)) {
            resultado = valor / 28.317;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(l) && unidad1.equals(pilc)) {
            resultado = valor * 61.024;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(mc) && unidad1.equals(l)) {
            resultado = valor * 1000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(mc) && unidad1.equals(pc)) {
            resultado = valor * 35.315;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(mc) && unidad1.equals(pilc)) {
            resultado = valor * 61024;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(mc) && unidad1.equals(ml)) {
            resultado = valor * 2.237;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(ml) && unidad1.equals(l)) {
            resultado = valor / 1000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(ml) && unidad1.equals(mc)) {
            resultado = valor / 1e+6;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad2.equals(ml) && unidad1.equals(pc)) {
            resultado = valor / 28317;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(ml) && unidad1.equals(pilc)) {
            resultado = valor / 16.387;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad2.equals(pc) && unidad1.equals(l)) {
            resultado = valor * 28.317;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(pc) && unidad1.equals(mc)) {
            resultado = valor / 35.315;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad2.equals(pc) && unidad1.equals(ml)) {
            resultado = valor * 28317;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(pc) && unidad1.equals(pilc)) {
            resultado = valor * 1728;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad2.equals(pilc) && unidad1.equals(l)) {
            resultado = valor / 61.024;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(pilc) && unidad1.equals(mc)) {
            resultado = valor / 61024;
            showED.setText(resultados = String.valueOf(resultado));
        } else if (unidad2.equals(pilc) && unidad1.equals(ml)) {
            resultado = valor * 16.387;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(pilc) && unidad1.equals(pc)) {
            resultado = valor / 1728;
            showED.setText(resultados = String.valueOf(resultado));

        }
    }
}
