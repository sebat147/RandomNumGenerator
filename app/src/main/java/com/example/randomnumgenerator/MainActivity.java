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
    TextView valini, nombre, valores, valseg;
    int val0, val01;
    String respu [] = new String [5];
    int val1;
    String valor, valor1, resp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id de las variables
        generar = findViewById(R.id.btngenerar);
        valini= findViewById(R.id.txtVal0);
        valseg= findViewById(R.id.txtVal2);
        nombre = findViewById(R.id.txtTitulo);
        valores = findViewById(R.id.txtnum);
        spp = findViewById(R.id.spp);

        //declaracion del los obj del spp
        String[] metodos = {"Explicación","Método de Cuadrados Medios","Método de Promedios Medios"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android
                .R.layout.simple_spinner_item, metodos);
        spp.setAdapter(adapter);
        spp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
             @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 valseg.setVisibility(View.INVISIBLE);
                 valini.setVisibility(View.INVISIBLE);
                 String selec = spp.getSelectedItem().toString();
                if(selec.equals("Método de Cuadrados Medios")){
                    nombre.setText("Método de Cuadrados Medios");
                    valini.setVisibility(View.VISIBLE);
                    valini.setText("");
                }
                else if (selec.equals("Método de Promedios Medios")){
                    nombre.setText("Método de Promedios Medios");
                    valini.setText("");
                    valseg.setText("");
                    valseg.setVisibility(View.VISIBLE);
                    valini.setVisibility(View.VISIBLE);

                }
                else if(selec.equals("Explicación")){
                    nombre.setText("Elija el método deseado");
                    valseg.setVisibility(View.INVISIBLE);
                    valini.setVisibility(View.INVISIBLE);
                }
                //seccion del boton generar
                 DecimalFormat digit = new DecimalFormat("########");
                 generar.setOnClickListener(new OnClickListener(){
                     @Override
                     public void onClick(View view) {
                         if (valini.getText().length() == 4 && selec.equals("Método de Cuadrados Medios")){
                             val0= Integer.parseInt(valini .getText().toString());
                             respu[0]=valini .getText().toString();
                             for(int i=1;i<5;i++){
                             //paso 1 multiplicar por si mismo
                             val1= val0*val0;
                             valor1= String.valueOf(val1);
                             if(valor1.length()<8){
                                 while(valor1.length()<8){
                                     valor1= "0"+ valor1 ;} }
                             valor = valor1.substring(2,6);
                            respu[i] =valor;
                                 resp= valores.getText().toString();
                                 valores.setText(resp +i+ ". " + respu[i] + "\n");
                             val0= Integer.parseInt(valor);
                             }//fin for
                                                 }//fin if
                         else if (valini.getText().length() == 4 && selec.equals("Método de Promedios Medios")  && valseg  .getText().length() == 4 ){
                             val0= Integer.parseInt(valini .getText().toString());
                             val01=Integer.parseInt(valseg .getText().toString());
                             for(int i=0;i<5;i++){
                                 //paso 1 multiplicar por si mismo
                                 val1= val0*val01;
                                 valor1= String.valueOf(val1);
                                 if(valor1.length()<8){
                                     while(valor1.length()<8){
                                         valor1= "0"+ valor1 ;} }
                                 valor = valor1.substring(2,6);
                                 respu[i] =valor;
                                 resp= valores.getText().toString();
                                 valores.setText(resp +(i+1)+ ". " + respu[i] + "\n");
                                 val0= val01;
                                 val01= Integer.parseInt(valor);

                         }}
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