# react-native-video-cache


```base
yarn add react-native-video-cache
react-native link react-native-video-cache
```

React native wrapper on 

- iOS: https://github.com/ChangbaDevs/KTVHTTPCache
- Android: https://github.com/danikula/AndroidVideoCache
- Others: return what's passed in

### Usage

```js
import convertToProxyURL from 'react-native-video-cache'
...
const localProxiedURL = await convertToProxyURL(originalURL)
...
<Video source={{uri: localProxiedURL}} />
```
