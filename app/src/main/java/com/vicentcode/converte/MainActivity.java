package com.vicentcode.converte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Longitud_Item> mLongiList;
    private LongitudAdapter mAdapter;
    String valorED;
    String km = "Kilometros";
    String mtros = "Metros";
    String cm = "Centimetros";
    String unidad1, unidad2;
    Double valorINT, resultado;
    String resultados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

    }

    private void initList() {
        mLongiList = new ArrayList<>();
        mLongiList.add(new Longitud_Item(mtros, R.drawable.metro));
        mLongiList.add(new Longitud_Item(km, R.drawable.km));
        mLongiList.add(new Longitud_Item(cm, R.drawable.km));

        Button btnLongi = findViewById(R.id.btnCon);
        EditText conver = findViewById(R.id.edLong);
        TextView txtResult = findViewById(R.id.showResultaod);
        Spinner spinnerLongi = findViewById(R.id.spinnerLongi);
        Spinner spinnerLongi2 = findViewById(R.id.spinnerLongi2);
        mAdapter = new LongitudAdapter(this, mLongiList);



        spinnerLongi.setAdapter(mAdapter);
        spinnerLongi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Longitud_Item clickedItem = (Longitud_Item) parent.getItemAtPosition(position);
                String unidadSP1 = clickedItem.getLongiName();
                if(unidadSP1.equals(cm)){
                    unidad1 = cm;
                }else if (unidadSP1.equals(km)) {
                    unidad1 = km;
                }else if (unidadSP1.equals(mtros)) {
                    unidad1 = mtros;
                }

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
                String unidadSP2 = clickedItem.getLongiName();
                if(unidadSP2.equals(cm)){
                    unidad2 = cm;
                }else if (unidadSP2.equals(km)) {
                    unidad2 = km;
                }else if (unidadSP2.equals(mtros)) {
                    unidad2 = mtros;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        conver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorED = conver.getText().toString();
                valorINT = Double.valueOf(valorED);
                converte(valorINT, txtResult);
                conver.setText("123456");
            }
        });

    }

    public void converte (Double valor, TextView showTXT) {

        if (unidad1.equals(mtros) && unidad2.equals(mtros)) {
            resultado = valor;
            showTXT.setText(resultados = String.valueOf(resultado) + " m");

        } else if (unidad1.equals(mtros) && unidad2.equals(km)) {
            resultado = valor / 1000;
            showTXT.setText(resultados = String.valueOf(resultado) + " km");

        }else if (unidad1.equals(mtros) && unidad2.equals(cm)) {
            resultado = valor * 100;
            showTXT.setText(resultados = String.valueOf(resultado) + " cm");

        }else if (unidad1.equals(km) && unidad2.equals(mtros)) {
            resultado = valor * 1000;
            showTXT.setText(resultados = String.valueOf(resultado) + " m");

        }else if (unidad1.equals(km) && unidad2.equals(cm)) {
            resultado = valor * 100000;
            showTXT.setText(resultados = String.valueOf(resultado) + " cm");

        }else if (unidad1.equals(cm) && unidad2.equals(mtros)) {
            resultado = valor / 100;
            showTXT.setText(resultados = String.valueOf(resultado) + " m");

        }else if (unidad1.equals(cm) && unidad2.equals(km)) {
            resultado = valor / 100000;
            showTXT.setText(resultados = String.valueOf(resultado) + " km");

        }
    }
}