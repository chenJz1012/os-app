define(function (require, exports, module, undefined) {
    var Portlet = require('portlet');
    exports.info = {
        version: "1.0",
        author: "ChenGJ"
    };
    exports.build = function (option) {
        var portlet = new Portlet(option);
        portlet.render();
        return portlet;
    };
});

define("portlet", [pathjs.path("element")], function (require, exports, module, undefined) {
    var root = this;
    var Element = require(pathjs.path("element"));
    var Portlet = function (option) {
        this.option = $.extend(true, {}, root.default, option);
    };
    module.exports = Portlet;

    Portlet.prototype.render = function () {
        var portletDiv = new Element({
            id: "portlet_id"
        }).portletDiv();
        var portletTilte = new Element().portletTitle({
            title : "新标题"
        });
        var portletBody = new Element().portletBody();
        portletDiv.append(portletTilte);
        portletDiv.append(portletBody);
        if(this.option.render!=undefined)
            $(this.option.render).append(portletDiv);
        this.$element = portletDiv;
    };
});
