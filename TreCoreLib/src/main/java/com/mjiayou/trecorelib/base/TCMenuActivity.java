package com.mjiayou.trecorelib.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mjiayou.trecorelib.R;
import com.mjiayou.trecorelib.bean.entity.TCMenu;
import com.mjiayou.trecorelib.util.MenuUtils;

import java.util.List;

/**
 * TCMenuActivity
 */
public class TCMenuActivity extends TCActivity {

    private LinearLayout mLayoutMenuContainer;
    private TextView mTvInfo;

    private static String mTitle;
    private static String mInfo;
    private static List<TCMenu> mTCMenus;

    /**
     * startActivity
     */
    public static void open(Context context, String title, String info, List<TCMenu> tcMenus) {
        mTitle = title;
        mInfo = info;
        mTCMenus = tcMenus;
        Intent intent = new Intent(context, TCMenuActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.tc_activity_menu;
    }

    @Override
    protected void afterOnCreate(Bundle savedInstanceState) {
        // mTitleBar
        if (!TextUtils.isEmpty(mTitle)) {
            getTitleBar().setTitle(mTitle);
        }

        // findViewById
        mLayoutMenuContainer = (LinearLayout) findViewById(R.id.layout_menu_container);
        mTvInfo = (TextView) findViewById(R.id.tv_info);

        // mLayoutMenuContainer
        if (mTCMenus == null) {
            mLayoutMenuContainer.setVisibility(View.GONE);
        } else {
            MenuUtils.setMenus(mContext, mLayoutMenuContainer, mTCMenus);
        }

        // mTvInfo
        if (TextUtils.isEmpty(mInfo)) {
            mTvInfo.setVisibility(View.GONE);
        } else {
            mTvInfo.setText(mInfo);
        }
    }
}
