package com.example.psyad9.fingerpainter;

import android.graphics.Color;
import android.graphics.Paint;

import androidx.lifecycle.ViewModel;

public class PainterViewModel extends ViewModel {               //Viewmodel for handling and saving paintbrush attributes
    private String paintcolour = "#000000";                                  //Encapsulated variables for painting attributes with assigned default values
    private String paintshape = "ROUND";
    private int paintwidth = 20;

    public void setPaintcolour(String paintcolour) {             //Setter for paintcolour
        this.paintcolour = paintcolour;
    }

    public int getPaintColourInt() {                            //getter for paintcolour, returned as an int colour value
        return Color.parseColor(paintcolour);
    }

    public String getPaintColourString() {                      //getter for paintcolour, returned as the original hex string
        return paintcolour;
    }

    public void setPaintshape(String paintshape) {              //setter for paint brush shape
        this.paintshape = paintshape;
    }

    public Paint.Cap getPaintShapePaint() {                     //Getter for paint brush shape, returned as a Paint.Cap type
        return Paint.Cap.valueOf(paintshape);
    }
    public String getPaintShapeString() {                       //Getter for paint brush shape, returned as original String
        return this.paintshape;
    }

    public void setPaintwidth(int paintwidth) {                 //Setter for paint brush width
        this.paintwidth = paintwidth;
    }

    public int getPaintwidth() {                                //Getter for paint brush width
        return paintwidth;
    }
}

