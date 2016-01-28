package com.diffey.view.progressview;

import android.content.Context;

/**
 * Created by diff on 2016/1/28.
 */
public class ViewUtil {

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static float sp2px(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return spValue * scale;
    }
}
