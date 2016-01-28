package com.diffey.view.progressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by diff on 2016/1/22.
 */
public class ProgressView extends View {
    private static final int DEF_MAX = 100;
    private static final int DEF_PROGRESS = 0;
    private static final int DEF_PROGRESS_COLOR = Color.BLUE;
    private static final int DEF_BACKGROUND_COLOR = Color.TRANSPARENT;
    private static final int DEF_TEXT_COLOR = Color.WHITE;
    private static final float DEF_TEXT_SIZE = 25;
    private static final float DEF_TEXT_LEFT_PADDING = 10;


    private int max = DEF_MAX;
    private int progress = DEF_PROGRESS;
    private int progressColor = DEF_PROGRESS_COLOR;
    private int backgroundColor = DEF_BACKGROUND_COLOR;
    private String text;
    private int textColor = DEF_TEXT_COLOR;
    private float textSize = DEF_TEXT_SIZE;
    private float textLeftPadding = DEF_TEXT_LEFT_PADDING;

    private Paint mPaint;

    public ProgressView(Context context) {
        super(context);
        inflateAttrs(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateAttrs(context, attrs);
    }

    private void inflateAttrs(Context context, AttributeSet attrs) {
        mPaint = new Paint();

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProgressView);
            max = typedArray.getInt(R.styleable.ProgressView_max, DEF_MAX);
            progress = typedArray.getInt(R.styleable.ProgressView_progress, DEF_PROGRESS);
            progressColor = typedArray.getColor(R.styleable.ProgressView_progressColor, DEF_PROGRESS_COLOR);
            backgroundColor = typedArray.getColor(R.styleable.ProgressView_backgroundColor, DEF_BACKGROUND_COLOR);
            text = typedArray.getString(R.styleable.ProgressView_text);
            textColor = typedArray.getColor(R.styleable.ProgressView_textColor, DEF_TEXT_COLOR);
            textSize = typedArray.getDimension(R.styleable.ProgressView_textSize, DEF_TEXT_SIZE);
            textLeftPadding = typedArray.getDimension(R.styleable.ProgressView_textLeftPadding, DEF_TEXT_LEFT_PADDING);
            typedArray.recycle();
        }
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

    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        invalidate();
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
        invalidate();
    }

    public float getTextLeftPadding() {
        return textLeftPadding;
    }

    public void setTextLeftPadding(float textLeftPadding) {
        this.textLeftPadding = textLeftPadding;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(backgroundColor);

        int width = getWidth();
        int height = getHeight();
        mPaint.setColor(progressColor);
        canvas.drawRect(0, 0, width * progress / max, height, mPaint);

        if (text != null) {
            mPaint.setColor(textColor);
            mPaint.setTextSize(textSize);
            Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
            canvas.drawText(text, textLeftPadding, (height - fontMetrics.top - fontMetrics.bottom) / 2, mPaint);
        }
    }
}
