package com.example.randomnumgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.TextUtils.substring;


public class MainActivity extends AppCompatActivity {
    //declaracion de variables
    Button generar;
    Spinner spp;
    TextView valini, nombre, valores;
    int val0 [];
    int val1;
    float val2;
    String valor, valor1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id de las variables
        generar = findViewById(R.id.btngenerar);
        valini= findViewById(R.id.txtVal0);
        nombre = findViewById(R.id.txtTitulo);
        valores = findViewById(R.id.txtnum);
        spp = findViewById(R.id.spp);

        //declaracion del los obj del spp
        String[] metodos = {"Explicación","Método de Cuadrados Medios","Método de Promedios Medios","Método Lineal"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android
                .R.layout.simple_spinner_item, metodos);
        spp.setAdapter(adapter);
        spp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
             @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 String selec = spp.getSelectedItem().toString();
                if(selec.equals("Método de Cuadrados Medios")){
                    nombre.setText("Método de Cuadrados Medios");


                }
                else if (selec.equals("Método de Promedios Medios")){
                    nombre.setText("Método de Promedios Medios");


                }
                else if(selec.equals("Método Lineal")){
                    nombre.setText("Método Lineal");


                }
                else if(selec.equals("Explicación")){
                    nombre.setText("Elija el método deseado");

                }


                //seccion del boton generar
                 DecimalFormat digit = new DecimalFormat("########");
                 DecimalFormat dos = new DecimalFormat("#.####");

                 generar.setOnClickListener(new View.OnClickListener(){
                     @Override
                     public void onClick(View view) {
                         if (valini.getText().length() == 4 ){
                             val0[0] = Integer.parseInt(valini .getText().toString());
                             for(int i=1;i>=5;i++){
                             //paso 1 multiplicar por si mismo
                             val1= val0[i]*val0[i];
                             valor1= String.valueOf(val1);
                             if(valor1.length()<8){
                                 while(valor1.length()<8){
                                     valor1= "0"+ valor1 ;} }
                             valor = substring(valor1,2,4);

                             valores.setText(valores.getText().toString() +i+". "+valor  );
                             val0[i]= Integer.parseInt(valor);
                             }//fin for

                         }//fin if
                         else Toast.makeText(getApplicationContext(), "Solo se aceptan números enteros con 4 cifras", Toast.LENGTH_SHORT).show();

                     }
                });//fin funcion onclick

            }//fin seleccion


            public void onNothingSelected(AdapterView<?> adapterView) {
                String selec = spp.getSelectedItem().toString();
                nombre.setText("JAJAJ NO SELECCION");
            }//fin nada seleccionado
        });//fin spinner
    }//fin oncreate
}//fin mainactivity