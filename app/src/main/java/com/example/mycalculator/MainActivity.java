package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String oldNumber="";
    String op="+";
    boolean isNewOp=true;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp=false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.buseven:
                number += "7";
                break;
            case R.id.buone:
                number += "1";
                break;
            case R.id.butwo:
                number += "2";
                break;
            case R.id.buthree:
                number += "3";
                break;
            case R.id.bufour:
                number += "4";
                break;
            case R.id.bufive:
                number += "5";
                break;
            case R.id.busix:
                number += "6";
                break;
            case R.id.bueight:
                number += "8";
                break;
            case R.id.bunine:
                number += "9";
                break;
            case R.id.bupoint:
                number += ".";
                break;
            case R.id.buzero:
                number += "0";
                break;
            case R.id.buPlusMinus:
                number += "-"+number;
                break;

        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp=true;
        oldNumber=ed1.getText().toString();
        switch (view.getId()){
            case R.id.budivide: op="/";break;
            case R.id.bumultiply: op="*";break;
            case R.id.buplus: op="+";break;
            case R.id.busub: op="-";break;
        }
    }

    public void equalEvent(View view) {
        String newNumber=ed1.getText().toString();
        double result=0.0;
        switch (op){
            case "+":
                result=Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result=Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "/":
                result=Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
            case "*":
                result=Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }

    public void acEvent(View view) {
        ed1.setText("0");
        isNewOp=true;
    }

    public void percentEvent(View view) {
        double no=Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        isNewOp=true;
    }
}