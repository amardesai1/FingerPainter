package com.example.psyad9.fingerpainter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ColourActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);                                 //Starting Colour picking activity
        setContentView(R.layout.activity_colourpicker);                     //Displaying Colour picking activity
        String colour = getIntent().getExtras().getString("colour");           //Saving colour variable passed through intent from main activity

        if(colour.equals("#000000")){                                        //If statement converting hex colour value to String
            colour = "Black";
        }else if(colour.equals("#D32F2F")) {
            colour = "Red";
        }else if(colour.equals("#ffffff")){
            colour = "White";
        }else if(colour.equals("#008000")){
            colour = "Green";
        }else if(colour.equals("#0000ff")){
            colour = "Blue";
        }else if(colour.equals("#ffff00")) {
            colour = "Yellow";
        }else if(colour.equals("#FFA500")){
            colour = "Orange";
        }else if(colour.equals("#ff6ec7")){
            colour = "pink";
        }else if(colour.equals("#6a0dad")){
            colour = "Purple";
        }

        TextView textView = (TextView) findViewById(R.id.currentcolour);     //Finding instance of textView so it can be edited
        textView.setText("The currently selected colour is "+ colour);       //Setting text of textview to show which colour is being used
    }

    public void setBlack(View view){                                        //Button onClick methods to return the chosen colour to the main activity in an intent
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour","#000000");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
    public void setRed(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour","#D32F2F");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
    public void setPink(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour", "#ff6ec7");
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
    public void setPurple(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour","#6a0dad");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
    public void setGreen(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour","#008000");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
    public void setBlue(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour","#0000ff");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }public void setWhite(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour","#ffffff");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
    public void setYellow(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour","#ffff00");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }public void setOrange(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("colour","#FFA500");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }



}
