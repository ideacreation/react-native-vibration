'use strict';

import { Platform } from 'react-native';

const Vibration = {
  vibrate(duration) {
    if (Platform.OS === 'ios') {
      const VibrationIOS = require('react-native').VibrationIOS;
      VibrationIOS.vibrate();
    } else {
      const { NativeModules } = require('react-native');
      if (duration === undefined) {
        duration = 300;
      }
      NativeModules.VibrationAndroid.vibrate(duration);
    }
  }
};

module.exports = Vibration;
