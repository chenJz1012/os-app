define(function (require, exports, module, undefined) {
    var Grid = require('grid');
    exports.info = {
        version: "1.0",
        author: "ChenGJ"
    };
    exports.build = function (option) {
        var g = new Grid(option);
        g.render();
        return g;
    };
});

define("grid", [pathjs.path("element")], function (require, exports, module, undefined) {
    var root = this;
    var Element = require(pathjs.path("element"));
    root.default = {
        render: "body"
    };
    var Grid = function (option) {
        this.option = $.extend(true, {}, root.default, option);
    };
    module.exports = Grid;

    Grid.prototype.render = function () {
        var row = new Element({
            id: "row_id"
        }).row();
        var col = new Element({
            id: "col_id"
        }).col();
        row.append(col);
        $(this.option.render).append(row);
        this.$element = col;
    };
});
