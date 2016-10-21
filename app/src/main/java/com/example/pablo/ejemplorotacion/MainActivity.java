package com.example.pablo.ejemplorotacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button btnEntrar;
    EditText etxtNom;
    RadioButton rbtnM;
    RadioButton rbtnF;
    TextView txtEdat;
    int edat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        etxtNom = (EditText) findViewById(R.id.etxtNom);
        rbtnM = (RadioButton) findViewById(R.id.rbtnM);
        rbtnF = (RadioButton) findViewById(R.id.rbtnF);
        txtEdat = (TextView) findViewById(R.id.txtEdat);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etxtNom.getText().toString();
                Bundle b = new Bundle();
                b.putString("nombre", nombre);
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtras(b);
                MainActivity.this.startActivityForResult(i, 1);

            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle bun = data.getExtras();
        edat = bun.getInt("edat");
        if ((edat>18)&&(edat<25)){
            txtEdat.setText("ja eres major d´edat");
        }
        if ((edat>=25)&&(edat<35)){
            txtEdat.setText("estas en la flor de la vida");
        }
        if(edat>=35){
            txtEdat.setText("ai,ai,ai...");
        }

    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("edat", edat);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        edat = savedInstanceState.getInt("edat");
        if ((edat>18)&&(edat<25)){
            txtEdat.setText("ja eres major d´edat");
        }
        if ((edat>=25)&&(edat<35)){
            txtEdat.setText("estas en la flor de la vida");
        }
        if(edat>=35){
            txtEdat.setText("ai,ai,ai...");
        }
    }
}

