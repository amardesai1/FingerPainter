package com.example.psyad9.fingerpainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class BrushActivity extends AppCompatActivity {

    private String shape;
    private int width;
    private EditText editText;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brushpicker);

        shape = getIntent().getExtras().getString("shape");
        width = getIntent().getExtras().getInt("width");

        EditText editText = (EditText) findViewById(R.id.width);
        editText.setText(Integer.toString(width));

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.shapebutton);
        if(shape.equals("ROUND"))
        {
            radioGroup.check(R.id.radioRound);
        }else if(shape.equals("SQUARE")) {
            radioGroup.check(R.id.radioSquare);
        }
    }

    public void onDone(View view){

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.shapebutton);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        EditText editText = (EditText) findViewById(R.id.width);

        if(editText.getText().toString().equals("") ||radioButton==null)
        {
            TextView textView = (TextView) findViewById(R.id.warningText);
            textView.setVisibility(View.VISIBLE);
        }
        else
        {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("shape", radioButton.getText().toString());
            returnIntent.putExtra("thickness", Integer.parseInt(editText.getText().toString()));
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }
}
