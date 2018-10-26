# InfoView  [![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-InfoView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6275)
A simple and easy to use information view for Android.

|Screenshot|Video demo|
|---|---|
|<img src="https://raw.githubusercontent.com/marcoscgdev/InfoView/master/device-2017-10-02-181419.png" width="350">|<img src="https://raw.githubusercontent.com/marcoscgdev/InfoView/master/device-2017-10-02-183520.gif" width="350">|

Download APK: https://github.com/marcoscgdev/InfoView/releases/download/1.0.0/app-debug.apk

## Usage:

### Adding the depencency

Add this to your root *build.gradle* file:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Now add the dependency to your app build.gradle file:

```
implementation 'com.github.marcoscgdev:InfoView:1.0.1'
```

### Using the view

- XML

```xml
<com.marcoscg.infoview.InfoView
    android:id="@+id/info_view"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_centerVertical="true"
    app:iv_title="Oops!"
    app:iv_message="That should not have happened."
    app:iv_icon="@drawable/ic_sad_emoji"
    app:iv_buttonText="Try again"
    app:iv_buttonTextColor="@color/colorAccent"
    app:iv_showButton="true"/>
```

- Java

```java
InfoView infoView = (InfoView) findViewById(R.id.info_view);
infoView.setTitle("Oops!");
infoView.setMessage("That should not have happened.");
infoView.setIconRes(R.drawable.ic_sad_emoji);
infoView.setButtonText("Try again");
infoView.setButtonTextColorRes(R.color.colorAccent);
infoView.setOnTryAgainClickListener(new InfoView.OnTryAgainClickListener() {
    @Override
    public void onTryAgainClick() {
        Toast.makeText(MainActivity.this, "Try again clicked!", Toast.LENGTH_SHORT).show();
    }
});
```

### Using progressbar
```java
infoView.setProgress(true); // Show the progressbar
infoView.setProgress(false); // Hide the progressbar and show the info content
```

---
>See the *sample project* to clarify any queries you may have.

---

## License

```
Copyright 2017 Marcos Calvo García

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
