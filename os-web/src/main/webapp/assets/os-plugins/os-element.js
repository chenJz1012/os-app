define(function (require, exports, module, undefined) {
    var root = this;
    root.attributes = {};
    var Element = function (attributes) {
        root.attributes = attributes||{};
    };
    module.exports = Element;

    var setAttribute = function (ele) {
        if (root.attributes.id != undefined)
            ele.attr("id", root.attributes.id);
        if (root.attributes.cls != undefined)
            ele.addClass(root.attributes.cls);
        if (root.attributes.style != undefined)
            ele.attr("style", root.attributes.style);
        if (root.attributes.attrs != undefined) {
            var attrs = root.attributes.attrs || {};
            for (var attr in attrs) {
                ele.attr(attr, attrs[attr]);
            }
        }
        if (root.attributes.item != undefined)
            ele.append(root.attributes.item);
    }


    Element.prototype.row = function () {
        var row = $('<div></div>');
        row.addClass("row");
        setAttribute(row);
        return row;
    };

    Element.prototype.col = function (innerOption) {
        innerOption = innerOption || {};
        var span = (innerOption.span == undefined ? "12" : innerOption.span);
        var col = $('<div></div>');
        col.addClass("col-md-" + span);
        col.addClass("col-sm-12");
        setAttribute(col);
        return col;
    };

    Element.prototype.portletDiv = function () {
        var portletDiv = $('<div></div>');
        portletDiv.addClass("portlet");
        portletDiv.addClass("light");
        setAttribute(portletDiv);
        return portletDiv;
    };

    Element.prototype.portletTitle = function (innerOption) {
        innerOption = innerOption || {};
        var portletTitle = $('<div></div>');
        portletTitle.addClass("portlet-title");
        setAttribute(portletTitle);
        var caption = $('<div class="caption caption-md">'
            + '<i class="icon-bar-chart theme-font hide"></i>'
            + '<span class="caption-subject theme-font bold uppercase">' + (innerOption.title != undefined ? innerOption.title : "未定义标题") + '</span>'
            + '<span class="caption-helper">' + (innerOption.helper != undefined ? innerOption.helper : "") + '</span>'
            + '</div>');
        portletTitle.append(caption);
        return portletTitle;
    };

    Element.prototype.portletBody = function () {
        var portletBody = $('<div></div>');
        portletBody.addClass("portlet-body");
        setAttribute(portletBody);
        return portletBody;
    };


});
