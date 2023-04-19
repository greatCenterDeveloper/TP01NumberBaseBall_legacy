package com.swj.tp01numberbaseball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText su100;
    EditText su10;
    EditText su1;
    Button btn;
    TextView result;
    int com100, com10, com1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        su100 = findViewById(R.id.su100);
        su10 = findViewById(R.id.su10);
        su1 = findViewById(R.id.su1);
        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);

        Random rnd = new Random();
        com100 = rnd.nextInt(9) + 1;
        com10 = rnd.nextInt(9) + 1;
        com1 = rnd.nextInt(9) + 1;

        while(com100 == com10) {
            com10 = rnd.nextInt(9) + 1;
        }

        while(com100 == com1 || com10 == com1) {
            com1 = rnd.nextInt(9) + 1;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num100 = Integer.parseInt(su100.getText().toString());
                int num10 = Integer.parseInt(su10.getText().toString());
                int num1 = Integer.parseInt(su1.getText().toString());
                int strike = 0, ball = 0;

                if(num100==com100) strike++;
                if(num10==com10) strike++;
                if(num1==com1) strike++;

                if((num100 == com10) || (num100 == com1)) ball++;
                if((num10 == com100) || (num10 == com1)) ball++;
                if((num1 == com100)  || (num1 == com10)) ball++;

                result.append("" + num100);
                result.append("" + num10);
                result.append("" + num1 + " : ");
                result.append("" + strike + " strike, " );
                result.append("" + ball + " ball \n" );

                su100.setText("");
                su10.setText("");
                su1.setText("");
            }
        });
    }
}