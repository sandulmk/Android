package com.example.calcu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {

    private EditText First, Second;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        First = findViewById(R.id.First);
        Second = findViewById(R.id.Second);
        resultText = findViewById(R.id.result);
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('+');

            }


        });
        Button sub = findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('-');
            }
        });

        Button mul = findViewById(R.id.mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('*');
            }
        });

        Button div = findViewById(R.id.div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('/');
            }
        });
    }

    private void performCalculation(char operation) {
        String input1 = First.getText().toString();
        String input2 = Second.getText().toString();
        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    resultText.setText("Cannot divide by zero");
                    return;
                }

                result = num1 / num2;
                break;

            default:
                resultText.setText("Invalid operation");
                return;
        }
        resultText.setText("Result: " + result);
    }
}