package com.batyrenko.android.converterus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    EditText mVal1, mRes1, mVal2, mRes2, mVal3, mRes3, mVal4, mRes4;
    Button btn1, btn2, btn3, btn4;

    public static List<String> convert_ratio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Converter US");
        setContentView(R.layout.activity_main);

        String[] myResArray = getResources().getStringArray(R.array.convert_ratio);
        List<String> convert_ratio = Arrays.asList(myResArray);

        // gal - liters
        mVal1 = (EditText) findViewById(R.id.val1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn1.setOnLongClickListener(this);
        mRes1 = (EditText) findViewById(R.id.res1);

        //miles - km
        mVal2 = (EditText) findViewById(R.id.val2);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn2.setOnLongClickListener(this);
        mRes2 = (EditText) findViewById(R.id.res2);

        //mpg - l/100
        mVal4 = (EditText) findViewById(R.id.val4);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn4.setOnLongClickListener(this);
        mRes4 = (EditText) findViewById(R.id.res4);

    }

    @Override
    public void onClick(View v) {
        String valS = null;
        float val = 0, res = 0;
        switch (v.getId()) {
            case R.id.btn1:
                valS = mVal1.getText().toString().trim();
                if (valS.equals("")) break;
                val = Float.parseFloat(mVal1.getText().toString());
                res = (float) (val * 3.785);
                mRes1.setText(String.valueOf(res));
                break;
            case R.id.btn2:
                valS = mVal2.getText().toString().trim();
                if (valS.equals("")) break;
                val = Float.parseFloat(mVal2.getText().toString());
                res = (float) (val * 1.609);
                mRes2.setText(String.valueOf(res));
                break;
            case R.id.btn4:
                valS = mVal4.getText().toString().trim();
                if (valS.equals("")) break;
                val = Float.parseFloat(valS);
                res = (float) (235 / val);
                mRes4.setText(String.valueOf(res));
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                mVal1.setText("");
                mRes1.setText("");
                break;
            case R.id.btn2:
                mVal2.setText("");
                mRes2.setText("");
                break;
            case R.id.btn3:
                mVal3.setText("");
                mRes3.setText("");
                break;
            case R.id.btn4:
                mVal4.setText("");
                mRes4.setText("");
                break;
        }
        return true;
    }
}
