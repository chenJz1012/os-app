define(function (require, exports, module, undefined) {
    var Element = require('element');
    exports.info = {
        version: "1.0",
        author: "ChenGJ"
    };
    exports.build = function () {
        var e = new Element();
        return e;
    };
});

define("element", function (require, exports, module, undefined) {
    function isType(type) {
        return function (obj) {
            return {}.toString.call(obj) == "[object " + type + "]"
        }
    }

    var isObject = isType("Object");
    var isString = isType("String");
    var isArray = Array.isArray || isType("Array");
    var isFunction = isType("Function");

    var Element = function () {
        this.attributes = {};
        return this;
    };
    module.exports = Element;

    var setAttribute = function (that, ele) {
        if (that.attributes.id != undefined)
            ele.attr("id", that.attributes.id);
        if (that.attributes.cls != undefined)
            ele.addClass(that.attributes.cls);
        if (that.attributes.style != undefined)
            ele.attr("style", that.attributes.style);
        if (that.attributes.attrs != undefined) {
            var attrs = that.attributes.attrs || {};
            for (var attr in attrs) {
                ele.attr(attr, attrs[attr]);
            }
        }
    };

    var initPortletDiv = function (that) {
        var portletDiv = $('<div></div>');
        portletDiv.addClass("portlet");
        portletDiv.addClass("light");
        setAttribute(that, portletDiv);
        return portletDiv;
    };

    var initPortletTitle = function (that) {
        var innerOption = that.attributes;
        var portletTitle = $('<div></div>');
        portletTitle.addClass("portlet-title");
        setAttribute(that, portletTitle);
        var caption = $('<div class="caption caption-md">'
            + '<i class="icon-bar-chart theme-font hide"></i>'
            + '<span class="caption-subject theme-font bold uppercase">' + (innerOption.title != undefined ? innerOption.title : "未定义标题") + '</span>'
            + '<span class="caption-helper">' + (innerOption.helper != undefined ? innerOption.helper : "") + '</span>'
            + '</div>');
        if(innerOption.titleIcon!=undefined)
            caption.find("i").removeClass().addClass(innerOption.titleIcon);
        portletTitle.append(caption);
        return portletTitle;
    };

    var initPortletBody = function (that) {
        var portletBody = $('<div></div>');
        portletBody.addClass("portlet-body");
        setAttribute(that, portletBody);
        return portletBody;
    };


    Element.prototype.common = function (innerOption) {
        var that = this;
        if (innerOption.render != undefined) {
            var renderObject;
            if (innerOption.render instanceof Element) {
                renderObject = innerOption.render.element;
            } else {
                renderObject = $(innerOption.render);
            }
            this.element.appendTo(renderObject);
        }
        if (innerOption.item != undefined) {
            var item = innerOption.item;
            if (isArray(item)) {
                for (var i in item) {
                    var appendObject;
                    if (item[i].element instanceof Element) {
                        appendObject = item[i].element;
                    } else {
                        appendObject = $(item[i]);
                    }
                    that.body.append(appendObject);
                }
            } else {
                var appendObject;
                if (item.element instanceof Element) {
                    appendObject = item.element;
                } else {
                    appendObject = $(item);
                }
                that.body.append(appendObject);
            }

        }
        if (innerOption.html != undefined) {
            that.body.html(innerOption.html);
        }
        this.append = function (ele) {
            that.body.append(ele);
        };
        this.appendTo = function (ele) {
            that.element.appendTo(ele);
        };
    };

    Element.prototype.row = function (innerOption) {
        this.attributes = innerOption || {};
        var row = $('<div></div>');
        row.addClass("row");
        this.element = row;
        this.body = row;
        setAttribute(this, row);
        this.common(innerOption);
        return this;
    };

    Element.prototype.col = function (innerOption) {
        this.attributes = innerOption || {};
        innerOption = innerOption || {};
        var span = (innerOption.span == undefined ? "12" : innerOption.span);
        var col = $('<div></div>');
        col.addClass("col-md-" + span);
        col.addClass("col-sm-12");
        this.element = col;
        this.body = col;
        setAttribute(this, col);
        this.common(innerOption);
        return this;
    };

    Element.prototype.portlet = function (innerOption) {
        this.attributes = innerOption || {};
        var portletDiv = initPortletDiv(this);
        var portletTitle = initPortletTitle(this);
        var portletBody = initPortletBody(this);
        portletDiv.append(portletTitle);
        portletDiv.append(portletBody);
        this.element = portletDiv;
        this.body = portletBody;
        this.common(innerOption);
        return this;
    };
});
