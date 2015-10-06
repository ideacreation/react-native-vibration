package com.eguma.vibration;

import android.os.Vibrator;
import android.content.Context;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;

public class VibrationModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public VibrationModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "VibrationAndroid";
  }

  @ReactMethod
  public void vibrate(int duration) {
    Vibrator v = (Vibrator) reactContext.getSystemService(Context.VIBRATOR_SERVICE);
    if (v == null) return;

    v.vibrate(duration);
  }
}
