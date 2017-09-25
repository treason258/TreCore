package com.mjiayou.trecore.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mjiayou.trecore.R;
import com.mjiayou.trecorelib.base.TCActivity;
import com.mjiayou.trecorelib.bean.entity.TCMenu;
import com.mjiayou.trecorelib.dialog.DialogHelper;
import com.mjiayou.trecorelib.dialog.TCAlertDialog;
import com.mjiayou.trecorelib.util.LogUtils;
import com.mjiayou.trecorelib.util.MenuUtil;
import com.mjiayou.trecorelib.util.SharedUtil;
import com.mjiayou.trecorelib.util.ToastUtils;
import com.mjiayou.trecorelib.util.UserUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by treason on 2017/9/25.
 */

public class TestActivity extends TCActivity {

    @InjectView(R.id.layout_menu_container)
    LinearLayout mLayoutMenuContainer;
    @InjectView(R.id.tv_info)
    TextView mTvInfo;

    @Override
    protected int getLayoutId() {
        return R.layout.tc_activity_menu;
    }

    @Override
    protected void afterOnCreate(Bundle savedInstanceState) {

        // mTitleBar
        getTitleBar().setTitle(TAG);
        getTitleBar().addLeftImageView(R.mipmap.tc_launcher, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.show("addLeftImageView");
            }
        });
        getTitleBar().addRightTextView("Debug", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.show("addRightTextView");
            }
        });

        // MaterialDrawer
        initMaterialDrawer();

        // mLayoutMenuContainer
        MenuUtil.setMenus(mContext, mLayoutMenuContainer, getMenus());
    }

    /**
     * MaterialDrawer
     */
    private void initMaterialDrawer() {
        // accountHeader
        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(true)
                .withHeaderBackground(R.drawable.tc_shape_rect_gradient_theme)
                .addProfiles(
                        new ProfileDrawerItem().withName("NameA").withEmail("EmailA").withIdentifier(0).withIcon(R.mipmap.tc_launcher),
                        new ProfileDrawerItem().withName("NameB").withEmail("EmailB").withIdentifier(1).withIcon(R.mipmap.tc_launcher),
                        new ProfileDrawerItem().withName("NameC").withEmail("EmailC").withIdentifier(2).withIcon(R.mipmap.tc_launcher))
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        ToastUtils.show("onProfileChanged | profile.getIdentifier() -> " + profile.getIdentifier() + " | profile.getName() -> " + profile.getName());
                        return true;
                    }
                })
                .build();
        accountHeader.setActiveProfile(0);

        // drawerBuilder
        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withSliderBackgroundColor(getResources().getColor(R.color.tc_white_alpha_light))
                .withAccountHeader(accountHeader)
                .addDrawerItems(
                        new SectionDrawerItem().withName("SectionDrawerA"),
                        new PrimaryDrawerItem().withName("PrimaryDrawer000").withIcon(R.mipmap.tc_launcher).withIdentifier(0).withDescription("description000"),
                        new SectionDrawerItem().withName("SectionDrawerB"),
                        new PrimaryDrawerItem().withName("PrimaryDrawer111").withIcon(R.mipmap.tc_launcher).withIdentifier(1),
                        new SectionDrawerItem().withName("SectionDrawerC"),
                        new PrimaryDrawerItem().withName("PrimaryDrawer222").withIcon(R.mipmap.tc_launcher),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("PrimaryDrawer333"),
                        new PrimaryDrawerItem().withName("PrimaryDrawer444")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        ToastUtils.show("onItemClick | drawerItem.getIdentifier() -> " + drawerItem.getIdentifier());
                        return true;
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(View view, int position, IDrawerItem drawerItem) {
                        ToastUtils.show("onItemLongClick | drawerItem.getIdentifier() -> " + drawerItem.getIdentifier());
                        return true;
                    }
                })
                .build();
        drawer.setSelection(0);
    }

    /**
     * getMenus
     */
    public List<TCMenu> getMenus() {
        List<TCMenu> tcMenus = new ArrayList<>();
        tcMenus.add(new TCMenu("LOG AND TOAST", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.show("LOG AND TOAST TEST");
                LogUtils.i("LOG AND TOAST TEST");
            }
        }));
        tcMenus.add(new TCMenu("设置为第一次启动", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogHelper.createTCAlertDialog(mContext,
                        "提示", "确认设置为第一次启动？",
                        "确定", "取消", true,
                        new TCAlertDialog.OnTCActionListener() {
                            @Override
                            public void onOkAction() {
                                SharedUtil.get(mContext).setConfigIsFirst(true);
                                ToastUtils.show("设置第一次启动成功");
                            }

                            @Override
                            public void onCancelAction() {
                            }
                        }).show();
            }
        }));
        tcMenus.add(new TCMenu("模拟登录", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogHelper.createTCAlertDialog(mContext,
                        "提示", "确认模拟登陆？",
                        "确定", "取消", true,
                        new TCAlertDialog.OnTCActionListener() {
                            @Override
                            public void onOkAction() {
                                UserUtil.doLogin("12345678901234567890123456789012");
                                ToastUtils.show("模拟登录成功");
                            }

                            @Override
                            public void onCancelAction() {
                            }
                        }).show();
            }
        }));
        tcMenus.add(new TCMenu("退出登录", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogHelper.createTCAlertDialog(mContext,
                        "提示", "确认退出登录？",
                        "确定", "取消", true,
                        new TCAlertDialog.OnTCActionListener() {
                            @Override
                            public void onOkAction() {
                                UserUtil.doLogout();
                                ToastUtils.show("退出登录成功");
                            }

                            @Override
                            public void onCancelAction() {
                            }
                        }).show();
            }
        }));
        tcMenus.add(new TCMenu("NullPointExceptionTest", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogHelper.createTCAlertDialog(mContext,
                        "提示", "确认抛出NullPointerException？",
                        "确定", "取消", true,
                        new TCAlertDialog.OnTCActionListener() {
                            @Override
                            public void onOkAction() {
                                // 抛出异常
                                throw new NullPointerException("NullPointExceptionTest");
                            }

                            @Override
                            public void onCancelAction() {
                            }
                        }).show();
            }
        }));
        tcMenus.add(new TCMenu("WebViewActivity", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, WebViewActivity.class));
            }
        }));
        return tcMenus;
    }

    // ******************************** project ********************************
}