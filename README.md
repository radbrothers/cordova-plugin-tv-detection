```javascript
document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady() {
    window.TvDetection.isTelevision(
        function(isTV) {
            if (isTV) {
                console.log("Android TV");
            } else {
                console.log("not Android TV");
            }
        },
        function(error) {
            console.error(error);
        }
    );
}
```
