//
//  RCTJCoreModule.m
//  RCTJCoreModule
//
//  Created by oshumini on 2017/8/8.
//  Copyright © 2017年 HXHG. All rights reserved.
//

#import "RCTJCoreModule.h"
#import "JGInforCollectionAuth.h"

#if RCT_NEW_ARCH_ENABLED
#import <RCTJCoreModuleSpec/RCTJCoreModuleSpec.h>
#endif


@implementation RCTJCoreModule

#define JgLog(fmt, ...) NSLog((@"| JGER | iOS | " fmt), ##__VA_ARGS__)

RCT_EXPORT_MODULE(JCoreModule);

#pragma mark --- 设备信息采集授权接口（合规接口）
RCT_EXPORT_METHOD(setAuth: (BOOL *)enable)
{
    JgLog("JCollectionAuth %d",enable);
    __block BOOL isAuth= enable;
    [JGInforCollectionAuth JCollectionAuth:^(JGInforCollectionAuthItems * _Nonnull authInfo) {
        authInfo.isAuth = isAuth;
    }];
}

RCT_EXPORT_METHOD(enableAutoWakeup: (BOOL *)enable)
{
   
}

RCT_EXPORT_METHOD(setCountryCode: (NSDictionary *)params)
{
   
}

RCT_EXPORT_METHOD(enableSDKLocalLog:(NSDictionary *)params)
{
   
}

RCT_EXPORT_METHOD(readNewLogs: (RCTResponseSenderBlock) callback)
{
   
}

//事件处理
- (NSArray<NSString *> *)supportedEvents
{
    return @[];
}

#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
  
    return std::make_shared<facebook::react::NativeJCoreSpecJSI>(params);
}
#endif

@end
