package com.example.yf.creatorshirt.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * dp与px单位间的相互转换
 */
public class DisplayUtil {
    public static int Dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int Px2Dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    public static int getScreenW(Context context) {
        DisplayMetrics metric = context.getResources().getDisplayMetrics();
        return metric.widthPixels;
    }

    public static int getScreenH(Context context) {
        DisplayMetrics metric = context.getResources().getDisplayMetrics();
        return metric.heightPixels;
    }

    public static int getScreenHWithoutStateBar(Context context) {
        DisplayMetrics metric = context.getResources().getDisplayMetrics();
        Rect frame = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        // 状态栏高度
        int statusBarHeight = frame.top;
        return metric.heightPixels - statusBarHeight;
    }

    /**
     * 动态设置对话框的宽为屏幕四分之三
     */
    public static void calculateDialogWidth(Context context, LinearLayout linearLayout) {
        int width = getScreenW(context);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = width / 2 + width / 4;
        linearLayout.setLayoutParams(layoutParams);
    }

    /**
     * 设置定制布局的宽和高
     *
     * @param context
     * @param linearLayout
     */
    public static void calculateItemWidth(Context context, LinearLayout linearLayout) {
        int width = getScreenW(context);
        int height = getScreenH(context);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = width / 3;
        layoutParams.height = height / 5;
        linearLayout.setLayoutParams(layoutParams);

    }

    /**
     * 设置定制布局的宽和高
     *
     * @param context
     * @param linearLayout
     */
    public static void calculateItem2Width(Context context, LinearLayout linearLayout) {
        int width = getScreenW(context);
        int height = getScreenH(context);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = width / 3;
        linearLayout.setLayoutParams(layoutParams);

    }

    /**
     * 设置定制布局的宽和高
     * @param context
     * @param linearLayout
     */
    public static void calculateDesignerClothesWidth(Context context, ImageView linearLayout) {
        int width = getScreenW(context);
        int height = getScreenH(context);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = width / 3;
        linearLayout.setLayoutParams(layoutParams);

    }

    /**
     * 设置衣服背景的高度
     *
     * @param context
     * @param mContainerBackground
     */
    public static void calculateBGWidth(Context context, RelativeLayout mContainerBackground) {
        int height = getScreenH(context);
        ViewGroup.LayoutParams layoutParams = mContainerBackground.getLayoutParams();
        layoutParams.height = height / 2;
        mContainerBackground.setLayoutParams(layoutParams);
    }

    public static void calculateRelative(Context context, RelativeLayout mRelative) {
        int height = getScreenH(context);
        ViewGroup.LayoutParams layoutParams = mRelative.getLayoutParams();
        layoutParams.height = height / 2;
        mRelative.setLayoutParams(layoutParams);
    }

    public static void calculateItemSizeWidth(Context context, LinearLayout mll) {
        int width = getScreenW(context);
        ViewGroup.LayoutParams layoutParams = mll.getLayoutParams();
        layoutParams.width = (int) (width / 6.5);
        mll.setLayoutParams(layoutParams);
    }
}
