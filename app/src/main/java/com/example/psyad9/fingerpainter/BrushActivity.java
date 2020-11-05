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

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);                                                         //Starting brush picking activity
        setContentView(R.layout.activity_brushpicker);                                              //Displaying brush activity
        String shape = getIntent().getExtras().getString("shape");                             //Saving shape variable passed through intent from
        int width = getIntent().getExtras().getInt("width");                                   //Saving brush width variable passed through intent

        EditText editText = (EditText) findViewById(R.id.width);                                     //Finding instance of editText so it can be edited
        editText.setText(Integer.toString(width));                                                     //Setting text of edittext to the current brush width passed in

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.shapebutton);                        //Finding instance of radio  buttons so it can be edited
        if(shape.equals("ROUND"))                                                                      // setting radio button state to the current used shape passed in as a string
        {
            radioGroup.check(R.id.radioRound);
        }else if(shape.equals("SQUARE")) {
            radioGroup.check(R.id.radioSquare);
        }
    }

    public void onDone(View view){

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.shapebutton);                       //Getting instance of Radiobutton and finding the selected buttons text
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        EditText editText = (EditText) findViewById(R.id.width);                                    // Getting width value in editText instance

        if(editText.getText().toString().equals(""))                                                //Checks if the text field is empty ot prevent activity ending with empty field
        {
            TextView textView = (TextView) findViewById(R.id.warningText);
            textView.setVisibility(View.VISIBLE);                                                   //Warning text made visible if a field is empty on the activity
        }
        else
        {
            Intent returnIntent = new Intent();                                                     //If both fields are filled, a new intent is created with shape and thickness values
            returnIntent.putExtra("shape", radioButton.getText().toString());
            returnIntent.putExtra("thickness", Integer.parseInt(editText.getText().toString()));
            setResult(Activity.RESULT_OK, returnIntent);
            finish();                                                                               //Activity is ended, starting main activit and passing it the data in an intent
        }
    }
}
