package com.example.tema2.classes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.tema2.R;

import java.util.Map;
import java.util.Random;

public class GraphView extends View {

    private final Context context;
    private final Map<String,Integer> source;
    private final Paint paint;
    private Random random;

    public GraphView(Context context,Map<String,Integer> source) {
        super(context);
        this.context = context;
        this.source = source;
        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.paint.setColor(Color.BLACK);
        this.random = new Random();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(source.isEmpty()){
            return;
        }
        //latime bara
        float widthBar = getWidth()/source.size();
        int maxValue = getMaxValue();
        int currentBarPosition = 0;
        for(String label:source.keySet()){
            //valoare bara curenta
            int value = source.get(label);
            //generare culoare
            int color = Color.argb(100,1+random.nextInt(254),1+random.nextInt(254),1+random.nextInt(254));
            paint.setColor(color);

            //determinare coordonate bara
            float x1 = currentBarPosition*widthBar;
            float y1 = (1-(float)(value)/maxValue)*getHeight();
            float x2 = x1+ widthBar;
            float y2 = getHeight();
            canvas.drawRect(x1,y1,x2,y2,paint);

            //trasare legenda
            paint.setColor(Color.BLACK);
            paint.setTextSize((float) (0.25*widthBar));
            float x = (float) ((currentBarPosition+0.5)*widthBar);
            float y = (float)(0.95*getHeight());
            canvas.rotate(270,x,y);
            canvas.drawText(context.getString(R.string.graph_legend,label,value),x,y,paint);
            canvas.rotate(-270,x,y);
            currentBarPosition++;
        }
    }

    private int getMaxValue() {
        int max = 0;
        for(Integer value:source.values()){
            if(max<value){
                max = value;
            }
        }
        return max;
    }
}
