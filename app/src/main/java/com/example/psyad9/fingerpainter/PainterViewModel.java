package com.example.psyad9.fingerpainter;

import android.graphics.Color;
import android.graphics.Paint;

import androidx.lifecycle.ViewModel;

public class PainterViewModel extends ViewModel {
    private String paintcolour;
    private String paintshape;
    private int paintwidth;

    public void setPaintcolour(String paintcolour) {
        this.paintcolour = paintcolour;
    }

    public int getPaintColourInt() {
        return Color.parseColor(paintcolour);
    }

    public String getPaintColourString() {
        return paintcolour;
    }

    public void setPaintshape(String paintshape) {
        this.paintshape = paintshape;
    }

    public Paint.Cap getPaintShapePaint() {
        return Paint.Cap.valueOf(paintshape);
    }
    public String getPaintShapeString() {
        return this.paintshape;
    }

    public void setPaintwidth(int paintwidth) {
        this.paintwidth = paintwidth;
    }

    public int getPaintwidth() {
        return paintwidth;
    }
}

