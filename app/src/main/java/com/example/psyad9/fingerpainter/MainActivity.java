package com.example.psyad9.fingerpainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    FingerPainterView myFingerPainterView;                                                           //Instance of FingerPainterView object
    private PainterViewModel myViewModel;                                                            //Instance of PainterViewModel
    public static int colourcode = 0;                                                                //Unique identifier for colour data intent
    public static int brushcode = 1;                                                                 //Unique identifier for brush size and shape intent

    @Override
    protected void onCreate(Bundle savedInstanceState)                                              //onCreate method for main class to start activity
    {
        super.onCreate(savedInstanceState);                                                         //Starting mainactivity
        setContentView(R.layout.activity_main);                                                     //displaying main activity

        myViewModel = new ViewModelProvider(this).get(PainterViewModel.class);               //initialise viewModel

        myFingerPainterView = findViewById(R.id.myFingerPainterView);                               //initialise Painter object
        myFingerPainterView.load(getIntent().getData());                                            //loads an image onto canvas if present

        if(savedInstanceState!=null)                                                                //Checks if there is existing state data bundle and saves to viewmodel and sets to Painter Object if there is one
        {
            myViewModel.setPaintcolour(savedInstanceState.getString("paintcolour", "#000000"));
            myFingerPainterView.setColour(myViewModel.getPaintColourInt());
            myViewModel.setPaintwidth(savedInstanceState.getInt("paintwidth", 20));
            myFingerPainterView.setBrushWidth(myViewModel.getPaintwidth());
            myViewModel.setPaintshape(savedInstanceState.getString("paintshape"));
            myFingerPainterView.setBrush(myViewModel.getPaintShapePaint());
        }
    }

    public void setColour(View view){                                                               //setColour class for running if Colour button is pressed on mainactivity
        Intent intent = new Intent(this, ColourActivity.class);                       //creates intent for sending current brush colour to colour acitivity
        intent.putExtra("colour", myViewModel.getPaintColourString());
        startActivityForResult(intent, colourcode);                                                 //starts colour activity, sending it an intent and allowing return of data when it finishes
    }
    public void setBrush(View view){                                                                //setBrush class for running if Brush button is pressed on mainactivity
        Intent intent = new Intent(this, BrushActivity.class);                        //Add data for current brush shape and width to intent
        intent.putExtra("width", myViewModel.getPaintwidth());
        intent.putExtra("shape", myViewModel.getPaintShapeString());
        startActivityForResult(intent, brushcode);                                                  //starts brush activity, passing it the intent and allowing a return of data
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {       //method for handling when intent data is returned from colour or brush method
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==colourcode&&resultCode==Activity.RESULT_OK&&data!=null)                     //Checks that intent data was for colour and returned in correct format
        {
            myViewModel.setPaintcolour(data.getStringExtra("colour"));                         //Sets brush colour to viewmodel
            myFingerPainterView.setColour(myViewModel.getPaintColourInt());                          //Gets brush colour from viewmodel and sets it to finger painter object


        }else if(requestCode==brushcode&&resultCode==Activity.RESULT_OK&&data!=null)                //Checks that intent data was for brush and returned in correct format
        {
            myViewModel.setPaintshape(data.getStringExtra("shape"));                          //Sets brush shape to viewmodel
            myFingerPainterView.setBrush(myViewModel.getPaintShapePaint());                         //Gets brush shape from viewmodel and sets it to finger painter object

            myViewModel.setPaintwidth(data.getIntExtra("thickness",20));          //Sets brush width to viewmodel
            myFingerPainterView.setBrushWidth(myViewModel.getPaintwidth());                         //Gets brush width from viewmodel and sets it to finger painter object

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {                                           //Method for handling state saving
        super.onSaveInstanceState(outState);
        outState.putString("paintcolour", myViewModel.getPaintColourString());                      //Sets colour, brush width and brush shape and puts it in bundle for restoration later
        outState.putInt("paintwidth", myViewModel.getPaintwidth());
        outState.putString("paintshape", myViewModel.getPaintShapeString());
    }


}
