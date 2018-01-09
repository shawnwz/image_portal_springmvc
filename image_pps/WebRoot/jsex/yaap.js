/**
 * Yaap
 * 
 * @description         Yet Another Ajax Pager | Pagination
 * @repository url      https://github.com/messycs/yaap    
 * @author              messycs@gmail.com 
 
 * @example:  
   <script type="javascript" src="yaap.js"></script>
   <script type="javascript">

        // create a pager instance
        var Pager = new Yaap({
            autoInit: true,
            enableCache: false,
            iPagerLimit: 6,
            iPerPage: 12,
            iTotal: 102,
            sContainerId: '',
            sActiveClassName: 'page_hover',
            sInactiveClassName: '',
            sPagerId: 'ajax_pager',
            sPagerWrapperTag: 'li',
            sPagerPrevTxt: '上一页',
            sPagerNextTxt: '下一页',
            makeURL: function (iPage) {
                // make your own url to get content from new page.
                // @param the number of the new page, count from 1.
                return 'http://exam.ple/returns_new_content?page=' + iPage;
            },
            makePostURL: function (iPage) {
                return 'test_name=test_value&test_name_1=' + 2 * iPage;
            },

            updateTotalCnt: function () {
                // this.
            }
        });
    
        // write your own method to parse new content
        Pager.parseContent = function (raw_content) {
            var sHTML = '';

            // ...
            // ... handle the raw content which come from the new page
            // ...
            // and return the structured HTML to yaap.

            return sHTML; 
        };

        Pager.getLatestTotalCnt: function (yaapCallback) {
            // maybe update total count asynchronously, then call yaapCallback to rebuild pagers.
        }

        // get content of page two.
        Pager.getContent(2);

    </script>
 *
 * @params  object   
 * 
 * shownCallback        替换内容之后的回调函数, 可选.
 * iPerPage             每页内容数量, 必需.
 * iPagerLimit          分页数量
 * iTotal               内容总数, 必需.
 * sActiveClassName     当前页码的className, 
 * sInactiveClassName   非当前页码的className, 可以为空
 * sPagerId             分页容器ID
 * sContainerId         内容容器ID
 * sPagerWrapperTag     单个分页标签<??><a>1,2,3</a></??>
 * sPagerPrevTxt        上一页 链接 文本
 * sPagerNextTxt        下一页 链接 文本
 * makeURL              获取新内容的url的方法, yaap传递的参数为页码,
 * makePostData         返回 标准序列化的URL参数字符串 的方法, 发起Post请求到makeURL()返回的URL, yaap传递的参数为页码
 *
 * @Yaap.parseContent(content) 
 * 需要在Yaap初始化之后覆写, 自定义每页显示的内容样式

 * @property

 * aContent             数组缓存每个分页的内容，索引与iPage相等
 * aCommonAnchors       普通(非'上下页')分页锚链接
 * iCurPagerKey         当前页码在aCommonAnchors中的键值
 * iPage                当前所处的分页，从1开始
 * iActualPagerCount    实际显示的页码数量
 * args                 原始的参数备份
 * funcs                pager需要的共用函数
 */

function Yaap(oArgs) {
    // init necessary properties
    this.args          = oArgs;
    this.autoInit      = true;
    this.enableCache   = true;
    this.funcs         = {};
    this.iPage         = 1;
    this.iCurPagerKey  = 0;
    this.aContent      = [];
    // set properties from param
    for (property in oArgs) {
        this[property] = oArgs[property];
    }

    this.init();
}

