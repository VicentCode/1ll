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

public class ActivityVelo extends AppCompatActivity {
    String m_h = "Millas por hora";
    String p_s = "Pie por segundo";
    String m_s = "Metro por segundo";
    String k_s = "Kilómetro por hora";
    String n = "Nudo";
    String TAG = "--ALERT--";
    String unidad1, unidad2;
    Double resultado;

    String resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velo);
        initList();


    }

    private void initList() {
        ArrayList<Longitud_Item> mLongiList = new ArrayList<>();
        mLongiList.add(new Longitud_Item(p_s, R.drawable.metro));
        mLongiList.add(new Longitud_Item(m_h, R.drawable.km));
        mLongiList.add(new Longitud_Item(m_s, R.drawable.km));
        mLongiList.add(new Longitud_Item(k_s, R.drawable.km));
        mLongiList.add(new Longitud_Item(n, R.drawable.km));


        EditText conver = findViewById(R.id.edvel);
        EditText conver1 = findViewById(R.id.edVel2);
        Spinner spinnerLongi = findViewById(R.id.spinnerVel);
        Spinner spinnerLongi2 = findViewById(R.id.spinnerVel2);
        ImageButton del1 = findViewById(R.id.dellVel1);
        ImageButton del2 = findViewById(R.id.dellVel2);
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

        if (unidad1.equals(p_s) && unidad2.equals(p_s)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(p_s) && unidad2.equals(m_h)) {
            resultado = valor /1.467;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p_s) && unidad2.equals(m_s)) {
            resultado = valor /3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p_s) && unidad2.equals(k_s)) {
            resultado = valor *1.097;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p_s) && unidad2.equals(n)) {
            resultado = valor /1.688;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(m_h) && unidad2.equals(p_s)) {
            resultado = valor * 1.467 ;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(m_h) && unidad2.equals(k_s)) {
            resultado = valor *1.609;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(m_h) && unidad2.equals(n)) {
            resultado = valor /1.151;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m_h) && unidad2.equals(m_s)) {
            resultado = valor /2.237;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m_s) && unidad2.equals(p_s)) {
            resultado = valor *3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m_s) && unidad2.equals(m_h)) {
            resultado = valor *2.237;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(m_s) && unidad2.equals(k_s)) {
            resultado = valor *3.6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m_s) && unidad2.equals(n)) {
            resultado = valor *1.944;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(k_s) && unidad2.equals(p_s)) {
            resultado = valor /1.097;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(k_s) && unidad2.equals(m_h)) {
            resultado = valor /1.609;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(k_s) && unidad2.equals(m_s)) {
            resultado = valor /3.6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(k_s) && unidad2.equals(n)) {
            resultado = valor /1.852;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(n) && unidad2.equals(p_s)) {
            resultado = valor *1.688;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(n) && unidad2.equals(m_h)) {
            resultado = valor *1.151;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(n) && unidad2.equals(m_s)) {
            resultado = valor /1.944;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(n) && unidad2.equals(k_s)) {
            resultado = valor *1.852;
            showED.setText(resultados = String.valueOf(resultado));

        }
    }

    public void converteED1 (Double valor, EditText showED) {

        if (unidad2.equals(p_s) && unidad1.equals(p_s)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(p_s) && unidad1.equals(m_h)) {
            resultado = valor /1.467;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p_s) && unidad1.equals(m_s)) {
            resultado = valor /3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p_s) && unidad1.equals(k_s)) {
            resultado = valor *1.097;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p_s) && unidad1.equals(n)) {
            resultado = valor /1.688;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(m_h) && unidad1.equals(p_s)) {
            resultado = valor * 1.467 ;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(m_h) && unidad1.equals(k_s)) {
            resultado = valor *1.609;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(m_h) && unidad1.equals(n)) {
            resultado = valor /1.151;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m_h) && unidad1.equals(m_s)) {
            resultado = valor /2.237;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m_s) && unidad1.equals(p_s)) {
            resultado = valor *3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m_s) && unidad1.equals(m_h)) {
            resultado = valor *2.237;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(m_s) && unidad1.equals(k_s)) {
            resultado = valor *3.6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m_s) && unidad1.equals(n)) {
            resultado = valor *1.944;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(k_s) && unidad1.equals(p_s)) {
            resultado = valor /1.097;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(k_s) && unidad1.equals(m_h)) {
            resultado = valor /1.609;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(k_s) && unidad1.equals(m_s)) {
            resultado = valor /3.6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(k_s) && unidad1.equals(n)) {
            resultado = valor /1.852;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(n) && unidad1.equals(p_s)) {
            resultado = valor *1.688;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(n) && unidad1.equals(m_h)) {
            resultado = valor *1.151;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(n) && unidad1.equals(m_s)) {
            resultado = valor /1.944;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(n) && unidad1.equals(k_s)) {
            resultado = valor *1.852;
            showED.setText(resultados = String.valueOf(resultado));

        }
    }

}