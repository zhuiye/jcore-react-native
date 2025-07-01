import type { TurboModule } from "react-native";
import { TurboModuleRegistry } from "react-native";

export interface Spec extends TurboModule {
  setAuth: (enabled: boolean) => void;
  enableAutoWakeup: (enabled: boolean) => void;
  setCountryCode: (obj: Object) => void;
  enableSDKLocalLog: (obj: Object) => void;
  readNewLogs: (obj: (logs: string) => void) => void;
}

export default TurboModuleRegistry.getEnforcing<Spec>("JCoreModule");
