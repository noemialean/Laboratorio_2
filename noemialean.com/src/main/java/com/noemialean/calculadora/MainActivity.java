package com.noemialean.calculadora;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroup;
    EditText editext, editext2;
    // RadioButton button;
    TextView textview;
    String resul,valor1,valor2;
    Button var1;
    Double val1,val2,oper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editext = (EditText) findViewById(R.id.editText);
        editext2 = (EditText) findViewById(R.id.editText2);
        textview = (TextView) findViewById(R.id.textView);
        var1=(Button) findViewById(R.id.var1);
        var1.setOnClickListener(this);




        radioGroup = (RadioGroup) findViewById(R.id.radiogrup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioButton) {
                    valor1 = editext.getText().toString();
                    valor2 = editext2.getText().toString();
                    val1 = Double.parseDouble(valor1);
                    val2 = Double.parseDouble(valor2);
                    oper = val1 + val2;
                    resul = String.valueOf(oper);

                    Toast.makeText(getApplicationContext(), "SUMA", Toast.LENGTH_SHORT).show();


                } else if (checkedId == R.id.radioButton2) {
                    valor1 = editext.getText().toString();
                    valor2 = editext2.getText().toString();
                    val1 = Double.parseDouble(valor1);
                    val2 = Double.parseDouble(valor2);
                    oper = val1 - val2;
                    resul = String.valueOf(oper);

                    Toast.makeText(getApplicationContext(), "RESTA", Toast.LENGTH_SHORT).show();

                } else if (checkedId == R.id.radioButton3) {
                    valor1 = editext.getText().toString();
                    valor2 = editext2.getText().toString();
                    val1 = Double.parseDouble(valor1);
                    val2 = Double.parseDouble(valor2);
                    oper = val1 / val2;
                    resul = String.valueOf(oper);

                    Toast.makeText(getApplicationContext(), "DIVICIÓN", Toast.LENGTH_SHORT).show();

                } else if (checkedId == R.id.radioButton4) {
                    valor1 = editext.getText().toString();
                    valor2 = editext2.getText().toString();
                    val1 = Double.parseDouble(valor1);
                    val2 = Double.parseDouble(valor2);
                    oper = val1 * val2;
                    resul = String.valueOf(oper);

                    Toast.makeText(getApplicationContext(), "MULTIPLICACIÓN", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    @Override
    public void onClick(View v) {
        textview.setText(resul);



    }




}
