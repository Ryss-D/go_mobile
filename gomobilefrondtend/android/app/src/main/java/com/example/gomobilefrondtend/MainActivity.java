package com.example.gomobilefrontend;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import go_mobile.Go_mobile;

public class MainActivity extends FlutterActivity {
  private static final String CHANNEL = "example.com/go_mobile";

  @Override
  public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {

    Go_mobile go_mobile = new Go_mobile();

    super.configureFlutterEngine(flutterEngine);
      new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
        .setMethodCallHandler(
          (call, result) -> {
            if(call.method.equals("getRandomNumber")) {
              result.success(go_mobile.randomNumber());
            }
            else {
              result.notImplemented();
            }
          }
        );
  }
}

