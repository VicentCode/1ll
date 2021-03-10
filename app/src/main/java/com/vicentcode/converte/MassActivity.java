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

public class MassActivity extends AppCompatActivity {
    String t = "Tonelada";
    String Kg = "Kilogramo";
    String g = "Gramos";
    String ib = "Libras";
    String oz = "Onzas";
    String mg = "miligramo";
    String TAG = "--ALERT--";
    String unidad1, unidad2;
    Double resultado;
    String resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        initList();
    }



    private void initList() {
        ArrayList<Longitud_Item> mLongiList = new ArrayList<>();
        mLongiList.add(new Longitud_Item(t, R.drawable.metro));
        mLongiList.add(new Longitud_Item(Kg, R.drawable.km));
        mLongiList.add(new Longitud_Item(g, R.drawable.km));
        mLongiList.add(new Longitud_Item(ib, R.drawable.km));
        mLongiList.add(new Longitud_Item(oz, 0));
        mLongiList.add(new Longitud_Item(mg, 0));

        EditText conver = findViewById(R.id.edMass);
        EditText conver1 = findViewById(R.id.edMass2);
        Spinner spinnerLongi = findViewById(R.id.spinnerMass);
        Spinner spinnerLongi2 = findViewById(R.id.spinnerMass2);
        ImageButton del1 = findViewById(R.id.delMass1);
        ImageButton del2 = findViewById(R.id.delMass2);
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

            if (unidad1.equals(Kg) && unidad2.equals(Kg)) {
                resultado = valor;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad1.equals(Kg) && unidad2.equals(t)) {
                resultado = valor / 1000;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(Kg) && unidad2.equals(mg)) {
                resultado = valor*1e+6;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(Kg) && unidad2.equals(ib)) {
                resultado = valor*2.205;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(Kg) && unidad2.equals(oz)) {
                resultado = valor*35.274;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(Kg) && unidad2.equals(g)) {
                resultado = valor * 1000;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad1.equals(t) && unidad2.equals(Kg)) {
                resultado = valor * 1000;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(t) && unidad2.equals(oz)) {
                resultado = valor * 35274;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(t) && unidad2.equals(ib)) {
                resultado = valor * 2205;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(t) && unidad2.equals(mg)) {
                resultado = valor * 1e+9;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad1.equals(t) && unidad2.equals(g)) {
                resultado = valor * 1e+6;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad1.equals(g) && unidad2.equals(Kg)) {
                resultado = valor / 1000;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(g) && unidad2.equals(oz)) {
                resultado = valor / 28.35;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad1.equals(g) && unidad2.equals(ib)) {
                resultado = valor / 454;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(g) && unidad2.equals(t)) {
                resultado = valor / 1e+6;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(g) && unidad2.equals(mg)) {
                resultado = valor * 1000;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad1.equals(mg) && unidad2.equals(Kg)) {
                resultado = valor / 1e+6;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad1.equals(mg) && unidad2.equals(t)) {
                resultado = valor / 1e+9;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad1.equals(mg) && unidad2.equals(g)) {
                resultado = valor / 1000;
                showED.setText(resultados = String.valueOf(resultado));

            }  else if (unidad1.equals(mg) && unidad2.equals(oz)) {
                resultado = valor /28350;
                showED.setText(resultados = String.format(String.valueOf( resultado),"%.5f" ));

            } else if (unidad1.equals(mg) && unidad2.equals(ib)) {
                resultado = valor / 453592;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(oz) && unidad2.equals(Kg)) {
                resultado = valor / 35.274;
                showED.setText(resultados = String.valueOf(resultado));

            }
            else if (unidad1.equals(oz) && unidad2.equals(t)) {
                resultado = valor / 35274;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(oz) && unidad2.equals(ib)) {
                resultado = valor /16;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(oz) && unidad2.equals(mg)) {
                resultado = valor /28350;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(oz) && unidad2.equals(g)) {
                resultado = valor * 28.35;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(ib) && unidad2.equals(Kg)) {
                resultado = valor /2.205;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(ib) && unidad2.equals(t)) {
                resultado = valor /2205;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(ib) && unidad2.equals(oz)) {
                resultado = valor *16;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(ib) && unidad2.equals(mg)) {
                resultado = valor *453592;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad1.equals(ib) && unidad2.equals(g)) {
                resultado = valor /454;
                showED.setText(resultados = String.valueOf(resultado));

            }
        }

        public void converteED1 (Double valor, EditText showED) {


            if (unidad2.equals(Kg) && unidad1.equals(Kg)) {
                resultado = valor;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad2.equals(Kg) && unidad1.equals(t)) {
                resultado = valor / 1000;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(Kg) && unidad1.equals(mg)) {
                resultado = valor*1e+6;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(Kg) && unidad1.equals(ib)) {
                resultado = valor*2.205;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(Kg) && unidad1.equals(oz)) {
                resultado = valor*35.274;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(Kg) && unidad1.equals(g)) {
                resultado = valor * 1000;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad2.equals(t) && unidad1.equals(Kg)) {
                resultado = valor * 1000;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(t) && unidad1.equals(oz)) {
                resultado = valor * 35274;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(t) && unidad1.equals(ib)) {
                resultado = valor * 2205;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(t) && unidad1.equals(mg)) {
                resultado = valor * 1e+9;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad2.equals(t) && unidad1.equals(g)) {
                resultado = valor * 1e+6;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad2.equals(g) && unidad1.equals(Kg)) {
                resultado = valor / 1000;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(g) && unidad1.equals(oz)) {
                resultado = valor / 28.35;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad2.equals(g) && unidad1.equals(ib)) {
                resultado = valor / 454;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(g) && unidad1.equals(t)) {
                resultado = valor / 1e+6;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(g) && unidad1.equals(mg)) {
                resultado = valor * 1000;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad2.equals(mg) && unidad1.equals(Kg)) {
                resultado = valor / 1e+6;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad2.equals(mg) && unidad1.equals(t)) {
                resultado = valor / 1e+9;
                showED.setText(resultados = String.valueOf(resultado));

            } else if (unidad2.equals(mg) && unidad1.equals(g)) {
                resultado = valor / 1000;
                showED.setText(resultados = String.valueOf(resultado));

            }  else if (unidad2.equals(mg) && unidad1.equals(oz)) {
                resultado = valor /28350;
                showED.setText(resultados = String.format(String.valueOf( resultado),"%.5f" ));

            } else if (unidad2.equals(mg) && unidad1.equals(ib)) {
                resultado = valor / 453592;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(oz) && unidad1.equals(Kg)) {
                resultado = valor / 35.274;
                showED.setText(resultados = String.valueOf(resultado));

            }
            else if (unidad2.equals(oz) && unidad1.equals(t)) {
                resultado = valor / 35274;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(oz) && unidad1.equals(ib)) {
                resultado = valor /16;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(oz) && unidad1.equals(mg)) {
                resultado = valor /28350;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(oz) && unidad1.equals(g)) {
                resultado = valor * 28.35;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(ib) && unidad1.equals(Kg)) {
                resultado = valor /2.205;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(ib) && unidad1.equals(t)) {
                resultado = valor /2205;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(ib) && unidad1.equals(oz)) {
                resultado = valor *16;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(ib) && unidad1.equals(mg)) {
                resultado = valor *453592;
                showED.setText(resultados = String.valueOf(resultado));

            }else if (unidad2.equals(ib) && unidad1.equals(g)) {
                resultado = valor / 454;
                showED.setText(resultados = String.valueOf(resultado));
            }


        }

    }