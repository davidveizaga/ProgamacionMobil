package com.example.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText t1,t3;
    RadioButton r1,r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.boton);
        t1 = (EditText)findViewById(R.id.texto1);
        t3 = (EditText)findViewById(R.id.texto3);
        r1 = (RadioButton)findViewById(R.id.rbC);
        r2 = (RadioButton)findViewById(R.id.rbF);

        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if(r1.isChecked()){

                    double c = Double.parseDouble(t1.getText().toString());

                    double f=(c*2)-(c/5);
                    f=f+32;

                    t3.setText(""+f);

                }

                if(r2.isChecked()) {

                    double f = Double.parseDouble(t1.getText().toString());
                    double c=(f-32) * 5 /9;
                    t3.setText(""+c);
                }
            }
        });


    }
}