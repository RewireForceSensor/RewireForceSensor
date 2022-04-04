package com.example.rewirebluetoothforcesensor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoadCellView extends View {

    Paint paint = new Paint();

    public LoadCellView(Context context, AttributeSet attrs) {
        //super(context);
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        RectF r = new RectF(0, 0, getWidth(), getHeight());
        paint.setColor(Color.TRANSPARENT);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(r, 25, 25, paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
        canvas.drawRoundRect(r, 75, 75, paint);

//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(100, 100, 100, paint);
//        canvas.drawCircle(getWidth()-100, getHeight()-100, 100, paint);
//        canvas.drawCircle(getWidth()-100, 100, 100, paint);
//        canvas.drawCircle(100, getHeight()-100, 100, paint);
    }

    //TODO: Override this function properly in order to make this view fit the fragment

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
