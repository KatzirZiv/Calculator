package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    int firstNum,secondNum;
    char ch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result = findViewById(R.id.textViewResult);
        result.setText("");
    }

    public void numFunction(View view) {

        Button button = (Button) view;
        result.append(button.getText().toString());
    }

    public void Calc(View view) {

        ch= ((Button) view).getText().toString().charAt(0);
        firstNum = (int) Double.parseDouble(result.getText().toString());
        result.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void Result(View view) {
        secondNum = (int) Double.parseDouble(result.getText().toString());
        int res=0;
        switch (ch)
        {
            case '+':
                res= firstNum + secondNum;
                break;

            case '-':
                res= firstNum - secondNum;
                break;

            case '/':
                res = firstNum / secondNum;
                break;
        }
        result.setText(res + "");
    }

    public void clearAll(View view) {
        firstNum = 0;
        secondNum = 0;
        ch = '\0';
        result.setText("");
    }
}