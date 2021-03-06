package com.mjiayou.trecorelib.helper;

import android.content.Context;

import com.mjiayou.trecorelib.util.LogUtils;

/**
 * Created by treason on 16/5/14.
 */
public class UmengHelper {

    private static final String TAG = UmengHelper.class.getSimpleName();

    // 在线参数
    public static final String PARAM_TEST = "test_by_treason"; // 测试 - umeng online params test success!!!!!!
    public static final String PARAM_CHECK_UPDATE_AUTO = "check_update_auto"; // 是否自动检测更新 - true
    public static final String PARAM_CHECK_UPDATE_FORCE = "check_update_force"; // 是否强制用户更新 - false

    // 自定义事件
    public static final String EVENT_UMENG_INIT = "test_umeng_init";
    public static final String EVENT_DEBUG_OPEN = "test_debug_open";

    // 第三方分享
    public static final int SHARE_FOR_NORMAL = 0;
    public static final int SHARE_FOR_OTHER = 1;

    // meta-data
//    public static final String META_UMENG_APPKEY = "UMENG_APPKEY";
//    public static final String META_UMENG_CHANNEL = "UMENG_CHANNEL";

    /**
     * 初始化
     */
    public static void init(Context context) {
        LogUtils.printInit(TAG);
        // 友盟功能:
        // 应用统计、第三方登录、第三方分享
        // 自定义参数、自动更新

//        // 友盟调试模式
//        MobclickAgent.setDebugMode(Configs.DEBUG_UMENG);
//        // 友盟异常统计
//        MobclickAgent.setCatchUncaughtExceptions(true);

//        // 社会化分享调试模式
//        com.umeng.socialize.utils.Log.LOG = Configs.DEBUG_UMENG;

//        // 在线参数调试模式
//        OnlineConfigAgent.getInstance().setDebugMode(Configs.DEBUG_UMENG);
//        // 自动更新调试模式
//        UpdateConfig.setDebug(Configs.DEBUG_UMENG);
//        // 自动更新集成检测
//        UmengUpdateAgent.setUpdateCheckConfig(Configs.DEBUG_UMENG);
//        // 用户反馈调试模式
//        com.umeng.fb.util.Log.LOG = Configs.DEBUG_UMENG;

//        // 友盟统计，统计APP打开次数
//        UmengHelper.onEvent(context, UmengHelper.EVENT_UMENG_INIT);
//
//        // 如有需要，更新在线参数，并测试
//        updateOnlineConfig(context);
//        LogUtils.i(TAG, "测试友盟在线参数 -> test_by_treason=" + getOnlineParam(context, UmengHelper.PARAM_TEST));
    }

//    // ******************************** 统计分析 ********************************
//
//    /**
//     * 手动提交错误日志-throwable
//     */
//    public static void reportError(Context context, Throwable throwable) {
//        MobclickAgent.reportError(context, throwable);
//    }
//
//    /**
//     * 手动提交错误日志-error
//     */
//    public static void reportError(Context context, String error) {
//        MobclickAgent.reportError(context, error);
//    }

//    // ******************************** 自定义事件 ********************************
//
//    /**
//     * 计数事件
//     */
//    public static void onEvent(Context context, String eventId) {
//        MobclickAgent.onEvent(context, eventId);
//    }

//    // ******************************** 在线参数 ********************************
//
//    /**
//     * 更新在线参数
//     */
//    public static void updateOnlineConfig(final Context context) {
//        // 更新在线参数回调
//        OnlineConfigAgent.getInstance().setOnlineConfigListener(new UmengOnlineConfigureListener() {
//            @Override
//            public void onDataReceived(JSONObject jsonObject) {
//                if (jsonObject != null) {
//                    LogUtils.i(TAG, "更新友盟在线参数成功:jsonObject -> " + jsonObject.toString());
//                } else {
//                    LogUtils.i(TAG, "更新友盟在线参数失败");
//                }
//            }
//        });
//        // 更新在线参数
//        OnlineConfigAgent.getInstance().updateOnlineConfig(context);
//    }
//
//    /**
//     * 获取在线参数
//     */
//    public static String getOnlineParam(Context context, String key) {
//        String data = OnlineConfigAgent.getInstance().getConfigParams(context, key);
//        LogUtils.i(TAG, "获取友盟在线参数:" + key + " -> " + data);
//        return data;
//    }

//    // ******************************** 自动更新 ********************************
//
//    /**
//     * 自动检查更新-可选择
//     */
//    public static void checkUpdateAuto(Context context) {
//        UmengUpdateAgent.setUpdateOnlyWifi(true);
//        UmengUpdateAgent.update(context);
//    }
//
//    /**
//     * 自动检查更新-强制更新
//     */
//    public static void checkUpdateAutoForce(Context context) {
//        UmengUpdateAgent.setUpdateOnlyWifi(false);
//        UmengUpdateAgent.setDialogListener(new UmengDialogButtonListener() {
//            @Override
//            public void onClick(int status) {
//                switch (status) {
//                    case UpdateStatus.Update:
//                        break;
//                    default:
//                        // 退出应用
//                        ActivityManager.get().clearAllActivity();
//                }
//            }
//        });
//        UmengUpdateAgent.forceUpdate(context);
//    }
//
//    /**
//     * 手动检查更新
//     */
//    public static void checkUpdateManual(final Context context) {
//        UmengUpdateAgent.setUpdateListener(new UmengUpdateListener() {
//            @Override
//            public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
//                switch (updateStatus) {
//                    case UpdateStatus.Yes: // has update
//                        UmengUpdateAgent.showUpdateDialog(context, updateInfo);
//                        break;
//                    case UpdateStatus.No: // has no update
//                        ToastUtil.show("您使用的是最新的版本");
//                        break;
//                    case UpdateStatus.NoneWifi: // none wifi
//                        ToastUtil.show("没有wifi连接，只在wifi下才能更新");
//                        break;
//                    case UpdateStatus.Timeout: // time out
//                        ToastUtil.show("检查更新超时");
//                        break;
//                }
//            }
//        });
//        UmengUpdateAgent.forceUpdate(context);
//    }

//    // ******************************** 意见反馈 ********************************
//
//    /**
//     * 打开意见反馈页面
//     */
//    public static void openFeedback(Context context) {
//        FeedbackAgent agent = new FeedbackAgent(context);
//        agent.startFeedbackActivity();
//    }

//    // ******************************** 第三方登陆 ********************************
//
//    /**
//     * UMServiceFactory.getUMSocialService("com.umeng.login")
//     */
//    private static UMSocialService mUMSocialLogin;
//
//    /**
//     * 授权认证回调
//     */
//    public interface OnDoOauthVerifyCallback {
//        void callback(Bundle value, SHARE_MEDIA platform);
//    }
//
//    /**
//     * 获取平台信息回调
//     */
//    public interface OnGetPlatformInfoCallback {
//        void callback(int status, Map<String, Object> info);
//    }
//
//    /**
//     * 获取UMServiceFactory.getUMSocialService("com.umeng.login")对象
//     */
//    public static UMSocialService getUMSocialLogin() {
//        if (mUMSocialLogin == null) {
//            mUMSocialLogin = UMServiceFactory.getUMSocialService("com.umeng.login");
//        }
//        return mUMSocialLogin;
//    }
//
//    /**
//     * 使用SSO授权必须添加如下代码，调用如下
//     * UmengHelper.onActivityResult(requestCode, resultCode, data);
//     */
//    public static void onActivityResult(int requestCode, int resultCode, Intent data) {
//        /**
//         * 使用SSO授权必须添加如下代码
//         */
//        UMSsoHandler ssoHandler = UmengHelper.getUMSocialLogin().getConfig().getSsoHandler(requestCode);
//        if (ssoHandler != null) {
//            ssoHandler.authorizeCallBack(requestCode, resultCode, data);
//        }
//    }
//
//    /**
//     * 第三方登陆注销
//     */
//    public static void deleteOauth(final Context context) {
//        SocializeListeners.SocializeClientListener listener = new SocializeListeners.SocializeClientListener() {
//            @Override
//            public void onStart() {
//                LogUtils.i(TAG, "第三方登陆注销开始");
//            }
//
//            @Override
//            public void onComplete(int status, SocializeEntity socializeEntity) {
//                if (status == 200) {
//                    LogUtils.i(TAG, "第三方登陆注销成功");
//                } else {
//                    LogUtils.i(TAG, "第三方登陆注销失败");
//                }
//            }
//        };
//
//        if (OauthHelper.isAuthenticated(context, SHARE_MEDIA.SINA)) {
//            getUMSocialLogin().deleteOauth(context, SHARE_MEDIA.SINA, listener);
//        }
//        if (OauthHelper.isAuthenticated(context, SHARE_MEDIA.QQ)) {
//            getUMSocialLogin().deleteOauth(context, SHARE_MEDIA.QQ, listener);
//        }
//    }

//    // ******************************** 第三方分享 ********************************
//
//    /**
//     * UMServiceFactory.getUMSocialService("com.umeng.share");
//     */
//    public static UMSocialService mUMSocialShare;
//
//    /**
//     * 获取UMServiceFactory.getUMSocialService("com.umeng.share")对象
//     */
//    public static UMSocialService getUMSocialShare() {
//        if (mUMSocialShare == null) {
//            mUMSocialShare = UMServiceFactory.getUMSocialService("com.umeng.share");
//        }
//        return mUMSocialShare;
//    }
//
//    /**
//     * 第三方分享
//     */
//    public static void openShare(final Activity activity, SHARE_MEDIA platform, int shareForWhat, TCUMShare TCUMShare, SocializeListeners.SnsPostListener snsPostListener) {
//
//        String title = TextViewUtil.dealWithQuot(TCUMShare.getTitle());
//        String content = TextViewUtil.dealWithQuot(TCUMShare.getDesc());
//        String imageUrl = TCUMShare.getImgUrl();
//        String targetUrl = TCUMShare.getTargetUrl();
//
//        // 打印
//        StringBuilder builder = new StringBuilder();
//        builder.append("分享内容");
//        builder.append("\ntitle -> ").append(title);
//        builder.append("\ncontent -> ").append(content);
//        builder.append("\nimageUrl -> ").append(imageUrl);
//        builder.append("\ntargetUrl -> ").append(targetUrl);
//        LogUtils.i(TAG, builder.toString());
//
//        // 本地图片
////        Bitmap bitmap = DeviceUtil.takeScreenShot(activity);
////        UMImage umImage = new UMImage(activity, bitmap);
//        // 在线图片
//        UMImage umImage = new UMImage(activity, imageUrl);
//
//        // 分享配置
//        // 新浪
//        getUMSocialShare().getConfig().setSsoHandler(new SinaSsoHandler());
//        // QQ
//        UMQQSsoHandler umqqSsoHandler = new UMQQSsoHandler(activity, Configs.QQ_APP_ID, Configs.QQ_APP_KEY);
//        umqqSsoHandler.addToSocialSDK();
//        // QQ空间
//        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(activity, Configs.QQ_APP_ID, Configs.QQ_APP_KEY);
//        qZoneSsoHandler.addToSocialSDK();
//        // 腾讯微博
//        getUMSocialShare().getConfig().setSsoHandler(new TencentWBSsoHandler());
//        // 微信
//        UMWXHandler wxHandler = new UMWXHandler(activity, Configs.WEIXIN_APP_ID, Configs.WEIXIN_APP_SECRET);
//        wxHandler.addToSocialSDK();
//        // 朋友圈
//        UMWXHandler wxCircleHandler = new UMWXHandler(activity, Configs.WEIXIN_APP_ID, Configs.WEIXIN_APP_SECRET);
//        wxCircleHandler.setToCircle(true);
//        wxCircleHandler.addToSocialSDK();
//
//        // 分享内容
//        switch (shareForWhat) {
//            default:
//            case SHARE_FOR_NORMAL:
//                // 通用
//                getUMSocialShare().setShareContent(content);
//                getUMSocialShare().setShareMedia(umImage);
//                // 新浪微博，分享不显示标题，且不可跳转到链接地址，图片可放大
//                SinaShareContent sinaShareContent = new SinaShareContent();
//                sinaShareContent.setTitle(title);
//                sinaShareContent.setShareContent(content + targetUrl); // 内容加链接
//                sinaShareContent.setTargetUrl(targetUrl);
//                sinaShareContent.setShareImage(umImage);
//                getUMSocialShare().setShareMedia(sinaShareContent);
//                // QQ好友，分享全部显示，图片centerCrop显示正方形不可放大
//                QQShareContent qqShareContent = new QQShareContent();
//                qqShareContent.setTitle(title);
//                qqShareContent.setShareContent(content);
//                qqShareContent.setTargetUrl(targetUrl);
//                qqShareContent.setShareImage(umImage);
//                getUMSocialShare().setShareMedia(qqShareContent);
//                // QQ空间，分享全部显示，图片centerCrop显示正方形不可放大
//                QZoneShareContent qZoneShareContent = new QZoneShareContent();
//                qZoneShareContent.setTitle(title);
//                qZoneShareContent.setShareContent(content);
//                qZoneShareContent.setTargetUrl(targetUrl);
//                qZoneShareContent.setShareImage(umImage);
//                getUMSocialShare().setShareMedia(qZoneShareContent);
//                // 腾讯微博，分享不显示标题，且不可跳转到链接地址，图片可放大
//                TencentWbShareContent tencentWbShareContent = new TencentWbShareContent();
//                tencentWbShareContent.setTitle(title);
//                tencentWbShareContent.setShareContent(content);
//                tencentWbShareContent.setTargetUrl(targetUrl);
//                tencentWbShareContent.setShareImage(umImage);
//                getUMSocialShare().setShareMedia(tencentWbShareContent);
//                // 微信好友，分享全部显示，图片centerCrop显示正方形不可放大
//                WeiXinShareContent weixinContent = new WeiXinShareContent();
//                weixinContent.setTitle(title);
//                weixinContent.setShareContent(content);
//                weixinContent.setTargetUrl(targetUrl);
//                weixinContent.setShareImage(umImage);
//                getUMSocialShare().setShareMedia(weixinContent);
//                // 朋友圈，分享不显示内容，图片centerCrop显示正方形不可放大
//                CircleShareContent circleMedia = new CircleShareContent();
//                circleMedia.setTitle(title);
//                circleMedia.setShareContent(content);
//                circleMedia.setTargetUrl(targetUrl);
//                circleMedia.setShareImage(umImage);
//                getUMSocialShare().setShareMedia(circleMedia);
//                break;
//            case SHARE_FOR_OTHER:
//                break;
//        }
//
//        // 分享
//        if (platform == null) { // 默认分享
//            getUMSocialShare().getConfig().setPlatformOrder(
//                    SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN,
//                    SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.TENCENT
//            );
//            getUMSocialShare().getConfig().removePlatform(SHARE_MEDIA.TENCENT);
//            getUMSocialShare().openShare(activity, snsPostListener);
//        } else { // 指定分享
//            getUMSocialShare().postShare(activity, platform, snsPostListener);
//        }
//    }
//
//    public static void openShare(final Activity activity, SHARE_MEDIA platform, int shareForWhat, TCUMShare tcumShare) {
//        openShare(activity, platform, shareForWhat, tcumShare, new MySnsPostListener(activity));
//    }
//
//    /**
//     * 默认分享回调
//     */
//    public static class MySnsPostListener implements SocializeListeners.SnsPostListener {
//
//        private Context mContext;
//
//        public MySnsPostListener(Context context) {
//            this.mContext = context;
//        }
//
//        @Override
//        public void onStart() {
//            ToastUtil.show(mContext, "正在分享");
//        }
//
//        @Override
//        public void onComplete(SHARE_MEDIA share_media, int code, SocializeEntity socializeEntity) {
//            if (code == 200) {
//                ToastUtil.show(mContext, "分享成功");
//
//            } else {
//                String msg = "";
//                if (code == -101) {
//                    msg = "没有授权";
//                }
//                LogUtils.i(TAG, "分享失败[" + code + "]" + msg);
//            }
//        }
//    }
}
