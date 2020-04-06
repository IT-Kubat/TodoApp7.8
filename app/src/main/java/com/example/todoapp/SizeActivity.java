package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SizeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText editText;
    float size;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);
        editText = findViewById(R.id.edit_size);
        editText.setVisibility(View.INVISIBLE);

        RadioButton redRadioButton = (RadioButton)findViewById(R.id.Shrift_14);
        redRadioButton.setOnClickListener(radioButtonClickListener);

        RadioButton greenRadioButton = (RadioButton)findViewById(R.id.Shrift_22);
        greenRadioButton.setOnClickListener(radioButtonClickListener);

        RadioButton blueRadioButton = (RadioButton)findViewById(R.id.Shrift_28);
        blueRadioButton.setOnClickListener(radioButtonClickListener);
        }
        View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            switch (rb.getId()) {
                case R.id.Shrift_14: editText.setTextSize(14);
                size = editText.getTextSize();
                    intent.putExtra("size", size);
                    setResult(RESULT_OK,intent);
                    finish();
                    break;
                case R.id.Shrift_22: editText.setTextSize(22);
                    size = editText.getTextSize();
                    intent.putExtra("size", size);
                    setResult(RESULT_OK,intent);
                    finish();
                    break;
                case R.id.Shrift_28: editText.setTextSize(28);
                    size = editText.getTextSize();
                    intent.putExtra("size", size);
                    setResult(RESULT_OK,intent);
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int size = 14;
        switch (checkedId){
            case R.id.Shrift_14:
                size = 14;
                break;
            case R.id.Shrift_22:
                size = 22;
                break;
            case R.id.Shrift_28:
                size = 28;
                break;
        }

        Intent intent = new Intent();
        intent.putExtra("size", size);
        setResult(RESULT_OK,intent);
        finish();
    }
}


