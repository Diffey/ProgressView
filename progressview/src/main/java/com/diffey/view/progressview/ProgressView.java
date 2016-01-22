package com.diffey.view.progressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 * Created by diff on 2016/1/22.
 */
public class ProgressView extends View {


    private int max = 100;
    private int progress = 0;
    private int progressColor = Color.BLUE;
    private String text = "";
    private int textColor = Color.WHITE;

    private Paint mPaint;

    public ProgressView(Context context) {
        super(context);
        init();
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProgressView);
        max = typedArray.getInt(R.styleable.ProgressView_max, 100);
        progress = typedArray.getInt(R.styleable.ProgressView_progress, 0);
        progressColor = typedArray.getColor(R.styleable.ProgressView_progressColor, Color.BLUE);
        text = typedArray.getString(R.styleable.ProgressView_text);
        textColor = typedArray.getColor(R.styleable.ProgressView_textColor, Color.WHITE);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
        invalidate();
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public int getProgressColor() {
        return progressColor;
    }

    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
        invalidate();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        mPaint.setColor(progressColor);
        canvas.drawRect(0, 0, width * progress / max, height, mPaint);

        mPaint.setColor(textColor);
        mPaint.setTextSize(25);
        canvas.drawText(text, 0, height / 2 + 25 / 2, mPaint);
    }
}
