var exec = require('cordova/exec');

exports.isTelevision = function (success, error) {
    exec(
        function(res) { success(res === 1); }, // Превращаем 1 в true, 0 в false
        error, 
        'TvDetectionPlugin', 
        'isTelevision', 
        []
    );
};
