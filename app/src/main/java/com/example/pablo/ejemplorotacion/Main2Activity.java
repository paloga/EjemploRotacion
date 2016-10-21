package com.example.pablo.ejemplorotacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText etxtEdat;
    TextView txtEdat;
    TextView txtNombre;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etxtEdat = (EditText) findViewById(R.id.etxtEdat);
        txtEdat = (TextView) findViewById(R.id.txtEdat);
        btn = (Button) findViewById(R.id.btn);
        txtNombre = (TextView) findViewById(R.id.txtNombre);

        String nombre = getIntent().getExtras().getString("nombre");
        txtNombre.setText("Buenos dias, "+nombre);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int edat=0;
                Bundle b = new Bundle();
                String edat1 = etxtEdat.getText().toString();
                try {
                    edat = Integer.parseInt(edat1);
                } catch(NumberFormatException nfe){
            }
                b.putInt("edat", edat);
                Intent i = new Intent();
                i.putExtras(b);
                setResult(RESULT_OK, i);
                finish();

            }
        });
    }

}
