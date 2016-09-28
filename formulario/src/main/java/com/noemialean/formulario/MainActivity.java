package com.noemialean.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Spinner spinner;
    String  ciudad,genero;
    TextView text3;
    EditText loggin,password,password2,correo,aux;
    RadioGroup radioGroup;
    Button masculino,femenino;
    CheckBox check1,check2,check3;
    Button boton;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        loggin=(EditText)findViewById(R.id.loggin);
        aux=(EditText)findViewById(R.id.aux);
        password=(EditText)findViewById(R.id.password);
        password2=(EditText)findViewById(R.id.password2);
        correo=(EditText)findViewById(R.id.correo);
        check1=(CheckBox)findViewById(R.id.check1);
        check2=(CheckBox)findViewById(R.id.check2);
        check3=(CheckBox)findViewById(R.id.check3);
        boton=(Button)findViewById(R.id.boton);
        boton.setOnClickListener(this);
        text3=(TextView)findViewById(R.id.text3);
        datePicker=(DatePicker)findViewById(R.id.datepicker);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.masculino:
                        genero="Masculino";

                        break;
                    case R.id.femenino:
                        genero="Femenino";
                        break;
                }


            }
        });
        List list= new  ArrayList();
        list.add("Medellin");
        list.add("Cali");
        list.add("Bogota");
        list.add("Bucaramanga");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ciudad=String.valueOf(spinner.getSelectedItem());
                //text3.setText(ciudad);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        if (!String.valueOf(loggin.getText()).equals(String.valueOf(aux.getText()))&&!String.valueOf(password.getText()).equals(String.valueOf(aux.getText()))){
            if (String.valueOf(password.getText()).equals(String.valueOf(password2.getText()))){
                StringBuffer hobbie =new StringBuffer();

                if (check1.isChecked()){
                    hobbie.append(" Leer ");

                }
                if (check2.isChecked()){
                    hobbie.append(" Estudiar ");

                }
                if (check3.isChecked()){
                    hobbie.append(" Escuchar Musica ");

                }


                text3.setText(String.valueOf("Loggin: " + loggin.getText() + "\nCorreo: " + correo.getText().toString() + "\nFecha de nacimiento: " + datePicker.getDayOfMonth() + "-" + String.valueOf(datePicker.getMonth() + "-"
                        + String.valueOf(datePicker.getYear() + "\nCiudad de nacimiento: " + ciudad + "\nHobbies: " + hobbie + "\nGenero: " + genero))));


            }else   Toast.makeText(getApplicationContext(), "Los password no son iguales", Toast.LENGTH_SHORT).show();}else Toast.makeText(getApplicationContext(), "Complete todos los datos", Toast.LENGTH_SHORT).show();}
}



