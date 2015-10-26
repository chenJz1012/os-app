define(function (require, exports, module, undefined) {
    var Grid = require('grid');
    exports.info = {
        version: "1.0",
        author: "ChenGJ"
    };
    exports.build = function (option) {
        var g = new Grid(option);
        return g;
    };
});

define("grid", [pathjs.path("element")], function (require, exports, module, undefined) {
    var root = this;
    root.default = {
        render: "body"
    };
    var Grid = function (option) {
        this.option = $.extend(true, {}, root.default, option);
    };
    module.exports = Grid;
});
