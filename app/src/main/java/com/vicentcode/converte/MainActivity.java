package com.vicentcode.converte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String km = "Kilometros";
    String mtros = "Metros";
    String cm = "Centimetros";
    String mm = "Milímetro";
    String in = "Pulgadas";
    String dm = "Decimetro";
    String p = "Pie";
    String m = "Milla";
    String y = "Yarda";
    String unidad1, unidad2;
    Double  resultado;
    String resultados;
    String TAG = "--ALERT--";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();


    }

    private void initList() {
        ArrayList<Longitud_Item> mLongiList = new ArrayList<>();
        mLongiList.add(new Longitud_Item(mtros, R.drawable.metro));
        mLongiList.add(new Longitud_Item(km, R.drawable.km));
        mLongiList.add(new Longitud_Item(cm, R.drawable.km));
        mLongiList.add(new Longitud_Item(dm, R.drawable.km));
        mLongiList.add(new Longitud_Item(mm, 0));
        mLongiList.add(new Longitud_Item(in,0));
        mLongiList.add(new Longitud_Item(p,0));
        mLongiList.add(new Longitud_Item(y,0));
        mLongiList.add(new Longitud_Item(m,0));

        EditText conver = findViewById(R.id.edLong);
        EditText conver1 = findViewById(R.id.edLong2);
        Spinner spinnerLongi = findViewById(R.id.spinnerLong);
        Spinner spinnerLongi2 = findViewById(R.id.spinnerLong2);
        ImageButton del1 = findViewById(R.id.delLong1);
        ImageButton del2 = findViewById(R.id.delLong2);
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

        if (unidad1.equals(mtros) && unidad2.equals(mtros)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(mtros) && unidad2.equals(km)) {
            resultado = valor / 1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mtros) && unidad2.equals(m)) {
            resultado = valor / 1609;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad1.equals(mtros) && unidad2.equals(p)) {
            resultado = valor *3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mtros) && unidad2.equals(dm)) {
            resultado = valor*10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mtros) && unidad2.equals(mm)) {
            resultado = valor*1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mtros) && unidad2.equals(in)) {
            resultado = valor*39.37;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mtros) && unidad2.equals(cm)) {
            resultado = valor * 100;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(km) && unidad2.equals(mtros)) {
            resultado = valor * 1000;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad1.equals(km) && unidad2.equals(m)) {
            resultado = valor /1.609;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad1.equals(km) && unidad2.equals(p)) {
            resultado = valor * 3281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(km) && unidad2.equals(y)) {
            resultado = valor *1094;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(mtros) && unidad2.equals(y)) {
            resultado = valor /1.094;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(km) && unidad2.equals(in)) {
            resultado = valor * 39370;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(km) && unidad2.equals(mm)) {
            resultado = valor * 1e+6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(km) && unidad2.equals(dm)) {
            resultado = valor * 10000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(km) && unidad2.equals(cm)) {
            resultado = valor * 100000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(cm) && unidad2.equals(mtros)) {
            resultado = valor / 100;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(cm) && unidad2.equals(m)) {
            resultado = valor / 160934;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(cm) && unidad2.equals(p)) {
            resultado = valor / 30.48;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(cm) && unidad2.equals(in)) {
            resultado = valor / 2.54;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(cm) && unidad2.equals(mm)) {
            resultado = valor * 10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(cm) && unidad2.equals(km)) {
            resultado = valor / 100000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(cm) && unidad2.equals(dm)) {
            resultado = valor / 10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(cm) && unidad2.equals(y)) {
            resultado = valor *91.44;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(dm) && unidad2.equals(mtros)) {
            resultado = valor / 10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(dm) && unidad2.equals(m)) {
            resultado = valor / 16093;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(dm) && unidad2.equals(p)) {
            resultado = valor / 3.048;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(dm) && unidad2.equals(km)) {
            resultado = valor / 10000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(dm) && unidad2.equals(cm)) {
            resultado = valor * 10;
            showED.setText(resultados = String.valueOf(resultado));

        }  else if (unidad1.equals(dm) && unidad2.equals(in)) {
            resultado = valor * 3.937;
            showED.setText(resultados = String.format(String.valueOf( resultado),"%.5f" ));

        }else if (unidad1.equals(dm) && unidad2.equals(y)) {
            resultado = valor *9.144;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(dm) && unidad2.equals(mm)) {
            resultado = valor * 100;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(in) && unidad2.equals(mtros)) {
            resultado = valor / 39.37;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(in) && unidad2.equals(p)) {
            resultado = valor / 12;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(in) && unidad2.equals(m)) {
            resultado = valor / 63360;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad1.equals(in) && unidad2.equals(km)) {
            resultado = valor / 39370;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(in) && unidad2.equals(mm)) {
            resultado = valor *25.4;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(in) && unidad2.equals(dm)) {
            resultado = valor /3.937;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(in) && unidad2.equals(cm)) {
            resultado = valor * 2.54;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mm) && unidad2.equals(mtros)) {
            resultado = valor /1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mm) && unidad2.equals(m)) {
            resultado = valor /1.609e+6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mm) && unidad2.equals(p)) {
            resultado = valor /305;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mm) && unidad2.equals(km)) {
            resultado = valor /1e+6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mm) && unidad2.equals(in)) {
            resultado = valor /25.4;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mm) && unidad2.equals(dm)) {
            resultado = valor /100;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mm) && unidad2.equals(cm)) {
            resultado = valor /10;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(p) && unidad2.equals(m)) {
            resultado = valor /3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p) && unidad2.equals(km)) {
            resultado = valor /3281;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad1.equals(mm) && unidad2.equals(y)) {
            resultado = valor *914;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p) && unidad2.equals(mtros)) {
            resultado = valor /3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p) && unidad2.equals(cm)) {
            resultado = valor /30.48;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p) && unidad2.equals(mm)) {
            resultado = valor *305;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p) && unidad2.equals(dm)) {
            resultado = valor /3.048;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p) && unidad2.equals(in)) {
            resultado = valor *12;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(p) && unidad2.equals(y)) {
            resultado = valor /3;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m) && unidad2.equals(km)) {
            resultado = valor *1.609;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m) && unidad2.equals(mtros)) {
            resultado = valor *1609;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m) && unidad2.equals(cm)) {
            resultado = valor *160934;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m) && unidad2.equals(mm)) {
            resultado = valor *1.609e+6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m) && unidad2.equals(dm)) {
            resultado = valor *16093;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(in) && unidad2.equals(y)) {
            resultado = valor *36;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m) && unidad2.equals(in)) {
            resultado = valor *63360;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(m) && unidad2.equals(y)) {
            resultado = valor *1760;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(m) && unidad2.equals(y)) {
            resultado = valor *1760;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(m) && unidad2.equals(p)) {
            resultado = valor *5280;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(y) && unidad2.equals(km)) {
            resultado = valor /1094;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(y) && unidad2.equals(mtros)) {
            resultado = valor /1.094;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(y) && unidad2.equals(cm)) {
            resultado = valor *91.44;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(y) && unidad2.equals(mm)) {
            resultado = valor *914;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(y) && unidad2.equals(dm)) {
            resultado = valor *9.144;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(y) && unidad2.equals(in)) {
            resultado = valor *36;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(y) && unidad2.equals(m)) {
            resultado = valor /1760;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(y) && unidad2.equals(p)) {
            resultado = valor * 3;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad1.equals(y) && unidad2.equals(p)) {
            resultado = valor / 3;
            showED.setText(resultados = String.valueOf(resultado));
        }
    }

    public void converteED1 (Double valor, EditText showED) {

        if (unidad2.equals(mtros) && unidad1.equals(mtros)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(mtros) && unidad1.equals(km)) {
            resultado = valor / 1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mtros) && unidad1.equals(m)) {
            resultado = valor / 1609;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad2.equals(mtros) && unidad1.equals(p)) {
            resultado = valor *3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mtros) && unidad1.equals(dm)) {
            resultado = valor*10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mtros) && unidad1.equals(mm)) {
            resultado = valor*1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mtros) && unidad1.equals(in)) {
            resultado = valor*39.37;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mtros) && unidad1.equals(cm)) {
            resultado = valor * 100;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(km) && unidad1.equals(mtros)) {
            resultado = valor * 1000;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad2.equals(km) && unidad1.equals(m)) {
            resultado = valor /1.609;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad2.equals(km) && unidad1.equals(p)) {
            resultado = valor * 3281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(km) && unidad1.equals(y)) {
            resultado = valor *1094;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(mtros) && unidad1.equals(y)) {
            resultado = valor /1.094;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(km) && unidad1.equals(in)) {
            resultado = valor * 39370;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(km) && unidad1.equals(mm)) {
            resultado = valor * 1e+6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(km) && unidad1.equals(dm)) {
            resultado = valor * 10000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(km) && unidad1.equals(cm)) {
            resultado = valor * 100000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(cm) && unidad1.equals(mtros)) {
            resultado = valor / 100;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(cm) && unidad1.equals(m)) {
            resultado = valor / 160934;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(cm) && unidad1.equals(p)) {
            resultado = valor / 30.48;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(cm) && unidad1.equals(in)) {
            resultado = valor / 2.54;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(cm) && unidad1.equals(mm)) {
            resultado = valor * 10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(cm) && unidad1.equals(km)) {
            resultado = valor / 100000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(cm) && unidad1.equals(dm)) {
            resultado = valor / 10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(cm) && unidad1.equals(y)) {
            resultado = valor *91.44;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(dm) && unidad1.equals(mtros)) {
            resultado = valor / 10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(dm) && unidad1.equals(m)) {
            resultado = valor / 16093;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(dm) && unidad1.equals(p)) {
            resultado = valor / 3.048;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(dm) && unidad1.equals(km)) {
            resultado = valor / 10000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(dm) && unidad1.equals(cm)) {
            resultado = valor * 10;
            showED.setText(resultados = String.valueOf(resultado));

        }  else if (unidad2.equals(dm) && unidad1.equals(in)) {
            resultado = valor * 3.937;
            showED.setText(resultados = String.format(String.valueOf( resultado),"%.5f" ));

        }else if (unidad2.equals(dm) && unidad1.equals(y)) {
            resultado = valor *9.144;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad2.equals(dm) && unidad1.equals(mm)) {
            resultado = valor * 100;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(in) && unidad1.equals(mtros)) {
            resultado = valor / 39.37;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(in) && unidad1.equals(p)) {
            resultado = valor / 12;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(in) && unidad1.equals(m)) {
            resultado = valor / 63360;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad2.equals(in) && unidad1.equals(km)) {
            resultado = valor / 39370;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(in) && unidad1.equals(mm)) {
            resultado = valor *25.4;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(in) && unidad1.equals(dm)) {
            resultado = valor /3.937;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(in) && unidad1.equals(cm)) {
            resultado = valor * 2.54;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mm) && unidad1.equals(mtros)) {
            resultado = valor /1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mm) && unidad1.equals(m)) {
            resultado = valor /1.609e+6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mm) && unidad1.equals(p)) {
            resultado = valor /305;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mm) && unidad1.equals(km)) {
            resultado = valor /1e+6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mm) && unidad1.equals(in)) {
            resultado = valor /25.4;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mm) && unidad1.equals(dm)) {
            resultado = valor /100;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mm) && unidad1.equals(cm)) {
            resultado = valor /10;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(p) && unidad1.equals(m)) {
            resultado = valor /3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p) && unidad1.equals(km)) {
            resultado = valor /3281;
            showED.setText(resultados = String.valueOf(resultado));

        }
        else if (unidad2.equals(mm) && unidad1.equals(y)) {
            resultado = valor *914;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p) && unidad1.equals(mtros)) {
            resultado = valor /3.281;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p) && unidad1.equals(cm)) {
            resultado = valor /30.48;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p) && unidad1.equals(mm)) {
            resultado = valor *305;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p) && unidad1.equals(dm)) {
            resultado = valor /3.048;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p) && unidad1.equals(in)) {
            resultado = valor *12;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(p) && unidad1.equals(y)) {
            resultado = valor /3;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m) && unidad1.equals(km)) {
            resultado = valor *1.609;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m) && unidad1.equals(mtros)) {
            resultado = valor *1609;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m) && unidad1.equals(cm)) {
            resultado = valor *160934;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m) && unidad1.equals(mm)) {
            resultado = valor *1.609e+6;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m) && unidad1.equals(dm)) {
            resultado = valor *16093;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(in) && unidad1.equals(y)) {
            resultado = valor *36;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m) && unidad1.equals(in)) {
            resultado = valor *63360;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(m) && unidad1.equals(y)) {
            resultado = valor *1760;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(m) && unidad1.equals(y)) {
            resultado = valor *1760;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(m) && unidad1.equals(p)) {
            resultado = valor *5280;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(y) && unidad1.equals(km)) {
            resultado = valor /1094;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(y) && unidad1.equals(mtros)) {
            resultado = valor /1.094;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(y) && unidad1.equals(cm)) {
            resultado = valor *91.44;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(y) && unidad1.equals(mm)) {
            resultado = valor *914;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(y) && unidad1.equals(dm)) {
            resultado = valor *9.144;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(y) && unidad1.equals(in)) {
            resultado = valor *36;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(y) && unidad1.equals(m)) {
            resultado = valor /1760;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(y) && unidad1.equals(p)) {
            resultado = valor * 3;
            showED.setText(resultados = String.valueOf(resultado));
        }else if (unidad2.equals(y) && unidad1.equals(p)) {
            resultado = valor / 3;
            showED.setText(resultados = String.valueOf(resultado));
        }
    }

}