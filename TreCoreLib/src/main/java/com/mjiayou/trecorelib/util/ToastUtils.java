package com.mjiayou.trecorelib.util;

import android.content.Context;
import android.widget.Toast;

import com.mjiayou.trecorelib.base.TCApp;
import com.mjiayou.trecorelib.helper.TCHelper;

/**
 * Toast显示封装--OK
 * <p>
 * Created by treason on 16/5/14.
 */
public class ToastUtils {

    private static final String TAG = ToastUtils.class.getSimpleName();

    private static Toast mToast = null;

    /**
     * 显示Toast - 默认context
     */
    public static void show(String text, int duration) {
        showToast(text, duration);
    }

    /**
     * 显示Toast - LENGTH_SHORT
     */
    public static void show(String text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    /**
     * 显示Toast - LENGTH_LONG
     */
    public static void showLong(String text) {
        showToast(text, Toast.LENGTH_LONG);
    }

    /**
     * 显示Toast - core
     */
    private static void showToast(String text, int duration) {
        Context context = TCApp.get();
        if (context == null) {
            LogUtils.e(TAG, TCHelper.ERROR_CONTEXT_NULL);
            return;
        }

        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
        }
        mToast.show();
        LogUtils.i(TAG, text);
    }
}
