package com.reactnativevideocache.rnvideocache;

import com.danikula.videocache.HttpProxyCacheServer;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNVideoCacheModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "RNVideoCache";
    private static ReactApplicationContext reactContext = null;
    private HttpProxyCacheServer proxy;

    public RNVideoCacheModule(ReactApplicationContext context) {
        // Pass in the context to the constructor and save it so you can emit events
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        super(context);

        reactContext = context;
    }

    @Override
    public String getName() {
        // Tell React the name of the module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        return REACT_CLASS;
    }

    @ReactMethod
    public void convert(
            String url,
            Promise promise) {
        if (this.proxy == null) {
            this.proxy = new HttpProxyCacheServer(RNVideoCacheModule.reactContext);
        }
        promise.resolve(this.proxy.getProxyUrl(url));
    }

}
