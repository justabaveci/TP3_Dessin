package com.example.tp3dessin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class Point {
    float x, y;
    int couleur;
    float epaisseur;

    public Point(float x, float y, int couleur, float epaisseur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
        this.epaisseur = epaisseur;
    }

}

public class Dessin extends View {
    public Dessin(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    ArrayList<Point> points = new ArrayList<>();
    int c = Color.BLACK;
    float e = 10;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public float getE() {
        return e;
    }

    public void setE(float e) {
        this.e = e;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        for (Point point : points) {
            p.setColor(point.couleur);
            p.setStrokeWidth(point.epaisseur);
            canvas.drawPoint(point.x,point.y,p);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        points.add(new Point(event.getX(), event.getY(), Color.RED, getE()));
        invalidate();
        return true; //phai thay bang trua thi no moi lien tiep duoc
    }
}
