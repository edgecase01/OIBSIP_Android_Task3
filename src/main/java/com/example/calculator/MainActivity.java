package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private List<String> expression = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        int[] buttonIds = {
                R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
                R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9,
                R.id.btn_add, R.id.btn_sub, R.id.btn_mul, R.id.btn_div,
                R.id.btn_equal, R.id.btn_clear, R.id.btn_dot
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        Button b = (Button) view;
        String text = b.getText().toString();

        if (Character.isDigit(text.charAt(0)) || text.equals(".")) {
            currentInput += text;
            updateDisplay(getFullExpressionString() + currentInput);
        }
        else if (text.equals("C")) {
            currentInput = "";
            expression.clear();
            updateDisplay("0");
        }
        else if (text.equals("=")) {
            if (!currentInput.isEmpty()) {
                expression.add(currentInput);
                calculateResult();
            }
        }
        else {
            if (!currentInput.isEmpty()) {
                expression.add(currentInput);
                expression.add(text);
                currentInput = "";
                updateDisplay(getFullExpressionString());
            }
        }
    }

    private void calculateResult() {
        if (expression.isEmpty()) return;

        List<String> pass1 = new ArrayList<>();
        int i = 0;
        while (i < expression.size()) {
            String token = expression.get(i);
            if (token.equals("x") || token.equals("/")) {
                double left = Double.parseDouble(pass1.remove(pass1.size() - 1));
                double right = Double.parseDouble(expression.get(i + 1));
                double res = token.equals("x") ? left * right : left / right;
                pass1.add(String.valueOf(res));
                i += 2;
            } else {
                pass1.add(token);
                i++;
            }
        }

        double finalResult = Double.parseDouble(pass1.get(0));
        for (int j = 1; j < pass1.size(); j += 2) {
            String op = pass1.get(j);
            double nextVal = Double.parseDouble(pass1.get(j + 1));
            if (op.equals("+")) finalResult += nextVal;
            else if (op.equals("-")) finalResult -= nextVal;
        }

        display.setText(String.valueOf(finalResult));

        currentInput = String.valueOf(finalResult);
        expression.clear();
    }

    private String getFullExpressionString() {
        StringBuilder sb = new StringBuilder();
        for (String s : expression) sb.append(s);
        return sb.toString();
    }

    private void updateDisplay(String text) {
        display.setText(text);
    }
}