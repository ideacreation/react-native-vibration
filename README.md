# react-native-vibration

Vibration module with support for android, based on the pull request https://github.com/facebook/react-native/pull/2794 from @christopherdro. For iOS it wraps VibrationIOS. On iOS the duration can't be specified. If you don't specify a duration on Android 300ms will be used.

### Installation

```bash
npm i --save react-native-vibration
```

### Add it to your android project

* In `android/setting.gradle`

```gradle
...
include ':ReactNativeVibration', ':app'
project(':ReactNativeVibration').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-vibration/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':ReactNativeVibration')
}
```

* register module (in MainActivity.java)

```java
import com.eguma.vibration.Vibration;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new Vibration())              // <------ add here
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "example", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Example
```javascript
'use strict';

var React = require('react-native');
var Vibration = require('react-native-vibration');

var {
  AppRegistry,
  StyleSheet,
  Text,
  TouchableHighlight,
  View,
} = React;

var VibrationExample = React.createClass({
  onPress() {
    Vibration.vibrate(500);
  },

  render() {
    return (
      <View style={styles.container}>
        <TouchableHighlight
          onPress={this.onPress}
          style={styles.button}
        >
          <Text>
            Click me to vibrate!
          </Text>
        </TouchableHighlight>
      </View>
    );
  }
});

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  button: {
    padding: 20,
    justifyContent: 'center',
    alignItems: 'center',
    borderColor: 'black',
    borderRadius: 5,
    borderWidth: 1,
  }
});

AppRegistry.registerComponent('VibrationExample', () => VibrationExample);
```
