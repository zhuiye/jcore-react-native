
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
import cn.jiguang.api.utils.JCollectionAuth;
import cn.jiguang.api.JCoreInterface;

public class JCoreModuleImpl  {

   public static ReactApplicationContext reactContext;

   public static final String NAME = "JCoreModule";

    public JCoreModuleImpl(ReactApplicationContext reactApplicationContext) {
       reactContext = reactApplicationContext;
    }

  

    public void setAuth(boolean bool){
        JCollectionAuth.setAuth(reactContext,bool);
    }

    public void enableAutoWakeup(boolean bool) {
        JCollectionAuth.enableAutoWakeup(reactContext,bool);
    }

    public void setCountryCode(ReadableMap readableMap){
        if (readableMap == null) {
            return;
        }
        String code = readableMap.getString("code");
        if (TextUtils.isEmpty(code)) {
        } else {
            JCoreInterface.setCountryCode(reactContext,code);
        }
    }

    public void enableSDKLocalLog(ReadableMap readableMap){
        if (readableMap == null) {
            return;
        }
        boolean enable = false;
        if (readableMap.hasKey("enable")) {
            enable = readableMap.getBoolean("enable");
        }
        boolean uploadJgToServer = false;
       if (readableMap.hasKey("uploadJgToServer")) {
            uploadJgToServer = readableMap.getBoolean("uploadJgToServer");
        }
        JCoreInterface.enableSDKLocalLog(reactContext,enable,uploadJgToServer);
    }

    public void readNewLogs(Callback callback) {
        if (callback == null) {
            return;
        }
        String logs = JCoreInterface.readNewLogs(reactContext);
        WritableMap writableMap = Arguments.createMap();
        writableMap.putString("logs", logs);
        callback.invoke(writableMap);
    }


}
