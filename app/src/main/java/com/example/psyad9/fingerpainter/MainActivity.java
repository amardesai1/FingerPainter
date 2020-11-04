package com.example.psyad9.fingerpainter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    FingerPainterView myFingerPainterView;
    private PainterViewModel myViewModel;
    public static int colourcode = 0;
    public static int brushcode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider(this).get(PainterViewModel.class);
        myViewModel.setPaintwidth(20);
        myViewModel.setPaintcolour("#000000");
        myViewModel.setPaintshape("ROUND");

        myFingerPainterView = findViewById(R.id.myFingerPainterView);
        myFingerPainterView.load(getIntent().getData());

        if(savedInstanceState!=null)
        {
            myViewModel.setPaintcolour(savedInstanceState.getString("paintcolour", "#000000"));
            myFingerPainterView.setColour(myViewModel.getPaintColourInt());
            myViewModel.setPaintwidth(savedInstanceState.getInt("paintwidth", 20));
            myFingerPainterView.setBrushWidth(myViewModel.getPaintwidth());
            myViewModel.setPaintshape(savedInstanceState.getString("paintshape"));
            myFingerPainterView.setBrush(myViewModel.getPaintShapePaint());
        }
    }

    public void setColour(View view){
        Intent intent = new Intent(this, ColourActivity.class);
        intent.putExtra("colour", myViewModel.getPaintColourString());
        startActivityForResult(intent, colourcode);
    }
    public void setBrush(View view){
        Intent intent = new Intent(this, BrushActivity.class);
        intent.putExtra("width", myViewModel.getPaintwidth());
        intent.putExtra("shape", myViewModel.getPaintShapeString());
        startActivityForResult(intent, brushcode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==colourcode&&resultCode==Activity.RESULT_OK&&data!=null)
        {
            myViewModel.setPaintcolour(data.getStringExtra("colour"));
            myFingerPainterView.setColour(myViewModel.getPaintColourInt());


        }else if(requestCode==brushcode&&resultCode==Activity.RESULT_OK&&data!=null)
        {
            myViewModel.setPaintshape(data.getStringExtra("shape"));
            myFingerPainterView.setBrush(myViewModel.getPaintShapePaint());

            myViewModel.setPaintwidth(data.getIntExtra("thickness",20));
            myFingerPainterView.setBrushWidth(myViewModel.getPaintwidth());

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("paintcolour", myViewModel.getPaintColourString());
        outState.putInt("paintwidth", myViewModel.getPaintwidth());
        outState.putString("paintshape", myViewModel.getPaintShapeString());
    }


}
