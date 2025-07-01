package cn.jiguang.plugins.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;


import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;

import cn.jiguang.api.utils.JCollectionAuth;
import cn.jiguang.api.JCoreInterface;



public class JCoreModule extends NativeJCoreSpec {

    private final JCoreModuleImpl delegate;

    public JCoreModule(ReactApplicationContext reactContext) {
        super(reactContext);
        delegate = new JCoreModuleImpl(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return JCoreModuleImpl.NAME;
    }

    @Override
    public void setAuth(boolean bool) {
        delegate.setAuth(bool);
    }

    @Override
    public void enableAutoWakeup(boolean bool) {
        delegate.enableAutoWakeup(bool);
    }

    @Override
    public void setCountryCode(ReadableMap readableMap) {
        delegate.setCountryCode(readableMap);
    }

    @Override
    public void enableSDKLocalLog(ReadableMap readableMap) {
        delegate.enableSDKLocalLog(readableMap);
    }

    @Override
    public void readNewLogs(Callback callback) {
        delegate.readNewLogs(callback);
    }
}