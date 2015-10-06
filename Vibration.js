'use strict';

var RNVibrationAndroid = require('NativeModules').VibrationAndroid;

var VibrationAndroid = {
  vibrate(duration) {
    if (duration === undefined) {
      duration = 300;
    }

    RNVibrationAndroid.vibrate(duration);
  }
};

module.exports = VibrationAndroid;
