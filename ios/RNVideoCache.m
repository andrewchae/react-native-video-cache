#import "RNVideoCache.h"
#import <KTVHTTPCache/KTVHTTPCache.h>

@implementation RNVideoCache

RCT_EXPORT_MODULE();

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(convert:(NSString *)url
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  if (!KTVHTTPCache.proxyIsRunning) {
    NSError *error;
    [KTVHTTPCache proxyStart:&error];
    if (error) {
      reject(@"init.error", @"failed to start proxy server", error);
      return;
    }
  }
  resolve([KTVHTTPCache proxyURLWithOriginalURL:[NSURL URLWithString:url]].absoluteString);
}

@end
