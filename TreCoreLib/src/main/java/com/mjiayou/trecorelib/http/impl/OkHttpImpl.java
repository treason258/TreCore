package com.mjiayou.trecorelib.http.impl;

import com.mjiayou.trecorelib.http.callback.BaseCallback;
import com.mjiayou.trecorelib.http.RequestEntity;
import com.mjiayou.trecorelib.http.RequestSender;
import com.mjiayou.trecorelib.util.LogUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;

/**
 * Created by xin on 18/10/16.
 */

public class OkHttpImpl extends RequestSender {

    @Override
    public void send(final RequestEntity requestEntity, final BaseCallback callback) {
        final String logTag = "send";
        logRequest(logTag, requestEntity);

        RequestCall requestCall = null;
        switch (requestEntity.getMethod()) {
            case POST_STRING:
                requestCall = OkHttpUtils
                        .postString()
                        .url(requestEntity.getUrl())
                        .headers(requestEntity.getHeaders())
                        .content(requestEntity.getContent())
                        .mediaType(MediaType.parse("application/json; charset=utf-8"))
                        .build();
                break;
            case POST:
                requestCall = OkHttpUtils
                        .post()
                        .url(requestEntity.getUrl())
                        .headers(requestEntity.getHeaders())
                        .params(requestEntity.getParams())
                        .build();
                break;
            case GET:
                requestCall = OkHttpUtils
                        .get()
                        .url(requestEntity.getUrl())
                        .headers(requestEntity.getHeaders())
                        .params(requestEntity.getParams())
                        .build();
                break;
            case POST_FILE:
                PostFormBuilder postFormBuilder = OkHttpUtils.post();
                Map<String, File> files = requestEntity.getFiles();
                Set<Map.Entry<String, File>> sets = files.entrySet();
                for (Map.Entry<String, File> entry : sets) {
                    File file = entry.getValue();
                    postFormBuilder.addFile(entry.getKey(), file.getName(), file);
                }
                requestCall = postFormBuilder
                        .url(requestEntity.getUrl())
                        .headers(requestEntity.getHeaders())
                        .params(requestEntity.getParams())
                        .build();
                break;
            default:
                break;
        }

        if (requestCall != null) {
            requestCall.execute(new StringCallback() {
                @Override
                public void onBefore(Request request, int id) {
                    super.onBefore(request, id);
                    if (callback != null) {
                        callback.onStart();
                    }
                }

                @Override
                public void onAfter(int id) {
                    super.onAfter(id);
                    if (callback != null) {
                        callback.onEnd();
                    }
                }

                @Override
                public void inProgress(float progress, long total, int id) {
                    super.inProgress(progress, total, id);
                    if (callback != null) {
                        callback.onProgress(progress, total);
                    }
                }

                @Override
                public void onError(Call call, Exception e, int id) {
                    if (callback != null) {
                        callback.onException(e);
                    }
                }

                @Override
                public void onResponse(String responseData, int id) {
                    logResponse(logTag, requestEntity, responseData);

                    if (callback != null) {
                        callback.onResult(responseData);
                    }
                }
            });
        }
    }

    @Override
    public void downloadFile(String url, FileCallBack fileCallBack) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(fileCallBack);
    }
}
