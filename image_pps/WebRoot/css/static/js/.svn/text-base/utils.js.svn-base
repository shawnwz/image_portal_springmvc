/**
 * @package     Corbis Frontend Massive Header.
 * @since       Mar 13, 2013 #
 * @author      Fractal Technology Ltd.
 */

define(function () {

    var utils;

    utils = {

        inited: true,

        /**
         * 从数组中移除某元素
         * @param  mixed    val 想移除的元素
         * @param  arr      arr 数组
         * @return arr      处理后的数组
         */
        removeThisFromArray: function (val, arr) {
            var key, arrpre, arrsuf, newarr, flag;

            key = -1;
            arrpre = arrsuf = [];

            for (var i = 0, len = arr.length; i < len; i += 1) {
                if (val === arr[i]) {
                    key = i;
                    break;
                }
            }

            if (key >= 0) {
                arrpre = arr.slice(0, key);
                arrsuf = arr.slice(key + 1, arr.length);
                newarr = arrpre.concat(arrsuf);
            } else {
                newarr = arr;
            }
            
            return newarr;
        },

        /**
         * 根据className取得元素
         * @param  string   wrapperId 在id="wrapper"的容器内查找, 默认为document.
         * @param  string   tagName   标签名称, 'a','li','img'等, 默认为'*'
         * @param  string   className 需要查找的className值
         * @return array              根据className取得的HTML元素数组
         */
        getElementsByClassName: function (wrapperId, tagName, className) {
            var node = wrapperId && document.getElementById(wrapperId) || document;
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
        },

        loadCSS: function (url, callback) {
            var link    = document.createElement("link");
            link.type   = "text/css";
            link.rel    = "stylesheet";
            link.href   = url;
			typeof(callback) == 'function' && (link.onload = callback);
            document.getElementsByTagName("head")[0].appendChild(link);
        },

        adjustImageSize: function (args) {
            var smallerFlag, oriWidth, oriHeight, iW, iH, tmpHeight, tmpWidth, autoHeight;

            smallerFlag = false;
            oriWidth    = args.oriWidth;
            oriHeight   = args.oriHeight;
            elemImg     = args.elemImg;
			autoHeight	= args.autoHeight;

            iW = args.iW;
            iH = args.iH;

            if (oriWidth / oriHeight >= iW / iH) {
                if (oriWidth > iW) { 
                    tmpHeight = (oriHeight * iW) / oriWidth;
                    elemImg.width  = iW; 
                    elemImg.height = tmpHeight;
					//console.log(autoHeight);
                    autoHeight !== true && (elemImg.style.marginTop  = (iH - tmpHeight) / 2 + "px");
                } else { 
                    smallerFlag = true;
                } 
            } else { 
                if(oriHeight > iH) { 
                    tmpWidth = (oriWidth * iH) / oriHeight
                    elemImg.height = iH; 
                    elemImg.width  = tmpWidth;
                    elemImg.style.marginLeft = (iW - tmpWidth) / 2 + "px"; 
                } else { 
                   smallerFlag = true;
                }
            }   

            if (smallerFlag === true) {
                elemImg.width  = oriWidth; 
                elemImg.height = oriHeight;
                autoHeight !== true && (elemImg.style.marginTop  = (iH - oriHeight) / 2 + "px");
                elemImg.style.marginLeft = (iW - oriWidth) / 2 + "px";
            }
			
			autoHeight === true && $(elemImg).parent().height('auto');

            elemImg.src = args.src;
        },

        /**
         * 处理单个图片的样式, 使其使用指定的高度和宽度
         * @param  HTML Element     elemImg      需要处理的<img>元素, 需要设置datasrc属性
         * @param  int              iW           不能大于的宽度值
         * @param  int              iH           不能大于的高度值
         * @param  [string]         src          可选, 如果datasrc的链接载入失败时显示的默认图片
         * @param  [boolean] for_fear_of_infinite 不必填, 程序需要
         */
        handleSingleImage: function (elemImg, iW, iH, src, for_fear_of_infinite, autoHeight) {

            var tmpImg, defaultImg, elemImg, datasrc, self;

            self = this;
            defaultImg  = FT.vars.BASE_URL + '/statics/front/images/images/02.jpg';
            elemImg     = elemImg;
            tmpImg      = new Image();
            datasrc     = elemImg.getAttribute('datasrc');

            tmpImg.onerror = function () {
                for_fear_of_infinite === undefined && self.handleSingleImage(elemImg, iW, iH, defaultImg, true, autoHeight);
            };

            tmpImg.onload = function () {
                if (tmpImg.width > 0 && tmpImg.height > 0) {
                    self.adjustImageSize({
                        oriWidth: tmpImg.width,
                        oriHeight: tmpImg.height,
                        iW: iW,
                        iH: iH,
                        elemImg: elemImg,
                        src: tmpImg.src,
						autoHeight : autoHeight
                    });
                }
            };

            tmpImg.src = (src !== undefined) ? src : datasrc;
        },

        /**
         * 调整图片样式以适应指定的宽度和高度
         * @param  string   wrapperId    imgClassName父容器Id
         * @param  string   imgClassName 需要改变样式的<img>标签的className
         * @param  int      toWidth      不能大于的宽度值
         * @param  int      toHeight     不能大于的高度值
		 * @param  boolean  autoHeight   高度是否自适应
         */
        adjustImage: function (wrapperId, imgClassName, toWidth, toHeight, autoHeight) { 
            var tmpImg, iW, iH, aElemImg;

            elemWrapper = document.getElementById(wrapperId);
            aElemImg    = this.getElementsByClassName(wrapperId, 'img', imgClassName);
            
            // check args
            if (!elemWrapper || aElemImg.length === 0 || isNaN(toWidth) || isNaN(toHeight)) {
                return true;
            }

            iW = parseInt(toWidth);
            iH = parseInt(toHeight);

            for (var i = 0, len = aElemImg.length; i < len; i += 1) {
                this.handleSingleImage(aElemImg[i], iW, iH, undefined, undefined, autoHeight);
            }
        } 
    }; 

    return utils;
});