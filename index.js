import { NativeModules, Platform } from 'react-native';

const { RNVideoCache } = NativeModules;

const convert = url => {
  if (Platform.OS === 'ios' || Platform.OS === 'android') {
    return RNVideoCache.convert(url);
  }
  return Promise.resolve(url);
};

export default convert;