Yaap.prototype = {
    
    constructor: Yaap,

    clearContentArea: function () {
        // 清空内容区域
        var elemContainer = document.getElementById(this.sContainerId);
        elemContainer.innerHTML = '';
    },

    clearPagerArea: function () {
        // 清空分页区域
        var elemPager = document.getElementById(this.sPagerId);
        elemPager.innerHTML = '';
    },

    getContent: function (iPage) {
        // 取得内容 主入口
        if (isNaN(iPage) || iPage == 0 || iPage > this.iPageCount) {
            this.showEmpty();
        } else {
            this.clearContentArea();
            if (this.enableCache === true && this.aContent[iPage] != undefined) {
                this.getContentFromCache(iPage);
            } else {
                this.getNewContent(iPage);  
            }
            this.iPage = iPage;
            this.sPagerPrevTxt && this.rebuildPagerPrev();
            this.sPagerNextTxt && this.rebuildPagerNext();
            this.pagerRebuild();
        }
    },

    getNewContent: function(iPage) {
        // 取得新内容
        var _ajax  = new this.AjaxRequest();
        var postData = this.makePostData ? this.makePostData(iPage) : '';
        this.iPage = iPage;

        _ajax.Post(
            this.makeURL(iPage), 
            postData,
            this.getNewContentCallBack, 
            { _this: this }
        );
    },

    getNewContentCallBack: function (raw, scope) {
        var rawContent = raw,
                 _this = scope._this;
        _this.aContent[_this.iPage] = rawContent;
        _this.showContent(rawContent);        
    },

    getContentFromCache: function(iPage) {
        // 从保存的数组中取得内容
        this.iPage = iPage;
        this.clearContentArea();
        this.showContent(this.aContent[iPage]);
    },

    init: function () {
        // init Yaap
        if (this.isPagerNeeded()) { 
            this.initArgs(); 
            this.initCommonFuncs(); 
            this.reCalcPagerLimit();   
            this.initPager(); 
            this.autoInit === true && this.getContent(this.iPage);
            this.getLatestTotalCnt && this.getLatestTotalCnt();
        }
    },

    initArgs: function () {
        // 初始化必要的参数
        (this.sActiveClassName == undefined) && (this.sActiveClassName = '');
        (this.sInactiveClassName == undefined) && (this.sInactiveClassName = '');
    },

    initCommonFuncs: function () {

        var _this = this;

        _this.funcs.getElementsByClassName = function (fatherId, tagName, className) {
            var node = fatherId && document.getElementById(fatherId) || document;
            var tagName = tagName || "*";
            var className = className.split(" ");
            var classNameLength = className.length;
            for (var i = 0, j = classNameLength; i < j; i++) {
                className[i] = new RegExp("(^|\\s)" + className[i].replace(/\-/g, "\\-") + "(\\s|$)"); 
            }
            var elements = node.getElementsByTagName(tagName);
            var result = [];
            for (var i = 0, j = elements.length, k = 0; i < j; i++) {
                var element = elements[i];
                while(className[k++].test(element.className)) {
                    if (k === classNameLength) {
                        result[result.length] = element;
                        break;
                    }   
                }
                k = 0;
            }
            return result;
        }

        _this.XmlHttpObj = function() { 
            var xmlhttp = null; 
            if (window.XMLHttpRequest) { 
                xmlhttp = new XMLHttpRequest(); 
                if (xmlhttp.overrideMimeType) {   //设置MiME类别 
                    xmlhttp.overrideMimeType("text/xml"); 
                } 
            } else if (window.ActiveXObject) { 
                try { 
                    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
                } catch (e) { 
                    try { 
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
                    } catch (e) { } 
                } 
            } 
            return xmlhttp; 
        }

        // 回调函数 
        _this.ReadyStateChange = function (obj, funcname, funcargs) { 
            return function () { 
                if (obj.xho.readyState == 4 && obj.xho.status == 200) { 
                    funcname(obj.xho.responseText, funcargs); 
                } 
            } 
        } 

        _this.AjaxRequest = function () { 
            this.xho = _this.XmlHttpObj(); 
            if (this.xho == null) return; 
        }

        _this.AjaxRequest.prototype.Post = function (url, data, funcname, funcargs) { 
            this.xho.open('POST', url, false); 
            this.xho.onreadystatechange = _this.ReadyStateChange(this, funcname, funcargs); 
            this.xho.setRequestHeader('CONTENT-TYPE', 'application/x-www-form-urlencoded'); 
            this.xho.send(data); 
        }

        _this.AjaxRequest.prototype.Get = function (url, funcname, funcargs) { 
            this.xho.open('GET', url, true); 
            this.xho.onreadystatechange = _this.ReadyStateChange(this, funcname, funcargs); 
            this.xho.setRequestHeader('CONTENT-TYPE', 'application/x-www-form-urlencoded'); 
            this.xho.send(null); 
        }
    },

    initPager: function() {
        // 分页区域初始化
        this.setPagerAnchorWrapper();
        this.initPagerAnchors();
    },

    initPagerAnchors: function () {
        // 创建上一页、下一页链接, 赋予其id
        var elemPager = document.getElementById(this.sPagerId);
        var sHTML = '';

        if (this.sPagerPrevTxt)  {
            sHTML += ' ' + this.sPagerWrapperPrefix + '<a href="javascript:" id="' + this.sPagerId + '_anchor_prev" >' + this.sPagerPrevTxt + '</a>' + this.sPagerWrapperSuffix;
        }

        for (var i = 0, len = this.iActualPagerCount; i < len; i++) {
            sHTML += ' ' + this.sPagerWrapperPrefix 
                  + '<a href="javascript:" class="' + this.sPagerId + '_anchor_common">' + (i + 1) + '</a>'
                  + this.sPagerWrapperSuffix;
        }

        if (this.sPagerNextTxt) {
            sHTML += ' ' + this.sPagerWrapperPrefix + '<a href="javascript:" id="' + this.sPagerId + '_anchor_next" >' + this.sPagerNextTxt + '</a>' + this.sPagerWrapperSuffix;
        }

        elemPager.innerHTML = sHTML;

        this.sPagerPrevTxt && this.rebuildPagerPrev();
        this.sPagerNextTxt && this.rebuildPagerNext();
        this.initPagerCommon();
    },

    initPagerCommon: function () {
        var _this = this;
        this.aCommonAnchors = this.funcs.getElementsByClassName(this.sPagerId, 'a', this.sPagerId + '_anchor_common');
        this.setAllAsInactive(this.aCommonAnchors);

        for (var i = 0, len = this.aCommonAnchors.length; i < len; i++) {
            var elemPagerAnchor = this.aCommonAnchors[i];
            if ((i + 1) == this.iPage) {
                this.setAsActive(elemPagerAnchor);
            }
            elemPagerAnchor.onclick = function () {
                var iPage = parseInt(this.innerHTML);
                _this.getContent(iPage);
                return false;
            };
        }
    },

    isPagerNeeded: function () {
        // 是否需要分页
        var flag = false;
        var elemContainer = document.getElementById(this.sContainerId);
        if (elemContainer !== null && this.iTotal > this.iPerPage) {
            flag = true;
        }
        return flag;
    },

    pagerRebuild: function() {
        // 每次切换到新的分页时检查重建分页区域
        var iPage = this.iPage;                 
        var iFrom = 1;
        var iTo   = this.iActualPagerCount;
        var j = 0;
        var iCurPagerKey = 0;

        if (this.iPageCount > this.iPagerLimit) {
            var iPageCount  = this.iPageCount;      
            var iPagerLimit = this.iPagerLimit;     
            var iHalf = Math.floor(iPagerLimit / 2); 
            var isPageCountOdd = ((iPagerLimit % 2) !== 0);

            if (iPage > iHalf) {
                var iActualLimit = iPageCount - iHalf;
                isPageCountOdd && iActualLimit--;

                if (iPage > iActualLimit) {
                    iFrom = iPageCount - iPagerLimit + 1;
                    iTo   = iPageCount; 
                } else {
                    iFrom = iPage - iHalf + 1;
                    iTo   = iPage + iHalf;
                    isPageCountOdd && iTo++;
                }
            }
        }

        for (i = iFrom; i <= iTo; i++) {
            this.aCommonAnchors[j].innerHTML = i;
            if (i === iPage) {
                this.iCurPagerKey = j;
            }
            j++;
        }

        this.setAllAsInactive(this.aCommonAnchors);
        this.setAsActive(this.aCommonAnchors[this.iCurPagerKey]);
    },

    reCalcPagerLimit: function () {
        // 首次初始化时 重新计算显示几个分页
        this.iPageCount  = Math.ceil(this.iTotal / this.iPerPage);
        this.iActualPagerCount = (this.iPageCount > this.iPagerLimit) ? this.iPagerLimit : this.iPageCount;
    },

    rebuildPagerPrev: function () {
        // 重新处理“上一页”
        var _this    = this;
        var elemPrev = document.getElementById(this.sPagerId + '_anchor_prev');
        if (this.iPage > 1) {
            elemPrev.onclick = function () {
                _this.getContent(_this.iPage - 1);
                return false;
            };
        } else {
            elemPrev.onclick = function () { return false; };
        }
    },
    
    rebuildPagerNext: function () {
        // 重新处理“下一页”
        var _this    = this;
        var elemNext = document.getElementById(this.sPagerId + '_anchor_next');
        if (this.iPage < this.iPageCount) {
            elemNext.onclick = function () {
                _this.getContent(_this.iPage + 1);
                return false;
            };
        } else {
            elemNext.onclick = function () { return false; };
        }
    },

    setAsActive: function (elemPagerAnchor) {

        // 将当前元素设置为active
        // if (this.sActiveClassName) {
            // var elemAffected = (this.sPagerWrapperTag) ? elemPagerAnchor.parentNode : elemPagerAnchor;
            // elemPagerAnchor.className = this.sActiveClassName;
            var oReg = new RegExp(this.sInactiveClassName, 'g');
            if (this.sInactiveClassName && elemPagerAnchor.className.indexOf(this.sInactiveClassName) != -1) {
                elemPagerAnchor.className = elemPagerAnchor.className.replace(oReg, this.sActiveClassName);
            } else {
                elemPagerAnchor.className = elemPagerAnchor.className + ' ' + this.sActiveClassName;
            }
        // }
    },

    setAsInactive: function (elemPagerAnchor) {
        // 将当前元素设置为inactive     
        // if (this.sInactiveClassName) {
            // var elemAffected = (this.sPagerWrapperTag) ? elemPagerAnchor.parentNode : elemPagerAnchor;
            var oReg = new RegExp(this.sActiveClassName, 'g');
            if (elemPagerAnchor.className.indexOf(this.sActiveClassName) != -1) {
                elemPagerAnchor.className = elemPagerAnchor.className.replace(oReg, this.sInactiveClassName);   
            } else {
                elemPagerAnchor.className = elemPagerAnchor.className + ' ' + this.sInactiveClassName;
            }
        // }  
    },

    setAllAsInactive: function (aElems) {
        for (var i = 0, len = aElems.length; i < len; i++) {
            this.setAsInactive(aElems[i]);
        }
    },

    parseContent: function (rawContent) {
        // 返回每个分页的HTML部分
        // must return some HTML or some Plain Text
    },

    setPagerAnchorWrapper: function () {
        // 设置父标签
        var sPagerWrapperTag = this.sPagerWrapperTag;
        this.sPagerWrapperPrefix = (sPagerWrapperTag) ? '<' + sPagerWrapperTag + '>' : '';
        this.sPagerWrapperSuffix = (sPagerWrapperTag) ? '</' + sPagerWrapperTag + '>' : '';
    },

    showEmpty: function () {
        // 内容为空时执行
    },

    showContent: function (rawContent) {
        // 显示内容 
        var elemContainer = document.getElementById(this.sContainerId);
        elemContainer.innerHTML = this.parseContent(rawContent);
        this.shownCallback && typeof this.shownCallback == 'function' && this.shownCallback();
    }
}