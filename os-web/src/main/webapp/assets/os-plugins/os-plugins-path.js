;
(function (global, document, undefined) {
    "use strict";
    var osPaths = {
        "element": "/assets/os-plugins/os-element",
        "grid": "/assets/os-plugins/os-grid",
        "portlet": "/assets/os-plugins/os-portlet"
    };
    if (global.pathjs) {
        return
    }
    var pathjs = global.pathjs = {
        version: "1.0"
    };
    var base = pathjs.base = "";
    var config = pathjs.config = function (option) {
        if (option.base != undefined) {
            base = option.base;
        }
    };
    var path = pathjs.path = function (alias) {
        return base + osPaths[alias];
    };
})(this, document);
