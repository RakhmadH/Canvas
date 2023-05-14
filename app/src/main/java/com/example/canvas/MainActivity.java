package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas theCanvas;
    private Paint thePaint = new Paint();
    private Paint paintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);

    private Bitmap theBitmap;
    private ImageView imageView;
    private Rect rect = new Rect();
    private Rect bounds = new Rect();

    private static final int OFFSET = 120;
    private int theOffset = OFFSET;
    private static final int MULTIPLIER = 100;
    private static final int COUNT = 5;
    private int count = 0;

    private int colorBackground;
    private int colorRectangle;
    private int colorAccent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorBackground = ResourcesCompat.getColor(getResources(), R.color.colorBackground, null);
        colorRectangle = ResourcesCompat.getColor(getResources(), R.color.colorRectangle, null);
        colorAccent = ResourcesCompat.getColor(getResources(), R.color.colorAccent, null);

        thePaint.setColor(colorBackground);
        paintText.setColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
        paintText.setTextSize(70);

        imageView = findViewById(R.id.theImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawSomething(v);
                count++;

            }
        });

    }

    public void drawSomething(View view){
        int width = view.getWidth();
        int height = view.getHeight();
        int halfWidth = width/2;
        int halfHeight = height/2;

        if (count == 0){
            theBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
            imageView.setImageBitmap(theBitmap);
            theCanvas = new Canvas(theBitmap);

//            theCanvas.drawColor(colorBackground);
            theCanvas.drawText(getString(R.string.keepTapping),100,100,paintText);

            System.out.println("count : "+count);}
         if(count == 1 ){
            thePaint.setColor(getResources().getColor(R.color.newBackground));
             rect.set(0,0,width,height);
             theCanvas.drawRect(rect,thePaint);


            System.out.println("count : "+count);}
        if(count == 2){
            System.out.println("count : "+count);
            thePaint.setColor(getResources().getColor(R.color.yellow));
            theCanvas.drawCircle(width/2, height/2, width/3, thePaint);

            thePaint.setColor(Color.BLACK);
            thePaint.setStyle(Paint.Style.STROKE);
            thePaint.setStrokeWidth(8);
            theCanvas.drawCircle(width/2, height/2, width/3, thePaint);

            thePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        if(count == 3){
            thePaint.setColor(Color.BLACK);
            theCanvas.drawCircle(width/2 - width/8, height/2 - height/12, width/30, thePaint);
            theCanvas.drawCircle(width/2 + width/8, height/2 - height/12, width/30, thePaint);

            System.out.println("count : "+count);
        }
        if(count == 4){
            RectF oval = new RectF(width/2 - width/4, height/2 - height/8, width/2 + width/4, height/2 + height/8);
            thePaint.setStyle(Paint.Style.STROKE);
            thePaint.setStrokeWidth(8);
            theCanvas.drawArc(oval, 0, 180, true, thePaint);

            System.out.println("count : "+count);
        }

        view.invalidate();

    }
}


