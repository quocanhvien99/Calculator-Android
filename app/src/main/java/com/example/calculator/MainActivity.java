package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textValue, secondDisplay;

    int currentValue = 0;
    int result = 0;
    String currentMath = "";
    boolean isDoubleClick = false;
    String secondDisplayText = "";

    public void addDigit(int number) {
        if (currentMath == "equal") {
            currentValue = 0;
            result = 0;
            currentMath = "";
        }
        if (String.valueOf(currentValue).length() < 9) {
            currentValue = currentValue * 10 + number;
            textValue.setText(Integer.toString(currentValue));
        }
        isDoubleClick = false;
    }
    public void mathExecution(String btn) {
        if (!isDoubleClick || currentMath == "equal") {
            addTextSecondDisplay(btn);
            if (!currentMath.isEmpty()) {
                if (currentMath == "divide") {
                    result = result / currentValue;
                    currentValue = 0;
                    textValue.setText(Integer.toString(result));
                }
                if (currentMath == "multiply") {
                    result = result * currentValue;
                    currentValue = 0;
                    textValue.setText(Integer.toString(result));
                }
                if (currentMath == "minus") {
                    result = result - currentValue;
                    currentValue = 0;
                    textValue.setText(Integer.toString(result));
                }
                if (currentMath == "plus") {
                    result = result + currentValue;
                    currentValue = 0;
                    textValue.setText(Integer.toString(result));
                }
            } else {
                result = currentValue;
                currentValue = 0;
            }
            isDoubleClick = true;
        }
    }
    public void addTextSecondDisplay(String value) {
        if (currentMath == "equal") {
            secondDisplayText = result + value;
        } else {
            secondDisplayText = secondDisplayText + currentValue + value;
        }
        secondDisplay.setText(secondDisplayText);

        //Log.v("TAG", "USD: " + secondDisplayText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValue = findViewById(R.id.text_value);
        secondDisplay = findViewById(R.id.second_display);

        findViewById(R.id.btn_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentValue != 0) {
                    addDigit(0);
                }
            }
        });
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(1);
            }
        });
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(2);
            }
        });
        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(3);
            }
        });
        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(4);
            }
        });
        findViewById(R.id.btn_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(5);
            }
        });
        findViewById(R.id.btn_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(6);
            }
        });
        findViewById(R.id.btn_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(7);
            }
        });
        findViewById(R.id.btn_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(8);
            }
        });
        findViewById(R.id.btn_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit(9);
            }
        });
        findViewById(R.id.btn_divide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathExecution("/");
                currentMath = "divide";
            }
        });
        findViewById(R.id.btn_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathExecution("x");
                currentMath = "multiply";
            }
        });
        findViewById(R.id.btn_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathExecution("-");
                currentMath = "minus";
            }
        });
        findViewById(R.id.btn_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathExecution("+");
                currentMath = "plus";
            }
        });
        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathExecution("=");
                currentMath = "equal";
            }
        });

        findViewById(R.id.btn_ce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue = 0;
                textValue.setText(Integer.toString(currentValue));
            }
        });
        findViewById(R.id.btn_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue = 0;
                result = 0;
                currentMath = "";
                textValue.setText(Integer.toString(currentValue));
                secondDisplayText = "";
                secondDisplay.setText(secondDisplayText);
            }
        });
        findViewById(R.id.btn_bs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue = currentValue / 10;
                textValue.setText(Integer.toString(currentValue));
            }
        });
    }
}