package com.vicentcode.converte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Longitud_Item> mLongiList;
    private LongitudAdapter mAdapter;
    String valorED;
    String km = "Kilometros";
    String mtros = "Metros";
    String cm = "Centimetros";
    String mm = "Milímetro";
    String in = "Pulgadas";
    String dm = "Decimetro";

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
        mLongiList.add(new Longitud_Item(dm, R.drawable.km));
        mLongiList.add(new Longitud_Item(in, R.drawable.km));
        mLongiList.add(new Longitud_Item(mm, R.drawable.km));

        EditText conver = findViewById(R.id.edLong);
        EditText conver1 = findViewById(R.id.edLong2);
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
                }else if (unidadSP1.equals(dm)) {
                    unidad1 = dm;
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
                }else if (unidadSP2.equals(dm)) {
                    unidad2 = dm;
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
                converteED(valorINT, conver1);

                //conver.setText("123456");
            }
        });
        conver1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorED = conver1.getText().toString();
                valorINT = Double.valueOf(valorED);
                converteED1(valorINT, conver);
            }
        });

    }

    public void converteED (Double valor, EditText showED) {

        if (unidad1.equals(mtros) && unidad2.equals(mtros)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(mtros) && unidad2.equals(km)) {
            resultado = valor / 1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mtros) && unidad2.equals(dm)) {
            resultado = valor*10;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(mtros) && unidad2.equals(cm)) {
            resultado = valor * 100;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(km) && unidad2.equals(mtros)) {
            resultado = valor * 1000;
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

        } else if (unidad1.equals(cm) && unidad2.equals(km)) {
            resultado = valor / 100000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad1.equals(cm) && unidad2.equals(dm)) {
            resultado = valor / 10;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(dm) && unidad2.equals(mtros)) {
            resultado = valor / 10;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(dm) && unidad2.equals(km)) {
            resultado = valor / 10000;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(dm) && unidad2.equals(cm)) {
            resultado = valor * 10;
            showED.setText(resultados = String.valueOf(resultado));

        } else if (unidad1.equals(dm) && unidad2.equals(in)) {
            resultado = valor * 3.937;
            System.out.println(resultado +"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
            showED.setText(resultados = String.valueOf(resultado));
            System.out.println(resultados +"wwwwwwwwwwwwwwwwwwwwwwwwwwwwsssssssssssssssswwwwww");
        }else if (unidad1.equals(dm) && unidad2.equals(mm)) {
            resultado = valor * 1000;
            showED.setText(resultados = String.valueOf(resultado));

        }
    }

    public void converteED1 (Double valor, EditText showED) {

        if (unidad2.equals(mtros) && unidad1.equals(mtros)) {
            resultado = valor;
            showED.setText(resultados = String.valueOf(resultado) );

        } else if (unidad2.equals(mtros) && unidad1.equals(km)) {
            resultado = valor / 1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(mtros) && unidad1.equals(cm)) {
            resultado = valor * 100;
            showED.setText(resultados = String.valueOf(resultado) );

        }else if (unidad2.equals(km) && unidad1.equals(mtros)) {
            resultado = valor * 1000;
            showED.setText(resultados = String.valueOf(resultado));

        }else if (unidad2.equals(km) && unidad1.equals(cm)) {
            resultado = valor * 100000;
            showED.setText(resultados = String.valueOf(resultado) );

        }else if (unidad2.equals(cm) && unidad1.equals(mtros)) {
            resultado = valor / 100;
            showED.setText(resultados = String.valueOf(resultado) );

        }else if (unidad2.equals(cm) && unidad1.equals(km)) {
            resultado = valor / 100000;
            showED.setText(resultados = String.valueOf(resultado) );

        }else if (unidad2.equals(dm) && unidad1.equals(mtros)) {
            resultado = valor / 10;
            showED.setText(resultados = String.valueOf(resultado));

        }
    }

}