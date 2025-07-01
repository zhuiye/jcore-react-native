import { Platform } from "react-native";
import JCoreModule from "./specs/NativeJCore";
export default class JCore {
  static setAuth(auth) {
    JCoreModule.setAuth(auth);
  }
  static setCountryCode(params) {
    if (Platform.OS == "android") {
      JCoreModule.setCountryCode(params);
    }
  }
  static enableAutoWakeup(enable) {
    if (Platform.OS == "android") {
      JCoreModule.enableAutoWakeup(enable);
    }
  }

  static enableSDKLocalLog(params) {
    if (Platform.OS == "android") {
      JCoreModule.enableSDKLocalLog(params);
    }
  }

  static readNewLogs(callback) {
    if (Platform.OS == "android") {
      JCoreModule.readNewLogs(callback);
    }
  }
}
