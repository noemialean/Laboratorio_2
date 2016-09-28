package com.noemialean.figurasgeometricas;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText altura,base,radio,lado;
    String altura_s,base_s,radio_s,lado_s,resul;
    Double altura_D,base_D,radio_D,lado_D,oper;

    TextView resultado;
    Button calcular;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        altura=(EditText)findViewById(R.id.base);
        base=(EditText)findViewById(R.id.altura);
        radio=(EditText)findViewById(R.id.radio);
        lado=(EditText)findViewById(R.id.lado);
        resultado=(TextView)findViewById(R.id.resultado);
        calcular=(Button)findViewById(R.id.calcular);
        calcular.setOnClickListener(this);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioBoton1:
                        lado.setEnabled(true);
                        // lado.setFocusable(true);
                        radio.setEnabled(false);
                        //radio.setFocusable(false);
                        base.setEnabled(false);
                        //base.setFocusable(false);
                        altura.setEnabled(false);
                        //altura.setFocusable(false);
                        lado_s = lado.getText().toString();
                        lado_D = Double.parseDouble(lado_s);
                        oper = lado_D*lado_D;
                        resul = String.valueOf(oper);
                        Toast.makeText(getApplicationContext(), "CUADRADO", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBoton2:
                        base.setEnabled(true);
                        altura.setEnabled(true);
                        radio.setEnabled(false);
                        lado.setEnabled(false);

                        base_s = base.getText().toString();
                        base_D = Double.parseDouble(base_s);
                        altura_s = altura.getText().toString();
                        altura_D = Double.parseDouble(altura_s);
                        oper = (base_D*altura_D)/2;
                        resul = String.valueOf(oper);
                        Toast.makeText(getApplicationContext(), "TRIANGULO", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBoton3:

                        base.setEnabled(true);
                        altura.setEnabled(true);
                        radio.setEnabled(false);
                        lado.setEnabled(false);

                        base_s = base.getText().toString();
                        base_D = Double.parseDouble(base_s);
                        altura_s = altura.getText().toString();
                        altura_D = Double.parseDouble(altura_s);
                        oper = (base_D*altura_D);
                        resul = String.valueOf(oper);
                        Toast.makeText(getApplicationContext(), "RECTANGULO", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBoton4:

                        base.setEnabled(false);
                        altura.setEnabled(false);
                        radio.setEnabled(true);
                        lado.setEnabled(false);
                        radio_s = radio.getText().toString();
                        radio_D = Double.parseDouble(radio_s);
                        oper = (radio_D*radio_D)*3.1416;
                        resul = String.valueOf(oper);
                        Toast.makeText(getApplicationContext(), "CIRCULO", Toast.LENGTH_SHORT).show();
                        break;
                    // default:
                }

            }
        });

    }
    @Override
    public void onClick(View v){
        resultado.setText(resul);
    }

}
