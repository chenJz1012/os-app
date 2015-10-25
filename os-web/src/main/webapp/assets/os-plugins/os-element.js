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
        return portletDiv;
    };

    var initPortletTitle = function (that) {
        var innerOption = that.attributes;
        var portletTitle = $('<div></div>');
        portletTitle.addClass("portlet-title");
        var caption = $('<div class="caption caption-md">'
            + '<i class="icon-bar-chart theme-font hide"></i>'
            + '<span class="caption-subject theme-font bold uppercase">' + (innerOption.title != undefined ? innerOption.title : "未定义标题") + '</span>'
            + '<span class="caption-helper">' + (innerOption.helper != undefined ? innerOption.helper : "") + '</span>'
            + '</div>');
        var action = $('<div class="actions"></div>');
        if (innerOption.titleAction != undefined) {
            var item = innerOption.titleAction;
            if (isArray(item)) {
                for (var i in item) {
                    var appendObject;
                    if (item[i] instanceof Element) {
                        appendObject = item[i].element;
                    } else {
                        appendObject = item[i];
                    }
                    action.append(appendObject);
                }
            } else {
                var appendObject;
                if (item instanceof Element) {
                    appendObject = item.element;
                } else {
                    appendObject = item;
                }
                action.append(appendObject);
            }
        }
        if (innerOption.fullscreen) {
            var fullscreen = $('<a href="javascript:;" class="btn btn-circle btn-default btn-icon-only fullscreen" data-original-title="全屏" title="全屏"></a>');
            action.append(fullscreen);
        }
        if (innerOption.titleIcon != undefined)
            caption.find("i").removeClass().addClass(innerOption.titleIcon);
        portletTitle.append(caption);
        portletTitle.append(action);
        return portletTitle;
    };

    var initPortletBody = function (that) {
        var portletBody = $('<div></div>');
        portletBody.addClass("portlet-body");
        if (that.attributes.scrollable) {
            var scroller = $('<div class="scroller" style="height:200px" data-rail-visible="1" data-rail-color="yellow" data-handle-color="#a1b2bd">');
            if (that.attributes.scrollHeight != undefined)
                scroller.css("height", that.attributes.scrollHeight + "px");
            if (that.attributes.scrollAllwaysVisible)
                scroller.attr("data-always-visible", "1");
            if (that.attributes.scrollRailColor != undefined)
                scroller.attr("data-rail-color", that.attributes.scrollRailColor);
            if (that.attributes.scrollHandleColor != undefined)
                scroller.attr("data-handle-color", that.attributes.scrollHandleColor);

            portletBody.append(scroller);
        }
        return portletBody;
    };

    var initAlert = function (option) {
        var alert = $('<div class="alert alert-' + (option.type == undefined ? "info" : option.type) + ' alert-dismissable">' +
            (option.close == false ? "" : '<button type="button" class="close" data-dismiss="alert" aria-hidden="true"></button>') +
            '<strong>' + (option.message == undefined ? "" : option.message) + '</strong></div>');
        return alert;
    };
    var initNote = function (option) {
        var note = $('<div class="note note-' + (option.type == undefined ? "info" : option.type) + '">' +
            '<h4 class="block">' + (option.title == undefined ? "" : option.title) + '</h4>' +
            '<p>' + (option.content == undefined ? "" : option.content) + '</p></div>');
        return note;
    };

    var initIcon = function (cls) {
        var icon = $('<i class="' + cls + '"></i>');
        return icon;
    }

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
                    if (item[i] instanceof Element) {
                        appendObject = item[i].element;
                    } else {
                        appendObject = item[i];
                    }
                    that.body.append(appendObject);
                }
            } else {
                var appendObject;
                if (item instanceof Element) {
                    appendObject = item.element;
                } else {
                    appendObject = item;
                }
                that.body.append(appendObject);
            }
        }
        if (innerOption.html != undefined) {
            that.body.html(innerOption.html);
            return that;
        }
        this.append = function (ele) {
            that.body.append(ele);
            return that;
        };
        this.appendTo = function (ele) {
            that.element.appendTo(ele);
            return that;
        };
        this.alert = function (type, msg, millions, scrollTo) {
            var option = {
                "type": type,
                "message": msg
            }
            var alert = new initAlert(option);
            that.body.prepend(alert);
            if (millions != undefined && millions > 0)
                alert.delay(millions).fadeOut();
            if (scrollTo)
                Metronic.scrollTo(alert);
            return that;
        }
        this.note = function (type, title, content) {
            var option = {
                "type": type,
                "title": title,
                "content": content
            }
            var note = new initNote(option);
            that.body.prepend(note);
            return that;
        }
    };

    Element.prototype.row = function (innerOption) {
        this.attributes = innerOption || {};
        var row = $('<div></div>');
        row.addClass("row");
        this.element = row;
        this.body = row;
        setAttribute(this, row);
        this.common(this.attributes);
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
        this.common(this.attributes);
        return this;
    };

    Element.prototype.portlet = function (innerOption) {
        this.attributes = innerOption || {};
        var portletDiv = initPortletDiv(this);
        var portletTitle = initPortletTitle(this);
        var portletBody = initPortletBody(this);
        portletDiv.append(portletTitle);
        portletDiv.append(portletBody);
        setAttribute(this, portletDiv);
        this.element = portletDiv;
        if (this.attributes.scrollable) {
            this.body = portletBody.find(".scroller");
            Metronic.initSlimScroll(this.body);
        } else {
            this.body = portletBody;
        }
        this.common(this.attributes);
        return this;
    };

    Element.prototype.alert = function (innerOption) {
        this.attributes = innerOption || {};
        var alert = new initAlert(this.attributes);
        this.element = alert;
        this.body = alert;
        setAttribute(this, alert);
        this.common(this.attributes);
        return this;
    };

    Element.prototype.note = function (innerOption) {
        this.attributes = innerOption || {};
        var note = new initNote(this.attributes);
        this.element = note;
        this.body = note;
        setAttribute(this, note);
        this.common(this.attributes);
        return this;
    };

    Element.prototype.button = function (innerOption) {
        var that = this;
        this.attributes = innerOption || {};
        var button = $('<button type="button" class="btn">' + (this.attributes.text == undefined ? "按钮" : this.attributes.text) + '</button>');
        if (this.attributes.icon != undefined) {
            var icon = initIcon(this.attributes.icon);
            if (this.attributes.iconPosition != undefined) {
                if ("right" == this.attributes.iconPosition) {
                    button.append(icon);
                } else {
                    button.prepend(icon);
                }
            } else {
                button.prepend(icon);
            }
        }
        if (this.attributes.click != undefined) {
            button.click(function () {
                that.attributes.click();
            });
        }
        this.element = button;
        this.body = button;
        setAttribute(this, button);
        return this;
    };

    Element.prototype.dropdown = function (innerOption) {
        this.attributes = innerOption || {};
        var btnGroup = $('<div class="btn-group"></div>');
        var a = $('<a class="btn yellow btn-circle" href="javascript:;" data-toggle="dropdown" aria-expanded="true">'
            + (this.attributes.text == undefined ? "按钮" : this.attributes.text) + '<i class="fa fa-angle-down"></i></a>');
        if (this.attributes.icon != undefined) {
            var icon = initIcon(this.attributes.icon);
            a.prepend(icon);
        }
        var dUl = $('<ul class="dropdown-menu pull-right"></ul>');
        if (this.attributes.actions != undefined) {
            var actions = this.attributes.actions;
            if (isArray(actions)) {
                $.each(actions, function (i, action) {
                    if (action.type == "divider") {
                        var li = $('<li class="divider"></li>');
                        dUl.append(li);
                    } else {
                        var li = $('<li><a href="javascript:;">' + (action.text == undefined ? "未定义text" : action.text) + '</a></li>');
                        if (action.click != undefined) {
                            li.click(function () {
                                action.click();
                            });
                        }
                        dUl.append(li);
                    }
                });
            } else {
                console.error("dropdown的actions必须为数组");
                return;
            }
        } else {
            console.error("dropdown的actions未定义");
            return;
        }
        btnGroup.append(a);
        btnGroup.append(dUl);
        this.element = btnGroup;
        this.body = btnGroup;
        setAttribute(this, btnGroup);
        return this;
    };

});
